package com.store.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(xpath = "//input[@placeholder='Search for projects']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//li[contains(@id, 'rbt-menu-item')]")
	private List<WebElement> searchBarContainer;
	
	@FindBy(xpath = "//h3[@class='project-detail-heading']")
	private WebElement backgroundProjectName;
	
	@FindBy(xpath = "//div[@class='not-found-section']")
	private WebElement noProjectFound;
	
	
	public  SearchPage() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public String validateSearch( String fullProjectName) {
		searchBar.sendKeys(fullProjectName);
		searchBar.sendKeys(Keys.RETURN);
		return backgroundProjectName.getText();
	}
	
	public Boolean validateSearchResult(String projectKeyword) {
		searchBar.sendKeys(projectKeyword);
		int flag = 0;
		for (WebElement webElement : searchBarContainer) {
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
		searchBar.sendKeys(firstProject);
		String searchBarResultFirstProject = searchBarContainer.get(0).getText();
		searchBar.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		return backgroundProjectName.getText().equals(searchBarResultFirstProject);
	}

	public String validateProjectNotFound(String projectFakeName) throws InterruptedException {
		searchBar.sendKeys(projectFakeName);
		searchBar.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		return noProjectFound.getText();
		
	}
		
	public Boolean validateFirstProject() throws InterruptedException{
		String FirstProj = backgroundProjectName.getText();
		searchBar.sendKeys("ma");
		searchBar.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		searchBar.sendKeys(Keys.CONTROL, "A" , Keys.BACK_SPACE);
		Thread.sleep(1000);
		return FirstProj.equals(backgroundProjectName.getText());
		
		
	}


	
}

