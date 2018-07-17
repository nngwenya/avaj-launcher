package za.co.wethinkcode.crafts;

import za.co.wethinkcode.weatherGenerator.WeatherTower;

public interface Flyable{
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}