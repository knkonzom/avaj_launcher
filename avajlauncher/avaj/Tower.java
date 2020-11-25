package avaj;

import avaj.*;
import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable)) {
            return;
        }
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
