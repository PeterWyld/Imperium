package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import values.MainValues;

public class StartGfx extends JPanel{	//sets up the Start Up frame
	private static final long serialVersionUID = 1L;
	File StartBGImg = new File("res/TwoHeadedBirdFinal.png");
	File StartButtonDefault = new File("res/buttonDefaultStart.png");
	File StartButtonHover = new File("res/buttonHoverStart.png");
	File Title_1 = new File("res/title_1.png");
	
	Image bg, StartBtnDef, StartBtnHvr, title1;
	
	public void paintComponent(Graphics g) {
		try {
			bg = ImageIO.read(StartBGImg);
			StartBtnDef = ImageIO.read(StartButtonDefault);
			StartBtnHvr = ImageIO.read(StartButtonHover);
			title1 = ImageIO.read(Title_1);
		} catch(Exception e) {
		}
		
		Graphics g2d = (Graphics2D) g;
		
		//	((16/number)-(imgSize/2))*MainValues.resolution
		//	is the equivalent to
		//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
		
		//	e.g. ((16/2)-(3/2))*MainValues.resolution
		//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
		
		g2d.drawImage(bg, 0, 0, MainValues.width, MainValues.height, null);
		g2d.drawImage(title1, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0/4-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
		g2d.drawImage(StartBtnDef, (int) Math.round((16/2-2/2)*MainValues.resolution), (int) Math.round((9.0/2-1.0/2)*MainValues.resolution), 2*MainValues.resolution, 1*MainValues.resolution, null);
	}
}
