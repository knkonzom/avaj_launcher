package avaj;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString() {
        return String.format("Tower says: Helicopter #%s(%d)",name, id);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN": this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                        System.out.println("Helicopter #" + name + "(" + id +"):" + " This weather is hot!");
                        if (this.coordinates.getHeight() > 100) {
                            this.coordinates.setHeight(100);
                        }
                        break;
            case "RAIN": this.coordinates.setHeight(this.coordinates.getHeight() + 5);
                        System.out.println("Helicopter #" + name + "(" + id +"):" + " It's not good flying in rain.");
                        break;
            case "SNOW": this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                        System.out.println("Helicopter #" + name + "(" + id +"):" + " The rotors will freeze if we continue flying.");
                        break;
            case "FOG": this.coordinates.setHeight(this.coordinates.getHeight() + 1);
                        System.out.println("Helicopter #" + name + "(" + id +"):" + " Limited visibility due to fog.");
                        break;
            default:
                        System.out.println("Helicopter #" + name + "(" + id +"):" + " Unable to contact Weather Tower.");
                        break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Helicopter #" + name + "(" + id +"):" + " Landing.");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
