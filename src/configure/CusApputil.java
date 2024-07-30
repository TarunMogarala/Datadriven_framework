package configure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.page.Admin_login;
import com.page.Logout;


public class CusApputil {
	
	public static WebDriver driver;
	Properties pro=new Properties();
	

	@BeforeTest
	public void launchapp() throws Throwable, IOException {
		
		pro.load(new FileInputStream("./PropertyFile/stock.properties"));
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		Admin_login log=PageFactory.initElements(driver, Admin_login.class);
		log.login("admin","master");
		
		
	}
	@AfterTest
	public void closeapp() {
	Logout logo=PageFactory.initElements(driver,Logout.class);
	logo.logout();
	
	driver.quit();
	}
}
