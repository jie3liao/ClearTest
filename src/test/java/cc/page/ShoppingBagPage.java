package cc.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cc.constant.FeatureValue;
import cc.util.JavaScriptUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * 
 * Shopping Bag Page.
 *
 */
public class ShoppingBagPage extends PageObject {
	
	public static final String XPATH_DIV = "./div";

	@FindBy(xpath="//div[contains(@class, 'productList')]")
	protected static WebElementFacade productList;
	
	@FindBy(xpath="//button[.='Use a discount code']")
	protected static WebElementFacade discountCodeButton;
	
	@FindBy(xpath="//button[.='Apply discount']")
	protected static WebElementFacade applyDiscountButton;
	
	@FindBy(xpath="//input[@id='discountCode']")
	protected static WebElementFacade discountCodeField;
	
	@FindBy(xpath="//span[@id='discount-code__error']/span[contains(@class, 'message')]")
	protected static WebElementFacade discountCodeErrorMessage;
	
	JavaScriptUtil seleniumUtil;
	
	public List<WebElement> getProductListFromBag() {
		return productList.findElements(By.xpath(XPATH_DIV));
	}
		
	public WebElementFacade getButton(String buttonName) {
		switch(buttonName) {
		    case FeatureValue.BUTTON_USE_A_DISCOUNT_CODE:
		    	seleniumUtil.scrollUp();
		    	return discountCodeButton;
		    case FeatureValue.BUTTON_APPLY_DISCOUNT:
		    	return applyDiscountButton;
		    default:
		    	throw new RuntimeException("Button name is not supported: " + buttonName);
		}
	}
	
	public WebElementFacade getField(String fieldName) {
		switch(fieldName) {
	        case FeatureValue.FIELD_DISCOUNT_CODE:
	        	seleniumUtil.scrollUp();
	    	    return discountCodeField;
	        default:
	    	    throw new RuntimeException("Field name is not supported: " + fieldName);
	    }
	}
	
	public boolean validateMessage(String messageLocation, String messageValue) {
		switch(messageLocation) {
            case FeatureValue.MESSAGE_LOCATION_DISCOUNT_CODE:
            	return discountCodeErrorMessage.getText().contains(messageValue);
            default:
    	        throw new RuntimeException("Message location is not supported: " + messageLocation);
        }
	}
}
