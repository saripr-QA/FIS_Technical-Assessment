package com.UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By searchBox = By.id("gh-ac");
	By searchBtn = By.xpath("//span[text()='Search']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String item) {
		driver.findElement(searchBox).sendKeys(item);
		driver.findElement(searchBtn).click();
	}

}
