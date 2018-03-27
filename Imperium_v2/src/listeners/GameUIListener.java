package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Window;
import units.Cavalry;
import units.Ranged;
import units.unit;
import values.MainValues;

public class GameUIListener implements MouseListener{
	int mX = 0;
	int mY = 0;
	int res = MainValues.resolution;
	unit selection = null;
	int action = 0;
	int loopTimes = 0;
	int tempCoordinate = 0;

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
		selection = main.Window.manager.getSelection();
		

		if (mY >= res * (6.0/5) && mY <= res * (17.0/10)) {
			if (mX >= (12.5 * res) && mX <= (13.5 * res)) {
				Window.manager.endPlayerTurn();
			}
		}
		if (selection == null) {
		
		} else if (selection instanceof units.Cavalry){
			if (mY >= res * 0.1 && mY <= res * 1.1) {
				if (mX >= (4 * res) && mX <= (5 * res)) {
					main.Window.manager.setAction(1);
					
					int i = selection.getYIndex() - selection.getRemainingMovement();
					if (i < 0) {
						i = 0;
					}					
					if (selection.getYIndex() + selection.getRemainingMovement() > MainValues.battleMapArray.size() -1) {
						loopTimes = MainValues.battleMapArray.size() -1;
					} else {
						loopTimes = selection.getYIndex() + selection.getRemainingMovement();
					}
					
					tempCoordinate = selection.getXIndex();
					for(;i <= loopTimes; i++ ) {
						main.Window.battleMapPanel.addTileHighlight(i, tempCoordinate, 1);
					}
					
					i = selection.getXIndex() - selection.getRemainingMovement();
					if (i < 0) {
						i = 0;
					}					
					if (selection.getXIndex() + selection.getRemainingMovement() > MainValues.battleMapArray.get(0).size() -1) {
						loopTimes = MainValues.battleMapArray.get(0).size() -1;
					} else {
						loopTimes = selection.getXIndex() + selection.getRemainingMovement();
					}
					
					tempCoordinate = selection.getYIndex();
					for(;i <= loopTimes; i++ ) {
						main.Window.battleMapPanel.addTileHighlight(tempCoordinate, i, 1);
					}
					
					Window.manager.setAction(1);
				}
			}
		} else if (selection instanceof units.Ranged) {
			if (mY >= res * 0.1 && mY <= res * 1.1) {
				if (mX >= (4 * res) && mX <= (5 * res)) {
					main.Window.manager.setAction(2);
					for (int i = 0; i <= MainValues.battleMapArray.size()-1; i++) {
						for (int j = 0; j <= MainValues.battleMapArray.get(0).size() -1;j++) {
							if (Math.round(Math.hypot((selection.getXIndex() - j), (selection.getYIndex() - i))) <= ((Ranged) selection).getRange()) {
								if (MainValues.battleUnitArray[i][j] != null) {
									main.Window.battleMapPanel.addTileHighlight(i, j, 2);
								} else {
									main.Window.battleMapPanel.addTileHighlight(i, j, 1);
								}
							}
						}
					}
					Window.manager.setAction(2);
				}
			}
		}
	}

}
