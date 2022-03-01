package com.qa.test.core;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.qa.test.base.TestBase;
import com.qa.test.utils.LocatorType;

public class BrowserInteractions extends TestBase {

	public static WebElement element;
	public static WebDriverWait wait;
	public static Actions action = new Actions(driver);

	public static void navigateToURL(String url) {
		driver.get(url);
	}

	public static void click(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.click();
	}

	public static void clearAndType(LocatorType type, String selector, String value) throws Exception {
		element = getElement(type, selector);
		element.clear();
		element.sendKeys(value);
	}

	public static void PasteField(LocatorType type, String selector, String value) throws Exception {
		element = getElement(type, selector);
		action.click(element).sendKeys(value).perform();
	}

	public static void isVisible(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.isDisplayed();

	}

	public static void isEnabled(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		element.isEnabled();
	}

	public static String getText(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		String text = element.getText();
		return text;
	}

	public static int intCount(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		String count = element.getText();
		return Integer.parseInt(count);
	}

	public static void pageRefresh() throws Exception {
		driver.navigate().refresh();
	}

	public static void doubleClick(LocatorType type, String selector) throws Exception {
		element = getElement(type, selector);
		action.doubleClick(element).perform();
	}

	public static boolean isElementPresent(LocatorType type, String selector) throws Exception {
		try {
			element = getElement(type, selector);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean isElementNotPresent(LocatorType type, String selector) throws Exception {
		try {
			element = getElement(type, selector);
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

	public static void alertAccept() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void switchFrame(String frameId) throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameId);

	}

	public static void switchToChildWindow(String title) throws Exception {
		try {

			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;
			String childWindowTitle;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
				if (!parentWindowHandler.equals(subWindowHandler)) {
					driver.switchTo().window(subWindowHandler);
					childWindowTitle = driver.getTitle();
					if (childWindowTitle.equalsIgnoreCase(title)) {
						break;
					}
					driver.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Expeced window is not present");
		}
	}

	public static void switchToDefaultFrame() throws Exception {
		driver.switchTo().defaultContent();
	}

	public static WebElement getElement(LocatorType locatorType, String locator) throws Exception {

		By by;
		switch (locatorType) {
		case XPATH:
			by = By.xpath(locator);
			break;
		case ID:
			by = By.id(locator);
			break;
		case CSSSELECTOR:
			by = By.cssSelector(locator);
			break;
		case NAME:
			by = By.name(locator);
			break;
		case CLASSNAME:
			by = By.className(locator);
			break;
		case LINKTEXT:
			by = By.linkText(locator);
			break;
		case PARTIALLINKTEXT:
			by = By.partialLinkText(locator);
			break;
		case TAGNAME:
			by = By.tagName(locator);
			break;
		default:
			throw new Exception("Unknown locator type");
		}

		try {
			element = waitForElementPresence(by);

		} catch (Exception e) {
			throw new Exception("Element not visible in the page" + "with locator: " + locator + " Type used:"
					+ locatorType.name());

		}
		return element;
	}

	private static WebElement waitForElementPresence(final By by) {
		wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
