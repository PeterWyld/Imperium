package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	public void WriteCSVFile(List<List<String>> data, String mapName) {
		int width = data.get(0).size() -1;
		File mapFile = new File(mapName);
		try {
			FileWriter newFile = new FileWriter(mapFile);
			BufferedWriter writer = new BufferedWriter(newFile);
			StringBuffer line = new StringBuffer();
			for(int i = 0; i <= data.size() -1; i++) {
				for(int j = 0; j <= width; j++) {
					line.append(data.get(i).get(j));
					line.append(",");
				}
				line.append("\r\n");
			}
			line.deleteCharAt(line.length()-2);
			line.deleteCharAt(line.length()-1);
			newFile.write(line.toString());
			System.out.println(line);
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}