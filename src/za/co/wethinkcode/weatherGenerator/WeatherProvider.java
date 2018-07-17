package za.co.wethinkcode.weatherGenerator;

import java.util.Random;

public class WeatherProvider{
    private static WeatherProvider weatherProvider =  new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){        
        Random rand = new Random();

        int randWeather = rand.nextInt(4);
        return weather[randWeather];
    }
}