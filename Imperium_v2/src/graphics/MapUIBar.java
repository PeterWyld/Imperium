package graphics;

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
	int cycle = 0;
	
	static TileImageLoader battleTiles = new TileImageLoader();
	Image[] imgArr = battleTiles.LoadImages();
	
	Image bgImage, lftBtn, rghtBtn; {
		try { 
			bgImage = ImageIO.read(BGImage);
			lftBtn = ImageIO.read(LeftButton);
			rghtBtn = ImageIO.read(RightButton);
		} catch(Exception e) {
		
		}
	}

	public void paintComponent(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(bgImage, 0, 0, MainValues.width, MainValues.width/4, null);
		for (int i = 0 ; i <= 8; i++) {
			g2d.drawImage(imgArr[i+cycle], (i*2+4) * 5 * MainValues.resolution/10, 2 * MainValues.resolution/10, 5 * MainValues.resolution/10, 5 * MainValues.resolution/10, null);
			if (cycle + i >= 15) {
				cycle = 0;
			}
		}
	}
}
