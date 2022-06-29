package cc.step;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import cc.common.JsonDocument;
import cc.common.TestContext;
import cc.util.RestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 * Steps from USAData.feature
 *
 */
public class USADataSteps {
	
	@Given("user gets data from url {string} with query parameters")
	public void user_gets_data_from_url_with_query_parameters(String url, Map<String, String> queryParamMap) {
		String httpGetStringValue = RestUtil.get(url, queryParamMap);
		TestContext.getInstance().setHttpGetStringValue(httpGetStringValue);
	}

	@Then("verify that the http get value is a JSON document")
	public void verify_that_the_http_get_value_is_a_json_document() {
		JsonDocument httpGetJsonValue = new JsonDocument(TestContext.getInstance().getHttpGetStringValue());
	    assertThat(httpGetJsonValue.isJsonObject()).isTrue();
	    TestContext.getInstance().setHttpGetJsonValue(httpGetJsonValue);
	}
	
	@Then("verify that the http get json value has a member {string} with {string} value.")
	public void verify_that_the_http_get_json_value_has_a_member_with_value(String memberName, String type) {
	    assertThat(TestContext.getInstance().getHttpGetJsonValue().get(memberName, type)).isNotNull();
	}

	@Then("verify that the http get json value has a member {string} with JsonArray value containing JsonObjects with distinct {string} values.")
	public void verify_that_the_http_get_json_value_has_a_member_with_json_array_value_containing_json_objects_with_distinct_values(String memberName, String memberName1) {
	    List<String> list = TestContext.getInstance().getHttpGetJsonValue().getStringListFromJsonArrayMember(memberName, memberName1);
	    assertThat(list.size()).isEqualTo((new HashSet<String>(list)).size());
	}
	
	@Then("verify that the http get json value has a member {string} with JsonArray value containing JsonObjects with same {string} values.")
	public void verify_that_the_http_get_json_value_has_a_member_with_json_array_value_containing_json_objects_with_same_values(String memberName, String memberName1) {
		List<String> list = TestContext.getInstance().getHttpGetJsonValue().getStringListFromJsonArrayMember(memberName, memberName1);
		assertThat((new HashSet<String>(list)).size()).isEqualTo(1);
	}
}
