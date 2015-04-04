package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AbsorbiumDust extends Item{
	private final String name = "AbsorbiumDust";
	
	public AbsorbiumDust(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName(){
		return name;
	}
	
}
