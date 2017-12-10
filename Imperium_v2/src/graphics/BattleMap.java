package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import utilities.TileImageLoader;
import values.MainValues;

public class BattleMap extends JPanel {
	private static final long serialVersionUID = 1L;
	String mapName = "";
	int zoom = 1;
	int originXPos = 0;
	int yPos = 0;
	static TileImageLoader battleTiles = new TileImageLoader();
	Image[] imgArr = battleTiles.LoadImages();
	int xPos = originXPos;
	File BGImage = new File("res/gridLines.png");
	
	Image bgImage; {
		try { 
			bgImage = ImageIO.read(BGImage);
		} catch(Exception e) {
		
		}
	}
	
	public void paintComponent(Graphics g) {
		List<List<String>> mapArray = MainValues.battleMapArray;
		zoom = MainValues.globalZoom; //accessed inside paint component as the above code is not run during window.frame.repaint();
		originXPos = -(MainValues.globalX);
		yPos = -(MainValues.globalY);
		
		Graphics g2d = (Graphics2D) g;
			
		//	((16/number)-(imgSize/2))*MainValues.resolution
		//	is the equivalent to
		//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
			
		//	e.g. ((16/2)-(3/2))*MainValues.resolution
		//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
		int imageIndex = 0;
		int tileSize = 16*zoom;
		g2d.drawImage(bgImage, 0, 0, 545, 545, null);
			
		for (List<String> mapLine : mapArray) {
			for (String mapTile: mapLine) {
				try {
					imageIndex = Integer.parseInt(mapTile); //check if input is a string
				} catch (NumberFormatException e) {
					imageIndex = 0; //defaults to zero (snowy mountain) if not a integer
				}
				if((imageIndex < 0) || (imageIndex > imgArr.length - 1)) {
					imageIndex = 0;//defaults to zero (snowy mountain) if outside of index
				}
				g2d.drawImage(imgArr[imageIndex], xPos, yPos, tileSize, tileSize, null);
				xPos += tileSize;
			}
			yPos += tileSize;
			xPos = originXPos;
		}
	}
}