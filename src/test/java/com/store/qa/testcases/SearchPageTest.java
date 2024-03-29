package com.store.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;
import com.store.qa.pages.SearchPage;

public class SearchPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchpage;

	public  SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = homePage.VerifySearchprojectbox();
	}

	//@Test
	public void zuruLogoTest() { 
		Assert.assertTrue(homePage.validateLogo());
	}
	
	//@Test
	public void verifySearchBar() {
		String projectName = searchpage.validateSearch("123");
		Assert.assertEquals(projectName, "123");
	}
	
	//@Test
	public void verifySearchBarResult() {
		Assert.assertTrue(searchpage.validateSearchResult("new"));
	}
	
	//@Test
	public void verifyFirstProjectPreview() throws InterruptedException {
		Assert.assertTrue(searchpage.validateFirstProjectPreview("12"));
	}
	
	//@Test
	public void verifyProjectNotFound() throws InterruptedException {
		String noProjectFoundMessage = "We could not find anything that matches \"12345\" and the applied filters\n" + 
				"Here's some tips to get better results:\n" + 
				"- Double check your spelling\n" + 
				"- Try different keywords\n" + 
				"- Try more generic keywords";
		Assert.assertEquals(searchpage.validateProjectNotFound("12345"), noProjectFoundMessage);
	}
	@Test
	public void verifyFirstProject() throws InterruptedException {
		Assert.assertTrue(searchpage.validateFirstProject("12"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


