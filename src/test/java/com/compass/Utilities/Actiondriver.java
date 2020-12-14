package com.compass.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.compass.pageobjects.BaseClass;


/**
 * All customized/ Generic functions
 * 
 * 
 */
public class Actiondriver extends BaseClass {

	// public static Property repository=new
	// Property("�bjectRepository.properties");
	public static WebDriver driver;
	public static WebDriverWait wait=null;

	/**
	 * This Method is to perform click operation on (link,button,check box,radio
	 * button) Before click the element it will wait until the element present.
	 * 
	 * @param locator
	 *            --Element locator
	 * 
	 */
	public static boolean click(By locator) throws Throwable {
		boolean flag = false;
		try {
			isElementPresent(locator);
			driver.findElement(locator).click();
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			flag = true;
			return false;
		} finally {
			if (flag) {
				// throw new ElementNotFoundException("", "", "");
				throw new NoSuchElementException("Element not found");
			} else {
			}
		}
	}

	/**
	 * Verify Element present or not through "isDisplayed()"
	 * 
	 * @param locator
	 * @return true if Element is present, false otherwise
	 * 
	 * 
	 */
	public static boolean isElementPresent(By locator) throws Throwable {
		try {
            return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			throw(e);
		}
		
		
	}


	/**
	 * This method for type in to text box or text area
	 * 
	 * @param locator
	 *            --Element locator
	 * @param testdata
	 *            -- input text
	 * @Revision History
	 * 
	 */
	public static boolean type(By locator, String testdata) throws Throwable {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(testdata);
			return true;
		} catch (NoSuchElementException e) {
			 
			return false;
			
		}
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            element to move to.
	 * @return A self reference.
	 */
	public static void mouseover(By locator) throws Throwable {

		try {
			WebElement mo = driver.findElement(locator);
			new Actions(driver).moveToElement(mo).build().perform();	
		} catch (Exception e) {
			throw(e);
		}

	}

	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves by a given offset, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param xOffset
	 *            horizontal move offset.
	 * @param yOffset
	 *            vertical move offset.
	 * @return A self reference.
	 * 
	 */
	public static void draggable(By source, int x, int y) throws Exception {

		WebElement dragitem = driver.findElement(source);

		new Actions(driver).dragAndDropBy(dragitem, x, y).build().perform();

		Thread.sleep(5000);
	}

	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves to the location of the target element, then
	 * releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * @return A self reference.
	 * 
	 */
	public static void draganddrop(By source, By target) throws Exception {

		WebElement from = driver.findElement(source);
		WebElement to = driver.findElement(target);
		new Actions(driver).dragAndDrop(from, to).perform();
	}

	/**
	 * To slide an object to some distance
	 * 
	 * @param slider
	 * @throws Exception
	 * 
	 */
	public static void slider(By slider) throws Exception {
		WebElement dragitem = driver.findElement(slider);
		new Actions(driver).dragAndDropBy(dragitem, 300, 1).build().perform();
		Thread.sleep(5000);
	}

	/**
	 * To right click on an element
	 * 
	 * @param by
	 * @throws Exception
	 */

	public static void rightclick(By by) throws Exception {
		WebElement elementToRightClick = driver.findElement(by);
		Actions clicker = new Actions(driver);
		clicker.contextClick(elementToRightClick).perform();
	}

	/**
	 * Wait for an element
	 * 
	 * @param locator
	 *            --Element locator
	 */

