package graphics;

import java.awt.Color;
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
	private File BGImage = new File("res/battleBG.png");
	private List<List<String>> mapArray;
	private int imageIndex = 0;
	private int tileSize = 16;
	private unit[][] unitArray = new unit[][] {new unit[0]};
	private int[][] highlights;
	private Color transparentBlue = new Color(0f, 0f, 1f, 0.25f );
	private Color transparentRed = new Color(1f, 0f, 0f, 0.25f);
	private Color invalidMove = new Color(1f, 0f, 0f, 0.5f);
	private Color isFriendly = new Color(0f, 1f, 0f, 0.25f);
	private Color[] colorArr = new Color[] {transparentBlue, transparentRed, invalidMove,isFriendly};
	private Color health = new Color(0f, 1f, 0f);
	private Color healthLost = new Color(1f,0f,0f);
	
	Image bgImage; {
		try { 
			bgImage = ImageIO.read(BGImage);
		} catch(Exception e) {
		
		}
	}
	
	public void addTileHighlight(int yPos, int xPos, int colourIndex) {
		// 0 = no highlight, 1 = blue, 2 = red, 3 = invalidMove, 4 = friendly
		if (colourIndex <= colorArr.length && colourIndex >= 0) {
			highlights[yPos][xPos] = colourIndex;
		}
	}
	
	public void clearHighlights() {
		highlights = new int[mapArray.size()][mapArray.get(0).size()];
	}
	
	public void setMap(List<List<String>> newMapArray, unit[][] newUnitArray) {
		mapArray = newMapArray;
		unitArray = newUnitArray;
		highlights = new int[mapArray.size()][mapArray.get(0).size()];
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
		
		g2d.drawImage(bgImage, 0, 0, MainValues.resolution*16, MainValues.resolution*7, null);
			
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
					g2d.setColor(healthLost);
					g2d.fillRect(xPos, yPos+15*zoom, tileSize, zoom);
					g2d.setColor(health);
					g2d.fillRect(xPos, yPos + 15*zoom, (int) (tileSize * (unitArray[i][j].getHealth() / 100.0)), zoom);
				}
				if (highlights[i][j] != 0) { // so that no rec is drawn if there is no highlight
					g2d.setColor(colorArr[highlights[i][j] -1]);
					g2d.drawRect(xPos, yPos, tileSize, tileSize); //gives a nice outline
					g2d.fillRect(xPos, yPos, tileSize, tileSize);
				}
				xPos += tileSize;
			}
			yPos += tileSize;
			xPos = originXPos;
		}
	}
}