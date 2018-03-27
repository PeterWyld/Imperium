package main;

import java.util.List;

import units.unit;
import values.MainValues;

public class BattleManager {
	private boolean playerTurn = true;
	private unit selection = null;
	private int action = 0;
	private unit uiSelection = null;
	
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	
	public void endPlayerTurn() {
		playerTurn = false;
		uiSelection = null;
		action = 0;
		main.Window.battleMapPanel.clearHighlights();
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
	
	public void printPath(List<int[]> path) {
		for(int i = 0; i <= path.size() -1; i++) {
			System.out.print(path.get(i)[0]);
			System.out.println(", " + path.get(i)[1]);
		}
	}
	
	public void setAction(int newAction) {
		// 0 =  nothing, 1 = charge, 2 = ranged Attack
		action = newAction;
	}
	
	public int getAction() {
		return action;
	}
	
	public void setSelection(unit newSelection) {
		selection = newSelection;
	}
	
	public unit getSelection() {
		return selection;
	}
}
