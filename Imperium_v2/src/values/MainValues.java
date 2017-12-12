package values;

import java.util.List;

public class MainValues {
	public static int resolution = 75;
	public static int width = 16*resolution; //height of Frame
	public static int height = 9*resolution; //width of Frame
	
	public static int fps = 60;
	
	public static String title = "Imperium";
	
	public static int globalZoom = 1;
	public static int globalX = 0;
	public static int globalY = 0;
	public static List<List<String>> battleMapArray;
	
	//Menu Values
	public static boolean startMenu = true;
	public static boolean mainMenu = false;
	public static boolean optionsMenu = false;
}
