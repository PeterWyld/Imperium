package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class saveMapBoxListener implements KeyListener{
	int capital = 1; // lowercase = 0 UPPERCASE = 1

	@Override
	public void keyPressed(KeyEvent e) {
		int charInt = e.getKeyCode();
		char newChar = (char) charInt;
		if(charInt >= 32 && charInt <= 126) {
			if(!(charInt >= 37 && charInt <= 40)) {
				if(charInt >= 65 && charInt <= 90) {
					newChar = ((char) (charInt  + capital * 32));
					main.Window.mapEditorUI.addChar(newChar);
				} else {
					newChar = (char) charInt;
					main.Window.mapEditorUI.addChar(e.getKeyChar());
				}
			}
		} else if (charInt == 8) {
			main.Window.mapEditorUI.backspaceTyped();
		} else if (charInt == 222) {
			main.Window.mapEditorUI.addChar(e.getKeyChar());
		} else if (charInt == e.VK_SHIFT) {
			capital = 0;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			capital = 1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

}
