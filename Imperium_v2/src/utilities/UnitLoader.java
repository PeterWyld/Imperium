package utilities;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import units.Cavalry;
import units.Melee;
import units.Ranged;
import units.unit;
import values.MainValues;

public class UnitLoader {
	
	public unit[][] LoadUnits(String mapName) throws JSONException {
		CSVReader unitLayoutReader = new CSVReader();
		List<List<String>> unitLayout = unitLayoutReader.ReadCSVFile("PlayerUnitLayout\\" + mapName + ".txt");
		JSONObject unitJson;
		int unitIndex = 0;
		int ySize = MainValues.battleMapArray.size();
		int xSize = MainValues.battleMapArray.get(0).size();		
		unit[][] unitArr = new unit[ySize][xSize];
		
		//Player's Units
		for(int i = 0; i <= ySize - 1; i++) {
			for (int j = 0; j <= xSize -1; j++) {
				try {
					unitIndex = Integer.parseInt(unitLayout.get(i).get(j));
				} catch (Exception e) {
					unitIndex = -1;
				}
				if (unitIndex != -1) {
					unitJson = main.Window.jsonUnits.getUnit(unitIndex);
					
					if(unitJson.getString("unitType").equals("Cav")) {
						Cavalry newUnit = new Cavalry(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
								unitJson.getString("fullname"), true);
						unitArr[i][j] = newUnit;
//					} else if (unitJson.getString("unitType").equals("Inf")) {
//						Melee newUnit = new Melee(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
//								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
//								unitJson.getString("fullname"), true);
//						unitArr[i][j] = newUnit;
//					} else if (unitJson.getString("unitType").equals("Skm")) {
//						Skirmisher newUnit = new Skirmisher(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
//								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
//								unitJson.getString("fullname"), true);
//						unitArr[i][j] = newUnit;
					} else if (unitJson.getString("unitType").equals("Rng")) {
						Ranged newUnit = new Ranged(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
								unitJson.getString("fullname"), true, unitJson.getInt("range"));
						unitArr[i][j] = newUnit;
					} else {
						unit newUnit = new unit(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
								unitJson.getString("fullname"), true);
						unitArr[i][j] = newUnit;
					}
				}
			}
		}
		
		// Enemy Units
		unitLayout = unitLayoutReader.ReadCSVFile("EnemyUnitLayout\\" + mapName + ".txt");
		for(int i = 0; i <= unitLayout.size() - 1; i++) {
			for (int j = 0; j <= unitLayout.get(i).size() -1; j++) {
				try {
					unitIndex = Integer.parseInt(unitLayout.get(i).get(j));
				} catch (Exception e) {
					unitIndex = -1;
				}
				if (unitIndex != -1) {
					unitJson = main.Window.jsonUnits.getUnit(unitIndex);
					
					if(unitJson.getString("unitType") == "Cav") {
						Cavalry newUnit = new Cavalry(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
								unitJson.getString("fullname"), false);
						unitArr[i][j] = newUnit;
//					} else if (unitJson.getString("unitType") == "Inf") {
//						Melee newUnit = new Melee(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
//								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
//								unitJson.getString("fullname"), false);
//						unitArr[i][j] = newUnit;
//					} else if (unitJson.getString("unitType") == "Skm") {
//						Skirmisher newUnit = new Skirmisher(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
//								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
//								unitJson.getString("fullname"), false);
//						unitArr[i][j] = newUnit;
//					} else if (unitJson.getString("unitType") == "Rng") {
//						Ranged newUnit = new Ranged(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
//								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
//								unitJson.getString("fullname"), false);
//						unitArr[i][j] = newUnit;
					} else {
						unit newUnit = new unit(j, i, unitJson.getInt("health"), unitJson.getInt("attack"), 
								unitJson.getInt("movement"), unitJson.getInt("unitIconIndex"),
								unitJson.getString("fullname"), false);
						unitArr[i][j] = newUnit;
					}
				}
			}
		}
		return unitArr;
		
	}
}
