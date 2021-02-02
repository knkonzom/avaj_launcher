package scr.com.avaj_launcher.simulator;

import scr.com.avaj_launcher.interfaces.Flyable;

public final class JetPlane extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	private WeatherTower weatherTower = null;

	JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "JetPlane";
	}

	
	public void updateConditions()
	{
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || !actualWeather.equals(newWeather))
			actualWeather = newWeather;
		if (actualWeather.equals("SUN"))
			this.log("Clear skies all around.");
		else if (actualWeather.equals("SNOW"))
			this.log("Currently snowing.");
		else if (actualWeather.equals("RAIN"))
			this.log("It's raining now.");
		else if (actualWeather.equals("FOG"))
			this.log("It's foggy - limited visibility bad for flying.");
		this.orderMove();
	}

	public void registerTower(WeatherTower weatherTower)
	{
		weatherTower.register(this);
		this.weatherTower = weatherTower;
	}

	private void orderMove()
	{
		Coordinates newCoords;
		if (this.actualWeather.equals("SUN"))
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
		else if (this.actualWeather.equals("RAIN"))
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
		else if (this.actualWeather.equals("FOG"))
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
		move(newCoords);
	}

	protected void land()
	{
		this.log("landing. - Coordinates : (" + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
