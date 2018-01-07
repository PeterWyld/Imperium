package listeners;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

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
	int previousPressedX = -1;
	int previousPressedY = -1;
	List<int[]> path = new LinkedList<int[]>();
	int[] coordinates;
	boolean pathValid = true;
	
	@Override
    public void mousePressed(MouseEvent e) {
		mX = e.getX()-6;
		mY = e.getY()-25;

		if (SwingUtilities.isLeftMouseButton(e)) {
			pressedX = mX + MainValues.globalX;
			pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
			pressedY = mY + MainValues.globalY;
			pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
			if (pressedX >= 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1
					&& pressedY >= 0 && pressedY <= MainValues.battleMapArray.size() -1) {
				selection = MainValues.battleUnitArray[pressedY][pressedX];
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
			pressedX = mX + MainValues.globalX;
			pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
			pressedY = mY + MainValues.globalY;
			pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
			if (pressedX != previousPressedX || pressedY != previousPressedY) {
				previousPressedX = pressedX;
				previousPressedY = pressedY;
				if (pressedX >= 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1
						&& pressedY >= 0 && pressedY <= MainValues.battleMapArray.size() -1) {
					if (selection != null && pathValid) {
						coordinates = new int[] {pressedY, pressedX};
						path.add(coordinates);
						if (path.size() - 3 >= 0) {
							if (path.get(path.size() - 3).equals(coordinates)) { //check if the same as tile previously selected
								path.remove(path.size() - 1);//removes last two items
								path.remove(path.size() - 2);
								/* this means that if the user hovers over tiles 1,2,3,2 (in that order
								 	then the path will be amended to 1,2. However if they hover over 1,2,3,4,2 then the
								 	path will not be amended*/
							}
						}
					} 
				} else {
					pathValid = false;
				}
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
	        MainValues.globalX -= (mX - previousXVal);
	        MainValues.globalY -= (mY - previousYVal);
	        previousXVal = mX;
	        previousYVal = mY;
		}
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (path != null && !path.isEmpty() && selection != null) {
			selection.movePath(path);
		}
		path.clear();
		pathValid = true;
	}
}
