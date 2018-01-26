package main;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import graphics.MenuGfx;
import graphics.OptionsGfx;
import graphics.StartGfx;
import graphics.BattleMap;
import graphics.GameUIBar;
import graphics.MapUIBar;
import listeners.MenuListener;
import utilities.ImageLibrary;
import utilities.JsonLibrary;
import values.MainValues;

public class Window {
	public static BattleManager manager = new BattleManager();
	public static EnemyAi theAi = new EnemyAi();
	public static ImageLibrary ImageUtility = new ImageLibrary();
	public static JsonLibrary jsonUnits = new JsonLibrary();
	public static JFrame frame = new JFrame(MainValues.title);
	public static JLayeredPane Layer = new JLayeredPane();
	
	public static JPanel startPanel = new StartGfx();
	public static JPanel menuPanel = new MenuGfx();
	public static JPanel optionsPanel = new OptionsGfx();
	public static BattleMap battleMapPanel = new BattleMap();
	public static MapUIBar mapEditorUI = new MapUIBar(); // not simply declared as a JPanel as it has its own method
	public static GameUIBar gameUI = new GameUIBar();
	
	public static void window() {
		startPanel.setSize(MainValues.width + 6, MainValues.height + 25);
		menuPanel.setSize(MainValues.width + 6, MainValues.height + 25);
		optionsPanel.setSize(MainValues.width + 6, MainValues.height + 25);
		battleMapPanel.setSize(MainValues.width + 6, MainValues.height + 25);
		mapEditorUI.setBounds(0, MainValues.height, MainValues.width, MainValues.resolution);
		gameUI.setBounds(0, MainValues.height, MainValues.width, 2*MainValues.resolution);
		
		frame.setSize(MainValues.width + 6,MainValues.height + 25);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Layer.add(startPanel, JLayeredPane.DEFAULT_LAYER);
		
		frame.addMouseListener(new MenuListener());
		frame.add(Layer);
		
		frame.setVisible(true);

	}
}
