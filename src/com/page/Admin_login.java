package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Admin_login {
	static WebDriver driver;
	public Admin_login(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="btnreset")
	WebElement reset;
	@FindBy(id="username")
	WebElement user;
	@FindBy(id="password")
	WebElement pass;
	@FindBy(id="btnsubmit")
	WebElement login;
	
	public void login(String user,String password) {
		reset.click();
		this.user.sendKeys(user);
		pass.sendKeys(password);
		login.click();
		String exp="dashboard";
		String act=driver.getCurrentUrl();
		try {
			Assert.assertTrue(act.contains(exp),"Invalid credentails");
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}

}
