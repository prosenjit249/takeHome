package com.compass.testCases;





import java.io.IOException;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.compass.pageobjects.BaseClass;
import com.compass.pageobjects.LoginPage;


public class LogInTest extends BaseClass {

	@Test
	public void logInTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.LogIn(username, password);

		// getting Title of the page
		String title = driver.getTitle();
		System.out.println(title);

		Thread.sleep(2000);
		lp.saleStatus();
		Thread.sleep(10000);
		captureScreen(driver,"finalpage");

		List<WebElement> neighborhood = driver.findElements(By.xpath("(//*[@colid='listing.location.neighborhood'])"));
	    Map<String, String> map = new LinkedHashMap<String, String>();

	        System.out.println("Five Most Expensive neighborhood in Manhattan are as follows --> ");

	        int count = 1;
	        for (int i=1; i<neighborhood.size(); i++) {
	            if(map.keySet().size() < 5) {
	                if (!map.containsKey(neighborhood.get(i).getText())) {
	                    String price_xpath = "(//*[@colid='listing.location.neighborhood'])[" + (i + 1) + "]/following-sibling::div[1]";
	                    WebElement price = driver.findElement(By.xpath(price_xpath));

	                    String link_xpath = "(//*[@colid='listing.location.neighborhood'])[" + (i + 1) + "]/preceding-sibling::div[1]//a";
	                    WebElement link = driver.findElement(By.xpath(link_xpath));

	                    map.put(neighborhood.get(i).getText(), price.getText());

	                    System.out.println("#" + count + "> Neighborhood -> " + neighborhood.get(i).getText() +
	                                        "; Price -> " + price.getText() + "; Address -> " + link.getText() +  "; Link -> " + link.getAttribute("href"));

	                    count++;
	                }
	            }else{
	                break;
	            }

	        }
	}
			
}