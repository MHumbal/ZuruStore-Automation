package com.store.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;
import com.store.qa.pages.PeopleAndTeamsPage;
import com.store.qa.pages.ProfilePage;
import com.store.qa.pages.ProjectsPage;
import com.store.qa.pages.SearchPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ProfilePage projectUploadPage;
	PeopleAndTeamsPage peopleAndTeamsPage;
	SearchPage searchpage;
	ProjectsPage projectPage;



	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void zuruLogoTest() { 
		Assert.assertTrue(homePage.validateLogo());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

