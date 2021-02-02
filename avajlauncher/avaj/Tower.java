package avaj;

import avaj.Flyable;
import java.util.*;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println(flyable + " registered to Weather Tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println((flyable + " unregistered from Weather Tower."));
    }

    protected void conditionsChanged() {
        int x = 0;
        while(x < observers.size()) {
            observers.get(x).updateConditions();
            x++;
        }
    }
}
