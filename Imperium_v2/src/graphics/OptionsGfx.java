package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import values.MainValues;

public class OptionsGfx extends JPanel {
	private static final long serialVersionUID = 1L;
	File BGImage = new File("res/TwoHeadedBirdFinal.png");
	File PlayBtnDef = new File("res/buttonDefaultPlay.png");
	File BackBtnDef = new File("res/buttonDefaultBack.png");
	File leftArrowButton = new File("res/lftButton.png");
	File rightArrowButton = new File("res/rghtButton.png");
	int res = 0;

	Image bg, playDef, backDef, lftBtn, rghtBtn;

	public void paintComponent(Graphics g) {
		res = MainValues.resolution;
		try {
			bg = ImageIO.read(BGImage);
			playDef = ImageIO.read(PlayBtnDef);
			backDef = ImageIO.read(BackBtnDef);
			lftBtn = ImageIO.read(leftArrowButton);
			rghtBtn = ImageIO.read(rightArrowButton);
		}	catch(Exception e) {
			
		}

			Graphics g2d = (Graphics2D) g;
			
			//	((16/number)-(imgSize/2))*MainValues.resolution
			//	is the equivalent to
			//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
			
			//	e.g. ((16/2)-(3/2))*MainValues.resolution
			//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
			
			g2d.drawImage(bg, 0, 0, MainValues.width, MainValues.height, null);
			g2d.drawImage(playDef, (int) Math.round((16.0/2-2.5/2)*res), (int) Math.round((9.0*5.0/12-1.0/2)*res), (int) Math.round(2.5*res), res, null);
			g2d.drawImage(backDef, (int) Math.round((16.0/2-2.5/2)*res), (int) Math.round((9.0*7.0/12-1.0/2)*res), (int) Math.round(2.5*res), res, null);
			g2d.drawImage(rghtBtn, (int) Math.round((16.0/2+2.5/2)*res), (int) Math.round((9.0*5.0/12-1.0/2)*res), res, res, null);
			g2d.drawImage(lftBtn, (int) Math.round((16.0/2-4.5/2)*res), (int) Math.round((9.0*5.0/12-1.0/2)*res), res, res, null);
	}
}
