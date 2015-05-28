package net.aerenserve.starport.engine.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.aerenserve.starport.engine.names.PlanetNames;
import net.aerenserve.starport.engine.names.StarNames;

public class System {
	
	private final String name;
	private final HyperspaceCoordinate coordinate;
	
	private Map<String, Destination> places;
	
	public System(String name, HyperspaceCoordinate coordinate) {
		this(name, 12 + (216 - 12) * new Random().nextDouble(), coordinate);
	}
	
	public System(String name, double radius, HyperspaceCoordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
		this.places = genPlaces(radius);
	}
	
	public String getName() {
		return this.name;
	}
	
	private Map<String, Destination> genPlaces(double radius) {
		List<String> nameRegistry = new ArrayList<String>();
		Map<String, Destination> places = new HashMap<String, Destination>();
		
		double maxPlaces = radius / 12;
		
		Random r = new Random();
		double rangeMin = -radius;
		double rangeMax = radius;
		
		//Generate the star
		Destination star = new Destination(this.name, new LocationCoordinate(0,0,0));
		places.put(this.name, star);
		
		for(double i = 0; i < maxPlaces; i++) {
			double rX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rZ = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			//TODO check if the coordinate is an acceptable range of other places..
			String name = PlanetNames.gen();
			while(nameRegistry.contains(name)) {
				name = StarNames.gen();
			}
			Destination place = new Destination(name, new LocationCoordinate(rX, rY, rZ));
			places.put(name, place);
		}
		if(places.size() <= 1) {
			double rX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double rZ = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			Destination place = new Destination(PlanetNames.gen(), new LocationCoordinate(rX, rY, rZ));
			places.put(name, place);
		}
		return places;
	}
}
