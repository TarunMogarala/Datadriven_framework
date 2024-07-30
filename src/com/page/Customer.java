package com.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class Customer {
	public Customer	(WebDriver driver) {
		this.driver=driver;
	}

	public static WebDriver driver;
	
	
	@FindBy(xpath ="(//a[.='Customers'])[2]" )
	WebElement customer;
	
	@FindBy(xpath = "(//span[@data-phrase='AddLink'])[1]")
	WebElement add;
	
	@FindBy(name = "x_Customer_Number")
	WebElement CustomerNumber;
	
	@FindBy(name = "x_Customer_Name")
	WebElement CustomerName;
	
	@FindBy(name = "x_Address")
	WebElement Address;
	
	@FindBy(name = "x_City")
	WebElement City;
	
	@FindBy(name = "x_Country")
	WebElement Country;
	
	@FindBy(name = "x_Contact_Person")
	WebElement ContactPerson;
	
	@FindBy(name = "x_Phone_Number")
	WebElement PhoneNumber;
	
	@FindBy(name = "x__Email")
	WebElement Email;
	
	@FindBy(name = "x_Mobile_Number")
	WebElement MobileNumber;
	
	@FindBy(name = "x_Notes")
	WebElement Notes;
	
	@FindBy(id = "btnAction")
	WebElement ClickAddButton;
	
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement OneOk;
	
	@FindBy(xpath = "(//button[contains(text(),'OK')])[6]")
	WebElement TwoOk;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement searchpannel;
	
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement SearchTextbox;
	
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ClickSearchButton;
	
	@FindBy (xpath = "//table[@id='tbl_a_customerslist']//tbody/tr[1]/td[5]/div/span/span")
	WebElement table;
	
	public boolean addcustomer(String name,String address,String city,String country,String cperson,String pnumber,String email,String mnumber,String notes) throws Throwable {
		Actions act=new Actions(driver);
		act.moveToElement(customer).click().perform();
		act.moveToElement(add).click().perform();
		Thread.sleep(1000);
		
	String num=	CustomerNumber.getAttribute("value");
	CustomerName.sendKeys(name);
	Address.sendKeys(address);
	City.sendKeys(city);
	Country.sendKeys(country);
	ContactPerson.sendKeys(cperson);
	PhoneNumber.sendKeys(pnumber);
	Email.sendKeys(email);
	MobileNumber.sendKeys(mnumber);
	Notes.sendKeys(notes);
	ClickAddButton.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	act.moveToElement(OneOk).click().perform();
	Thread.sleep(2000);
	act.moveToElement(TwoOk).click().perform();
	Thread.sleep(1000);
	if(!SearchTextbox.isDisplayed()) 
		searchpannel.click();
		SearchTextbox.clear();
		SearchTextbox.sendKeys(num);
		ClickSearchButton.click();
		Thread.sleep(1000);
		
		String val=table.getText();
		if(val.equals(num)) {
			Reporter.log(val+"======="+num,true);
			return true;
		}else {
			Reporter.log(val+"======"+num,true);
			return false;
		}

	}
}
