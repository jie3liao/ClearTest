package cc.util;

import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.pages.PageObject;

/**
 * 
 * Use JavaScript to supplement Selenium.
 *
 */
public class JavaScriptUtil extends PageObject{
	
	public void scrollUp() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 250)");
		waitABit(2000);
	}
	
	public void scrollToBottem() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, document.body.scrollHeight)");
		waitABit(2000);
	}
	
	public void scrollDown() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -250)");
		waitABit(2000);
	}
	
	public void scrollToTop() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		waitABit(2000);
	}
}
