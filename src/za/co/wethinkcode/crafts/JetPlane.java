package za.co.wethinkcode.crafts;

import za.co.wethinkcode.weatherGenerator.Coordinates;
import za.co.wethinkcode.weatherGenerator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
     
        if (weather == "SUN")
        {
        	this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
           
            String str = "JetPlane#" + this.name + "(" + this.id + "):" + " Mommy i don't wanna go to the light.";
            Logger.writeToFile(str);
        }
        else if (weather == "RAIN")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight());
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
        	
            String str = "JetPlane#" + this.name + "(" + this.id + "):" + " I made it rain";
            Logger.writeToFile(str);
        }
        else if (weather == "FOG")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight());
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            String str = "JetPlane#" + this.name + "(" + this.id + "):" + " Am as blind Bob mally";
            Logger.writeToFile(str);
        }
        else if (weather == "SNOW")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
            String str ="JetPlane#" + this.name + "(" + this.id + "):" + " FREEZE Jet";
            Logger.writeToFile(str);
        }        

        if (this.coordinates.getHeight() == 0)
        {
            this.weatherTower.unregister(this);
            String UnregStr = "Tower says: JetPlane" + this.name + "#" + "(" + this.id + ")" + " unregistered from weather tower [Coordinates = "  + this.coordinates.getLongitude() + ","
            + this.coordinates.getLatitude() + "," + this.coordinates.getHeight() + "]";
            Logger.writeToFile(UnregStr);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String RegStr = "Tower says: JetPlane" + this.name + "#" + "(" + this.id + ")" + " registered to weather tower";
        Logger.writeToFile(RegStr);
    }
}