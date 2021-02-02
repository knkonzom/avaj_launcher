package avaj;


public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString() {
        return String.format("Tower says: JetPlane #%s(%d)",name, id);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        
        switch (weather) {
            case "SUN": this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                        System.out.println("JetPlane #" + name + "(" + id +"):" + " This weather is hot!");
                        if (this.coordinates.getHeight() > 100) {
                            this.coordinates.setHeight(100);
                        }
                        break;
            case "RAIN": this.coordinates.setHeight(this.coordinates.getHeight() + 5);
                        System.out.println("JetPlane #" + name + "(" + id +"):" + " Expect some rainy weather.");
                        break;
            case "SNOW": this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                        System.out.println("JetPlane #" + name + "(" + id +"):" + "  Limited visibility due to snow.");
                        break;
            case "FOG": this.coordinates.setHeight(this.coordinates.getHeight() + 1);
                        System.out.println("JetPlane #" + name + "(" + id +"):" + " Fog will limit visibility.");
                        break;
            default:
                        System.out.println("JetPlane #" + name + "(" + id +"):" + " Unable to contact Weather Tower");
            break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("JetPlane #" + name + "(" + id +"):" + " Landed");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
