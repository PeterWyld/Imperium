package units;

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
			int inMovement, int inUnitIconIndex) {
		xIndex = inXIndex;
		yIndex = inYIndex;
		health = inHealth;
		attack = inAttack;
		movement = inMovement;
		unitIconIndex = inUnitIconIndex;
	}
	public void move(int newX, int newY) {
		MainValues.battleUnitArray[newY][newX] = this;
		MainValues.battleUnitArray[yIndex][xIndex] = null;		
		xIndex = newX;
		yIndex = newY;
	}
	public void attack(int targetX, int targetY) {
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
