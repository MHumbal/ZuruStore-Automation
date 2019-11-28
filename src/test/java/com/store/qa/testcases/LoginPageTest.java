package com.store.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.TestBase;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage ; 
    HomePage homePage;
    public LoginPageTest() {
        super();

    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        Assert.assertEquals(loginPage.validateLoginPageTitle(), "Auth");
    }

    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        wait.until(ExpectedConditions.titleIs("Store"));
        Assert.assertEquals(homePage.validateHomePageTitle(), "Store");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}