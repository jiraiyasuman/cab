package com.online_cab_booking.ride.serviceimpl;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.online_cab_booking.ride.entity.RideDetails;
import com.online_cab_booking.ride.repository.RideRepository;
import com.online_cab_booking.ride.service.RideDetailsService;
@Service
public class RideDetailsServiceImpl implements RideDetailsService{

	@Value("${geocoding.api.key}")
	private String apiKey;
	private RideRepository rideRepository;
	@Autowired
	public RideDetailsServiceImpl(RideRepository rideRepository) {
		super();
		this.rideRepository = rideRepository;
	}

	@Override
	public double[] getLatitudeLongitudeFrom(String place) {
	    try {
	        String encodedPlace = URLEncoder.encode(place, StandardCharsets.UTF_8);
	        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedPlace + "&key=" + apiKey;

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest req = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .build();

	        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

	        JSONObject json = new JSONObject(res.body());
	        JSONArray results = json.getJSONArray("results");

	        if (results.isEmpty()) {
	            throw new RuntimeException("No location found for place: " + place);
	        }

	        JSONObject location = results.getJSONObject(0)
	                                     .getJSONObject("geometry")
	                                     .getJSONObject("location");

	        double lat = location.getDouble("lat");
	        double lng = location.getDouble("lng");

	        return new double[] { lat, lng };

	    } catch (Exception e) {
	        throw new RuntimeException("Geocoding failed: " + e.getMessage(), e);
	    }
	}

	@Override
	public double calculateDistance(double fromLatitude, double toLatitude, double fromLongitude, double toLongitude) {
		final int R = 6371; // Earth radius in km
        double latDistance = Math.toRadians(toLatitude - fromLatitude);
        double lonDistance = Math.toRadians(toLongitude - toLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(fromLatitude)) * Math.cos(Math.toRadians(toLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        return R * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
	}

	@Override
	public RideDetails saveToDatabase(RideDetails rideDetails) {
		RideDetails savedDetails = rideRepository.save(rideDetails);
		return savedDetails;
	}

}
