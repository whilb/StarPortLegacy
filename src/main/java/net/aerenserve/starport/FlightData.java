package net.aerenserve.starport;

public class FlightData {
	
	public final Classification classification;
	public final int passengers;
	public final int cargo;
	public final Destination destination;

	public FlightData(Classification classification, int passengers, int cargo, Destination destination) {
		this.classification = classification;
		this.passengers = passengers;
		this.cargo = cargo;
		this.destination = destination;
	}
}
