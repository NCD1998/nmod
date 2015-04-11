package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class NmodRecipes {
	public static void addRecipes(){
		//SkyCobalt to block
		GameRegistry.addRecipe(new ItemStack(NBlocks.SkyCobaltBlock), 
				"SSS",
				"SSS",
				"SSS",
				'S', new ItemStack(NItems.SkyCobalt));
		//SkyCobalt from block
		GameRegistry.addShapelessRecipe(new ItemStack(NBlocks.SkyCobaltBlock, 1), new ItemStack(NItems.SkyCobalt, 9));
		//Absorption Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorptionCrystal),
				"AAA",
				"ASA",
				"AAA",
				'A', new ItemStack(NItems.AbsorbiumDust),
				'S', new ItemStack(NItems.SkyCobaltCrystal));
		//Absorbium Ingot
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumIngot, 1),
				" A ",
				"AIA",
				" A ",
				'A', new ItemStack(NItems.AbsorbiumDust),
				'I', new ItemStack(Items.iron_ingot));
		//Nether Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.NetherCrystal, 1, 1),
				"CBC",
				"GAG",
				"CBC",
				'C', new ItemStack(NItems.ChargedNetherQuartz),
				'B', new ItemStack(Items.blaze_rod),
				'G', new ItemStack(Items.ghast_tear),
				'A', new ItemStack(NItems.AbsorptionCrystal));
		//Ender Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.EnderCrystal, 1, 1),
				" E ",
				"EAE",
				" E ",
				'E', new ItemStack(Items.ender_pearl),
				'A', new ItemStack(NItems.AbsorptionCrystal));
		//Mystic Wood Planks
		GameRegistry.addShapelessRecipe(new ItemStack(NBlocks.MysticWoodPlanks, 4), new ItemStack(NBlocks.MysticWoodLog));
		//Mystic Stick
		GameRegistry.addRecipe(new ItemStack(NItems.MysticStick, 4),
				"P",
				"P",
				'P', new ItemStack(NBlocks.MysticWoodPlanks));
		//Cobalt Draining Sword Recipe Tree
			//Cobalt Draining Sword Handle
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordHandle, 1),
					"V",
					"S",
					"V",
					'V', new ItemStack(NItems.VoiditeIngot),
					'S', new ItemStack(NItems.MysticStick));
			//Cobalt Draining Sword Core
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordCore, 1),
					"III",
					"AEA",
					"III",
					'I', new ItemStack(NItems.AbsorbiumIngot),
					'A', new ItemStack(NItems.AbsorptionCrystal),
					'E', new ItemStack(Items.ender_eye));
			//Cobalt Draining Sword Edge
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordEdge, 1),
					"III",
					" IE",
					"  I",
					'I', new ItemStack(NItems.AbsorbiumIngot),
					'E', new ItemStack(Items.ender_pearl));
			//Cobalt Draining Sword Blade
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordBlade, 1),
					" I ",
					"IAI",
					"IAI",
					'I', new ItemStack(NItems.VoiditeIngot),
					'A', new ItemStack(NItems.AbsorbiumIngot));
			//Cobalt Draining Sword
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSword, 1),
					" B ",
					"ECE",
					" H ",
					'B', new ItemStack(NItems.CobaltDrainingSwordBlade),
					'E', new ItemStack(NItems.CobaltDrainingSwordEdge),
					'C', new ItemStack(NItems.CobaltDrainingSwordCore),
					'H', new ItemStack(NItems.CobaltDrainingSwordHandle));
		//Temporary Testing Recipes
		GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSword),
				" D ",
				" S ",
				"   ",
				'D', new ItemStack(Items.diamond_sword), 'S', new ItemStack(NItems.SkyCobaltCrystal));
		GameRegistry.addShapelessRecipe(new ItemStack(NItems.FireCrystal, 1, 200), new ItemStack(NItems.VolitiliumDust, 1));
		
	}
}
