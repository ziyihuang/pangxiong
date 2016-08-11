package yydb.baseLib;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.Properties;

import android.util.Log;


public class CommonLib{
	
	public static  String getCurrentTime() {

   try{
	   Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH);
		int day = ca.get(Calendar.DATE);
		int minute = ca.get(Calendar.MINUTE);
		int hour = ca.get(Calendar.HOUR);
		int second = ca.get(Calendar.SECOND);
		String currentTime=(String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
				+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
				+ String.valueOf(minute) + "-" + String.valueOf(second));
	//	Log.i(tag,"The current time is: "+currentTime);
		
		return currentTime;
   }
   catch(Exception e){
	   
	  // Log.e(tag,"Exceptionet the current time "); 
	   return "00000000";
	   
   }
	}
/*	
   public static Properties getPropertyString() {
	   Properties props = new Properties();  
       InputStream in = CommonLib.class.getResourceAsStream("/assets/Config.properties");  
       try {  
           props.load(in);  
           Log.i(NewSolo.tag,"Get file Config.properties "+"Success");
       } catch (IOException e) { 
    	   Log.e(NewSolo.tag,"Exceptionet file Config.properties ");
           e.printStackTrace();  
       }  
       return props;  
   }
 */
	public static String getPropertyString(String key ) {

		InputStream in = CommonLib.class.getResourceAsStream("/assets/Config.properties");  
	    Properties properties = new Properties();
		    
		    try {
		properties.load(in);
		}catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		        if (key == null || key.equals("") || key.equals("null")) {
		            return "";
		        }
		        String result = "";
		        try {
		            result = properties.getProperty(key); 
		        } catch (MissingResourceException e) {
		            e.printStackTrace();
		        }
		        return result;
		    }
	   
	
//	public static void newVerifyEquals(String p_message, Object p_expected,
//			Object p_actual) throws Exception {
//
//		// String shotImage=CommonLib.getCurrentTime()+".jpg";
//
//		if (p_expected == p_actual) {
//
//			// Log.i(tag,p_message + DebugInfoStore.Info_Pass+" 1");
//
//			// File imagedir = new File(InputDataStore.Input_LogImagePath);
//			// NewTakeshot.shoot(getCurrentActivity(),
//			// InputDataStore.Input_LogImagePath+shotImage);
//			ReportLib.logWriter(p_message, p_expected, p_actual, "Pass");
//			Log.i(tag, p_message + DebugInfoStore.Info_Pass + " 2");
//
//		} else {
//			// ReportLib.setImageName(shotImage);
//			// File imagedir = new File(InputDataStore.Input_LogImagePath);
//
//			// NewTakeshot.shoot(getCurrentActivity(),
//			// InputDataStore.Input_LogImagePath+shotImage);
//			ReportLib.logWriter(p_message, p_expected, p_actual, "Fail");
//			Log.e(tag, p_message + DebugInfoStore.Info_Fail + "expected="
//					+ p_expected + " actual=" + p_actual);
//		}
//	}
	
 }