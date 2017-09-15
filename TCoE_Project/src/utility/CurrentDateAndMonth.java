package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateAndMonth 
{
	
	public static String CurrentDate() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 

		String currentDate = sdf.format(new Date());
		
		return currentDate;
	}
	
	
	public static String CurrentMonth() 
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");

		String currentMonth = sdf1.format(new Date());
    
		return currentMonth;
	}

}
