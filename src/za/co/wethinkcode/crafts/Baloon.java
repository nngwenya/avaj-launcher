package za.co.wethinkcode.crafts;

import za.co.wethinkcode.weatherGenerator.Coordinates;
import za.co.wethinkcode.weatherGenerator.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN")
        {
        	this.coordinates.setHeight(this.coordinates.getHeight() + 4);
        	this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
        	
            String str = "Baloon#" + this.name + "(" + this.id + "):" + " The sun is gonna pop my baloon";
            Logger.writeToFile(str);
        }
        else if (weather == "RAIN")
        {
        	
        	this.coordinates.setHeight(this.coordinates.getHeight() - 5);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
        
            String str = "Baloon#" + this.name + "(" + this.id + "):" + " I needed a shower like Jacob Zuma ";
            Logger.writeToFile(str);
        }
        else if (weather == "FOG")
        {
        	this.coordinates.setHeight(this.coordinates.getHeight() - 3);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
         
            String str = "Baloon#" + this.name + "(" + this.id + "):" + " Am as blind Bob marley";
            Logger.writeToFile(str);
        }
        else if (weather == "SNOW")
        {
        	this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
        	
            String str = "Baloon#" + this.name + "(" + this.id + "):" + " Wow it's so cold i feel like a snow man";
            Logger.writeToFile(str);
        }

        if (this.coordinates.getHeight() == 0)
        {
            this.weatherTower.unregister(this);
            String land = "Tower says: Baloon" + this.name + "#" + "(" + this.id + ")" + " Has landed.";
            String UnregStr = "Tower says: Baloon" + this.name + "#" + "(" + this.id + ")" + " unregistered from weather tower [Coordinates = "  + this.coordinates.getLongitude() + "," 
            + this.coordinates.getLatitude() + "," + this.coordinates.getHeight() + "]";
            Logger.writeToFile(land);
            Logger.writeToFile(UnregStr);
        }
    }

    public void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String str = "Tower says: Baloon" + this.name + "#" + "(" + this.id + ")" + " registered to weather tower";
        Logger.writeToFile(str);
    }
}