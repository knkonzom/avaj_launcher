package avaj;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String[] weather = new String[]{"SUN", "FOG", "RAIN", "SNOW"};

    private static void WeatherProvider(){}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        
        int nearestNumber = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        if (nearestNumber <= 40) {
            return weather[3];
        } else if ( nearestNumber > 40 && nearestNumber <= 60) {
            return weather[2];
        } else if (nearestNumber >60 && nearestNumber <= 80) {
            return weather[1];
        } else if( nearestNumber > 80) {
            return weather[0];
        } else {
            return ("Invalid Weather\n");
        }
    }
}
