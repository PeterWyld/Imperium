package units;

import values.MainValues;

public class unit {
	int xIndex = 0;
	int yIndex = 0;
	int health = 100;
	int attack = 10;
	int movement = 4;
	int unitIconIndex = 0;
	public unit(int inXIndex, int inYIndex, int inHealth, int inAttack,
			int inMovement, int inUnitIconIndex) {
		xIndex = inXIndex;
		yIndex = inYIndex;
		health = inHealth;
		attack = inAttack;
		movement = inMovement;
	}
	public void move(int newX, int newY) {
		xIndex = newX;
		yIndex = newY;
	}
	public void attack(int targetX, int targetY) {
		MainValues.unitArray.get(targetY).get(targetX);
	}
	public void takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			MainValues.unitArray.get(yIndex).remove(xIndex);
		}
	}
}
