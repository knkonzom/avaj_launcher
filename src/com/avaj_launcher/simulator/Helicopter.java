package src.com.avaj_launcher.simulator;

import src.com.avaj_launcher.interfaces.Flyable;

public final class Helicopter extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	private WeatherTower weatherTower = null;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
		this.type = "Helicopter";
	}

	public void updateConditions()
	{
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || !actualWeather.equals(newWeather))
			actualWeather = newWeather;
		if (actualWeather.equals("SUN"))
			this.log("Pleasant skies for flying.");
		else if (actualWeather.equals("SNOW"))
			this.log("It's freesing - the rotor can snap.");
		else if (actualWeather.equals("RAIN"))
			this.log("It's not safe flying in the rain.");
		else if (actualWeather.equals("FOG"))
			this.log("Visibility is limited due to fog.");
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
			newCoords = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
		else if (this.actualWeather.equals("RAIN"))
			newCoords = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
		else if (this.actualWeather.equals("FOG"))
			newCoords = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
		move(newCoords);
	}

	protected void land()
	{
		this.log("landing. - Coordinates : (" + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
