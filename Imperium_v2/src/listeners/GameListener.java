package listeners;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import units.unit;
import values.MainValues;

public class GameListener extends MouseInputAdapter {
	int previousXVal = 0;
	int previousYVal = 0;
	int mX = 0;
	int mY = 0;
	int pressedX = 0;
	int pressedY = 0;
	unit selection = null;
	
	@Override
    public void mousePressed(MouseEvent e) {
		mX = e.getX()-6;
		mY = e.getY()-25;

		if (SwingUtilities.isLeftMouseButton(e)) {
			pressedX = mX + MainValues.globalX;
			pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
			pressedY = mY + MainValues.globalY;
			pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
			if (pressedX > 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1
					&& pressedY > 0 && pressedY <= MainValues.battleMapArray.size() -1) {
				if (selection == null) {
					selection = MainValues.battleUnitArray[pressedY][pressedX];
				} else {
					selection.move(pressedX, pressedY);
					selection = null;
				}
			}
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	    	previousXVal = mX;
	    	previousYVal = mY;
		}
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
		mX = e.getX()-6;
		mY = e.getY()-25;
		if (SwingUtilities.isLeftMouseButton(e)) {
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	        MainValues.globalX -= (mX - previousXVal);
	        MainValues.globalY -= (mY - previousYVal);
	        previousXVal = mX;
	        previousYVal = mY;
		}
    }
}
