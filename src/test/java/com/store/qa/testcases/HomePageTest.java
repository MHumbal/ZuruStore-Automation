package com.store.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;
import com.store.qa.pages.PeopleAndTeamsPage;
import com.store.qa.pages.ProjectUploadPage;
import com.store.qa.pages.ProjectsPage;
import com.store.qa.pages.SearchPage;




	
	public class HomePageTest extends TestBase {
		HomePage homePage;
		LoginPage loginPage;
		ProjectUploadPage projectUploadPage;
		PeopleAndTeamsPage peopleAndTeamsPage;
		SearchPage searchpage;
		ProjectsPage projectPage;
			
		
		
		public HomePageTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp() {
			initialization();
			projectUploadPage = new ProjectUploadPage();
			peopleAndTeamsPage = new PeopleAndTeamsPage();
			searchpage = new SearchPage();
			projectPage = new ProjectsPage();	
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		}
		
		@Test(priority = 1)
		public void HomePageTitileTest() {
		wait.until(ExpectedConditions.titleIs("Store"));
	    Assert.assertEquals(homePage.validateHomePageTitle(),"Store");
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}

