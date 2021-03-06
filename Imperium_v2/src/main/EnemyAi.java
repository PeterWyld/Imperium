package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import units.unit;
import values.MainValues;

public class EnemyAi {
	private unit selection = null;
	private int[] unitXY = {0, 0};
	private int rNumb1 = 0;
	private boolean rNumb2 = false;
	private Random generator = new Random();
	private List<int[]> path = new LinkedList<int[]>();
	
	public void AiTurn() {
		for(int y = 0; y <= MainValues.battleMapArray.size() -1; y++) {
			for(int x = 0; x <= MainValues.battleMapArray.get(0).size() -1; x++) {
				selection = MainValues.battleUnitArray[y][x];
				if (selection != null) {
					if (selection.isPlayersUnit() ==  false) {
						unitXY = selection.getCoordinates();
						for(int i = 0; i <= selection.getMovement() - 1; i++) {
							rNumb1 = generator.nextInt(2);
							rNumb2 = generator.nextBoolean();
							if (rNumb2) {
								unitXY[rNumb1] = unitXY[rNumb1] - 1;
							} else {
								unitXY[rNumb1] = unitXY[rNumb1] + 1;
							}
							if (unitXY[0] >= 0 && unitXY[0] <= MainValues.battleMapArray.size() -1) {
								if (unitXY[1] >= 0 && unitXY[1] <= MainValues.battleMapArray.get(0).size() -1) {
									path.add((new int[] {unitXY[0], unitXY[1]}));
								}
							}
						}
						selection.movePath(path);
						path.clear();
					}
				}
			}
		}
		Window.manager.endAITurn();
	}
}
