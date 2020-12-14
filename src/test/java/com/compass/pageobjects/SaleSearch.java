package com.compass.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaleSearch {
    WebDriver Idriver;

    public SaleSearch(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//a[contains(text(),\"Buy\")]")
    WebElement buy;
    
    @FindBy(xpath="//span[contains(text(),\"Locations\")]")
    WebElement locations;
    
    @FindBy(xpath="//span[contains(text(),\"Manhattan\")]")
    WebElement manhattan;
    
    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(id="continue")
    WebElement continueSignIn;

    public  void highPrice()
    {
    	buy.click();
    	locations.click();
    	manhattan.click();
    }

}
