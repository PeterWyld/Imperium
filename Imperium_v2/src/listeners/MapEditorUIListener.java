package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import values.MainValues;

public class MapEditorUIListener implements MouseListener{
	int res = MainValues.resolution;
	boolean savingMap = false;

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
			if (savingMap == false) {
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
				}
			}
		}
		
	}

}
