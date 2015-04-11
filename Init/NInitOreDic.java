package com.ncd1998.nmod.Init;

import net.minecraftforge.oredict.OreDictionary;

public class NInitOreDic {

	public static void init(){
		//Blocks
		OreDictionary.registerOre("plankWood", NBlocks.MysticWoodPlanks);
		OreDictionary.registerOre("logWood", NBlocks.MysticWoodLog);
		OreDictionary.registerOre("treeLeaves", NBlocks.MysticLeaves);
		OreDictionary.registerOre("treeSapling", NBlocks.MysticTreeSapling);
		//Items
		OreDictionary.registerOre("stickWood", NItems.MysticStick);
	}
}
