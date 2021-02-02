package src.com.avaj_launcher.interfaces;


import src.com.avaj_launcher.simulator.*;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	String getDescription();
}
