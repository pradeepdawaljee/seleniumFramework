package com.framework.Package.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.framework.Package.core.BaseClass;
import com.framework.Package.driver.CommonMethods;
import com.framework.Package.helper.LoggerHelper;
import com.framework.Package.pageObjects.ForgotPassword;
import com.framework.Package.pageObjects.LandingScreen;
import com.framework.Package.pageObjects.Login;
import com.framework.Package.utilities.RandomDataUtility;

public class SmokeTest extends BaseClass{
	
	 private Logger log=LoggerHelper.getLogger(SmokeTest.class);
	
	Login login=new Login();
	LandingScreen landingScreen=new LandingScreen();
	ForgotPassword forgotPassword=new ForgotPassword();
	
	
	
	
	//@Test(priority=1,description="Entering valid username & Empty password")
	public void loginWithEmptyPasswordField() throws Exception{
		extentTest=extent.startTest("TC001 loginWithEmptyPasswordField testcase");
		String username=data.getCellData("InvalidCredentials", "username", 3);//"Platformadmin@moolya.global"
		String password=data.getCellData("InvalidCredentials", "password", 3);
		login.passDataToUsernameField(username);
		login.passDataToPasswordField(password);
		login.clickOnLoginButton();
		String message=CommonMethods.getPopUpNotificationMessage();
		//Comment
		System.out.println("loginWithEmptyPasswordField="+message);
		CommonMethods.explicitWaitTillElementInvisible(CommonMethods.popUpNotification);
	}
	
	@Test(priority=6,description="Entering valid username & password")
	public void loginFunc() throws Exception{
		extentTest=extent.startTest("TC006 login with valid credentials testcase");
		String username=data.getCellData("login", "Username", 2);//"Platformadmin@moolya.global"
		String password=data.getCellData("login", "Password", 2);//"MoolyaAdmin@123"
		login.verifyLoginPage();
		System.out.println("Login page verified successfully");
		login.passDataToUsernameField(username);
		login.passDataToPasswordField(password);
		login.clickOnLoginButton();
		//System.out.println("CommonMethods.compareWithExpectedElement(landingScreen.chaptersText)="+CommonMethods.compareWithExpectedElement(landingScreen.chaptersText));
		landingScreen.verifyLandingScreen();
		System.out.println("Login Page Verified");
		log.info("Landing Page Verified successfully");
		data.setCellData("login", "Status", 2, "Pass@"+RandomDataUtility.getCurrentDateAndTime());
	}
		
	@Test(priority=5,description="Entering empty username & valid password")
	public void loginWithEmptyUsername() throws Exception{
		extentTest=extent.startTest("TC005 loginWithEmptyUsername testcase");
		String username=data.getCellData("InvalidCredentials", "username", 4);//"Platformadmin@moolya.global"
		String password=data.getCellData("InvalidCredentials", "password", 4);
		login.passDataToUsernameField(username);
		login.passDataToPasswordField(password);
		login.clickOnLoginButton();
		String message=CommonMethods.getPopUpNotificationMessage();
		System.out.println("loginWithEmptyUsername="+message);
		CommonMethods.explicitWaitTillElementInvisible(CommonMethods.popUpNotification);
	}
	
	@Test(priority=2)
	public void forgotPasswordFunc() throws Exception{
		extentTest=extent.startTest("TC002 Forgot Password testcase");
		String username=data.getCellData("ForgotPassword", "Username", 2);//"pradeepdawaljee@raksan.in"
		login.clickOnForgotPasswordLink();
		//CommonMethods.compareWithExpectedElement(forgotPassword.verifyForgotPasswordText);
		forgotPassword.verifyForgotPasswordPage();
		System.out.println("Forgot Password page verified @"+RandomDataUtility.getCurrentDateAndTime());
		log.info("Forgot Password page Verified successfully @"+RandomDataUtility.getCurrentDateAndTime());
		forgotPassword.passDataToUserNameField(username);
		forgotPassword.clickSubmitButton();
		//forgotPassword.getPopUpNotificationMessage();
		CommonMethods.getPopUpNotificationMessage();
		System.out.println("Forgot password notification message="+CommonMethods.getPopUpNotificationMessage());
		CommonMethods.explicitWaitTillElementInvisible(CommonMethods.popUpNotification);
		
	}
	
	@Test(priority=3)
	public void forgotPasswordWithInvalidEmail() throws Exception{
		extentTest=extent.startTest("TC003 Forgot Password testcase with invalid credentials");
		String username=data.getCellData("ForgotPassword", "Username", 3);//"pradeepdawaljee@raksan.i"
		
		forgotPassword.passDataToUserNameField(username);
		forgotPassword.clickSubmitButton();
		//forgotPassword.getPopUpNotificationMessage();
		CommonMethods.getPopUpNotificationMessage();
		System.out.println("Forgot password notification message="+CommonMethods.getPopUpNotificationMessage());
		CommonMethods.explicitWaitTillElementInvisible(CommonMethods.popUpNotification);
		
		
	}
	
	@Test(priority=4)
	public void navigateToLoginPageFromForgotPasswordScreen() throws Exception{
		extentTest=extent.startTest("TC004  navigateToLoginPageFromForgotPasswordScreen testcase");
		forgotPassword.clickLoginHyperlink();
		login.verifyLoginPage();
		
	}

}
