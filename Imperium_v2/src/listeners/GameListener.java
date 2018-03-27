package listeners;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
	List<int[]> path = new ArrayList<int[]>();
	int[] coordinates;
	boolean pathValid = true;
	boolean attackedUnit = false;
	int action = 0;
	
	
	@Override
    public void mousePressed(MouseEvent e) {
		mX = e.getX();
		mY = e.getY();

		if (SwingUtilities.isLeftMouseButton(e)) {
			pressedX = mX + MainValues.globalX;
			pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
			pressedY = mY + MainValues.globalY;
			pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
			if (pressedX >= 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1
					&& pressedY >= 0 && pressedY <= MainValues.battleMapArray.size() -1) { // check if on map
				if(main.Window.manager.getAction() == 0) {
					if (MainValues.battleUnitArray[pressedY][pressedX] != null) {
						if (MainValues.battleUnitArray[pressedY][pressedX].isPlayersUnit() == true) {
							setUnitUISelection(MainValues.battleUnitArray[pressedY][pressedX]);
							main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 1);
						} else {
							main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 2);
						}
					}
				} else if (main.Window.manager.getAction() == 1) {
					if (!(pressedX == main.Window.manager.getSelection().getXIndex() &&
							pressedY == main.Window.manager.getSelection().getYIndex())) {
						if (pressedY == main.Window.manager.getSelection().getYIndex()) {
							if (pressedX >  main.Window.manager.getSelection().getXIndex()) {
								((units.Cavalry) main.Window.manager.getSelection()).charge(1, 1);
							} else {
								((units.Cavalry) main.Window.manager.getSelection()).charge(1, -1);
							}
						} else if (pressedX == main.Window.manager.getSelection().getXIndex()) {
							if (pressedY >  main.Window.manager.getSelection().getYIndex()) {
								((units.Cavalry) main.Window.manager.getSelection()).charge(0, 1);
							} else {
								((units.Cavalry) main.Window.manager.getSelection()).charge(0, -1);
							}
						}
					}
					main.Window.manager.setAction(0);
				} else if (main.Window.manager.getAction() == 2) {
					((units.Ranged) main.Window.manager.getSelection()).fire(pressedX, pressedY);
					main.Window.manager.setAction(0);
				} else {
					main.Window.manager.setAction(0);
				}
			}
			previousPressedX = pressedX;
			previousPressedY = pressedY;
			
		} else if (SwingUtilities.isRightMouseButton(e)) {
	    	previousXVal = mX;
	    	previousYVal = mY;
		}
    }
	
	@Override
    public void mouseDragged(MouseEvent e) {
		mX = e.getX();
		mY = e.getY();
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (main.Window.manager.getPlayerTurn()) {
				pressedX = mX + MainValues.globalX;
				pressedX = (int) Math.ceil(pressedX/(16.0*MainValues.globalZoom)) -1;
				pressedY = mY + MainValues.globalY;
				pressedY = (int) Math.ceil(pressedY/(16.0*MainValues.globalZoom)) -1;
				if (selection != null) {
					if (pressedX != previousPressedX || pressedY != previousPressedY) {
						previousPressedX = pressedX;
						previousPressedY = pressedY;
						if (pressedX >= 0 && pressedX <= MainValues.battleMapArray.get(0).size() -1
								&& pressedY >= 0 && pressedY <= MainValues.battleMapArray.size() -1) { //check if inside map bounds
							if (path.size() -1 >= 0 && pressedY == selection.getCoordinates()[0] && pressedX== selection.getCoordinates()[1]) {// see if has returned to start pos
								path.clear();
								main.Window.battleMapPanel.clearHighlights();
								main.Window.battleMapPanel.addTileHighlight(selection.getCoordinates()[0], selection.getCoordinates()[1], 1);
							} else if (pathValid) {
								coordinates = new int[] {pressedY, pressedX};
								path.add(coordinates);
								if (MainValues.battleUnitArray[pressedY][pressedX] == null) {
									main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 1);
								} else if (MainValues.battleUnitArray[pressedY][pressedX].isPlayersUnit() == false) {
									main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 2);
								} else {
									main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 4);
								}
								if (path.size() - 3 >= 0) {
									if (path.get(path.size() - 3)[0] == coordinates[0] && path.get(path.size() - 3)[1] == coordinates[1]) { //check if the same as tile previously selected
										path.remove(path.size() - 1);//removes last two items
										main.Window.battleMapPanel.addTileHighlight(path.get(path.size() -1)[0], path.get(path.size() -1)[1], 0);
										path.remove(path.size() - 1);
										
										/* this means that if the user hovers over tiles 1,2,3,2 (in that order
										 	then the path will be amended to 1,2. However if they hover over 1,2,3,4,2 then the
										 	path will not be amended*/
									}
								}
								if (path.size() > selection.getMovement()) {
									main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 3);
								}
							} else {
								main.Window.battleMapPanel.addTileHighlight(pressedY, pressedX, 3);
							}
						} else {
							pathValid = false;
						}
					}
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
		selection = null;
		path.clear();
		pathValid = true;
		main.Window.battleMapPanel.clearHighlights();
	}
	
	public void setUnitUISelection(unit newSelection) {
		selection = newSelection;
		main.Window.manager.setSelection(newSelection);
	}
	
}
