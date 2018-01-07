package units;

import java.util.List;

import values.MainValues;

public class unit {
	private int xIndex = 0;
	private int yIndex = 0;
	private int health = 100;
	private int attack = 10;
	private int movement = 4;
	private int unitIconIndex = 0;
	private String unitName = "";
	
	public unit(int inXIndex, int inYIndex, int inHealth, int inAttack,
			int inMovement, int inUnitIconIndex, String newUnitName) {
		xIndex = inXIndex;
		yIndex = inYIndex;
		health = inHealth;
		attack = inAttack;
		movement = inMovement;
		unitIconIndex = inUnitIconIndex;
		unitName = newUnitName;
	}
	
	public void move(int newY, int newX) {
		MainValues.battleUnitArray[newY][newX] = this;
		MainValues.battleUnitArray[yIndex][xIndex] = null;		
		xIndex = newX;
		yIndex = newY;
	}
	
	public void movePath(List<int[]> path) {
		int moveIndex = 1; //starts at one as index 0 is simply where the unit already is
		while (moveIndex <= movement + 1 && moveIndex <= path.size() -1) {
			if (MainValues.battleUnitArray[path.get(moveIndex)[0]][path.get(moveIndex)[1]] == null) {
				move(path.get(moveIndex)[0],path.get(moveIndex)[1]);
				moveIndex += 1;
			} else {
				attack(path.get(moveIndex)[0],path.get(moveIndex)[1]);
				moveIndex = movement + 1; //exits loop
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
}
