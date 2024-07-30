package commonFunction;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.Reporter;

import configure.Apputil;

public class FunctionLibrary extends Apputil {

	public static boolean login(String user,String pass) throws Throwable {
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath(pro.getProperty("reset"))).click();
		driver.findElement(By.xpath(pro.getProperty("username"))).sendKeys(user);
		driver.findElement(By.xpath(pro.getProperty("password"))).sendKeys(pass);
		driver.findElement(By.xpath(pro.getProperty("login"))).click();
		Thread.sleep(2000);
		String exp="dashboard";
		String act=driver.getCurrentUrl();
		if(act.contains(exp)) {
			Reporter.log("Valid username and password"+exp+"     "+act);
			driver.findElement(By.xpath(pro.getProperty("logout"))).click();
			return true;
		}else {
		String err=	driver.findElement(By.xpath(pro.getProperty("errormsg"))).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pro.getProperty("ok"))).click();
		return false;
		}
	
		
	}
}
