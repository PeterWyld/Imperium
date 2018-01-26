package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Window;
import values.MainValues;

public class GameUIListener implements MouseListener{
	int mX = 0;
	int mY = 0;
	int res = MainValues.resolution;

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
	public void mouseReleased(MouseEvent arg0) {
		mX = arg0.getX();
		mY = arg0.getY();
		
		if (mY >= res * (6.0/5) && mY <= res * (17.0/10)) {
			if (mX >= (12.5 * res) && mX <= (13.5 * res)) {
				Window.manager.endPlayerTurn();
			}
		}
		
	}

}
