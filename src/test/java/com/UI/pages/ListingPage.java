package com.UI.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListingPage {
	
	 WebDriver driver;

	    public By addToCartBtn = By.xpath("//span[text()='Add to cart']");
	//    By closepopup = By.xpath("(//button[contains(@class,'lightbox-dialog__close')])[4]");
	    By opencart= By.xpath("(//span[text()='See in cart'])[2]");
	    
	    By cartCount = By.id("gh-cart-n");

	    public ListingPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void addToCart() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        driver.findElement(addToCartBtn).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(opencart)).click();
	    }

	    public String getCartCount() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        return wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.id("gh-cart-n")))
	                .getText();
	    }

}
