package com.framework.Package.pageObjects;

import org.openqa.selenium.By;

import com.framework.Package.driver.CommonMethods;

public class Login {

	By username=By.name("userName");
	By password=By.name("Password");
	String loginButtonText="Sign in";
	By rememberMeCheckBox=xpath(".//*[@class='checkbox_wrap']/input");
	By rememberMeElementName=xpath(".//*[@class='checkbox_wrap']/span");
	By forgotPasswordLink=By.linkText("Forgot Password");
	By registerLink=By.linkText("Register");
	By verifyLoginText=By.xpath(".//*[text()='Login']");
	
	
	public static By xpath(String xpathExpression){
		return By.xpath(xpathExpression);
	}

	public void passDataToUsernameField(String userEmail) throws Exception{

		CommonMethods.clear(username);
		CommonMethods.sendKeys(username, userEmail);

	}

	public void passDataToPasswordField(String userPassword) throws Exception{

		CommonMethods.clear(password);
		CommonMethods.sendKeys(password, userPassword);

	}
	
	public void clickOnLoginButton() throws Exception{
		
		CommonMethods.findElementByTextAndClick(loginButtonText);
	}
	
	public void clickOnRememberMeCheckBox() throws Exception{
		CommonMethods.click(rememberMeCheckBox);
	}
	
	public void clickOnForgotPasswordLink() throws Exception{
		CommonMethods.click(forgotPasswordLink);
	}
	
	public void clickOnRegisterLink() throws Exception{
		CommonMethods.click(registerLink);
	}
	
	public void verifyLoginPage() throws Exception{
		CommonMethods.compareWithExpectedElement(verifyLoginText);
	}

}
