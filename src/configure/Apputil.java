package configure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Apputil {
	
	public static WebDriver driver;
	public static Properties pro;
	
	@BeforeTest
	public static void launchbro() throws Throwable, IOException {
		pro=new Properties();
		pro.load(new FileInputStream("./PropertyFile/stock.properties"));
		if(pro.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(pro.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else {
			Reporter.log("No driver found",true);
		}
	}
	
	@AfterTest
	public static void closebro() {
		driver.quit();
	}

}
