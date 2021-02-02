package scr.com.avaj_launcher.simulator;

import java.util.ArrayList;
import scr.com.avaj_launcher.input_output.Logger;
import scr.com.avaj_launcher.interfaces.Flyable;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		Logger.log("Tower says: " + flyable.getDescription() + " registered to weather tower.");
	}

	public  void unregister(Flyable flyable)
	{
		observers.remove(flyable);
		Logger.log("Tower says: " + flyable.getDescription() + " unregistered from weather tower.");
	}

	protected void conditionsChanged()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}

