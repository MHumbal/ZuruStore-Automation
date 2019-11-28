package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;

import com.store.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//input[@placeholder='Search for projects']")
	private WebElement ProjectSearchtxtBox;

	@FindBy(xpath="//a[contains(text(),'Projects')]")
	private WebElement ProjectsPageLink;

	@FindBy(xpath="//a[contains(text(),'People & Teams')]")
	private WebElement PeopleAndTeamPageLink;

	@FindBy(xpath="//ul[@class='nav navbar-nav']//li//a//img")
	private WebElement ProfilePageLink;
	
	@FindBy(xpath="//div[@class = 'title-home']")
	private WebElement HomeText;

	public HomePage() {
		PageFactory.initElements(driver, this); 
	}

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
		
		return HomeText.getText();
		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public SearchPage VerifySearchprojectbox() {
		ProjectSearchtxtBox.click();
		return new SearchPage();
	}

	public ProjectsPage VerifyProjectPage() {
		ProjectsPageLink.click();
		return new ProjectsPage();
	}
	
	public PeopleAndTeamsPage VerifyPeopleAndTeamPageLink() {
		PeopleAndTeamPageLink.click();
		return new PeopleAndTeamsPage();
	}
	
	public ProfilePage VerifyProjectUploadLink() {
		ProfilePageLink.click();
		return new ProfilePage();
	}



}
