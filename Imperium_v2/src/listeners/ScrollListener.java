package listeners;

import java.awt.event.ComponentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import main.Window;
import values.MainValues;

public class ScrollListener implements MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches =  -(e.getWheelRotation());
		MainValues.globalZoom += notches * 0.25;
		if (MainValues.globalZoom < 0.25) {
			MainValues.globalZoom = 0.25;
		}
	}
}
