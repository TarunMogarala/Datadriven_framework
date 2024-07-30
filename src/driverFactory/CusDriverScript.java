package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.page.Customer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import configure.CusApputil;
import utilities.ExcelFileUtil;

public class CusDriverScript extends CusApputil {
	
	String input="./FileInput/Customer.xlsx";
	String output="./FileOutput/CusResult.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void start() throws Throwable {
	
		ExcelFileUtil xl=new ExcelFileUtil(input);
		report=new ExtentReports("./Reports/customer.html");
		int count=xl.Count("Tarun");
		Reporter.log("No of rows is" +count,true);
		for(int i=1;i<=count;i++) {
		test=report.startTest("Customer");
		test.assignAuthor("Tarun kumar");
			String name=xl.GetCellData("Tarun", i, 0);
			String address=xl.GetCellData("Tarun", i, 1);
			String city=xl.GetCellData("Tarun", i, 2);
			String country=xl.GetCellData("Tarun", i, 3);
			String cperson=xl.GetCellData("Tarun", i, 4);
			String pnumber=xl.GetCellData("Tarun", i, 5);
			String email=xl.GetCellData("Tarun", i, 6);
			String mnumber=xl.GetCellData("Tarun", i, 7);
			String notes=xl.GetCellData("Tarun", i, 8);
			
			Customer cus=PageFactory.initElements(driver,Customer.class);
			//Customer cus=PageFactory.initElements(driver, Customer.class);
			test.log(LogStatus.INFO,name+ address+ city+ country+ cperson+ pnumber+ email+ mnumber+ notes);
		boolean res=cus.addcustomer(name, address, city, country, cperson, pnumber, email, mnumber, notes);
			if(res) {
				xl.SetCell("Tarun", i, 9,"Pass",output);
				test.log(LogStatus.PASS,"Customer sucessfully added");
				
			}else {
				xl.SetCell("Tarun", i, 9,"Fail",output);
				test.log(LogStatus.FAIL,"Customer not  added");
			}
			report.endTest(test);
			report.flush();
		}
		
	}

}
