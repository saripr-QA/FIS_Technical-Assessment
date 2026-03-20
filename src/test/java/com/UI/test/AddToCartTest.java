package com.UI.test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.UI.base.BaseTest;
import com.UI.pages.HomePage;
import com.UI.pages.ListingPage;
import com.UI.pages.SearchResultsPage;

public class AddToCartTest extends BaseTest {

	@Test
	public void verifyItemAddedToCart() {

		HomePage home = new HomePage(driver);
		home.searchItem("book");

		SearchResultsPage results = new SearchResultsPage(driver);
		results.clickFirstItem();

		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}

		ListingPage product = new ListingPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(product.addToCartBtn));

		product.addToCart();

		String count = product.getCartCount();

		Assert.assertTrue(Integer.parseInt(count) > 0, "Cart is not updated");
	}

}
