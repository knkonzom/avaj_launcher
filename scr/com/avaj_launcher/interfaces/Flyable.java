package scr.com.avaj_launcher.interfaces;

import scr.com.avaj_launcher.simulator.*;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	String getDescription();
}
