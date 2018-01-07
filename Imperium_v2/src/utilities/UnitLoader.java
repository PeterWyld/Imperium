package utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import units.unit;
import values.MainValues;

public class UnitLoader {
	
	public unit[][] LoadUnits(JSONObject layoutJson) throws JSONException {
		JsonParser unitFinder = new JsonParser();
		String unitName = "";
		JSONObject unitJson;
		unit[][] unitArr = new unit[MainValues.battleMapArray.size()][MainValues.battleMapArray.get(0).size()];
		JSONArray armyArr = layoutJson.getJSONArray("Army");
		for(int i = 0; i <= armyArr.length() - 1; i++) {
			unitName = armyArr.getJSONObject(i).getString("type");
			unitJson = unitFinder.JsonReader("Units\\" + unitName + ".txt");
			
			unit newUnit = new unit(armyArr.getJSONObject(i).getInt("xPos"), armyArr.getJSONObject(i).getInt("yPos"),
					unitJson.getInt("health"), unitJson.getInt("attack"), unitJson.getInt("movement"),
					unitJson.getInt("unitIconIndex"), unitJson.getString("fullname"));
			unitArr[armyArr.getJSONObject(i).getInt("yPos")][armyArr.getJSONObject(i).getInt("xPos")] = newUnit;
		}
		return unitArr;
		
	}
}
