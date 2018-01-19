package utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonLibrary {
	JsonParser fileReader;
	JSONObject jsonObj;
	JSONArray jsonUnits;
	public JsonLibrary() {
		try {
			fileReader = new JsonParser();
			jsonObj = fileReader.JsonReader("Units\\UnitJson.txt");
			jsonUnits = jsonObj.getJSONArray("Units");
		} catch (JSONException e) {
			//send pop-up
			System.exit(0);
		}
	}
	public JSONObject getUnit(int unitIndex) throws JSONException{
		return jsonUnits.getJSONObject(unitIndex);
	}
}
