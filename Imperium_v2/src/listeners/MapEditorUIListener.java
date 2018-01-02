package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JLayeredPane;

import main.Window;
import utilities.CSVReader;
import values.MainValues;

public class MapEditorUIListener implements MouseListener{
	int res = MainValues.resolution;
	boolean savingMap = false;
	int uiStatus = 0; // 0 = default , 1 = saving, 2 = loading 
	saveMapBoxListener saveKeyListener = new saveMapBoxListener();

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
		int mX = e.getX();
		int mY = e.getY();
		if(mY >= res/5 && mY <= res/5 + res/2) {
			if (uiStatus == 0) {
				if(mX >= res && mX <= 3 * res/2) {
					main.Window.mapEditorUI.lftBtnClick();
				} else if (mX >= res && mX <= 6 * res){
					int pressedX = (int) Math.ceil(((mX * 2)/res) - 3);
					int cycle = main.Window.mapEditorUI.getCycle();
					int newTileType = cycle + pressedX;
					listeners.MapEditorListener.setTileType(newTileType);		
				} else if (mX >= 6 * res && mX <= 6 * res + res/2) {
					main.Window.mapEditorUI.rghtBtnClick();
				} else if (mX >= 7* res && mX <= 8 * res) {
					main.Window.mapEditorUI.setSavingStatus(true);
					uiStatus = 1;
					main.Window.frame.addKeyListener(saveKeyListener);
				} else if (mX >= 8.5 * res && mX <= 9.5 * res) {
					uiStatus = 2;
					main.Window.mapEditorUI.setSavingStatus(true);
				} else if (mX >= 10 * res && mX <= 11 * res) { // return to main menu
					MainValues.mainMenu = true;
					Window.frame.addMouseListener(new MenuListener());
					
					Window.frame.removeMouseListener(this);
					Window.frame.removeMouseWheelListener(new ScrollListener());
			
					Window.battleMapPanel.removeAll();
					Window.Layer.remove(Window.battleMapPanel);
					
					Window.mapEditorUI.removeAll();
					Window.Layer.remove(Window.mapEditorUI);
					
					Window.Layer.add(Window.menuPanel);
				}
			} else if (uiStatus == 1) {
				if (mX >= 7* res && mX <= 8 * res) {
					String mapName = main.Window.mapEditorUI.getMapName();
					CSVReader writer = new CSVReader();
					writer.WriteCSVFile(MainValues.battleMapArray, "Maps" + File.separator + mapName + ".txt");
				} else if (mX >= 8.5 * res && mX <= 9.5 * res) {
					main.Window.mapEditorUI.setSavingStatus(false);
					uiStatus = 0;
					main.Window.frame.removeKeyListener(saveKeyListener);
				}
			}
		}
	}
}
