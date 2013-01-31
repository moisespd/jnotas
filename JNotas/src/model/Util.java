package model;

import java.util.Date;
import java.text.SimpleDateFormat;

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
}

