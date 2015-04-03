package com.ncd1998.nmod;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class NmodRecipes {
	public static void addRecipes(){
		//SkyCobalt to block
		GameRegistry.addRecipe(new ItemStack(nmod.SkyCobaltBlock), 
				"SSS",
				"SSS",
				"SSS",
				'S', new ItemStack(nmod.SkyCobalt));
		//SkyCobalt from block
		GameRegistry.addShapelessRecipe(new ItemStack(nmod.SkyCobaltBlock, 1), new ItemStack(nmod.SkyCobalt));
		
		
	}
}
