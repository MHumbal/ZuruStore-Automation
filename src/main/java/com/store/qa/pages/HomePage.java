package com.store.qa.pages;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import com.store.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Elements
	private By ProjectSearchtxtBox = By.xpath("//input[@placeholder='Search for projects']");
	
	private By ProjectsPageLink = By.xpath("//a[contains(text(),'Projects')]");
	
	private By PeopleAndTeamPageLink = By.xpath("//a[contains(text(),'People & Teams')]");
	
	private By ProfilePageLink = By.xpath("//ul[@class='nav navbar-nav']//li//a//img");
	
	private By HomeText = By.xpath("//div[@class = 'title-home']");

	//Methods
	public boolean validateLogo() {
		try {
			s.find("./Images/Zuru_Logo.png");
			return true;
		} catch (FindFailed e) {
			System.out.println("Logo does not match");
			return false;
		}
	}
	
	public String validateHomeText() {
		
		return driver.findElement(HomeText).getText();
		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage VerifySearchprojectbox() {
		driver.findElement(ProjectSearchtxtBox).click();
		return new SearchPage();
	}

	public ProjectsPage VerifyProjectPage() {
		driver.findElement(ProjectsPageLink).click();
		return new ProjectsPage();
	}
	
	public PeopleAndTeamsPage VerifyPeopleAndTeamPageLink() {
		driver.findElement(PeopleAndTeamPageLink).click();
		return new PeopleAndTeamsPage();
	}
	
	public ProfilePage VerifyProjectUploadLink() {
		driver.findElement(ProfilePageLink).click();
		return new ProfilePage();
	}



}
