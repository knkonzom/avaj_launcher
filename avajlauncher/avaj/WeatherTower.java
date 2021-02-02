package avaj;


public class WeatherTower extends Tower {
    WeatherProvider getnewProvider = new WeatherProvider();

    public String getWeather(Coordinates coordinates) {
        return getnewProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
