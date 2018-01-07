package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import units.unit;
import values.MainValues;

public class BattleMap extends JPanel {
	private static final long serialVersionUID = 1L;
	private int zoom = 1;
	private int originXPos = 0;
	private int yPos = 0;
	private Image[] tileImgArr = main.Window.ImageUtility.getTileImgArr();
	private Image[] unitImgArr = main.Window.ImageUtility.getUnitImgArr();
	private int xPos = originXPos;
	private File BGImage = new File("res/gridLines.png");
	private List<List<String>> mapArray;
	private int imageIndex = 0;
	private int tileSize = 16;
	private unit[][] unitArray = new unit[][] {new unit[0]};
	
	Image bgImage; {
		try { 
			bgImage = ImageIO.read(BGImage);
		} catch(Exception e) {
		
		}
	}
	
	public void setMap(List<List<String>> newMapArray, unit[][] newUnitArray) {
		mapArray = newMapArray;
		unitArray = newUnitArray;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		zoom = MainValues.globalZoom; //accessed inside paint component as the above code is not run during window.frame.repaint();
		originXPos = -(MainValues.globalX);
		yPos = -(MainValues.globalY);
		
		Graphics g2d = (Graphics2D) g;
			
		//	((16/number)-(imgSize/2))*MainValues.resolution
		//	is the equivalent to
		//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
			
		//	e.g. ((16/2)-(3/2))*MainValues.resolution
		//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
		imageIndex = 0;
		tileSize = 16*zoom;
		
		g2d.drawImage(bgImage, 0, 0, 545, 545, null);
			
		for (int i = 0; i <= mapArray.size() -1; i++) {
			for (int j = 0; j <= mapArray.get(i).size() -1; j++) {
				/* drawing tile */
				try {
					imageIndex = Integer.parseInt(mapArray.get(i).get(j)); //check if input is a string
				} catch (NumberFormatException e) {
					imageIndex = 0; //defaults to zero (snowy mountain) if not a integer
				}
				if((imageIndex < 0) || (imageIndex > tileImgArr.length - 1)) {
					imageIndex = 0;//defaults to zero (snowy mountain) if outside of index
				}
				g2d.drawImage(tileImgArr[imageIndex], xPos, yPos, tileSize, tileSize, null);
				
				/* drawing unit */
				if (unitArray[i][j] != null) {
					imageIndex = unitArray[i][j].getUnitImgIndex(); 
					if((imageIndex < 0) || (imageIndex > unitImgArr.length - 1)) {
						imageIndex = 0;//defaults to zero (Carthaginian Elephant) if outside of index
					}
					g2d.drawImage(unitImgArr[imageIndex], xPos, yPos, tileSize, tileSize, null);
				}
				xPos += tileSize;
			}
			yPos += tileSize;
			xPos = originXPos;
		}
	}
}