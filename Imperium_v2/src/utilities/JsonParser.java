package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class JsonParser {

	public JSONObject JsonReader(String filePath) {
		JSONObject json;
		String text = "";
		File mapFile = new File(filePath);
		if(mapFile.exists() == true) { 
			try {
				FileReader file = new FileReader(mapFile);
				BufferedReader reader = new BufferedReader(file);
				String line = "";
				
				while ((line = reader.readLine()) != null){
					text = text + line;
				}
	
				file.close();
			} catch (Exception exec) {
				if(exec instanceof FileNotFoundException) { //ADD MORE CODE TO EXCEPTION
					exec.printStackTrace();
				}else if(exec instanceof IOException) {
					exec.printStackTrace();
				}
			}
		}
		try {
			json = new JSONObject(text);
			return json;
		} catch (Exception e) {
			
		}
		return null;
	}
}