	public static void waitForElementPresent(By locator) throws Throwable {
		for (int i = 0; i < 200; i++) {
			if (isElementPresent(locator)) {
				break;
			} else {
				Thread.sleep(50);
			}
			{
				try {
					driver.wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Click and wait for an element
	 * 
	 * @param locator
	 *            -- Element locator
	 * @param waitElement
	 *            -- Element which you are waiting for
	 * @throws Throwable
	 */
	public static void clickAndWaitForElementPresent(By locator, By waitElement)
			throws Throwable {
		click(locator);
		waitForElementPresent(waitElement);

	}

	/**
	 * Select a value from Dropdown using send keys
	 * 
	 * @param locator
	 *            -- Element locator
	 * @param value
	 */
	public static void select(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	/**
	 * select value from DD by using selectByIndex
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @param index
	 *            -- Drop down value index
	 */
	public void selectByIndex(By locator, int index) {
		Select s = new Select(driver.findElement(locator));
		s.selectByIndex(index);
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @param value
	 *            -- Drop down value
	 */

	public void selectByValue(By locator, String value) throws Throwable {
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByValue(value);	
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		
		
	}

	/**
	 * select value from DD by using selectByVisibleText
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @param visibletext
	 *            --Visible text of Drop down value
	 */

	public void selectByVisibleText(By locator, String visibletext) throws Throwable {
		try {
			if (isElementPresent(locator)) {
				Select s = new Select(driver.findElement(locator));
				s.selectByVisibleText(visibletext);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		
	}
	
	/**
	 * SWITCH TO WINDOW BY USING TITLE
	 * 
	 * @param windowTitle
	 *            --Title of the child widow
	 * @param count
	 *            --Number of the window
	 */
	//
	public Boolean switchWindowByTitle(String windowTitle, int count)
			throws Throwable {
		
		try {
			
			Set<String> windowList = driver.getWindowHandles();
			int windowCount = windowList.size();

			// DateTime timeout = DateTime.Now.AddSeconds(30);
			Calendar calendar = new GregorianCalendar();
			int second = calendar.get(Calendar.SECOND); // /to get current time
			int timeout = second + 40;
			// calendar.add(Calendar.SECOND, 40);
			while (windowCount != count && second < timeout) {
				Thread.sleep(500);
				windowList = driver.getWindowHandles();
				windowCount = windowList.size();

			}

			String[] array = windowList.toArray(new String[0]);

			for (int i = 0; i < windowCount; i++) {

				driver.switchTo().window(array[i]);
				if (driver.getTitle().contains(windowTitle))
					return true;
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		

	}

	/**
	 * Function To get column count and print data in Columns
	 * 
	 * @param locator
	 *            ---- Element locator
	 */
	public void getColumncount(By locator) throws Throwable {
		
		try {
			WebElement tr = driver.findElement(locator);
			List<WebElement> columns = tr.findElements(By.tagName("td"));
			System.out.println(columns.size());
			for (WebElement column : columns) {
				System.out.print(column.getText());
				System.out.print("|");
			}	
		} catch (Exception e) {
			throw(e);
		}

		

	}

	/**
	 * Function To get row count and print data in rows
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @throws Throwable 
	 * @Date 08/01/2014
	 */
	public int getRowCount(By locator) throws Throwable {

		WebElement table = driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// System.out.println(rows.size()-1);
		int a = rows.size() - 1;
		
		System.out.println("tr count is" + a);
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
		return a;

	}
	 
	/**
	 * Verify alert present or not
	 * 
	 * @return True if alert is present false other wise
	 */
	public boolean isAlertPresent() {

		boolean presentFlag = false;

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = true;
			// if present consume the alert
			alert.accept();

		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}

		return presentFlag;
	}

	/**
	 * To launch URL
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * check box checked or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return True if the element is enabled, false otherwise.
	 */
	public Boolean isChecked(By locator) throws Throwable {
		
		try {
			Boolean value = false;
			if (driver.findElement(locator).isSelected()) {
				value = true;
			}
			return value;	
		} catch (Exception e) {
			throw(e);
		}
		
	}

	/**
	 * Element is editable or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return True if the element is enabled, false otherwise.
	 */

	public Boolean isEditable(By locator) throws Throwable {
		
		try {
			Boolean value = false;
			if (driver.findElement(locator).isEnabled()) {
				value = true;
			}
			return value;	
		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
		
	}

	/**
	 * Element visible or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return True if the element is visible false other wise
	 */

	public Boolean IsVisible(By locator) throws Throwable {
		Boolean value = false;
		
		try {
			if (isElementPresent(locator)) {
				value = driver.findElement(locator).isDisplayed();
			}
			return value;	
		} catch (Exception e) {
			throw(e);
		}
		
	}

	/**
	 * Get the CSS value of an element
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return CSS value of the element
	 */

	public String GetValue(By locator) throws Throwable {
		String value = "";
		if (isElementPresent(locator)) {
			value = driver.findElement(locator).getCssValue(value);
		}
		return value;
	}

	/**
	 * Check the expected value is available or not
	 * 
	 * @param expvalue
	 * @param locator
	 * @param attribute
	 * */
	public static boolean assertValue(String expvalue, By locator,
			String attribute) throws Throwable {
		Assert.assertEquals(expvalue, getAttribute(locator, attribute));
		return true;
	}

	/**
	 * Check the text is presnt or not
	 * 
	 * @param text
	 */
	public void assertTextPresent(String text) throws Throwable {
			Assert.assertTrue(isTextPresent(text), text);	
		
	}

	/**
	 * Assert element present or not
	 * 
	 * @param text
	 * @param by
	 */

	public static boolean assertElementPresent(By by) throws Throwable {
		try {
			Assert.assertTrue(isElementPresent(by));
			Assert.assertTrue(driver.findElement(by).isDisplayed());
			return true;
		} catch (Error e) {
			return false;
		}
	}

	/**
	 * Assert text
	 * 
	 * @param text
	 * @param by
	 */

	public static boolean assertText(String text, By by) throws Exception {

		boolean value = false;
		try {
			Thread.sleep(1000);
			Assert.assertEquals(text, getText(by));
			System.out.println("Expected Text is available");
			value = true;
		} catch (Throwable e) {

			System.out.println("Expected text is not available");
			value = false;
			throw new Exception(e);

		}
		return value;

	}

	/**
	 * assert title
	 * 
	 * @param title
	 */
	public static boolean asserttitle(String title) {
		try {
			Assert.assertEquals(title, driver.getTitle());
			return true;
		}

		catch (Exception e) {
			System.out.println("Title does not match");
			return false;
		}

	}

	/**
	 * Verifies the URL of the current page. 
	 * 
	 * @return true if the url is matched, false otherwise
	 * @param title
	 */

	public static boolean asserturl(String url) {
		try {
			Assert.assertEquals(url, driver.getCurrentUrl());
			return true;
		}

		catch (Exception e) {
			System.out.println("URL does not match");
			return false;
		}
	}

	/**
	 * Verify text present or not
	 * 
	 * @param text
	 * @return true if text is present false other wise
	 */
	public static boolean verifyTextPresent(String text) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(text));
			System.out.println(text + " is Available");
			return true;
		} catch (Error e) {
			System.out.println(text + "Not avaliable");

		}
		return false;
	}

	/**
	 * Verify the 404 error or broken links
	 * 
	 * @param text
	 */
	public static void verify404(String text)

	{

		if (driver.getPageSource().contains("404")) {
			System.out.println("404 error");
		}

	}

	/**
	 * Get the value of a the given attribute of the element.
	 * 
	 * @param by
	 * @param attribute
	 * @return Will return the current value
	 */

	public static String getAttribute(By by, String attribute) throws Throwable {
		String value = "";
		if (isElementPresent(by)) {
			value = driver.findElement(by).getAttribute(attribute);
		}
		return value;
	}

	/**
	 * Text present or not
	 * 
	 * @param text
	 * @return
	 */

	public boolean isTextPresent(String text) {

		return driver.getPageSource().contains(text);
	}

	/**
	 * The innerText of this element.
	 * 
	 * @param locator
	 * @return
	 */

	public static String getText(By locator) throws Throwable {
		String text = "";
		if (isElementPresent(locator)) {
			text = driver.findElement(locator).getText();
		}

		return text;
	}

	/**
	 * Capture Screenshot
	 * 
	 * @param fileName
	 */

	/**
	 * Click on the Link
	 * 
	 * @param Locator
	 */
	public static boolean clickLink(By locator) throws Throwable {

		try {
			isElementPresent(locator);
			driver.findElement(locator).click();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			return false;
		}

	}


	/**
	 * Element is Enable or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 * @return True if the element is enabled, false otherwise.
	 */
	public static Boolean activeButton(By locator) {
		Boolean value = false;
		if (driver.findElement(locator).isEnabled()) {
			value = true;
		}
		return value;
	}

	/**
	 * Checking the message display or not
	 * 
	 * @param locator
	 *            ---- Element locator
	 */
	
	public static boolean displayMsg(By locator) {

		return driver.findElement(locator).isDisplayed();
	}

	
	
	/** this method is used to upload file
	 * @param locator  
	 * @param testdata  
	 * @author 
	 * @return
	 */
	public static boolean uploadFile(By locator, String testdata) {
		try {
			driver.findElement(locator).sendKeys(testdata);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	}

	
	/**
	 * scrolling the page to the specified element
	 * @param locator
	 * @throws Throwable
	 * @author vnandyal
	 */
	public static void scrollToElement(By locator) throws Throwable{
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
			
		} catch (Exception e) {
			throw(e);
			
		}
		
	}
	
	/**
	 * on successful selection of multiple values, other false
	 * @param locator
	 * @param Options
	 * @throws Throwable 
	 */
	public void multiselection(By locator, String Options) throws Throwable{
		
		try {
			if (isElementPresent(locator)) {
				Select s1 = new Select(driver.findElement(locator));
				//ArrayList aList = new ArrayList (Arrays.asList(Options.split("\\s*,\\s*")));
				@SuppressWarnings("unchecked")
				ArrayList aList = new ArrayList (Arrays.asList(Options.split(",")));
				for(int i=0;i<aList.size();i++)
				{
					//s1.selectByVisibleText((String) aList.get(i));
					s1.selectByVisibleText(((String) aList.get(i)).trim());
				    //System.out.println(aList.get(i));
				}	
			}	
		} catch (Exception e) {
			throw(e);
		}
		
	}
	
			
			/** fetches all the links count in the page
			 * @param locator
			 * @return
			 * @throws Throwable
			 */
			public int getlinkCount(By locator) throws Throwable {

				WebElement ele = driver.findElement(locator);
				List<WebElement> links = ele.findElements(By.tagName("a"));
				int cnt = links.size();
				System.out.println("count is" + cnt);
				for (WebElement link : links) {
					System.out.println(link.getText());
				}
				return cnt;

			}
			
			public static void waitDriverUntilElementIsInvisible(WebDriver driver, WebElement ele) {
				wait = new WebDriverWait(driver, Util.WAIT_TIME);
				wait.until(ExpectedConditions.invisibilityOf(ele));
			}
			public static void waitDriverUntilElementIsVisible(WebDriver driver, WebElement element) {
				wait = new WebDriverWait(driver, Util.WAIT_TIME);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			public static void clickEle(WebElement ele) {
				ele.click();
			}
			
			public static void inputKeysToEle(WebElement ele, String val) {
				ele.clear();
				ele.sendKeys(val);
			}
			public static void waitDriverUntilElementIsClickable(WebDriver driver, WebElement element) {
				wait = new WebDriverWait(driver, Util.WAIT_TIME);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			

			
			
			
		
			
}

