package utilities;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Images failed to load", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		// UnitImgArr
		File CarElephant = new File("res/carthageElephantUnit.png");
		File CarHeavCavalry = new File("res/carthageHeavCavalryUnit.png");
		File CarLiCavalry = new File("res/carthageLiCavalryUnit.png");
		File CarHoplite = new File("res/carthageHopliteUnit.png");
		File CarSlinger = new File("res/carthageSlingerUnit.png");
		File RomLegionarie = new File("res/LegionarieUnit.png");
		File RomArcher = new File("res/romeArcherUnit.png");
		File RomHeavCavalry = new File("res/romeHeavCavalryUnit.png");
		File RomLiCavalry = new File("res/romeLiCavalryUnit.png");
		File RomSkirmisher = new File("res/skirmisherUnit.png");
		File PerImmortal = new File("res/immortalUnit.png");
		File PerArcher = new File("res/persiaArchUnit.png");
		File PerElephant = new File("res/persiaElephantUnit.png");
		File PerHeavCavalry = new File("res/persiaHeavCavalryUnit.png");
		File PerLightCavalry = new File("res/persiaLiCavalryUnit.png");
		File PerSparabara = new File("res/sparabaraUnit.png");
		File GreCompCavalry = new File("res/companionCavalryUnit.png");
		File GreArcher = new File("res/greekArcherUnit.png");
		File GreLiCavalry = new File("res/greekLiCavalryUnit.png");
		File GreHoplite = new File("res/HopliteUnit.png");
		File GrePeltasts = new File("res/peltastsUnit.png");
		File HunHeavCav = new File("res/hunnicHeavCavalryUnit.png");
		File HunLiCav = new File("res/hunnicLiCavalryUnit.png");
		File HunHorseArcher = new File("res/hunnicHorseArcher.png");
		File HunInfantry = new File("res/hunnicInfantryUnit.png");
		File HunArcherUnit = new File("res/hunnicArcherUnit.png");
		File GalHeavCavalry = new File("res/gallicHeavCavalryUnit.png");
		File GalLiCavalry = new File("res/gallicLiCavalryUnit.png");
		File GalInfantry = new File("res/gallicInfantry.png");
		File GalHeavInfantry = new File("res/gallicHeavyInfantry.png");
		File GalChariot = new File("res/celticChariot.png");
		//File  = new File("res/Unit.png");
		
		Image carEle, carHvCav, carLiCav, carHop, carSling,
				romLeg, romArch, romHvCav, romLiCav, romSkrm,
				perImor, perArch, perEle, perHvCav, perLiCav, perSpa,
				greComCav, greArch, greLiCav, greHop, grePel,
				hunHvCav, hunLiCav, hunHorsArch, hunInf, hunArch,
				galHvCav, galLiCav, galInf, galHvInf, galCha;
		
		try {
			carEle = ImageIO.read(CarElephant);
			carHvCav = ImageIO.read(CarHeavCavalry);
			carLiCav = ImageIO.read(CarLiCavalry);
			carHop = ImageIO.read(CarHoplite);
			carSling = ImageIO.read(CarSlinger);
			
			romLeg = ImageIO.read(RomLegionarie);
			romArch = ImageIO.read(RomArcher);
			romHvCav = ImageIO.read(RomHeavCavalry);
			romLiCav = ImageIO.read(RomLiCavalry);
			romSkrm = ImageIO.read(RomSkirmisher);
			
			perImor = ImageIO.read(PerImmortal);
			perArch = ImageIO.read(PerArcher);
			perEle = ImageIO.read(PerElephant);
			perHvCav = ImageIO.read(PerHeavCavalry);
			perLiCav = ImageIO.read(PerLightCavalry);
			perSpa = ImageIO.read(PerSparabara);
			
			greComCav = ImageIO.read(GreCompCavalry);
			greArch = ImageIO.read(GreArcher);
			greLiCav = ImageIO.read(GreLiCavalry);
			greHop = ImageIO.read(GreHoplite);
			grePel = ImageIO.read(GrePeltasts);
			
			hunHvCav = ImageIO.read(HunHeavCav);
			hunLiCav = ImageIO.read(HunLiCav);
			hunHorsArch = ImageIO.read(HunHorseArcher);
			hunInf = ImageIO.read(HunInfantry);
			hunArch = ImageIO.read(HunArcherUnit);
			
			galHvCav = ImageIO.read(GalHeavCavalry);
			galLiCav = ImageIO.read(GalLiCavalry);
			galInf = ImageIO.read(GalInfantry);
			galHvInf = ImageIO.read(GalHeavInfantry);
			galCha = ImageIO.read(GalChariot);
			
			unitImgArr = new Image[] {carEle, carHvCav, carLiCav, carHop, carSling,
					romLeg, romArch, romHvCav, romLiCav, romSkrm,
					perImor, perArch, perEle, perHvCav, perLiCav, perSpa,
					greComCav, greArch, greLiCav, greHop, grePel,
					hunHvCav, hunLiCav, hunHorsArch, hunInf, hunArch,
					galHvCav, galLiCav, galInf, galHvInf, galCha};
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Images failed to load", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	public Image[] getTileImgArr() {
		return tileImgArr;
	}
	public Image[] getUnitImgArr() {
		return unitImgArr;
	}
}
