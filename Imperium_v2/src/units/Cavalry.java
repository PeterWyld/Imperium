package units;

import values.MainValues;

public class Cavalry extends unit{
	public Cavalry(int inXIndex, int inYIndex, int inHealth, int inAttack, int inMovement, int inUnitIconIndex,
			String newUnitName, boolean inPlayersUnit) {
		super(inXIndex, inYIndex, inHealth, inAttack, inMovement, inUnitIconIndex, newUnitName, inPlayersUnit);
		// TODO Auto-generated constructor stub
	}
	
	public void charge(int xOrY, int direction) {
		//xOrY: 0 = y, 1 = x
		//direction: -1 = up/left, 1 = down/right
		if (xOrY == 0) {
			for (int i = 0; i <= movement && movementUsed <= movement -1; i++) {
				if (yIndex + direction >= 0 && yIndex + direction <= MainValues.battleMapArray.size() - 1) {
					if (MainValues.battleUnitArray[yIndex + direction][xIndex] == null) {
						move(yIndex + direction, xIndex);
					} else if (MainValues.battleUnitArray[yIndex + direction][xIndex].isPlayersUnit()) {
						movementUsed = movement;
					} else {
						MainValues.battleUnitArray[yIndex + direction][xIndex].takeDamage(50);
					}
				}
				movementUsed += 1;
			}
		} else {
			for (int i = 0; i <= movement && movementUsed <= movement -1; i++) {
				if (xIndex + direction >= 0 && xIndex + direction <= MainValues.battleMapArray.get(0).size() - 1) {
					if (MainValues.battleUnitArray[yIndex][xIndex + direction] == null) {
						move(yIndex, xIndex + direction);
					} else if (MainValues.battleUnitArray[yIndex][xIndex + direction].isPlayersUnit()) {
						movementUsed = movement;
					} else {
						MainValues.battleUnitArray[yIndex][xIndex + direction].takeDamage(50);
					}
				}
				movementUsed += 1;
			}
		}
		
		movementUsed = movement;
	}

}
