package cc.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cc.constant.FeatureValue;
import cc.util.JavaScriptUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

/**
 * 
 * Ikea landing page.
 *
 */
public class IkeaLandingPage extends PageObject {
	
	public static final String XPATH_ADD_TO_CART_BUTTON = ".//button[contains(@aria-label, 'Add')]";
	public static final String XPATH_DIV = "./div";
	
	@FindBy(xpath="//input[@aria-label='Search by product']")
	protected static WebElementFacade searchField;
	
	@FindBy(xpath="//div[@id='search-results']")
	protected static WebElementFacade searchResults;
	
	@FindBy(xpath="//a[contains(@aria-label,'Shopping bag')]")
	protected static WebElementFacade shoppingBagLink;
	
	JavaScriptUtil seleniumUtil;
	
	public void gotoLandingPage() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		getDriver().navigate().to(variables.getProperty("environment.ikea.url"));
	}

	public void searchItem(String itemName) {
		seleniumUtil.scrollToTop();
		searchField.typeAndEnter(itemName);
	}
	
	public WebElementFacade findAddToCartButton(int position) {
		seleniumUtil.scrollUp();	
		WebElementFacade element = getItem(position);
		return element.findBy(XPATH_ADD_TO_CART_BUTTON);
	}
	
	public WebElementFacade getItem(int position) {
		return element(getItemList().get(position - 1));
	}
	
	public List<WebElement> getItemList() {
		waitABit(2000); // Wait 2 seconds for items to settle down.
		return searchResults.findElements(By.xpath(XPATH_DIV));
	}
	
    public WebElementFacade getLink(String linkName) {
    	switch(linkName) {
            case FeatureValue.LINK_SHOPPING_BAG:
            	seleniumUtil.scrollToTop();
            	waitABit(3000); // Wait 3 seconds for the shopping bag to appear.
    	        return shoppingBagLink;
            default:
    	        throw new RuntimeException("Link name is not supported: " + linkName);
        }
	}
}
