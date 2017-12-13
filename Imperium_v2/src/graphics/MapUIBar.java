package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import utilities.TileImageLoader;
import values.MainValues;

public class MapUIBar extends JPanel{
	private static final long serialVersionUID = 1L;
	File LeftButton = new File("res/gridlines.png");
	File RightButton = new File("res/gridlines.png");
	File BGImage = new File("res/buttonHover.png");
	File SaveButton = new File("res/buttonDefaultLoad.png");
	File ExitButton = new File("res/buttonDefaultExit.png");
	File WriteNameBG = new File("res/ice.png");
	int cycle = 0;
	boolean savingMap = false;
	int res = MainValues.resolution;
	String saveText = "Sample";
	Font saveBox = new Font("saveBox", Font.PLAIN, (int) Math.ceil(res/2));
	
	static TileImageLoader battleTiles = new TileImageLoader();
	Image[] imgArr = battleTiles.LoadImages();
	
	Image bgImage, lftBtn, rghtBtn, saveBtn, writeBG, exitBtn; {
		try { 
			bgImage = ImageIO.read(BGImage);
			lftBtn = ImageIO.read(LeftButton);
			rghtBtn = ImageIO.read(RightButton);
			saveBtn = ImageIO.read(SaveButton);
			writeBG = ImageIO.read(WriteNameBG);
			exitBtn = ImageIO.read(ExitButton);
		} catch(Exception e) {
		
		}
	}
	
	public int getCycle() {
		return cycle;
	}
	
	public void lftBtnClick() {
		if (cycle > 0) {
			cycle -= 1;
		}
	}
	
	public void rghtBtnClick() {
		if ((imgArr.length -1) >= cycle + 9) {
			cycle += 1;
		}
	}
	
	public void setSavingStatus(boolean status) {
		savingMap = status;		
	}

	public void paintComponent(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(bgImage, 0, 0, MainValues.width, MainValues.width/4, null);
		if (savingMap == false) {
			g2d.drawImage(lftBtn, res, res/5, res/2, res/2, null);
			g2d.drawImage(rghtBtn, 6 * res, res/5, res/2, res/2, null);
			g2d.drawImage(saveBtn, 7 * res, res/5, res, res/2, null);
			g2d.drawImage(saveBtn, (int) Math.ceil(13.5 * res), res/5, res, res/2, null);
			g2d.drawImage(saveBtn, (int) Math.ceil(15 * res), res/5, res, res/2, null);
			for (int i = 0 ; i <= 8; i++) {		
				if (cycle + i <= imgArr.length -1) {
					g2d.drawImage(imgArr[i+cycle], (i+3) * res/2, res/5, res/2, res/2, null);
				}
			}
		} else {
			g2d.drawImage(writeBG, res, res/5, 6*res, res/2, null);
			g2d.setFont(saveBox);
			g2d.drawString(saveText, res, (int) Math.ceil(3.0/5 * res));
		}
	}
}
