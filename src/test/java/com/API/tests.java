package com.API;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class tests extends base {

	@Test
	public void validateBitcoinAPI() {

		Response response = 
				given()
			//	.log().all()
			//	.relaxedHTTPSValidation() 
				.when().get("/coins/bitcoin").then().log().all().statusCode(200)
				.extract().response();

		String homepage = response.jsonPath().getString("links.homepage[0]");
		Assert.assertNotNull(homepage);
		Assert.assertFalse(homepage.isEmpty());

		Assert.assertNotNull(response.jsonPath().get("market_data.market_cap"));
		Assert.assertNotNull(response.jsonPath().get("market_data.total_volume"));

		Float priceChange = response.jsonPath().getFloat("market_data.price_change_percentage_24h");

		Assert.assertNotNull(priceChange);

		String responseBody = response.asString();

		Assert.assertTrue(responseBody.contains("usd"));
		Assert.assertTrue(responseBody.contains("eur"));
		Assert.assertTrue(responseBody.contains("gbp"));
	}
}