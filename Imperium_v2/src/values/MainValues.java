package values;

import java.util.List;

import units.unit;
import utilities.CSVReader;

public class MainValues {
	private static CSVReader configReading = new CSVReader();
	public static int resolution = Integer.parseInt(configReading.ReadCSVFile("configCSV.txt").get(0).get(0));
	public static int tempRes = resolution; //for changing the resolution
	public static int width = 16*resolution; //height of Frame
	public static int height = 9*resolution; //width of Frame
	
	public static int fps = 60;
	public static int titleTimerIndex = 0;
	
	public static String title = "Imperium";
	
	public static int globalZoom = 1;
	public static int globalX = 0;
	public static int globalY = 0;
	public static List<List<String>> battleMapArray;
	public static unit[][] battleUnitArray;
	
	//Menu Values
	public static boolean startMenu = true;
	public static boolean mainMenu = false;
	public static boolean optionsMenu = false;
}
