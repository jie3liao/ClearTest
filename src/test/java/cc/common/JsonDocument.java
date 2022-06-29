package cc.common;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * Hold a JsonObject to provide custom methods for testing.
 *
 */
public class JsonDocument {
	
	public static final String JSON_ARRAY = "JsonArray";
	
	private JsonObject jsonObject;
	
	public JsonDocument(String content) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		jsonObject = gson.fromJson(content, JsonObject.class);
	}
	
	public boolean isJsonObject() {
		return jsonObject.isJsonObject();
	}
	
	public Object get(String memberName, String type) {
		switch (type) {
		    case JSON_ARRAY:
		        return jsonObject.getAsJsonArray(memberName);
            default:
            	throw new RuntimeException("Type is not supported: " + type);
		}
	}
	
	/**
	 * The JsonDocument has a member (memberName) with JsonArray value.
	 * The JsonArray value contains JsonObjects with the same member (memberName1).
	 * @param memberName member name of this JsonDocument as a JsonObject
	 * @param memberName1 member name of JsonObjects in JsonArray
	 * @return a list of string
	 */
	public List<String> getStringListFromJsonArrayMember(String memberName, String memberName1) {
		JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);
		List<String> valueList = new ArrayList<>();
		for (int i = 0; i < jsonArray.size(); i++) {
			valueList.add(jsonArray.get(i).getAsJsonObject().get(memberName1).getAsString());
		}
		
		return valueList;
	}
}
