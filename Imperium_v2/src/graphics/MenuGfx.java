package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import values.MainValues;

public class MenuGfx extends JPanel{
	private static final long serialVersionUID = 1L;
	File BGImage = new File("res/TwoHeadedBirdFinal.png");
	File PlayBtnDef = new File("res/buttonDefaultPlay.png");
	File PlayBtnHvr = new File("res/buttonHoverPlay.png");
	File MapEditorBtn = new File("res/buttonDefaultMapEditor.png");
	File OptionsBtnDef = new File("res/buttonDefaultOptions.png");
	File OptionsBtnHvr = new File("res/buttonHoverOptions.png");
	File ExitBtnDef = new File("res/buttonDefaultExit.png");
	File ExitBtnHvr = new File("res/buttonHoverExit.png");
	int res = MainValues.resolution;
	
	Image bg, playDef, playHvr, optDef, optHvr, exitDef, exitHvr, mpEditDef;

	public void paintComponent(Graphics g) {
		try {
			bg = ImageIO.read(BGImage);
			playDef = ImageIO.read(PlayBtnDef);
			playHvr = ImageIO.read(PlayBtnHvr);
			optDef = ImageIO.read(OptionsBtnDef);
			optHvr = ImageIO.read(OptionsBtnHvr);
			exitDef = ImageIO.read(ExitBtnDef);
			exitHvr = ImageIO.read(ExitBtnHvr);
			mpEditDef = ImageIO.read(MapEditorBtn);
		}	catch(Exception e) {
			
		}

			Graphics g2d = (Graphics2D) g;
			
			//	((16/number)-(imgSize/2))*res
			//	is the equivalent to
			//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
			
			//	e.g. ((16/2)-(3/2))*res
			//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
			
			g2d.drawImage(bg, 0, 0, MainValues.width, MainValues.height, null);
			g2d.drawImage(playDef, (int) Math.round((16/2-2.5/2)*res), (int) Math.round((9.0/4-1.0/2)*res), (int) Math.round(2.5*res), 1*res, null);
			g2d.drawImage(mpEditDef, (int) Math.round((16/2-2.5/2)*res), (int) Math.round((9.0*5.0/12-1.0/2)*res), (int) Math.round(2.5*res), 1*res, null);
			g2d.drawImage(optDef, (int) Math.round((16/2-2.5/2)*res), (int) Math.round((9.0*7.0/12-1.0/2)*res), (int) Math.round(2.5*res), 1*res, null);
			g2d.drawImage(exitDef, (int) Math.round((16/2-2.5/2)*res), (int) Math.round((9.0*3.0/4-1.0/2)*res), (int) Math.round(2.5*res), 1*res, null);
	}
}
