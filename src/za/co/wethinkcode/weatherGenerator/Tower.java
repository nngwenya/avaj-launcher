package za.co.wethinkcode.weatherGenerator;
import java.util.List;

import za.co.wethinkcode.crafts.Flyable;

import java.util.ArrayList;
public  abstract class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> unregistered = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if(observers.contains(flyable))
            return;
        observers.add(flyable);

    }

    public void unregister(Flyable flyable){

        if(unregistered.contains(flyable))
            return;
        unregistered.add(flyable);
    }

    protected void conditionsChanged(){

        for (Flyable flyable : observers)
        {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    } 
}