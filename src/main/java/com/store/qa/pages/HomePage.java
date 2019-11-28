package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//input[@placeholder='Search for projects']")
	private WebElement ProjectSearchtxtBox;

	@FindBy(xpath="//a[contains(text(),'Projects')]")
	private WebElement ProjectsPageLink;


	@FindBy(xpath="//a[contains(text(),'People & Teams')]")
	private WebElement PeopleAndTeamPageLink;

	@FindBy(xpath="//ul[@class='nav navbar-nav']//li//a//img")
	private WebElement ProjectUploadLink;



	public HomePage() {
		PageFactory.initElements(driver, this); 
	}


	public String validateHomePageTitle() {
		return driver.getTitle();
	}


	public SearchPage VerifySearchprojectbox() {

		ProjectSearchtxtBox.click();
		return new SearchPage();

	}

	public ProjectsPage VerifyProjectPage() {
		// TODO Auto-generated method stub
		ProjectsPageLink.click();
		return new ProjectsPage();
		
			
	}
	
	public PeopleAndTeamsPage VerifyPeopleAndTeamPageLink() {
		PeopleAndTeamPageLink.click();
		return new PeopleAndTeamsPage();
	}
	
	public ProjectUploadPage VerifyProjectUploadLink() {
		ProjectUploadLink.click();
		return new ProjectUploadPage();
	}



}
