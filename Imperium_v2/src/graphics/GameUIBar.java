package graphics;

import java.awt.Color;
import java.awt.Font;
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
	File TextBacking = new File("res/gridlines.png");
	File ChargeAttackIcon = new File("res/gridlines.png");
	File RangedAttackIcon = new File("res/gridlines.png");
	int res = MainValues.resolution;
	Font basic = new Font("basic", Font.PLAIN, (int) Math.ceil(res/4));
	Color text = new Color(1f, 1f, 1f, 1f );
	unit selection = null;
	int imageIndex = 0;
	
	Image[] imgArr = main.Window.ImageUtility.getUnitImgArr();
	Image[] generalArr;
	
	Image bgImage, lftBtn, rghtBtn, writeBG, exitBtn, backBtn, endTurnBtn, txtBack, chargeIcon, fireIcon; {
		try { 
			bgImage = ImageIO.read(BGImage);
			lftBtn = ImageIO.read(LeftButton);
			rghtBtn = ImageIO.read(RightButton);
			exitBtn = ImageIO.read(ExitButton);
			backBtn = ImageIO.read(BackButton);
			endTurnBtn = ImageIO.read(EndTurnButton);
			txtBack = ImageIO.read(TextBacking);
			chargeIcon = ImageIO.read(ChargeAttackIcon);
			fireIcon = ImageIO.read(RangedAttackIcon);
		} catch(Exception e) {
		
		}
	}
	
	public void paintComponent(Graphics g) {
		selection = main.Window.manager.getSelection();
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(bgImage, 0, 0, MainValues.width, MainValues.width/4, null);
		g2d.drawImage(backBtn, (int) Math.round(14 * res), (int) Math.round(res * (6.0/5)), res, res/2, null);
		g2d.drawImage(endTurnBtn, (int) Math.round(12.5 * res), (int) Math.round(res * (6.0/5)), res, res/2, null);
		if (selection == null) { //default menu

		} else { //unit orders
			imageIndex = selection.getUnitImgIndex(); 
			if((imageIndex < 0) || (imageIndex > imgArr.length - 1)) {
				imageIndex = 0;//defaults to zero (Carthaginian Elephant) if outside of index
			}
			g2d.drawImage(imgArr[imageIndex], (int) Math.round(res*0.1),  (int) Math.round(res*0.1), (int) Math.round(res*1.75), (int) Math.round(res*1.75), null);
			g2d.drawImage(txtBack, res * 2, (int) Math.round(res*0.1), (int) Math.round(res*1.5), (int) Math.round(res*0.25), null);
			g2d.setFont(basic);
			g2d.drawString("Movement: " + selection.getRemainingMovement(), res * 2, (int) Math.round(res*0.35));
			if (selection instanceof units.Cavalry) {
				g2d.drawImage(chargeIcon, res * 4, (int) Math.round(res*0.1) , res, res, null);
			} else if (selection instanceof units.Ranged) {
				g2d.drawImage(fireIcon, res * 4, (int) Math.round(res* 0.1), res, res, null);
			}
		}
		
	}

}
