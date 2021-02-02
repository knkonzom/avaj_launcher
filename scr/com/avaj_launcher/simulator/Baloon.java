package scr.com.avaj_launcher.simulator;

import scr.com.avaj_launcher.interfaces.Flyable;

public final class Baloon extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	private WeatherTower weatherTower = null;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "Baloon";
	}

	public void updateConditions()
	{
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || !actualWeather.equals(newWeather))
			actualWeather = newWeather;

		if (actualWeather.equals("SUN"))
			this.log("Sunny skies all around.");
		else if (actualWeather.equals("SNOW"))
			this.log("Oh no it's snowing.");
		else if (actualWeather.equals("RAIN"))
			this.log("Rain will affect how the baloon flies.");
		else if (actualWeather.equals("FOG"))
			this.log("It's not safe flying in a fog.");
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
			newCoords = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
		else if (this.actualWeather.equals("RAIN"))
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
		else if (this.actualWeather.equals("FOG"))
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
		move(newCoords);
	}

	protected void land()
	{
		this.log("Landing - Coordinates : (" + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
