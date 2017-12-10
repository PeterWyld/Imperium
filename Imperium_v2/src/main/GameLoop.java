package main;

import java.util.Timer;
import java.util.TimerTask;

import values.MainValues;

public class GameLoop {
	
	static Timer t = new Timer();
	
	public static void run() {
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Window.frame.repaint();
			}

		}, 0, 1000 / MainValues.fps);
	}
}
