package yydb.baseLib;


import java.io.File;

import android.view.View;

import com.kugou.yiyuanmai1.entrance;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.os.Environment;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AssertionFailedError;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

public class UIManager   {
	 /*
	  * UIManager类是统一管理页面UI的类，定义成静态变量，其他类调用时可以直接 用(类名.变量）
	  * 
	  * 不过此引用方法不太安全，如果要提高安全性，可以把成员变量都使用get set方法
	  * 
	  * 
	  */
	
	public static Solo solo = entrance.getSolo();
	public UIManager(Solo solo) throws ClassNotFoundException{
		this.solo = solo;
		//super();
		
	}
	
	/*
	 * 夺宝页面
	 */ 
	public View getDuoBaoView()
	{
		return solo.getView("main_yiyuanmai");
	}
	public View getJieXiaoView()
	{
		return solo.getView("main_find");
	}
	public View getFindPageView()
	{
		return solo.getView("main_announced");
	}
	public View getQingDanView()
	{
		return solo.getView("main_inventory");
	}
	
	public View getPersonalView()
	{
		return solo.getView("personal_img");
	}
	
	public static String getAbsoluteFile() {
		File storeDir = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/Robotium-Screenshots/");
		if(!storeDir.exists()) {
			storeDir.mkdirs();
		}
		return storeDir.getAbsolutePath();
	}
	

      
      
      /*
//       * 锟结宝页锟斤拷锟皆拷锟�
//       */
//	   public GridView getDuobaoGridView()
//	   {
//		   return (GridView)solo.getView(InputDataStore.Input_TargetPakage+":id/index_grid_view");
//	   }
//      
//     /*
//      * 锟斤拷锟斤拷页锟斤拷锟皆拷锟�
//      */
//
//	 public ListView getShareListView() {
//	
//			return (ListView) solo.getView(InputDataStore.Input_TargetPakage+":id/list_view");//锟斤拷取锟斤拷锟斤拷锟叫憋拷
//		
//	}
	 
	


//	public void setShareListparentView(View shareListparentView) {
//		this.shareListparentView = shareListparentView;
//	}
	

}
