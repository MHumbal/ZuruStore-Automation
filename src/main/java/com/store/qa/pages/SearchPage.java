package com.store.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.store.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	//Elements
	private By searchBar = By.xpath("//input[@placeholder='Search for projects']");
	
	private By searchBarContainer = By.xpath("//li[contains(@id, 'rbt-menu-item')]");
	
	private By backgroundProjectName = By.xpath("//h3[@class='project-detail-heading']");
	
	private By noProjectFound = By.xpath("//div[@class='not-found-section']");
	
	//Methods
	public String validateSearch( String fullProjectName) {
		driver.findElement(searchBar).sendKeys(fullProjectName);
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		return driver.findElement(backgroundProjectName).getText();
	}
	
	public Boolean validateSearchResult(String projectKeyword) {
		driver.findElement(searchBar).sendKeys(projectKeyword);
		int flag = 0;
		for (WebElement webElement : driver.findElements(searchBarContainer)) {
			if(!webElement.getText().toUpperCase().contains(projectKeyword.toUpperCase())){
				flag = 1;
			}
		}
		if(flag == 0)
			return true;
		else
			return false;
	}
	
	
	public Boolean validateFirstProjectPreview(String firstProject) throws InterruptedException {
		driver.findElement(searchBar).sendKeys(firstProject);
		String searchBarResultFirstProject = driver.findElements(searchBarContainer).get(0).getText();
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		return driver.findElement(backgroundProjectName).getText().equals(searchBarResultFirstProject);
	}

	public String validateProjectNotFound(String projectFakeName) throws InterruptedException {
		driver.findElement(searchBar).sendKeys(projectFakeName);
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		return driver.findElement(noProjectFound).getText();
	}
		
	public Boolean validateFirstProject() throws InterruptedException{
		String FirstProj = driver.findElement(backgroundProjectName).getText();
		driver.findElement(searchBar).sendKeys("ma");
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(searchBar).sendKeys(Keys.CONTROL, "A" , Keys.BACK_SPACE);
		Thread.sleep(1000);
		return FirstProj.equals(driver.findElement(backgroundProjectName).getText());
	}


	
}

