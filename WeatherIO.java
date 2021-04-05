package climatechange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherIO implements IWeatherIO
{
	/**
	 *  Reads all data from the weather data file
	 */
	public ArrayList<ITemperature> readDataFromFile(String fileName) 
	{
		ArrayList<ITemperature> itemp = new ArrayList<>();

		try
		{
			// Build chain of readers.
			File f = new File(fileName);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine(); // skip the 1st line of the file
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] arr = line.split(",");
				Temperature temp = new Temperature(Double.parseDouble(arr[0].trim()),
						Integer.parseInt(arr[1].trim()), arr[2].trim(), arr[3].trim(), arr[4].trim());
				itemp.add(temp);
			}
			//Close br, fr
			br.close();
			fr.close();	
		}
		catch(IOException io)
		{
			System.out.println("Invalid Data File");
		}
		
		return itemp;
	}
	
	
	// 1. write the subject header before dumping data returned from each ClimateAnalyzer method
	// 2. a subject header is to be written for each ClimateAnalyzer method call
	// @param subject stores the actual header for the specific topic
	public void writeSubjectHeaderInFile(String filename, String subject)
	{
		try
		{
			// Build chain of writers.
			File f = new File(filename);
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.write(subject); 
			bw.newLine();
			// Close pw, fw
			bw.close();
			fw.close();
		}
		catch(IOException io)
		{
			System.out.println("Invalid File");
		}
	}
	
	// 1. file name should be called “taskXX_climate_info.csv” where XX will be replaced by the task id: A1, A2, etc
	// 2. use this method to store the temperature info (for each Climate Analyzer task)
	// a) one row for each temperature data object (i.e. all fields in one row (each comma delimited) )
	// b) similar to the original input data file)
	// 3. temperature value should be formatted to use a maximum of 2 decimal places
	// 4. temperature field should also show the Fahrenheit value (using decimal rules above)
	// a) the temperature field should look like i.e. 21.34(C) 70.42(F)
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList)
	{
		try
		{
			// Build chain of writers.
			File f = new File(filename);
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(topic); 
			bw.newLine();
			for(ITemperature t : theWeatherList)
			{
				bw.write(String.format("%.2f", t.getTemperature(false)) + "(C) "); // print temperature in Celsius with 2 decimal places
				bw.write(String.format("%.2f", t.getTemperature(true)) + "(F),"); // print temperature in Fahrenheit with 2 decimal places
				bw.write(t.getYear() + "," + t.getMonth()+ "," + t.getCountry() + "," + t.getCountry3LetterCode());
				bw.newLine();
			}
			bw.newLine();
			
			// Close pw, fw
			bw.close();
			fw.close();
		}
		catch(IOException io)
		{
			System.out.println("Invalid File");
		}
	}

}
