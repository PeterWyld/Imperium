package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import units.unit;
import values.MainValues;

public class GameUIBar extends JPanel {
	private static final long serialVersionUID = 1L;
	File LeftButton = new File("res/gridlines.png");
	File RightButton = new File("res/gridlines.png");
	File BGImage = new File("res/buttonHover.png");
	File ExitButton = new File("res/buttonDefaultExit.png");
	File BackButton = new File("res/buttonDefaultBack.png");
	File EndTurnButton = new File("res/buttonDefaultLoad.png");
	int res = MainValues.resolution;
	unit selection;
	
	Image[] imgArr = main.Window.ImageUtility.getTileImgArr();
	
	Image bgImage, lftBtn, rghtBtn, writeBG, exitBtn, backBtn, endTurnBtn; {
		try { 
			bgImage = ImageIO.read(BGImage);
			lftBtn = ImageIO.read(LeftButton);
			rghtBtn = ImageIO.read(RightButton);
			exitBtn = ImageIO.read(ExitButton);
			backBtn = ImageIO.read(BackButton);
			endTurnBtn = ImageIO.read(EndTurnButton);
		} catch(Exception e) {
		
		}
	}
	public void paintComponent(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(bgImage, 0, 0, MainValues.width, MainValues.width/4, null);
		if (selection == null) { //default menu
			g2d.drawImage(backBtn, (int) Math.round(14 * res), (int) Math.round(res * (6.0/5)), res, res/2, null);
			g2d.drawImage(endTurnBtn, (int) Math.round(12.5 * res), (int) Math.round(res * (6.0/5)), res, res/2, null);

		} else { //unit orders
			
		}
		
	}

}
