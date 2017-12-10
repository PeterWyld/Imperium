package listeners;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import values.MainValues;

public class ScrollListener implements MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches =  -(e.getWheelRotation());
		MainValues.globalZoom += notches;
		if (MainValues.globalZoom < 1) {
			MainValues.globalZoom = 1;
		}
	}
}
