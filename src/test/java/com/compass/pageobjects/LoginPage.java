package com.compass.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.compass.Utilities.Actiondriver;

public class LoginPage {
    WebDriver Idriver;

    public LoginPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//button[contains(text(),\"Register/Sign In\")]")
    WebElement register;
    
    @FindBy(xpath="//button[contains(text(),\"Buyer / Seller\")]")
    WebElement buyerAndSeller;
    
    @FindBy(xpath="//body/div[4]/div[2]/div[2]/div[1]/button[5]/div[1]")
    WebElement continueWithEmail;
    
    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(id="continue")
    WebElement continueSignIn;
    
    @FindBy(linkText="Buy")
    WebElement Buy;
    
    @FindBy(xpath="//uc-search-bar-toggle-menu[5]/dl/dt/span")
    WebElement locations;
    
    @FindBy(xpath="//uc-search-bar-accordion-menu-item[3]/div/span")
    WebElement manhattan;
    
    @FindBy(xpath="//uc-search-bar-accordion-menu-item[3]/div[2]/search-select/div/div/div[2]/div/label/span")
    WebElement allManhattan;
    
    @FindBy(xpath="(//span[@id='agText'])[4]")
    WebElement price;
    


    public  void LogIn(String emailadd,String pwd) throws InterruptedException
    {
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, register);
    	Actiondriver.clickEle(register);
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, buyerAndSeller);
    	Actiondriver.clickEle(buyerAndSeller);
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, continueWithEmail);
    	Actiondriver.clickEle(continueWithEmail);
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, email);
    	Actiondriver.inputKeysToEle(email,emailadd);
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, continueSignIn);
    	Actiondriver.clickEle(continueSignIn);
   
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, password);
    	Actiondriver.inputKeysToEle(password,pwd);
    	
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, continueSignIn);
    	Actiondriver.clickEle(continueSignIn);
    }
    
    public void saleStatus() throws InterruptedException
    {
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, Buy);
    	Actiondriver.clickEle(Buy);
    	
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, locations);
    	Actiondriver.clickEle(locations);
    	
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, manhattan);
    	Actiondriver.clickEle(manhattan);
    	
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, allManhattan);
    	Actiondriver.clickEle(allManhattan);
    	
    	Actiondriver.waitDriverUntilElementIsVisible(BaseClass.driver, price);
    	Actiondriver.clickEle(price);
    	Thread.sleep(2000);
    	Actiondriver.clickEle(price);	
    	
    }

}
