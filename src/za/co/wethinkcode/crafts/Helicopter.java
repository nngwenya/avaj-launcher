package za.co.wethinkcode.crafts;

import za.co.wethinkcode.weatherGenerator.Coordinates;
import za.co.wethinkcode.weatherGenerator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();

    Helicopter(String name, Coordinates coordinates){
       super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather == "SUN")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
          
            String str = "Helicopter#" + this.name + "(" + this.id + "):" + " Sun's out guns out.";
            Logger.writeToFile(str);
        }
        else if (weather == "RAIN")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight());
        	this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
         
            String str = "Helicopter#" + this.name + "(" + this.id + "):" + " I made it rain";
            Logger.writeToFile(str);
        }
        else if (weather == "FOG")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight());
        	this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
           
            String str = "Helicopter#" + this.name + "(" + this.id + "):" + " Am as blind Bob marley";
            Logger.writeToFile(str);
        }
        else if (weather == "SNOW")
        {
         	this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        	this.coordinates.setLongitude(this.coordinates.getLongitude());
        	this.coordinates.setLatitude(this.coordinates.getLatitude());
          
            String str = "Helicopter#" + this.name + "(" + this.id + "):" + " Am getting a brain freeze";
            Logger.writeToFile(str);
        }

        if (this.coordinates.getHeight() == 0)
        {
            this.weatherTower.unregister(this);
            String land = "Tower says: Helicopter" + this.name + "#" + "(" + this.id + ")" + " Has landed.";
            String UnregStr = "Tower says: Helicopter" + this.name + "#" + "(" + this.id + ")" + " unregistered from weather tower [Coordinates = "  + this.coordinates.getLongitude() + "," 
            + this.coordinates.getLatitude() + "," + this.coordinates.getHeight() + "]";
            Logger.writeToFile(land);
            Logger.writeToFile(UnregStr);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String str = "Tower says: Helicopter" + this.name + "#" + "(" + this.id + ")" + " registered to weather tower";
        Logger.writeToFile(str);
    }
}