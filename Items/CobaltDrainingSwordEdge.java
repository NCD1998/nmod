package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CobaltDrainingSwordEdge extends NItem{
	private final String name = "CobaltDrainingSwordEdge";
	
	public CobaltDrainingSwordEdge(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	
}
