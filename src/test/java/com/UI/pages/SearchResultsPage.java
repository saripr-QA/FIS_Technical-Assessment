package com.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	
	 WebDriver driver;

	    By firstItem = By.xpath("(//a[@class='s-card__link image-treatment'])[1]");

	    public SearchResultsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickFirstItem() {
	        driver.findElement(firstItem).click();
	    }

}
