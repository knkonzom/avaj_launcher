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
		int idx = (coordinates.getLongitude() + coordinates.getHeight() + coordinates.getLatitude()) % 20;
		if (idx < 5)
			return weather[0];
		else if (idx < 10)
			return weather[1];
		else if (idx < 15)
			return weather[2];
		else
			return weather[3];
	}
}