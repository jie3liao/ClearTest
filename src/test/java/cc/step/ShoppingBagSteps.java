package cc.step;

import static org.assertj.core.api.Assertions.*;

import cc.page.IkeaLandingPage;
import cc.page.ShoppingBagPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 
 * Steps from ShoppingBag.feature
 *
 */
public class ShoppingBagSteps {
	
	IkeaLandingPage ikeaLandingPage;
	ShoppingBagPage shoppingBagPage;
	
	@Given("user is on Ikea shopping page")
	public void user_is_on_ikea_shopping_page() {
		ikeaLandingPage.gotoLandingPage();
	}

	@When("user types {string} in search bar to search")
	public void user_types_in_search_bar_to_search(String itemName) {
		ikeaLandingPage.searchItem(itemName);
	}
	
	@When("user picks number {int} position item in the list and puts the item in shopping bag")
	public void user_picks_number_position_item_in_the_list_and_puts_the_item_in_shopping_bag(Integer position) {
		ikeaLandingPage.findAddToCartButton(position).click();
	}
	
	@Then("verify {int} items in shopping bag")
	public void verify_items_in_shopping_bag(Integer itemCount) {
		assertThat(shoppingBagPage.getProductListFromBag().size()).isEqualTo(itemCount);
	}
	
	@When("user clicks {string} button in shopping bag")
	public void user_clicks_button_in_shopping_bag(String buttonName) {
		shoppingBagPage.getButton(buttonName).click();
	}
	
	@When("user enters {int} character string into {string} field in shopping bag")
	public void user_enters_character_string_into_field_in_shopping_bag(Integer size, String fieldName) {
		shoppingBagPage.getField(fieldName).type(RandomStringUtils.randomAlphanumeric(size));
	}
	
	@Then("validate that {string} error message is displayed in {string} message location in shopping bag")
	public void validate_that_error_message_is_displayed_in_message_location_in_shopping_bag(String messageValue, String messageLocation) {
		shoppingBagPage.validateMessage(messageLocation, messageValue);
	}
	
	@When("user click {string} link on landing page")
	public void user_click_link_on_landing_page(String linkName) {
		ikeaLandingPage.getLink(linkName).waitUntilVisible().click();
	}
}
