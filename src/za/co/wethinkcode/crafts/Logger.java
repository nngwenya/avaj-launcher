package za.co.wethinkcode.crafts;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	static File file;
	static FileWriter filewrt;
	public static void Openfile()
	{
		try
		{
			File file = new File("Simulation.txt");
			if (!file.exists())
				{
					file.createNewFile();
				}	
				filewrt = new FileWriter(file);
		}
		catch(IOException ioe)
		{

		}

	}

	public static void closefile()
	{
		try
		{
			filewrt.close();
		}
		catch(IOException ieo)
		{

		}
	}
	public static void writeToFile(String line) {

		try {

			filewrt.write(line);
			filewrt.write("\n");
		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		}
	}

}