package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SappingCrystal extends NItem{
	private final String name = "SappingCrystal";
	
	public SappingCrystal(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setMaxStackSize(1);
	}
	
	public String getName(){
		return name;
	}
	
}
