package listeners;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import values.MainValues;

public class GameListener extends MouseInputAdapter {
	int previousXVal = 0;
	int previousYVal = 0;
	
	@Override
    public void mousePressed(MouseEvent e) {
		int mX = e.getX()-6;
		int mY = e.getY()-25;
		if (SwingUtilities.isLeftMouseButton(e)) {
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	    	previousXVal = mX;
	    	previousYVal = mY;
		}
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
		int mX = e.getX()-6;
		int mY = e.getY()-25;
		if (SwingUtilities.isLeftMouseButton(e)) {
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	        MainValues.globalX -= (mX - previousXVal);
	        MainValues.globalY -= (mY - previousYVal);
	        previousXVal = mX;
	        previousYVal = mY;
		}
    }
}
