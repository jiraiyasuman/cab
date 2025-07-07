package com.online_cab_booking.ride.entity;

public enum Vehicle {

	ECONOMY{
		public String toString() {
			return "Economy Class";
		}
	},
	STANDARD{
		public String toString() {
			return "Standard Class";
		}
	},
	LUXURY{
		public String toString() {
			return "Luxury Class";
		}
	}
	
}
