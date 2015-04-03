package com.ncd1998.nmod;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NmodSmeltingRecipes {
	public static void addRecipes(){
		//Sky Cobalt Crystal
		GameRegistry.addSmelting(new ItemStack(nmod.SkyCobaltBlock, 1), new ItemStack(nmod.SkyCobaltCrystal, 1), 1F);
	}
}
