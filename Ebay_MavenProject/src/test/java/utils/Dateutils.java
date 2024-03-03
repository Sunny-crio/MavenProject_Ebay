package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Dateutils {
    public static int getCurrentYear() {
    	     return LocalDate.now().getYear();
    }
    
    public static int getseconds() {
    	
    	return LocalTime.now().getSecond();
    }
    public static int getDayofMonth() {
	     return LocalDate.now().getDayOfMonth();
    }
    public static int getCurrentmonth() {
	     return LocalDate.now().getMonthValue();
    }
	public static String getcurrentDateTime() {
		
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate = new Date(); 
		return customformat.format(currentdate);
	}
	
	public static String getCurrentDate() {
		
		DateFormat customformat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentdate = new Date(); 
		return customformat.format(currentdate);
	}
	
	public static String getEndDate(int term) {
		
		int stryear = getCurrentYear();
		int strfutureyear = stryear+term;
		DateFormat customformat = new SimpleDateFormat("MM-dd");
		Date newdate = new Date();
		String formatteddate = customformat.format(newdate);
		String enddate = Integer.toString(strfutureyear)+"-"+formatteddate;
		return enddate;
				
	}
	
}

