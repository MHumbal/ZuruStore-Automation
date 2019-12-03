package com.store.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		peopleAndTeamsPage = homePage.VerifyPeopleAndTeamPageLink();
		Thread.sleep(1000);
	}
	
	//@Test
	public void verifySearchBarContainer() {
		Assert.assertTrue(peopleAndTeamsPage.validateSearchBarContainer("Ma"));
	}
	
	@Test
	public void verifyFollowUnFollow() throws InterruptedException{
		Assert.assertTrue(peopleAndTeamsPage.validateFollowUnFollow("Mayur"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
