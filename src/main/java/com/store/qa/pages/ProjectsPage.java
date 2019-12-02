package com.store.qa.pages;

import org.openqa.selenium.By;

import com.store.qa.base.TestBase;

public class ProjectsPage extends TestBase{
	
	//Elements
	private By Zuru = By.xpath("//img[@class = 'home-logo']");
	
	//Methods
	public void validateHomePage() {
		driver.findElement(Zuru).click();
	}
	
}
