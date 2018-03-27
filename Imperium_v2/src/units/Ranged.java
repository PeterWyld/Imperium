package units;

import values.MainValues;

public class Ranged extends unit{
	private int range = 0;
	public Ranged(int inXIndex, int inYIndex, int inHealth, int inAttack, int inMovement, int inUnitIconIndex,
			String newUnitName, boolean inPlayersUnit, int inRange) {
		super(inXIndex, inYIndex, inHealth, inAttack, inMovement, inUnitIconIndex, newUnitName, inPlayersUnit);
		range = inRange; //name of variable is refering to the input of range
	}
	public void fire(int targetX, int targetY) {
		if (Math.round((Math.hypot((xIndex - targetX), (yIndex - targetY)))) <= range) {
			if (movement > movementUsed && MainValues.battleUnitArray[targetY][targetX] != null
					&& MainValues.battleUnitArray[targetY][targetX].isPlayersUnit() == false) {
				MainValues.battleUnitArray[targetY][targetX].takeDamage(attack);
				movementUsed += 1;
			}
		}
	}
	
	public int getRange() {
		return range;
	}

}
