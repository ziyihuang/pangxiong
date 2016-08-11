package com.kugou.yiyuanmai1;


import yydb.baseLib.CommonLib;
import yydb.baseLib.DebugInfoStore;
import yydb.baseLib.ReportLib;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;


import android.util.Log;

import com.robotium.solo.Solo;
public class entrance  extends ActivityInstrumentationTestCase2{
	public static String Input_MainActivity = "com.kugou.yiyuanmai.activity.WelcomeActivity";
	public static Solo solo;
	private Activity activity;

	static String tag = "ziyi";
	//private Log log;

	@SuppressWarnings("unchecked")
	public entrance() throws ClassNotFoundException {
		super(Class.forName(Input_MainActivity));

	}

	@Override
	protected void setUp() throws Exception {
		this.activity = this.getActivity();
		this.solo = new Solo(getInstrumentation(), this.activity);
		ReportLib.newSetup("oneyuan","ziyi");
	}

	/*
	 * Áî®get set ÊñπÊ≥ïÂ∞ÅË£Ösolo,Êñπ‰æøÁªü‰∏ÄË∞ÉÁî®
	 */


	public void setSolo(Solo solo) {
		this.solo = solo;
	}
	
	public static Solo getSolo() {
		return solo;
	}
//	public void test() throws Exception {
//	solo.clickOnView(solo.getView("personal_img"));
//	solo.sleep(1000);
//	}

	
	protected void tearDown() throws Exception {
		ReportLib.newTeardown("ziyi");
		solo.finishOpenedActivities();
		
		
	}
	public static void newVerifyEquals(String p_message, Object p_expected,
			Object p_actual) throws Exception {

		   String shotImage=CommonLib.getCurrentTime();
		   

		if (p_expected == p_actual) {

			 Log.i(tag,p_message + DebugInfoStore.Info_Pass+" 1");
			 ReportLib.setImageName(shotImage);
			
			ReportLib.logWriter(p_message, p_expected, p_actual, "Pass");
			solo.takeScreenshot(shotImage,80);
		
			
		} else {
			//ReportLib.setImageName(shotImage);
			//File imagedir = new File(InputDataStore.Input_LogImagePath);

			//NewTakeshot.shoot(solo.getCurrentActivity(), InputDataStore.Input_LogImagePath+shotImage);
		    ReportLib.setImageName(shotImage);
			solo.takeScreenshot(shotImage,80);//ΩÿÕº¥Ê∑≈‘⁄Robotium_Screenshots
			ReportLib.logWriter(p_message, p_expected, p_actual, "Fail");
			Log.e(tag, p_message + DebugInfoStore.Info_Fail + "expected="
					+ p_expected + " actual=" + p_actual);
		}
	}
}

	

