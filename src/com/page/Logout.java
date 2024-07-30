package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {
	@FindBy(xpath = "(//a[.=' Logout'])[2]")
	WebElement logout;
	
	public void logout() {
		logout.click();
	}
	

}
