package za.co.wethinkcode.crafts;

import za.co.wethinkcode.weatherGenerator.Coordinates;

public abstract class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();

    }
    private long nextId(){
        return (++idCounter);
    }
}