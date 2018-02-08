package units;

import java.util.List;

import values.MainValues;

public class unit {
	protected int xIndex = 0;
	protected int yIndex = 0;
	protected int health = 100;
	protected int attack = 10;
	protected int movement = 4;
	private int unitIconIndex = 0;
	protected String unitName = "";
	protected boolean playersUnit = true;
	protected int moveIndex = 0;
	protected int movementUsed = 0;
	
	public unit(int inXIndex, int inYIndex, int inHealth, int inAttack,
			int inMovement, int inUnitIconIndex, String newUnitName, boolean inPlayersUnit) {
		xIndex = inXIndex;
		yIndex = inYIndex;
		health = inHealth;
		attack = inAttack;
		movement = inMovement;
		unitIconIndex = inUnitIconIndex;
		unitName = newUnitName;
		playersUnit = inPlayersUnit;
	}
	
	public void move(int newY, int newX) {
		MainValues.battleUnitArray[newY][newX] = this;
		MainValues.battleUnitArray[yIndex][xIndex] = null;		
		xIndex = newX;
		yIndex = newY;
	}
	
	public void movePath(List<int[]> path) {
		moveIndex = 0;
		while (movementUsed <= movement -1 && moveIndex <= path.size() -1) { //movement has 1 subtracted because moveIndex is a array index (which starts at 0)
			if (MainValues.battleUnitArray[path.get(moveIndex)[0]][path.get(moveIndex)[1]] == null) {
				move(path.get(moveIndex)[0],path.get(moveIndex)[1]);
				movementUsed += 1;
				moveIndex += 1;
			} else if (MainValues.battleUnitArray[path.get(moveIndex)[0]][path.get(moveIndex)[1]].isPlayersUnit() != playersUnit) { // check if target and this unit are on different teams
				attack(path.get(moveIndex)[0],path.get(moveIndex)[1]);
				moveIndex = movement; //exits loop
			} else {
				moveIndex = movement; //exits loop
			}
		}
		//movement -= moveIndex;
	}
	
	public void attack(int targetY, int targetX) {
		MainValues.battleUnitArray[targetY][targetX].takeDamage(attack);
	}
	
	public void takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			MainValues.battleUnitArray[yIndex][xIndex] = null;
		}
	}
	
	public int getUnitImgIndex() {
		return unitIconIndex;
	}
	
	public int[] getCoordinates() {
		return new int[] {yIndex, xIndex};
	}
	
	public int getYIndex() {
		return yIndex;
	}
	
	public int getXIndex() {
		return xIndex;
	}
	
	public int getMovement() {
		return movement;
	}
	
	public boolean isPlayersUnit() {
		return playersUnit;
	}
	
	public void turnOver() {
		moveIndex = 0;
	}
	
	public int getRemainingMovement() {
		return movement - movementUsed;
	}
	
}
