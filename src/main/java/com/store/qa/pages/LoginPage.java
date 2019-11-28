package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Page Factory
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement login;
	
	@FindBy(id = "login-input-field")
	private WebElement email;
	
	@FindBy (id = "passowrd-input-field")
	private WebElement password;
	
	@FindBy	(xpath = "//div[@class='login-checkmark']")
	private WebElement lognBtn;
	
	//Initialize the Page Objects;
	
	public LoginPage() {
		PageFactory.initElements(driver, this); 
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) {
		login.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		lognBtn.click();
		
		return new HomePage();
	}
	

}
