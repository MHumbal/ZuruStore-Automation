package com.store.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import com.store.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Screen s;
	public static Actions actions;
	
	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/store/qa/config/config.properties");
			prop.load(ip);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		s = new Screen();
		actions = new Actions(driver);
		
		driver.get(prop.getProperty("url"));
		
	}

}
