package main;

import units.unit;
import values.MainValues;

public class BattleManager {
	private boolean playerTurn = true;
	private unit selection = null;
	
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	
	public void endPlayerTurn() {
		playerTurn = false;
		for(int y = 0; y <= MainValues.battleMapArray.size() -1; y++) {
			for(int x = 0; x <= MainValues.battleMapArray.get(0).size() -1; x++) {
				selection = MainValues.battleUnitArray[y][x];
				if (selection != null) {
					selection.turnOver();
				}
			}
		}
		Window.theAi.AiTurn();
	}
	
	public void endAITurn() {
		playerTurn = true;
	}
}
