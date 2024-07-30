package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunction.FunctionLibrary;
import configure.Apputil;
import utilities.ExcelFileUtil;

public class DriverScript extends Apputil {

	String input="./FileInput/Login.xlsx";
	String output="./FileOutput/results.xlsx";
	ExtentReports report;
	ExtentTest test;
	
	@Test
	public void starttest() throws Throwable {
		
		report=new ExtentReports("./Reports/login.html");
		ExcelFileUtil xl=new ExcelFileUtil(input);
		int rc= xl.Count("Login");
		Reporter.log("no of rows in the sheet is "+rc,true);
		for(int i=1;i<=rc;i++) {
			test=report.startTest("Login");
			test.assignAuthor("Tarun Kumar");		
		String username=xl.GetCellData("Login", i, 0);
		String password=xl.GetCellData("Login", i, 1);
		test.log(LogStatus.INFO,username+"=========="+password);
		 boolean res=FunctionLibrary.login(username, password);
		 if(res) {
			 xl.SetCell("Login", i, 2, "Valid username password", output);
			 xl.SetCell("Login", i, 3, "Pass",output);
			 test.log(LogStatus.PASS, "Login pass");
		 }else {
			 xl.SetCell("Login", i, 2, "InValid username password", output);
			 xl.SetCell("Login", i, 3, "Fail",output);
			 test.log(LogStatus.FAIL,"Login fail");
		 }
		 report.endTest(test);
		 report.flush();
		}
		
	}
}
