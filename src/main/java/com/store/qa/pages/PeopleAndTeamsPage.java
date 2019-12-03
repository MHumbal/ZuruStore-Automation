package com.store.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.store.qa.base.TestBase;

public class PeopleAndTeamsPage extends TestBase{

	//Elements
	private By searchBar = By.xpath("//input[@placeholder = 'Find people']");

	private By searchBarContainer = By.xpath("//li[contains(@id, 'rbt-menu-item')]");

	private By firstUser = By.xpath("//div[@class = 'people-list-wrapper row']/div[1]/div/div[2]/div[2]/div[1]");
	
	private By firstUserFollow = By.xpath("//div[@class = 'people-list-wrapper row']/div[1]/div/div[2]/div[3]");

	//Methods
	public boolean validateSearchBarContainer(String partialName) {
		int flag = 0;
		driver.findElement(searchBar).sendKeys(partialName);
		for (WebElement webElement : driver.findElements(searchBarContainer)) {
			if(!webElement.getText().toUpperCase().contains(partialName.toUpperCase())) {
				flag = 1;
				break;
			}
		}
		if(flag == 1)
			return false;
		else
			return true;
	}
	
	public Boolean validateFollowUnFollow(String userName) throws InterruptedException {
		driver.findElement(searchBar).sendKeys(userName);
		driver.findElement(searchBar).sendKeys(Keys.RETURN);
		WebElement followUnFollow = driver.findElement(firstUserFollow);
		
		if(driver.findElement(firstUser).getText().contains(userName)) {
			if(followUnFollow.getText().equals("FOLLOW")) {
				followUnFollow.click();
				wait.until(ExpectedConditions.textToBePresentInElement(followUnFollow, "UNFOLLOW"));
				if(followUnFollow.getText().equals("UNFOLLOW"))
					return true;
				else
					return false;
			}
			else {
				actions.moveToElement(followUnFollow).perform();
				wait.until(ExpectedConditions.textToBePresentInElement(followUnFollow, "UNFOLLOW"));
				if(followUnFollow.getText().equals("UNFOLLOW")) {
					followUnFollow.click();
					wait.until(ExpectedConditions.textToBePresentInElement(followUnFollow, "FOLLOW"));
					Thread.sleep(1000);
					if(followUnFollow.getText().equals("FOLLOW"))
						return true;
					else
						return false;
				}
				else
					return false;
			}
		}
		else
			return false;
	}

}
