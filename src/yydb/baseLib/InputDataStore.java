package yydb.baseLib;

import android.os.Environment;

public class InputDataStore {
	
	public static int Input_ObjectWaitTime = Integer.parseInt(CommonLib.getPropertyString("objectWaitTime"));
	public static int Input_APIWaitTime = Integer.parseInt(CommonLib.getPropertyString("APIWaitTime"));

	public static String Input_LogPath = UIManager.getAbsoluteFile();//"/storage/sdcard0/Robotium-Screenshots/";
   
	
	
	
}

