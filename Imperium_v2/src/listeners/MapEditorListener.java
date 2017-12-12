package listeners;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import values.MainValues;

public class MapEditorListener extends MouseInputAdapter{
	int previousXVal = 0;
	int previousYVal = 0;
	static String tileType = "1";
	
	public static void setTileType(int newTileType) {
		tileType = Integer.toString(newTileType);
	}	
	
	@Override
    public void mousePressed(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		int loopTimes = 0;
		if (SwingUtilities.isLeftMouseButton(e)) {
			int pressedX = mX + MainValues.globalX;
			pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
			int pressedY = mY + MainValues.globalY;
			pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
			loopTimes = MainValues.battleMapArray.get(0).size();
			
			if (pressedX < 0) {
				MainValues.globalX += 16*MainValues.globalZoom*(- pressedX);
				for (int i = 0; i <= MainValues.battleMapArray.size() -1; i++) { //iterates over rows
					for (int j = 0; j <= -(pressedX) -1; j++) {
						MainValues.battleMapArray.get(i).add(0, "0");
					}
				}
			} else {
				for (int i = 0; i <= MainValues.battleMapArray.size() -1; i++) {
					for (int j = loopTimes; j <= pressedX; j++) {
						MainValues.battleMapArray.get(i).add("0"); 
					}
				}
			}
			

			List<String> newXMapLine = new LinkedList<String>(); // creating a row of snowy mountains to be added onto list
			for (int i = 0; i <= MainValues.battleMapArray.get(0).size() - 1; i++) {
				newXMapLine.add("0");
			}
			
			loopTimes = (pressedY - MainValues.battleMapArray.size());
			for (int i = 0; i <= loopTimes; i++) {	//pressedY is positive
				MainValues.battleMapArray.add(new LinkedList<String>(newXMapLine));
			}
			for (int i = 0; i <= -(pressedY) -1; i++) { //pressedY is negative	
				MainValues.battleMapArray.add(0, new LinkedList<String>(newXMapLine));
				MainValues.globalY += 16*MainValues.globalZoom;
			}
			
			if (pressedX < 0) { //if pressedX was outside of the battlemap
				pressedX = 0;
			}
			
			if (pressedY < 0) {
				pressedY = 0;
			}
			
			MainValues.battleMapArray.get(pressedY).set(pressedX, tileType);
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	    	previousXVal = mX;
	    	previousYVal = mY;
	
		}
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
		int mX = e.getX();
		int mY = e.getY();
		int pressedX = mX + MainValues.globalX;
		pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
		int pressedY = mY + MainValues.globalY;
		pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (pressedY >= 0 && pressedY <= MainValues.battleMapArray.size() -1 && pressedX >= 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1) {
				MainValues.battleMapArray.get(pressedY).set(pressedX, tileType);
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
	        MainValues.globalX -= (mX - previousXVal);
	        MainValues.globalY -= (mY - previousYVal);
	        previousXVal = mX;
	        previousYVal = mY;
		}
    }

}
