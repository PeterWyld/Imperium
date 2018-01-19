package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JLayeredPane;

import org.json.JSONException;

import main.Window;
import units.unit;
import utilities.CSVReader;
import utilities.JsonParser;
import utilities.UnitLoader;
import values.MainValues;

public class MenuListener implements MouseListener {
	int mX = 0;
	int mY = 0;

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
			if(mX > (16/2-2/2)*MainValues.resolution && mX < (16/2+2/2)*MainValues.resolution &&
				mY > (9.0/2-1.0/2)*MainValues.resolution && mY < (9.0/2+1.0/2)*MainValues.resolution){ //check if they clicked the button
				MainValues.startMenu = false;
				MainValues.mainMenu = true;
				Window.Layer.remove(Window.startPanel);
				Window.Layer.add(Window.menuPanel);
			}
		} else if (MainValues.mainMenu == true) {
			if (mX > (16/2-2.5/2)*MainValues.resolution && mX < (16/2+2.5/2)*MainValues.resolution) { //check if in right row
				if (mY > (9.0/4-1.0/2)*MainValues.resolution && mY < (9.0/4+1.0/2)*MainValues.resolution) { //clicked play button
					MainValues.mainMenu = false;
					Window.Layer.remove(Window.menuPanel);
					Window.Layer.add(Window.battleMapPanel);
					Window.frame.removeMouseListener(this);
					
					CSVReader fileReader = new CSVReader();
					MainValues.battleMapArray = fileReader.ReadCSVFile("Maps" + File.separator + "Peter's Map.txt");
					UnitLoader unitArrMaker = new UnitLoader();
					try {
						MainValues.battleUnitArray = unitArrMaker.LoadUnits("testMapJson");
					} catch (JSONException ex1) {
						MainValues.battleUnitArray = new unit[][] {new unit[] {new unit(1, 1, 1, 1, 1, 1,"", true)}};
					}
					main.Window.battleMapPanel.setMap(MainValues.battleMapArray, MainValues.battleUnitArray);
					Window.frame.addMouseWheelListener(new ScrollListener());
					GameListener myListener = new GameListener();
					Window.frame.addMouseListener(myListener);
					Window.frame.addMouseMotionListener(myListener);
					
				} else if(mY > (9.0*5.0/12-1.0/2)*MainValues.resolution && mY < (9.0*5.0/12+1.0/2)*MainValues.resolution){ //Map editor
					MainValues.mainMenu = false;
					Window.frame.removeMouseListener(this);
					Window.frame.addMouseWheelListener(new ScrollListener());
					
					CSVReader fileReader = new CSVReader();
					MainValues.battleMapArray = fileReader.ReadCSVFile("Maps" + File.separator + "ANewMap.txt");
					Window.Layer.add(Window.battleMapPanel);					
					MapEditorListener myListener = new MapEditorListener();
					Window.battleMapPanel.addMouseListener(myListener);
					Window.battleMapPanel.addMouseMotionListener(myListener);
					MainValues.battleUnitArray = new unit[][] {new unit[1]};
					main.Window.battleMapPanel.setMap(MainValues.battleMapArray, MainValues.battleUnitArray);
					
					Window.mapEditorUI.setLocation(0, 8 * MainValues.resolution);
					Window.Layer.add(Window.mapEditorUI, JLayeredPane.MODAL_LAYER);
					MapEditorUIListener uiListerner = new MapEditorUIListener();
					Window.mapEditorUI.addMouseListener(uiListerner);

					Window.Layer.remove(Window.menuPanel);
				} else if(mY > (9.0*7.0/12-1.0/2)*MainValues.resolution && mY < (9.0*7.0/12+1.0/2)*MainValues.resolution) { //clicked Options 
					MainValues.mainMenu = false;
					MainValues.optionsMenu = true;
					Window.Layer.remove(Window.menuPanel);
					Window.Layer.add(Window.optionsPanel);
				} else if(mY > (9.0*3.0/4-1.0/2)*MainValues.resolution && mY < ((9.0*3.0/4)+(1.0/2))*MainValues.resolution) { //exit
					System.exit(0);
				}
			}
		}
	}
	
}