package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import values.MainValues;

public class MapEditorUIListener implements MouseListener{

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
		if(mY >= MainValues.resolution/5 && mY <= MainValues.resolution/5 + MainValues.resolution/2) {
			if(mX >= MainValues.resolution && mX <= 3 * MainValues.resolution/2) {
				//auto
			} else if (mX >= 2 * MainValues.resolution && mX <= 10 * MainValues.resolution + MainValues.resolution/2){
				int pressedX = (int) Math.ceil(((mX * 2)/MainValues.resolution) - 4);
				if((pressedX/2.0) % 1 == 0) {
					pressedX = (int) Math.floor(pressedX/2.0);
					int cycle = main.Window.mapEditorUI.getCycle();
					int newTileType = 9 * cycle + pressedX;
					listeners.MapEditorListener.setTileType(newTileType);
				}			
				
			}
		}
		
	}

}
