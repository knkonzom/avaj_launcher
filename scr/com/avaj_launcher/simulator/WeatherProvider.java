package scr.com.avaj_launcher.simulator;

public class WeatherProvider
{
	private WeatherProvider() { }

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static final String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

	public static WeatherProvider getProvider() {
		return (WeatherProvider.weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int x = (coordinates.getLongitude() + coordinates.getHeight() + coordinates.getLatitude()) % 20;
		if (x < 5)
			return weather[0];
		else if (x < 10)
			return weather[1];
		else if (x < 15)
			return weather[2];
		else
			return weather[3];
	}
}