package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {
	public List<List<String>> ReadCSVFile(String mapName){
		List<List<String>> CSVListArray = new LinkedList<List<String>>(); // 2D array (using lists) of string
		File mapFile = new File(mapName);
		if(mapFile.exists() == true) { 
			try {
				FileReader file = new FileReader(mapFile);
				BufferedReader reader = new BufferedReader(file);
				String line = "";
				
				while ((line = reader.readLine()) != null){

					String[] lineVals = line.split(",");
					List<String> mapLine = new LinkedList<String>(Arrays.asList(lineVals));
					CSVListArray.add(mapLine); // adds the new list to the list of lists
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
		return CSVListArray;
	}
}