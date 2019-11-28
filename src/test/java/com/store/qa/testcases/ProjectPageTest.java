package com.store.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;
import com.store.qa.pages.ProjectsPage;

public class ProjectPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	ProjectsPage projectsPage;
	
	public ProjectPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		projectsPage = homePage.VerifyProjectPage();
	}
	
	@Test
	public void navigateToHomePage() {
		projectsPage.validateHomePage();
		Assert.assertEquals(homePage.validateHomeText(), "Home");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
