package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NmodSmeltingRecipes {
	public static void addRecipes(){
		//Sky Cobalt Crystal
		GameRegistry.addSmelting(new ItemStack(NBlocks.SkyCobaltBlock, 1), new ItemStack(NItems.SkyCobaltCrystal, 1), 1F);
		//Smelt VoiditeOre
		GameRegistry.addSmelting(new ItemStack(NBlocks.VoiditeOre, 1), new ItemStack(NItems.VoiditeIngot, 1), 1F);
	}
}
