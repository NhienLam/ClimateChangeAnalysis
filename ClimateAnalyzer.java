package climatechange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClimateAnalyzer implements IClimateAnalyzer
{
	private WeatherIO wio;
	private ArrayList<ITemperature> wList;
	
	public ClimateAnalyzer(String filename)
	{
		super();
		wio = new WeatherIO();
		wList = wio.readDataFromFile(filename);
	}
	
	// Convert int month to corresponding month String
	public String convertMonthToString(int month)
	{
		String monthString;
		switch(month)
		{
			case 1: 
				monthString = "Jan";
				break;
			case 2:  
				monthString = "Feb";
				break;
			case 3: 
				monthString = "Mar";
				break;
			case 4:
				monthString = "Apr";
				break;
			case 5:
				monthString = "May";
				break;
			case 6:
				monthString = "Jun";
				break;
			case 7:
				monthString = "Jul";
				break;
			case 8:
				monthString = "Aug";
				break;
			case 9:
				monthString = "Sep";
			break;
			case 10: 
				monthString = "Oct";
				break;
			case 11:
				monthString = "Nov";
				break;
			case 12:
				monthString = "Dec";
				break;
			default:
				monthString = "Invalid month";
				break;
		}
		return monthString;
	}
	
	
	/* ********** TASK A - For a specific country search ********** */
	
	// TASK A-1
	// for all data that matches the specified month, get the lowest temperature reading
	public ITemperature getLowestTempByMonth(String country, int month)
	{
		ITemperature lowestTempObj = null;// = new Temperature(Double.MAX_VALUE, Integer.MAX_VALUE, convertMonthToString(month), country, "");
		double lowestTemp = Double.MAX_VALUE; //lowestTempO.getTemperature(false);
		
		// Traverse through the wList to find the Temperature objects with specified country and target month 
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country and target month  
			if(it.getCountry().equals(country) && it.getMonth().contentEquals(convertMonthToString(month)))
			{
				// Checks if this temperature is lower than lowestTemp
				if(it.getTemperature(false) < lowestTemp)
				{
					// Assign this temperature to the lowestTemp
					lowestTemp = it.getTemperature(false);
					lowestTempObj = it;
				}
			}
		}
				
		return lowestTempObj;
	}

	// TASK A-1
	// for all data that matches the specified month, get the highest temperature reading
	public ITemperature getHighestTempByMonth(String country, int month)
	{
		ITemperature highestTempObj = null;
		double highestTemp = -Double.MAX_VALUE; 

		// Traverse through the wList to find the Temperature objects with specified country and target month 
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country and target month  
			if(it.getCountry().equals(country) && it.getMonth().contentEquals(convertMonthToString(month)))
			{
				// Checks if this temperature is higher than highestTemp
				if(it.getTemperature(false) > highestTemp)
				{
					// Assign this temperature to the highestTemp
					highestTemp = it.getTemperature(false);
					highestTempObj = it;
				}
			}
		}

		return highestTempObj;
	}

	
	// TASK A-2
	// for all data that matches the specified year, get the lowest temperature reading
	public ITemperature getLowestTempByYear(String country, int year)
	{
		ITemperature lowestTempObj = null;
		double lowestTemp = Double.MAX_VALUE; 
		
		// Traverse through the wList to find the Temperature objects with specified country and target year 
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country and target year  
			if(it.getCountry().equals(country) && it.getYear() == year)
			{
				// Checks if this temperature is lower than lowestTemp
				if(it.getTemperature(false) < lowestTemp)
				{
					// Assign this temperature to the lowestTemp
					lowestTemp = it.getTemperature(false);
					lowestTempObj = it;
				}
			}
		}
		
		return lowestTempObj;
	}

	// TASK A-2
	// for all data that matches the specified year, get the highest temperature reading
	public ITemperature getHighestTempByYear(String country, int year)
	{
		ITemperature highestTempObj = null;
		double highestTemp = -Double.MAX_VALUE; 
		
		// Traverse through the wList to find the Temperature objects with specified country and target year 
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country and target year  
			if(it.getCountry().equals(country) && it.getYear() == year)
			{
				// Checks if this temperature is higher than highestTemp
				if(it.getTemperature(false) > highestTemp)
				{
					// Assign this temperature to the highestTemp
					highestTemp = it.getTemperature(false);
					highestTempObj = it;
				}
			}
		}
		
		return highestTempObj;
	}
	
	// TASK A-3
	// get all temperature data that fall within the given temperature range
	// the set is sorted from lowest to highest temperature
	// input parameter values are in Celsius
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp)
	{
		TreeSet<ITemperature> lowHighTree = new TreeSet<>();
		
		for(ITemperature it : wList)
		{
			if(it.getCountry().equals(country) && it.getTemperature(false) <= rangeHighTemp 
					&& it.getTemperature(false) >= rangeLowTemp)
			{
				lowHighTree.add(it);
			}
		}
		
		return lowHighTree;	
	}
	
	// TASK A-4
	// 1. get the lowest temperature reading amongst all data for that country	
	public ITemperature getLowestTempYearByCountry(String country)
	{
		ITemperature lowestTempObj = null;
		double lowestTemp = Double.MAX_VALUE; 

		// Traverse through the wList to find the Temperature objects with specified country
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country
			if(it.getCountry().equals(country))
			{
				// Checks if this temperature is lower than lowestTemp
				if(it.getTemperature(false) < lowestTemp)
				{
					// Assign this temperature to the lowestTemp
					lowestTemp = it.getTemperature(false);
					lowestTempObj = it;
				}
			}
		}
		
		return lowestTempObj;
	}
	
	// TASK A-4
	// 1. get the highest temperature reading amongst all data for that country
	public ITemperature getHighestTempYearByCountry(String country)
	{
		ITemperature highestTempObj = null;
		double highestTemp = -Double.MAX_VALUE; 

		// Traverse through the wList to find the Temperature objects with specified country
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified country
			if(it.getCountry().equals(country))
			{
				// Checks if this temperature is higher than highestTemp
				if(it.getTemperature(false) > highestTemp)
				{
					// Assign this temperature to the highestTemp
					highestTemp = it.getTemperature(false);
					highestTempObj = it;
				}
			}
		}
		
		return highestTempObj;
	}

	/* ********** TASK B - For an inclusive all countries search (all data) ********** */

	// TASK B-1
	// Get the list of the Top10 lowest temperature reading for a given month between 2000 and 2016
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month)
	{
		ArrayList<ITemperature> sameMonth = new ArrayList<>();
		ArrayList<ITemperature> top10LowestTemp = new ArrayList<>();
		ArrayList<String> uniqueCountries = new ArrayList<>(); 
		
		// Traverse through the wList to find the Temperature objects with specified months
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified month
			if(it.getMonth().equals(convertMonthToString(month)))
			{
				// Add all the Temperature objects with the specified moth
				sameMonth.add(it);
			}
		}
		
		// Sort the sameMonth list into ascending order 
		Collections.sort(sameMonth);
		
		int count = 0;

		// Add the first 10 elements (unique countries) of the sorted sameMonth list to the top10LowestTemp
		// Traverse through the sorted sameMonth list
		for(ITemperature itemp : sameMonth)
		{
			// Make sure only add 10 obj
			if(count < 10)
			{
				// Checks if the country is already added to the top10LowestTemp list
				// Guarantee countries are unique
				if(!uniqueCountries.contains(itemp.getCountry()))
				{
					// Adds the Temperature object to the top10LowestTemp list 
					top10LowestTemp.add(itemp);
					uniqueCountries.add(itemp.getCountry());
					count++;
				}
			}
			else
			{
				break;
			}
		}		
		
		return top10LowestTemp;
	}
	
	// TASK B-1
	// Get the list of the Top10 highest temperature reading for a given month between 2000 and 2016
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month)
	{
		ArrayList<ITemperature> sameMonth = new ArrayList<>();
		ArrayList<ITemperature> top10HighestTemp = new ArrayList<>();
		ArrayList<String> uniqueCountries = new ArrayList<>(); 
		
		// Traverse through the wList to find the Temperature objects with specified months
		for(ITemperature it : wList)
		{
			// Check if the Temperature object has the same specified month
			if(it.getMonth().equals(convertMonthToString(month)))
			{
				// Add all the Temperature objects with the specified moth
				sameMonth.add(it);
			}
		}
		
		// Sort the sameMonth list into descending order 
		Collections.sort(sameMonth, Collections.reverseOrder());
		
		int count = 0;

		// Add the first 10 elements (unique countries) of the descending sorted sameMonth list to the top10HighestTemp
		// Traverse through the sorted sameMonth list
		for(ITemperature itemp : sameMonth)
		{
			// Make sure only add 10 obj
			if(count < 10)
			{
				// Checks if the country is already added to the top10LowestTemp list
				// Guarantee countries are unique
				if(!uniqueCountries.contains(itemp.getCountry()))
				{
					// Adds the Temperature object to the top10LowestTemp list 
					top10HighestTemp.add(itemp);
					uniqueCountries.add(itemp.getCountry());
					count++;
				}
			}
			else
			{
				break;
			}
		}		
		
		// sort the top10HighestTemp list to make lowest to highest
		Collections.sort(top10HighestTemp);
		
		return top10HighestTemp;
	}

	// TASK B-2
	// Get top 10 countries with the lowest temperature reading between 2000 and 2016
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp()
	{
		ArrayList<ITemperature> top10LowestTemp = new ArrayList<>();
		ArrayList<String> uniqueCountries = new ArrayList<>(); 
		ArrayList<ITemperature> asscendingSorted = wList;
		
		// Sort the wList list into ascending order 
		Collections.sort(asscendingSorted);
		
		int count = 0;

		// Add the first 10 elements (unique countries) of the sorted asscendingSorted list to the top10LowestTemp
		// Traverse through the sorted asscendingSorted list
		for(ITemperature itemp : asscendingSorted)
		{
			// Make sure only add 10 obj
			if(count < 10)
			{
				// Checks if the country is already added to the top10LowestTemp list
				// Guarantee countries are unique
				if(!uniqueCountries.contains(itemp.getCountry()))
				{
					// Adds the Temperature object to the top10LowestTemp list 
					top10LowestTemp.add(itemp);
					uniqueCountries.add(itemp.getCountry());
					count++;
				}
			}
			else
			{
				break;
			}
		}		

		return top10LowestTemp;		
	}

	// TASK B-2
	// Get top 10 countries with the highest temperature reading between 2000 and 2016
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp()
	{
		ArrayList<ITemperature> top10HighestTemp = new ArrayList<>();
		ArrayList<String> uniqueCountries = new ArrayList<>(); 
		ArrayList<ITemperature> descendingSorted = wList;
		
		// Sort the wList list into descending order 
		Collections.sort(descendingSorted, Collections.reverseOrder());
		
		int count = 0;

		// Add the first 10 elements (unique countries) of the descending sorted descendingSorted list to the top10HighestTemp
		// Traverse through the sorted descendingSorted list
		for(ITemperature itemp : descendingSorted)
		{
			// Make sure only add 10 obj
			if(count < 10)
			{
				// Checks if the country is already added to the top10HighestTemp list
				// Guarantee countries are unique
				if(!uniqueCountries.contains(itemp.getCountry()))
				{
					// Adds the Temperature object to the top10HighestTemp list 
					top10HighestTemp.add(itemp);
					uniqueCountries.add(itemp.getCountry());
					count++;
				}
			}
			else
			{
				break;
			}
		}
		
		// Sort the top10HighestTemp list so that lowest to highest
		Collections.sort(top10HighestTemp);
		
		return top10HighestTemp;
	}
	
	
	// TASK B-3
	// List all of the countries that fall within a specific temperature range
	// 1. the return list is sorted from lowest to highest temperature
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp)
	{
		ArrayList<ITemperature> inRange = new ArrayList<>();
		
		// Traverse through the wList to get all the Temperature obj within a lowRangeTemp-highRangeTemp range
		for(ITemperature it : wList)
		{
			if(it.getTemperature(false) <= highRangeTemp && it.getTemperature(false) >= lowRangeTemp)
			{
				inRange.add(it);
			}
		}
		
		// Sort the inRange list into ascending order 
		Collections.sort(inRange);
		
		return inRange;		
	}
	
	
	/* ********** TASK C - Climate change detection ********** */
	
	// TASK C-1
	// Get the top 10 countries with the largest change in temperature in the same specified month between
	// two different specified years
	// 1. the countries with the largest temperature differences (absolute value) of the same month between 2 given years.
	// 2. the return list is sorted from lowest to highest temperature delta
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2)
	{
		ArrayList<ITemperature> top10TempDelta = new ArrayList<>();
		ArrayList<ITemperature> validCountries = new ArrayList<>();
		Set<ITemperature> deltaTreeSet = new TreeSet<>();
		int deltaYear = Math.abs(year1 - year2);

		// Create a set of country 
		HashSet<String> countrySet = new HashSet<>();
		for(ITemperature i : wList)
		{
			countrySet.add(i.getCountry());
		}		
		
		// Traverse through the wList to get objects with specified month and years
		for(ITemperature it : wList)
		{
			if(it.getYear() == year1 || it.getYear() == year2)
			{
				if(it.getMonth().equals(convertMonthToString(month)))
				{
					validCountries.add(it);
				}
			}
		}

		// Get each country -> unique
		for(String c : countrySet)
		{
			double temp1 = 0 ;
			double temp2 = 0;
			String letterCode = "";
			
			// Traverse through validCountries list to get the country c's 1st temp, 2nd temp, and 3 letter code
			for(ITemperature vc : validCountries)
			{
				if(vc.getCountry().equals(c) && vc.getYear() == year1)
				{
					temp1 = vc.getTemperature(false);
					letterCode = vc.getCountry3LetterCode();
				}
				if(vc.getCountry().equals(c) && vc.getYear() == year2)
				{
					temp2 = vc.getTemperature(false);
				}
			}
			double deltaTemp = Math.abs(temp1-temp2);  // get the Temperature Delta 
			ITemperature deltaObj = new Temperature(deltaTemp, deltaYear, convertMonthToString(month), 
					c, letterCode);
			deltaTreeSet.add(deltaObj);
		}
		
		// Make an ArrayList of deltaTreeSet - to use get() method
		ArrayList<ITemperature> sortedDelta = new ArrayList<>(deltaTreeSet);
		
		// Add the last 10 objects (10 highest) of sortedDelta to top10TempDelta
		for(int i = sortedDelta.size() - 10; i < sortedDelta.size(); i++)
		{
			top10TempDelta.add(sortedDelta.get(i));
		}
		
		return top10TempDelta;
	}
	
	
	// 1. This method starts the climate-change task activities
	// 2. The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A
	// methods, second are the Task B methods, and third are the Task C methods)
	// 3. For each of the ClimateChange methods that require input parameters, this method must ask the user to
	// enter the required information for each of the tasks.
	// 4. Each ClimateAnalyzer method returns data, so the data results must be written to data files
	public void runClimateAnalyzer()
	{
		WeatherIO weatherIO = new WeatherIO();
		Scanner in = new Scanner(System.in);
		int month = -1;
		String topic = "Temperature,Year,Month,Country,Country_Code";
		
		// Create a set of country to check if the user input is valid
		HashSet<String> countrySet = new HashSet<>();
		for(ITemperature it : wList)
		{
			countrySet.add(it.getCountry());
		}
		
		// Create a set of month to check if the user input is valid
		HashSet<Integer> monthSet = new HashSet<>();
		for(int i =1 ; i <= 12; i++)
		{
			monthSet.add(i);
		}
		
		// Create a set of year (2000 - 2016) to check if the user input is valid
		HashSet<Integer> yearSet = new HashSet<>();
		for(int i = 2000 ; i <= 2016; i++)
		{
			yearSet.add(i);
		}
		

				
		// **** TASK A
		System.out.println("TASK A - Data for a specific country search");
		System.out.println("Please enter a country: ");
		String country = in.nextLine();
		
		// check user input 
		// if the input is invalid, ask user to enter a country until it is valid
		while(!countrySet.contains(country))
		{
			System.out.println("Invalid Input - Your country name is invalid, please try again: ");
			country = in.nextLine();
		}
			
		// TASK A1
		System.out.println("TASK A1 - Get data which has the lowest and highest temperature reading for a given month");
		System.out.println("Please enter a month (1-12): ");

		String nextLineA1 = in.nextLine();
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineA1) == false)
		{
			System.out.println("Invalid input - Please enter a month as an Integer: ");
			nextLineA1 = in.nextLine();
		}
		if(isInteger(nextLineA1) == true)
		{
			month = Integer.valueOf(nextLineA1);
			// Check if the input is a valid month
			// Keep asking, until the user enter a valid month
			while(!monthSet.contains(month)) 
			{
				System.out.println("Invalid Input - Your month is invalid, please try again: ");
				nextLineA1 = in.nextLine();
				if(isInteger(nextLineA1) == true)
				{
					month = Integer.valueOf(nextLineA1);
				}
			}
		}	
		
		// TASK A1_1 - getLowestTempByMonth(String country, int month)
		ITemperature taskA1_1 = getLowestTempByMonth(country, month);
		ArrayList<ITemperature>  taskA1_1List = new ArrayList<>();
		taskA1_1List.add(taskA1_1);
		
		weatherIO.writeSubjectHeaderInFile("data/taskA1_climate_info.csv", "Task A1: Lowest temperature for " + country 
										+ " for the month " + convertMonthToString(month));
		weatherIO.writeDataToFile("data/taskA1_climate_info.csv", topic, taskA1_1List);
		
	
		// TASK A1_2 - getHighestTempByMonth(String country, int month)
		ITemperature taskA1_2 = getHighestTempByMonth(country, month);
		ArrayList<ITemperature>  taskA1_2List = new ArrayList<>();
		taskA1_2List.add(taskA1_2);

		weatherIO.writeSubjectHeaderInFile("data/taskA1_climate_info.csv", "Task A1: Highest temperature for " + country 
				+ " for the month " + convertMonthToString(month));
		weatherIO.writeDataToFile("data/taskA1_climate_info.csv", topic, taskA1_2List);

		
		// TASK A2
		int yearA2 = -1;
		System.out.println("TASK A2 - Get data for the month which has the lowest and highest temperature in a given year");
		System.out.println("Please enter a year (2000-2016): ");
		String nextLineA2 = in.nextLine();
		
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineA2) == false)
		{
			System.out.println("Invalid input - Please enter a year as an Integer: ");
			nextLineA2 = in.nextLine();
		}
		if(isInteger(nextLineA2) == true)
		{
			yearA2 = Integer.valueOf(nextLineA2);
			// Check if the input is a valid year
			// Keep asking, until the user enter a valid year
			while(!yearSet.contains(yearA2)) 
			{
				System.out.println("Invalid Input - Your year is invalid, please try again: ");
				nextLineA2 = in.nextLine();
				if(isInteger(nextLineA2) == true)
				{
					yearA2 = Integer.valueOf(nextLineA2);
				}
			}
		}
		
		
		// TASK A2_1 - getLowestTempByYear(String country, int year)
		ITemperature taskA2_1 = getLowestTempByYear(country, yearA2);
		ArrayList<ITemperature>  taskA2_1List = new ArrayList<>();
		taskA2_1List.add(taskA2_1);
		
		weatherIO.writeSubjectHeaderInFile("data/taskA2_climate_info.csv", "Task A2: Lowest temperature for " + country 
				+ " for the year " + yearA2);
		weatherIO.writeDataToFile("data/taskA2_climate_info.csv", topic, taskA2_1List);
		
		
		// TASK A2_2 - getHighestTempByYear(String country, int year)
		ITemperature taskA2_2 = getHighestTempByYear(country, yearA2);
		ArrayList<ITemperature>  taskA2_2List = new ArrayList<>();
		taskA2_2List.add(taskA2_2);
		
		weatherIO.writeSubjectHeaderInFile("data/taskA2_climate_info.csv", "Task A2: Highest temperature for " + country 
				+ " for the year " + yearA2);
		weatherIO.writeDataToFile("data/taskA2_climate_info.csv", topic, taskA2_2List);
		
		
		// TASK A-3 - getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp)
		double lowRange = 0;
		System.out.println("TASK A3 - Get all data that falls within a specific temperature range");
		System.out.println("Please enter the low temperature range (in Celsius): ");
	//	double lowRange = Double.valueOf(in.nextLine());
		
		String nextLineA3Low = in.nextLine();
		
		// Check if the input is a number
		// Keep asking, until the user enter a number
		while(isDouble(nextLineA3Low) == false)
		{
			System.out.println("Invalid input - Please enter a low temperature range as a number: ");
			nextLineA3Low = in.nextLine();
		}
		if(isDouble(nextLineA3Low) == true)
		{
			lowRange = Double.valueOf(nextLineA3Low);
		}
		
		double highRange = 0;
		System.out.println("Please enter the high temperature range (in Celsius): ");
	//	double highRange = Double.valueOf(in.nextLine());

		String nextLineA3High = in.nextLine();
		
		// Check if the input is a number
		// Keep asking, until the user enter a number
		while(isDouble(nextLineA3High) == false)
		{
			System.out.println("Invalid input - Please enter a high temperature range as a number: ");
			nextLineA3High = in.nextLine();
		}
		if(isDouble(nextLineA3High) == true)
		{
			highRange = Double.valueOf(nextLineA3High);
			// Check if the input is a number
			// Keep asking, until the user enter a valid high temperature range
			while(!(highRange > lowRange))
			{
				System.out.println("Invalid Input - High temperature range should be higher than low temperature range");
				System.out.println("Please enter the high temperature range (in Celsius) again: ");
				nextLineA3High = in.nextLine();
				
				if(isDouble(nextLineA3High) == true)
				{
					highRange = Double.valueOf(nextLineA3High);
				}
			}	
		}
		
		TreeSet<ITemperature> tempWithinRange = getTempWithinRange(country, lowRange, highRange);
		ArrayList<ITemperature> taskA3_List = new ArrayList<>(tempWithinRange);
		
		weatherIO.writeSubjectHeaderInFile("data/taskA3_climate_info.csv", "Task A3: All data of " +
		country + " that falls within a specific temperature range " + lowRange + " - " + highRange);
		weatherIO.writeDataToFile("data/taskA3_climate_info.csv", topic, taskA3_List);
		
		
		// TASK A-4 
		
		// TASK A4_1 - getLowestTempYearByCountry(String country)
		ITemperature taskA4_1 = getLowestTempYearByCountry(country);
		ArrayList<ITemperature>  taskA4_1List = new ArrayList<>();
		taskA4_1List.add(taskA4_1);
				
		weatherIO.writeSubjectHeaderInFile("data/taskA4_climate_info.csv", "Task A4: Data of " + country
		+ " for the year with the lowest temperature ");
		weatherIO.writeDataToFile("data/taskA4_climate_info.csv", topic, taskA4_1List);
		
		// TASK A4_2 - getHighestTempYearByCountry(String country)
		ITemperature taskA4_2 = getHighestTempYearByCountry(country);
		ArrayList<ITemperature>  taskA4_2List = new ArrayList<>();
		taskA4_2List.add(taskA4_2);
				
		weatherIO.writeSubjectHeaderInFile("data/taskA4_climate_info.csv", "Task A4: Data of " + country
		+ " for the year with the highest temperature ");
		weatherIO.writeDataToFile("data/taskA4_climate_info.csv", topic, taskA4_2List);
		
		
		// ***** TASK B
		
		// TASK B1
		
		System.out.println("TASK B1 - Get the top 10 countries with the lowest temperature reading and the top\r\n" + 
					"          10 countries with the highest temperature reading for a given month between 2000 and 2016");
		System.out.println("Please enter a month (1-12): ");
	
		String nextLineB1 = in.nextLine();
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineB1) == false)
		{
			System.out.println("Invalid input: Please enter a month as an Integer: ");
			nextLineB1 = in.nextLine();
		}
		if(isInteger(nextLineB1) == true)
		{
			month = Integer.valueOf(nextLineB1);
			// Check if the input is a valid month
			// Keep asking, until the user enter a valid month
			while(!monthSet.contains(month)) 
			{
				System.out.println("Invalid Input - Your month is invalid, please try again: ");
				nextLineB1 = in.nextLine();
				if(isInteger(nextLineB1) == true)
				{
					month = Integer.valueOf(nextLineB1);
				}
			}
		}
		

		// TASK B1_1 - allCountriesGetTop10LowestTemp(int month)
		ArrayList<ITemperature> taskB1_1List = allCountriesGetTop10LowestTemp(month);
		
		weatherIO.writeSubjectHeaderInFile("data/taskB1_climate_info.csv",
				"Task B1_1: Top 10 countries with the lowest temperature reading for " + convertMonthToString(month));
		weatherIO.writeDataToFile("data/taskB1_climate_info.csv", topic, taskB1_1List);
		
		// TASK B1_2 - allCountriesGetTop10HighestTemp(int month)
		ArrayList<ITemperature> taskB1_2List = allCountriesGetTop10HighestTemp(month);
		
		weatherIO.writeSubjectHeaderInFile("data/taskB1_climate_info.csv",
				"Task B1_2: Top 10 countries with the highest temperature reading for " + convertMonthToString(month));
		weatherIO.writeDataToFile("data/taskB1_climate_info.csv", topic, taskB1_2List);

		
		// TASK B2
		
		// TASK B2_1 - allCountriesGetTop10LowestTemp()
		ArrayList<ITemperature> taskB2_1List = allCountriesGetTop10LowestTemp();
		
		weatherIO.writeSubjectHeaderInFile("data/taskB2_climate_info.csv",
				"Task B2_1: Top 10 countries with the lowest temperature readings between 2000 and 2016");
		weatherIO.writeDataToFile("data/taskB2_climate_info.csv", topic, taskB2_1List);
		
		// TASK B2_2 - allCountriesGetTop10HighestTemp()
		ArrayList<ITemperature> taskB2_2List = allCountriesGetTop10HighestTemp();

		weatherIO.writeSubjectHeaderInFile("data/taskB2_climate_info.csv",
				"Task B2_2: Top 10 countries with the highest temperature readings between 2000 and 2016");
		weatherIO.writeDataToFile("data/taskB2_climate_info.csv", topic, taskB2_2List);

		
		// TASK B3 - allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp);
		double lowRangeB3 = 0;
		System.out.println("TASK B3 - List all of the countries that fall within a specific temperature range");
		System.out.println("Please enter the low temperature range (in Celsius): ");
	//	double lowRangeB3 = Double.valueOf(in.nextLine());
		
		String nextLineB3Low = in.nextLine();
		
		// Check if the input is a number
		// Keep asking, until the user enter a number
		while(isDouble(nextLineB3Low) == false)
		{
			System.out.println("Invalid input - Please enter a low temperature range as a number: ");
			nextLineB3Low = in.nextLine();
		}
		if(isDouble(nextLineB3Low) == true)
		{
			lowRangeB3 = Double.valueOf(nextLineB3Low);
		}
		
		double highRangeB3 = 0;
		System.out.println("Please enter the high temperature range (in Celsius): ");
		
		String nextLineB3High = in.nextLine();
		
		// Check if the input is a number
		// Keep asking, until the user enter a number
		while(isDouble(nextLineB3High) == false)
		{
			System.out.println("Invalid input - Please enter a high temperature range as a number: ");
			nextLineB3High = in.nextLine();
		}
		if(isDouble(nextLineB3High) == true)
		{
			highRangeB3 = Double.valueOf(nextLineB3High);
			// Check if the input is a number
			// Keep asking, until the user enter a valid high temperature range
			while(!(highRangeB3 > lowRangeB3))
			{
				System.out.println("Invalid Input - High temperature range should be higher than low temperature range");
				System.out.println("Please enter the high temperature range (in Celsius) again: ");
				nextLineB3High = in.nextLine();
				
				if(isDouble(nextLineB3High) == true)
				{
					highRangeB3 = Double.valueOf(nextLineB3High);
				}
			}	
		}
		
		ArrayList<ITemperature> taskB3_List = allCountriesGetAllDataWithinTempRange(lowRangeB3, highRangeB3);
		
		weatherIO.writeSubjectHeaderInFile("data/taskB3_climate_info.csv",
				"Task B3: All of the countries that fall within a specific temperature range " 
						+ lowRangeB3 + "-" + highRangeB3);
		weatherIO.writeDataToFile("data/taskB3_climate_info.csv", topic, taskB3_List);
		

		// ***** TASK C - allCountriesTop10TempDelta(int month, int year1, int year2)
		System.out.println("TASK C - The top 10 countries with the largest change in temperature in the same month between\r\n" + 
				"	 two different years (given),");
		System.out.println("Please enter a month (1-12): ");
		
		String nextLineCMonth = in.nextLine();
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineCMonth) == false)
		{
			System.out.println("Invalid input: Please enter a month as an Integer: ");
			nextLineCMonth = in.nextLine();
		}
		if(isInteger(nextLineCMonth) == true)
		{
			month = Integer.valueOf(nextLineCMonth);
			// Check if the input is a valid month
			// Keep asking, until the user enter a valid month
			while(!monthSet.contains(month)) 
			{
				System.out.println("Invalid Input - Your month is invalid, please try again: ");
				nextLineCMonth = in.nextLine();
				if(isInteger(nextLineCMonth) == true)
				{
					month = Integer.valueOf(nextLineCMonth);
				}
			}
		}
		
		int year1 = -1;
		System.out.println("Please enter a first year (2000-2016): ");
		
		String nextLineCYear1 = in.nextLine();
		
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineCYear1) == false)
		{
			System.out.println("Invalid input: Please enter a 1st year as an Integer: ");
			nextLineCYear1 = in.nextLine();
		}
		if(isInteger(nextLineCYear1) == true)
		{
			year1 = Integer.valueOf(nextLineCYear1);
			// Check if the input is a valid year
			// Keep asking, until the user enter a valid year
			while(!yearSet.contains(year1)) 
			{
				System.out.println("Invalid Input - Your 1st year is invalid, please try again: ");
				nextLineCYear1 = in.nextLine();
				if(isInteger(nextLineCYear1) == true)
				{
					year1 = Integer.valueOf(nextLineCYear1);
				}
			}
		}
		
		int year2 = -1;
		System.out.println("Please enter a second year (2000-2016): ");
	
		String nextLineCYear2 = in.nextLine();
		
		// Check if the input is an integer
		// Keep asking, until the user enter an integer
		while(isInteger(nextLineCYear2) == false)
		{
			System.out.println("Invalid input: Please enter a 2nd year as an Integer: ");
			nextLineCYear2 = in.nextLine();
		}
		if(isInteger(nextLineCYear2) == true)
		{
			year2 = Integer.valueOf(nextLineCYear2);
			// Check if the input is a valid year
			// Check if the year 1 and year 2 are different
			// Keep asking, until the user enter a valid year
			while(!yearSet.contains(year2) || year1 == year2) 
			{
				System.out.println("Invalid Input - Your 2nd year (different from 1st year) is invalid, please try again: ");
				nextLineCYear2 = in.nextLine();
				if(isInteger(nextLineCYear2) == true)
				{
					year2 = Integer.valueOf(nextLineCYear2);
				}
			}
		}
		
		ArrayList<ITemperature> taskC_List = allCountriesTop10TempDelta(month, year1, year2);
		String taskCTopic = "Temperature Delta,Year Delta,Month,Country,Country_Code";
		
		weatherIO.writeSubjectHeaderInFile("data/taskC_climate_info.csv",
				"Task C: The top 10 countries with the largest change in temperature between " 
						+ convertMonthToString(month) + " " + year1 + " and " + convertMonthToString(month) + " " + year2);
		weatherIO.writeDataToFile("data/taskC_climate_info.csv", taskCTopic, taskC_List);
	}
	
	// Return true if the input is an integer
	// Else, return false
	public boolean isInteger(String str) 
	{ 	   
		try 
		{
	        Integer.parseInt(str);  // Make an input to an integer
	        return true; 
	    }
	    catch( Exception e) 
		{ 
	    	// return false if the input cannot be made to an integer
	        return false;
	    }
	} 
	
	// Return true if the input is an integer
	// Else, return false
	public boolean isDouble(String str)
	{
		try 
		{
			Double.parseDouble(str);  // Make an input to a double
			return true;
		} 
		catch(Exception e) 
		{
	    	// return false if the input cannot be made to a double
			return false;
		}
	}
}
