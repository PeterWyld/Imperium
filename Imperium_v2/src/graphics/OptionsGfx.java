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

	Image bg, playDef;

	public void paintComponent(Graphics g) {
		try {
			bg = ImageIO.read(BGImage);
			playDef = ImageIO.read(PlayBtnDef);

		}	catch(Exception e) {
			
		}

			Graphics g2d = (Graphics2D) g;
			
			//	((16/number)-(imgSize/2))*MainValues.resolution
			//	is the equivalent to
			//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
			
			//	e.g. ((16/2)-(3/2))*MainValues.resolution
			//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
			
			g2d.drawImage(bg, 0, 0, MainValues.width, MainValues.height, null);
			//g2d.drawImage(playDef, (int) Math.round((16/4-3.0/2)*MainValues.resolution), (int) Math.round((9.0/3-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
			//g2d.drawImage(playDef, (int) Math.round((16/4-3.0/2)*MainValues.resolution), (int) Math.round((9.0/2-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
			//g2d.drawImage(playDef, (int) Math.round((16/4-3.0/2)*MainValues.resolution), (int) Math.round((9.0*2.0/3-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
			//g2d.drawImage(playDef, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0/3-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
			//g2d.drawImage(playDef, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0/2-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
			//g2d.drawImage(playDef, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0*2.0/3-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
	}
}
