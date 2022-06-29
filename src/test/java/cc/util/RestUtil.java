package cc.util;

import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

/**
 * 
 * Utility functions for REST API test.
 *
 */
public class RestUtil {
	
	public static String get(String url, Map<String, String> queryParamMap) {
		try {
			Response response = SerenityRest.given().queryParams(queryParamMap).get(url);
			if (response.statusCode() == 200) {
				return response.body().asString();
			} else {
				throw new RuntimeException("Http Get Status code is: " + response.statusCode());
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
