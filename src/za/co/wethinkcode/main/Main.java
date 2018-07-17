package za.co.wethinkcode.main;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

import za.co.wethinkcode.weatherGenerator.WeatherTower;
import za.co.wethinkcode.crafts.AircraftFactory;
import za.co.wethinkcode.crafts.Flyable;
import za.co.wethinkcode.crafts.Logger;

public class Main{
private static WeatherTower weatherTower;
private static List<Flyable> flyables = new ArrayList<Flyable>();

private static boolean checkNumber(String line)
{
	for (int i = 0; i < line.length(); i++)
	{
		if (Character.isDigit(line.charAt(i)) == false)
			return false;
	}
	return true;
}

private static boolean verifyDigits(String items[])
{
	if (checkNumber(items[2]) == true && checkNumber(items[3]) == true && checkNumber(items[4]) == true)
		return true;
	else
		return false;
	
}

public static void main(String[] args) throws InterruptedException
  {

    try{
      Logger.Openfile();
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      String line = reader.readLine();
      
      if(line != null){
        weatherTower = new WeatherTower();
        int simulations = Integer.parseInt(line.toString().trim().split(" ")[0]); //converting a string into Integers

        if(simulations < 0){
          System.out.println("Invalid simulations count " + simulations);
          System.exit(1);
        }
        while ((line = reader.readLine()) != null){
          line = line.trim();
          String items[] = line.split("\\s");
          if (verifyDigits(items) == true)
          {
	          Flyable flyable = AircraftFactory.newAircraft(items[0], items[1],
	                  Integer.parseInt(items[2]), Integer.parseInt(items[3]),
	                  Integer.parseInt(items[4]));
	          flyables.add(flyable);
	      }
          else
          {
        	  System.out.println("Invalid input detected");
        	  return;
          }
        }
        for (Flyable flyable : flyables){
          flyable.registerTower(weatherTower);
        }
        for (int i = 1; i <= simulations; i++){
          Logger.writeToFile("\nsimulation " + i);
          weatherTower.changeWeather();
        }
      }
      Logger.closefile();
      reader.close();

    } catch (FileNotFoundException e){
      System.out.println("Couldn't find file " + args[0]);
    } catch (IOException e){
      System.out.println("There was an error while reading the file " + args[0]);
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Specify scenario file");
    }catch (Exception exc){
      System.out.println("Invalid file format");
    }
    

	
  }
}
