package com.ncd1998.nmod.Init;

import net.minecraftforge.oredict.OreDictionary;

public class NInitOreDic {

	public static void init(){
		//Blocks
		OreDictionary.registerOre("plankWood", NBlocks.MysticWoodPlanks);
		OreDictionary.registerOre("plankWood", NBlocks.MagicFruitTreePlanks);
		OreDictionary.registerOre("logWood", NBlocks.MysticWoodLog);
		OreDictionary.registerOre("logWood", NBlocks.MagicFruitTreeLog);
		OreDictionary.registerOre("treeLeaves", NBlocks.MysticLeaves);
		OreDictionary.registerOre("treeLeaves", NBlocks.MagicFruitLeaves);
		OreDictionary.registerOre("treeSapling", NBlocks.MysticTreeSapling);
		//Items
		OreDictionary.registerOre("stickWood", NItems.MysticStick);
		//Items
	}
}
