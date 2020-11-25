package avaj;

import avaj.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN": this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                        Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: SUN");
                        if (this.coordinates.getHeight() > 100) {
                            this.coordinates.setHeight(100);
                        }
                        break;
            case "RAIN": this.coordinates.setHeight(this.coordinates.getHeight() + 5);
                        Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: RAIN");
                        break;
            case "SNOW": this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                        Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: SNOW");
                        break;
            case "FOG": this.coordinates.setHeight(this.coordinates.getHeight() + 1);
                        Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: FOG");
                        break;
            default:
                        Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: unable to contact Weather Tower.");
                        break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().logToFile("Helicopter #" + this.name + " [" + this.id + "]: landed/no departure.");
            Logger.getLogger().logToFile("Tower says: Helicopter #" + this.name + " [" + this.id + "]" + ": unregistered from Weather Tower.");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        Logger.getLogger().logToFile("Tower says: Helicopter #" + this.name + " [" + this.id + "]" + ": registered to Weather Tower.");
        weatherTower.register(this);
    }
}
