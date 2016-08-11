package com.kugou.yiyuanmai1;
import yydb.baseLib.CommonLib;
import yydb.baseLib.DebugInfoStore;
import yydb.baseLib.InputDataStore;
import yydb.baseLib.ReportLib;
import yydb.baseLib.UIManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.kugou.yiyuanmai1.entrance;
public class loginTest extends entrance {

public loginTest() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
  
protected void setUp() throws Exception {
	// TODO Auto-generated method stub
	super.setUp();
	
	mUIManager = new UIManager(solo);
}

protected void tearDown() throws Exception {
	//ReportLib.newTeardown("ziyi");
	solo.finishOpenedActivities();
	//loginout();
}
    UIManager mUIManager;
	private EditText nameEditText, passwordEditText;
    private Log log;
    String casename;
    public void testPersonal() throws Exception {
//    	if (solo.searchText("^进入一元买$"));
//    	{
//    	solo.clickOnView(solo.getView("into_sys"));
//    	solo.clickOnView(solo.getView("go_buy"));
//    	}


    		
    	solo.clickOnView(mUIManager.getPersonalView());
    	if (solo.searchText("^夺宝币$"))/* 在我的页面校验app是否登录，若未登录，则调用login()方法登录 */
		{

			//f.share();// 分享页面的测试用例
			//d.TestDuobaopage();// 夺宝页面的测试用例
			casename="我的页面--已登录状态";
			Log.d("ziyi","已登录");
			
			newVerifyEquals(casename, solo.searchButton("充值"),true);
       
			solo.sleep(InputDataStore.Input_APIWaitTime);
		} else

		{   casename="登录页面";
		    solo.clickOnView(solo.getView("goto_login"));
		    Log.d(tag,"进入登录界面");
		    Toast.makeText(getActivity(), "进入登录界面", Toast.LENGTH_LONG).show();
			login();
			//ReportLib.setup("ziyi");
			newVerifyEquals(casename, solo.searchButton("充值"),true);
		  
			
		}
    	
    }

	public void login() {
				nameEditText = (EditText) solo
				.getView("login_name");// 账号
		passwordEditText = (EditText) solo
				.getView("login_password");// 密码
		solo.clearEditText(0);
		solo.enterText(nameEditText,CommonLib.getPropertyString("user"));
		solo.enterText(passwordEditText, CommonLib.getPropertyString("password"));
		solo.clickOnButton("^登录$");
		// solo.sleep(APIWaitTime);
		if (solo.waitForText("^夺宝币")) {
			// solo.clickOnView(view1);
			solo.sleep(InputDataStore.Input_APIWaitTime);
			Log.d(tag, "登录成功");
	
		    loginout();
		} else {
			log.d(tag, "登录失败");


		}
	}
	public  void loginout(){
		 //solo.clickOnView(mUIManager.getPersonalView());
		 solo.sleep(2000);
		 solo.clickOnView(solo.getView("main_setting"));
		 solo.clickOnView(solo.getView("exit_layout"));
	     solo.sleep(1000);
	     solo.waitForText("幸运降临");
		 solo.clickOnView(solo.getView("sure_t"));
	     solo.sleep(1000);
	
	}
    
}

