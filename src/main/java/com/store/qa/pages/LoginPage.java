package com.store.qa.pages;

import org.openqa.selenium.By;

import com.store.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Elements
	private By login = By.xpath("//span[contains(text(),'Login')]");
	
	private By email = By.id("login-input-field");
	
	private By password = By.id("passowrd-input-field");
	
	private By lognBtn = By.xpath("//div[@class='login-checkmark']");
	
	//Methods
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd) {
		driver.findElement(login).click();
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(lognBtn).click();
		
		return new HomePage();
	}
	

}
