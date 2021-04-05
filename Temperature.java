package climatechange;


public class Temperature implements ITemperature, Comparable<ITemperature>
{
	private double temperature;
	private int year;
	private String month;
	private String country;
	private String country3LetterCode;
	
	public Temperature(double temperature, int year, String month, String country, String country3LetterCode)
	{
		this.temperature = temperature;
		this.year = year;
		this.month = month;
		this.country = country;
		this.country3LetterCode = country3LetterCode;
	}
	
	// Gets the name of the country
	public String getCountry()
	{		
		return country;	
	}
	
	
	// Gets the 3-letter code of the country
	public String getCountry3LetterCode()
	{		
		return country3LetterCode;
	}
	
	// Gets the month
	public String getMonth()
	{		
		return month;
	}
	
	// Gets the year
	public int getYear()
	{		
		return year;
	}
	
	// Gets temperature; input parameter of false = return Celsius value)
	public double getTemperature(boolean getFahrenheit)
	{
		if(getFahrenheit == true)
		{
			return (temperature * 1.8) + 32; // convert the temperature from Celsius to Fahrenheit
			
		}
		else
		{
			return temperature;
		}
	}
	
	// Compare 2 Temperature objects
	// Compare by temperature, then by country name, then by year, then by month
	public int compareTo(ITemperature other)
	{
		Temperature that = (Temperature) other;
		
		// Compare temperature first
		if(this.temperature != that.temperature)
		{
			return Double.compare(this.temperature, that.temperature);
		}
		// Compare country name
		else if(!(this.country.equals(that.country)))
		{
			if(this.country.compareTo(that.country) < 0)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		// Compare year
		else if(this.year != that.year)
		{
			//return Double.compare(this.year, that.year);
		
			// earliest year wins the tie
			if(this.year < that.year)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		// Compare month
		else if(!(this.month.equals(that.month)))
		{
			// Convert String month to corresponding  int
			int monthThis = convertMonthStringToInt(this.month);
			int monthThat = convertMonthStringToInt(that.month);
			
			// earliest months win the tie
			if(monthThis < monthThat)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			return 0;
		}
	}
	
	
	// Convert String month to corresponding month int
	public int convertMonthStringToInt(String monthString)
	{
		int month;
		switch(monthString)
		{
		case "Jan": month = 1;
					break;
		case "Feb":	month = 2;
					break;
		case "Mar": month = 3;
					break;
		case "Apr":	month = 4;
					break;
		case "May":	month = 5;
					break;
		case "Jun":	month = 6;
					break;
		case "Jul":	month = 7;
					break;
		case "Aug":	month = 8;
					break;
		case "Sep":	month = 9;
					break;
		case "Oct":	month = 10;
					break;
		case "Nov":	month = 11;
					break;
		case "Dec":	month = 12;
					break;
		default:	month = -1;
					break;
		}
		return month;
	}
	
	public String toString()
	{
		return temperature + "," + year + "," + month + "," + country + "," + country3LetterCode;
	}
	
	
	// Return the hashcode of the Temperature
	public int hashcode()
	{
		return (int)temperature + year + month.hashCode() + country.hashCode() + country3LetterCode.hashCode();
	}

	
	@Override
	// Checks if 2 Temperature are equal
	public boolean equals(Object otherObject)
	{
    	if (otherObject == null) 
    	{
    		return false;
    	} 
    	if (this.getClass() != otherObject.getClass()) 
    	{
    		return false;
    	}
    	
    	Temperature other = (Temperature)otherObject;
    	return this.compareTo(other) == 0;
//    	return(this.temperature == other.temperature && this.year == other.year &&
//    			this.month.equals(other.month)) && this.country.equals(other.country) 
//				&& this.country3LetterCode.equals(other.country3LetterCode);
	}
	
	
}
