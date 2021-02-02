package avaj;


public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();
    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
                case "SUN": this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: SUN");
                            if (this.coordinates.getHeight() > 100) {
                                this.coordinates.setHeight(100);
                            }
                            break;
                case "RAIN": this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: RAIN");
                            break;
                case "SNOW": this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: SNOW");
                            break;
                case "FOG": this.coordinates.setHeight(this.coordinates.getHeight() - 2);
                            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: FOG");
                            break;
                default:
                            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: unable to contact Weather Tower.");
                            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().logToFile("Balloon #" + this.name + " [" + this.id + "]: landed/no departure.");
            Logger.getLogger().logToFile("Tower says: Balloon #" + this.name + " [" + this.id + "]" + ": unregistered from Weather Tower.");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        Logger.getLogger().logToFile("Tower says: Balloon #" + this.name + " [" + this.id + "]" + ": registered to Weather Tower.");
        weatherTower.register(this);
    }
}
