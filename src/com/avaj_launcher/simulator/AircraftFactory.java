package src.com.avaj_launcher.simulator;

import src.com.avaj_launcher.interfaces.Flyable;


public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int latitude, int longitude, int height) throws SimulatorException
	{
		if (latitude < 0 || longitude < 0 || height < 0)
			throw new SimulatorException("Error: Inputs MUST be positive values.");
		else if (height > 100)
			height = 100;
		Coordinates coordinates = new Coordinates(latitude, longitude, height);
		if (type.equals("Baloon"))
		{
			return new Baloon(name, coordinates);
		}
		else if (type.equals("JetPlane"))
		{
			return new JetPlane(name, coordinates);
		}
		else if (type.equals("Helicopter"))
		{
			return new Helicopter(name, coordinates);
		}
		else
		{
			throw new SimulatorException("Error: Unknown Aircraft [" + type + "]");
		}
	}
}
