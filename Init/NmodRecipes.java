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
		
		
		//Temporary Testing Recipes
		GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSword),
				" D ",
				" S ",
				"   ",
				'D', new ItemStack(Items.diamond_sword), 'S', new ItemStack(NItems.SkyCobaltCrystal));
		GameRegistry.addShapelessRecipe(new ItemStack(NItems.FireCrystal, 1, 200), new ItemStack(NItems.VolitiliumDust, 1));
		
	}
}
