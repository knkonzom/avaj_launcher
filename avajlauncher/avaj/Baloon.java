package avaj;

import avaj.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString() {
        return String.format("Tower says: Baloon #%s(%d)",name, id);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
                case "SUN": this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                            System.out.println("Balon #" + name + "(" + id +"):" + " This weather is hot!");
                            if (this.coordinates.getHeight() > 100) {
                                this.coordinates.setHeight(100);
                            }
                            break;
                case "RAIN": this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                            System.out.println("Balon #" + name + "(" + id +"):" + " It's currently raining!");
                            break;
                case "SNOW": this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                            System.out.println("Balon #" + name + "(" + id +"):" + " Snow makes flying difficult!");                            
                            break;
                case "FOG": this.coordinates.setHeight(this.coordinates.getHeight() - 2);
                System.out.println("Ballon #" + name + "(" + id +"):" + " Weather is all foggy - terrible for flying!");
                            break;
                default:
                System.out.println("Ballon #" + name + "(" + id +"):" + " Unable to contact Weather Tower.");
                            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Ballon #" + name + "(" + id +"):" + " Landing");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
