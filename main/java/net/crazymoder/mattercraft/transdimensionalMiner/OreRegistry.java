package net.crazymoder.mattercraft.transdimensionalMiner;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.oredict.OreDictionary;

public class OreRegistry {
	
	
 	private static List<ItemStack> Ores  = new ArrayList<ItemStack>();

	public static void init(File configFile){
		Configuration configuration = new Configuration(configFile);
		configuration.load();
		String[] loadedVal = configuration.get("Ores", "Ores", getDefaults()).getStringList();
		registerOres(loadedVal);
		configuration.save();
	}
	
	public static boolean loaded(){
		return true;
	}
	
	public static ItemStack getRandomOre(){
		return null;	
	}
	
	private static void registerOres(String[] loadedVal){
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		for (String string : OreDictionary.getOreNames()) {
			System.out.println(string);
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		for (String entry : loadedVal) {
			String[] entrySplit = entry.split(":");
			if(entrySplit.length == 2){
				System.out.println("0:"+entrySplit[0]+" "+"1:"+entrySplit[1]);
				if(OreDictionary.getOres(entrySplit[1]).size() > 0){
					System.out.println("Exists: "+entrySplit[1]);
					ItemStack ore = OreDictionary.getOres(entrySplit[1]).get(0);
					ore.stackSize = 1;
					for (int i = 0; i < Integer.parseInt(entrySplit[0]); i++) {
						Ores.add(ore);
					}
				}
			}
		}
		for (ItemStack is : Ores) {
			System.out.println(is.getUnlocalizedName());
		}
		System.out.println();
		while(true){}
	}
	
	private static String[] getDefaults(){
		String[] defVal= {
				"175:Coal",
				"150:Iron",
				"100:Redstone",
				"100:Nikolite",
				"50:oreSalt",
				"50:oreNetherSalt",
				"90:Copper",
				"85:Tin",
				"85:oreCheese",
				"85:Force",
				"80:glowstone",
				"80:Lapis",
				"70:Gold",
				"70:oreQuartz",
				"60:Lead",
				"30:oreZinc",
		        "30:oreSphalerite",
				"60:NaturalAluminum",
				"60:Aluminium",
				"60:Aluminum",
				"60:oreDark",
				"60:oreSodalite",
				"55:Mithril",
				"55:Steel",
				"55:oreCassiterite",
				"55:Diamond",
				"55:oreDesh",
				"50:CertusQuartz",
				"50:Osmium",
				"50:oreBauxite",
				"45:Rutile",
				"45:Titanium",
				"45:Tungsten",
				"22:oreTungstate",
				"23:oreNetherTungsten",
				"45:orePyrite",
				"45:FzDarkIron",
				"40:Tennantite",
				"40:Nickel",
				"40:Sulfur",
				"40:Saltpeter",
				"35:Emerald",
				"35:Ruby",
				"35:Sapphire",
				"35:GreenSapphire",
				"35:Peridot",
				"35:Topaz",
				"35:Tanzanite",
				"35:Malachite",
				"35:Amber",
				"30:Adamantium",
				"30:Silver",
				"30:Galena",
				"30:Apatite",
				"30:Silicon",
				"25:Magnesium",
		        "25:Amethyst",
				"20:Uranium",
				"10:orePitchblende",
				"10:oreNetherUranium",
				"20:oreFirestone",
				"20:MonazitOre",
				"15:Cinnabar",
				"15:Platinum",
				"7:oreCooperite",
				"8:oreNetherPlatinum",
				"10:oreArdite",
				"10:oreCobalt",
				"10:Yellorite",
				"5:Iridium",
				"20:oreTetrahedrite",
				"20:oreCadmium",
				"20:oreIndium",
				"20:oreAmmonium",
				"20:oreCalcite",
				"20:oreFluorite",
				"20:oreMagnetite",
				"20:oreManganese",
				"20:oreMeutoite",
				"20:oreEximite",
				"20:oreAtlarus",
				"20:oreOrichalcum",
				"20:oreRubracium",
				"20:oreCarmot",
				"20:oreAstralSilver",
				"20:oreOureclase",
				"20:oreInfuscolium",
				"20:oreDeepIron",
				"20:orePrometheum",
				"20:oreSanguinite",
				"20:oreVulcanite",
				"20:oreKalendrite",
				"20:oreAlduorite",
				"20:oreCeruclase",
				"20:oreVyroxeres",
				"20:oreMidasium",
				"20:oreLemurite",
				"20:oreShadowIron",
				"20:oreIgnatius",
				"20:orePotash",
				"20:oreBitumen",
				"20:orePhosphorite"
		};
		return defVal;	
	}
	
}
