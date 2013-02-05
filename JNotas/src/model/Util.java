package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	// ----------------------------------------------------------------------
	public static boolean isInteger(String input)  
	{  
	   try  
	   {  
	      Integer.parseInt(input);  
	      return true;  
	   }  
	   catch(Exception e)  
	   {  
	      return false;  
	   }  
	}
	
	// ----------------------------------------------------------------------
	public static String datetime2String(Date date) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return formato.format(date);		
	}
	// ----------------------------------------------------------------------
	public static String date2String(Date date) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(date);		
	}
	// ----------------------------------------------------------------------
	public static Date string2date(String strdate) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha = new Date();
		try {
			fecha = formato.parse(strdate);
		} 
		catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		return fecha;
	}
	// ----------------------------------------------------------------------
}

