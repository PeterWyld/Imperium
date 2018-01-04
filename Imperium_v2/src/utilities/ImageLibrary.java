package utilities;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageLibrary {
	private Image[] tileImgArr;
	private Image[] unitImgArr;
	public ImageLibrary() {
		//Tile ImgArr
		File SnowMountainImage = new File("res/snowyMountain.png"); // in order of their value in map CSV files
		File SwampImage = new File("res/swamp.png");
		File SnowImage = new File("res/snow.png");
		File OceanImage = new File("res/sea.png");
		File SandImage = new File("res/sand.png");
		File RockyGrassImage = new File("res/roughGrass.png");
		File StoneImage = new File("res/rocky.png");
		File StoneRoadImage = new File("res/road.png");
		File DirtImage = new File("res/Mud.png");
		File MountainImage = new File("res/Mountain.png");
		File MarshImage = new File("res/marsh.png");
		File IceImage = new File("res/ice.png");
		File GrassImage = new File("res/Grass.png");
		File CoastImage = new File("res/coast.png");
		File DryGrassImage = new File("res/dryGrass.png");
		File ForestImage = new File("res/Forest.png");
		Image snowMtn, swamp, snow, ocean, sand, rockyGrass, stone, road, dirt, mountain, marsh, ice, grass, coast, dryGrass, forest;

		try {
			snowMtn = ImageIO.read(SnowMountainImage);
			swamp = ImageIO.read(SwampImage);
			snow = ImageIO.read(SnowImage);
			ocean = ImageIO.read(OceanImage);
			sand = ImageIO.read(SandImage);
			rockyGrass = ImageIO.read(RockyGrassImage);
			stone = ImageIO.read(StoneImage);
			road = ImageIO.read(StoneRoadImage);
			dirt = ImageIO.read(DirtImage);
			mountain = ImageIO.read(MountainImage);
			marsh = ImageIO.read(MarshImage);
			ice = ImageIO.read(IceImage);
			grass = ImageIO.read(GrassImage);
			coast = ImageIO.read(CoastImage);
			dryGrass = ImageIO.read(DryGrassImage);
			forest = ImageIO.read(ForestImage);
			tileImgArr = new Image[] {snowMtn, swamp, snow, ocean, sand, rockyGrass, stone, road, dirt, mountain, marsh, ice, grass, coast, dryGrass, forest};
		}	catch(Exception e) {
			
		}
		
		// UnitImgArr
		File CarElephant = new File("res/carthageElephantUnit.png");
		File CarHeavCavalry = new File("res/carthageHeavCavalryUnit.png");
		File CarLiCavalry = new File("res/carthageLiCavalryUnit.png");
		File CarHoplite = new File("res/carthageHopliteUnit.png");
		File CarSlinger = new File("res/carthageSlingerUnit.png");
		Image carEle, carHvCav, carLiCav, carHop, carSling;
		
		try {
			carEle = ImageIO.read(CarElephant);
			carHvCav = ImageIO.read(CarHeavCavalry);
			carLiCav = ImageIO.read(CarLiCavalry);
			carHop = ImageIO.read(CarHoplite);
			carSling = ImageIO.read(CarSlinger);
			unitImgArr = new Image[] {carEle, carHvCav, carLiCav, carHop, carSling};
		} catch (Exception e) {
			System.out.println("Images failed to load");
		}
	}
	public Image[] getTileImgArr() {
		return tileImgArr;
	}
	public Image[] getUnitImgArr() {
		return unitImgArr;
	}
}
