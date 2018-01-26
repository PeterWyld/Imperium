package main;

import java.util.Timer;
import java.util.TimerTask;

import values.MainValues;

public class GameLoop {
	
	static Timer t = new Timer();
	static int index = 0;
	
	public static void run() {
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Window.frame.repaint();
				MainValues.titleTimerIndex += 1;
				if (MainValues.titleTimerIndex > 200) {
					MainValues.titleTimerIndex = 0;
				}
			}

		}, 0, 1000 / MainValues.fps);
	}
}
