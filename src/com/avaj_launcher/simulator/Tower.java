package src.com.avaj_launcher.simulator;


import java.util.ArrayList;

import src.com.avaj_launcher.interfaces.Flyable;
import src.com.avaj_launcher.io.Logger;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		observers.add(flyable);
		Logger.log("Tower: " + flyable.getDescription() + " registered to Tower.");
	}

	public  void unregister(Flyable flyable)
	{
		observers.remove(flyable);
		Logger.log("Tower: " + flyable.getDescription() + " unregistered from Tower.");
	}

	protected void conditionsChanged()
	{
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}

