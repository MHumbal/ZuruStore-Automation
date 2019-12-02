package com.store.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;
import com.store.qa.pages.PeopleAndTeamsPage;

public class PeopleAndTeamsPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	PeopleAndTeamsPage peopleAndTeamsPage;

	public PeopleAndTeamsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		peopleAndTeamsPage = homePage.VerifyPeopleAndTeamPageLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
