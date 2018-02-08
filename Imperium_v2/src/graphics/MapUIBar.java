package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import values.MainValues;

public class MapUIBar extends JPanel{
	private static final long serialVersionUID = 1L;
	File LeftButton = new File("res/lftButton.png");
	File RightButton = new File("res/rghtButton.png");
	File BGImage = new File("res/buttonHover.png");
	File SaveButton = new File("res/buttonDefaultSave.png");
	File LoadButton = new File("res/buttonDefaultLoad.png");
	File ExitButton = new File("res/buttonDefaultExit.png");
	File BackButton = new File("res/buttonDefaultBack.png");
	File WriteNameBG = new File("res/ice.png");
	int cycle = 0;
	boolean savingMap = false;
	int res = MainValues.resolution;
	Font saveBox = new Font("monospaced", Font.PLAIN, (int) Math.ceil(res/2));
	StringBuffer textVar = new StringBuffer("Map Name");
	int startIndex = 0;
	int endIndex = 0;
	
	Image[] imgArr = main.Window.ImageUtility.getTileImgArr();
	
	Image bgImage, lftBtn, rghtBtn, saveBtn, writeBG, exitBtn, loadBtn, backBtn; {
		try { 
			bgImage = ImageIO.read(BGImage);
			lftBtn = ImageIO.read(LeftButton);
			rghtBtn = ImageIO.read(RightButton);
			saveBtn = ImageIO.read(SaveButton);
			writeBG = ImageIO.read(WriteNameBG);
			exitBtn = ImageIO.read(ExitButton);
			backBtn = ImageIO.read(BackButton);
			loadBtn = ImageIO.read(LoadButton);
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
	
	public void addChar(char newChar) {
		textVar.append(newChar);
	}
	
	public void backspaceTyped() {
		if (textVar.length() > 0) {
			textVar.deleteCharAt(textVar.length()-1);
		}
	}
	
	public String getMapName() {
		return textVar.toString();
	}
	
	public void paintComponent(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(bgImage, 0, 0, MainValues.width, MainValues.width/4, null);
		if (savingMap == false) {
			g2d.drawImage(lftBtn, res, res/5, res/2, res/2, null);
			g2d.drawImage(rghtBtn, 6 * res, res/5, res/2, res/2, null);
			g2d.drawImage(saveBtn, 7 * res, res/5, res, res/2, null);
			g2d.drawImage(loadBtn, (int) Math.round(8.5 * res), res/5, res, res/2, null);
			g2d.drawImage(backBtn, (int) Math.round(10 * res), res/5, res, res/2, null);
			for (int i = 0 ; i <= 8; i++) {		
				if (cycle + i <= imgArr.length -1) {
					g2d.drawImage(imgArr[i+cycle], (i+3) * res/2, res/5, res/2, res/2, null);
				}
			}
		} else {
			g2d.drawImage(writeBG, res, res/5, 6*res, res/2, null);
			g2d.drawImage(saveBtn, 7 * res, res/5, res, res/2, null);
			g2d.drawImage(backBtn, (int) Math.round(8.5 * res), res/5, res, res/2, null);
			g2d.drawImage(saveBtn, (int) Math.round(10 * res), res/5, res, res/2, null);
			g2d.setFont(saveBox);
			startIndex = textVar.length() - 19;
			if (startIndex < 0) {
				startIndex = 0;
			}
			endIndex = textVar.length();
			g2d.drawString(textVar.toString().substring(startIndex, endIndex), res, (int) Math.ceil(3.0/5 * res));
		}
	}
}
