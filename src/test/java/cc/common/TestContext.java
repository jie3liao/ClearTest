package cc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a thread singleton class. It is used to hold test state values.
 * It serves the purpose of making test steps loosely coupled.
 */
public class TestContext {
	
	public static final String KEY_HTTP_GET_STRING_VALUE = "httpGetStringValue";
	public static final String KEY_HTTP_GET_JSON_VALUE = "httpGetJsonValue";
    
	private static final ThreadLocal<TestContext> localInstance = new ThreadLocal<TestContext>() {
		protected TestContext initialValue() {
			return new TestContext();
		}
	};
	
	private Map<String, Object> stateMap;
	
	private TestContext() {
		stateMap = new HashMap<>();
	}
	
	public static TestContext getInstance() {
		return localInstance.get();
	}
	
	private void setValue(String key, Object value) {
		stateMap.put(key, value);
	}
	
	private Object getValue(String key) {
		return stateMap.get(key);
	}
	
	public String getHttpGetStringValue() { return (String) getValue(KEY_HTTP_GET_STRING_VALUE); }
	public void setHttpGetStringValue(String value) { setValue(KEY_HTTP_GET_STRING_VALUE, value); }
	
	public JsonDocument getHttpGetJsonValue() { return (JsonDocument) getValue(KEY_HTTP_GET_JSON_VALUE); }
	public void setHttpGetJsonValue(JsonDocument value) { setValue(KEY_HTTP_GET_JSON_VALUE, value); }
	 
}
