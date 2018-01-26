package graphics;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import values.MainValues;

public class StartGfx extends JPanel{	//sets up the Start Up frame
	private static final long serialVersionUID = 1L;
	float alpha = 0.5f; //draw half transparent
	File StartBGImg = new File("res/TwoHeadedBirdFinal.png");
	File StartButtonDefault = new File("res/buttonDefaultStart.png");
	File StartButtonHover = new File("res/buttonHoverStart.png");
	File Title_1 = new File("res/title_1.png");
	File Title_2 = new File("res/title_2.png");
	File Title_3 = new File("res/title_3.png");
	File Title_4 = new File("res/title_4.png");
	int timerIndex = 0;
	AlphaComposite ac;
	
	BufferedImage bg, StartBtnDef, StartBtnHvr, title1, title2, title3, title4;
	
	public void paintComponent(Graphics g) {
		timerIndex = MainValues.titleTimerIndex;
		try {
			bg = ImageIO.read(StartBGImg);
			StartBtnDef = ImageIO.read(StartButtonDefault);
			StartBtnHvr = ImageIO.read(StartButtonHover);
			title1 = ImageIO.read(Title_1);
			title2 = ImageIO.read(Title_2);
			title3 = ImageIO.read(Title_3);
			title4 = ImageIO.read(Title_4);
		} catch(Exception e) {
			
		}
		
		Graphics2D g2d = (Graphics2D) g;
		
		//	((16/number)-(imgSize/2))*MainValues.resolution
		//	is the equivalent to
		//	((The dimension of the frame/percent across screen the img is)-(size of img/2))*resolution
		
		//	e.g. ((16/2)-(3/2))*MainValues.resolution
		//	This will have a image with a dimension of 3*resolution and will be halfway across the screen
		
		g2d.drawImage(bg, 0, 0, MainValues.width, MainValues.height, null);
		g2d.drawImage(StartBtnDef, (int) Math.round((16/2-2/2)*MainValues.resolution), (int) Math.round((9.0/2-1.0/2)*MainValues.resolution), 2*MainValues.resolution, 1*MainValues.resolution, null);
		
		if (timerIndex >= 0 && timerIndex <= 100) {
			alpha = (float) (timerIndex / 100.0);
		} else if (timerIndex >= 100 && timerIndex <= 200) {
			alpha = (float) (1 - (timerIndex -100) / 100.0);
		} else {
			alpha = 0f;
		}
		ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
		g2d.setComposite(ac);
		g2d.drawImage(title2, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0/4-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
		
		if (timerIndex >= 50 && timerIndex <= 150) {
			alpha = (float) ((timerIndex - 50) / 100.0);
		} else if (timerIndex >= 150 && timerIndex <= 200) {
			alpha = (float) (1 - (timerIndex - 150) / 100.0);
		} else if (timerIndex >= 0 && timerIndex <= 50) {
			alpha = (float) (0.5 - (timerIndex) / 100.0);
		} else {
			alpha = 0f;
		}
		ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
		g2d.setComposite(ac);
		g2d.drawImage(title4, (int) Math.round((16/2-3.0/2)*MainValues.resolution), (int) Math.round((9.0/4-1.0/2)*MainValues.resolution), 3*MainValues.resolution, 1*MainValues.resolution, null);
	}
}
