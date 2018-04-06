package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLayeredPane;

import org.json.JSONException;

import main.Window;
import units.unit;
import utilities.CSVReader;
import utilities.UnitLoader;
import values.MainValues;

public class MenuListener implements MouseListener {
	int mX = 0;
	int mY = 0;
	int res = MainValues.resolution;
	MapEditorListener mapListener = new MapEditorListener();
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mX = e.getX()-6;
		mY = e.getY()-25;
		if (MainValues.startMenu == true) {
			if(mX > (16/2-2/2)*res && mX < (16/2+2/2)*res &&
				mY > (9.0/2-1.0/2)*res && mY < (9.0/2+1.0/2)*res){ //check if they clicked the button
				MainValues.startMenu = false;
				MainValues.mainMenu = true;
				Window.Layer.remove(Window.startPanel);
				Window.Layer.add(Window.menuPanel);
			}
		} else if (MainValues.mainMenu == true) {
			if (mX > (16/2-2.5/2)*res && mX < (16/2+2.5/2)*res) { //check if in right column
				if (mY > (9.0/4-1.0/2)*res && mY < (9.0/4+1.0/2)*res) { //clicked play button
					MainValues.mainMenu = false;
					Window.Layer.remove(Window.menuPanel);
					Window.Layer.add(Window.battleMapPanel);
					Window.Layer.add(Window.gameUI, JLayeredPane.MODAL_LAYER);
					Window.frame.removeMouseListener(this);
					Window.gameUI.setLocation(0, 7 * res);
					
					CSVReader fileReader = new CSVReader();
					MainValues.battleMapArray = fileReader.ReadCSVFile("Maps" + File.separator + "NewTestingMap.txt");
					UnitLoader unitArrMaker = new UnitLoader();
					try {
						MainValues.battleUnitArray = unitArrMaker.LoadUnits("testMapJson");
					} catch (JSONException ex1) {
						MainValues.battleUnitArray = new unit[][] {new unit[] {new unit(1, 1, 1, 1, 1, 1,"", true)}};
					}
					main.Window.battleMapPanel.setMap(MainValues.battleMapArray, MainValues.battleUnitArray);
					GameUIListener uiListener = new GameUIListener();
					Window.gameUI.addMouseListener(uiListener);
					GameListener myListener = new GameListener();
					Window.battleMapPanel.addMouseListener(myListener);
					Window.battleMapPanel.addMouseMotionListener(myListener);
					
				} else if(mY > (9.0*5.0/12-1.0/2)*res && mY < (9.0*5.0/12+1.0/2)*res){ //Map editor
					MainValues.mainMenu = false;
					Window.frame.removeMouseListener(this);
					
					MainValues.battleMapArray = new LinkedList<List<String>>();
					List<String> tempList = new LinkedList<String>();
					tempList.add("0");
					MainValues.battleMapArray.add(tempList);
			
					Window.Layer.add(Window.battleMapPanel);					
					Window.battleMapPanel.addMouseListener(mapListener);
					Window.battleMapPanel.addMouseMotionListener(mapListener);
					MainValues.battleUnitArray = new unit[][] {new unit[1]};
					main.Window.battleMapPanel.setMap(MainValues.battleMapArray, MainValues.battleUnitArray);
					
					Window.mapEditorUI.setLocation(0, 8 * res);
					Window.Layer.add(Window.mapEditorUI, JLayeredPane.MODAL_LAYER);
					MapEditorUIListener uiListerner = new MapEditorUIListener();
					Window.mapEditorUI.addMouseListener(uiListerner);

					Window.Layer.remove(Window.menuPanel);
				} else if(mY > (9.0*7.0/12-1.0/2)*res && mY < (9.0*7.0/12+1.0/2)*res) { //clicked Options 
					MainValues.mainMenu = false;
					MainValues.optionsMenu = true;
					Window.Layer.remove(Window.menuPanel);
					Window.Layer.add(Window.optionsPanel);
				} else if(mY > (9.0*3.0/4-1.0/2)*res && mY < ((9.0*3.0/4)+(1.0/2))*res) { //exit
					System.exit(0);
				}
			}
		} else if (MainValues.optionsMenu == true) {
			if (mX >= (int) Math.round((16.0/2-2.5/2)*res) && mX <= (int) Math.round((16.0/2+2.5/2)*res)) { //check if in right column
				if (mY >= (int) Math.round((9.0*7.0/12-1.0/2)*res) && mY <= (int) Math.round((9.0*7.0/12+1.0/2)*res)) {
					MainValues.optionsMenu = false;
					MainValues.mainMenu = true;
					Window.Layer.remove(Window.optionsPanel);
					Window.Layer.add(Window.menuPanel);
				}
			} else if (mY >= Math.round((9.0*5.0/12-1.0/2)*res) && mY <= Math.round((9.0*5.0/12+1.0/2)*res)) {
				if (mX >= (int) Math.round((16.0/2+2.5/2)*res) && mX <= (int) Math.round((16.0/2+4.5/2)*res)) {
					CSVReader reconfig = new CSVReader();
					List<List<String>> configList = reconfig.ReadCSVFile("configCSV.txt");
					configList.get(0).set(0, Integer.toString(MainValues.tempRes += 5));
					reconfig.WriteCSVFile(configList, "configCSV.txt");
				} else if (mX >= (int) Math.round((16.0/2-4.5/2)*res) && mX <= (int) Math.round((16.0/2-2.5/2)*res)) {
					if (MainValues.tempRes >= 20) {
						CSVReader reconfig = new CSVReader();
						List<List<String>> configList = reconfig.ReadCSVFile("configCSV.txt");
						configList.get(0).set(0, Integer.toString(MainValues.tempRes -= 5));
						reconfig.WriteCSVFile(configList, "configCSV.txt");
					}
				}
			}
		}
	}
	
}