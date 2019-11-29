package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.base.TestBase;

public class ProjectsPage extends TestBase{

	@FindBy(xpath = "//img[@class = 'home-logo']")
	private WebElement Zuru;
	
	@FindBy(xpath = "//input[@placeholder='Search for projects']")
	private WebElement Searchtxtbox;
	
	
	
	public ProjectsPage() {
		PageFactory.initElements(driver, this); 
	}
	
	public void validateHomePage() {
		Zuru.click();
	}
	
	public void ValidateSearchProject() {
	
		
		
	}
	
}
