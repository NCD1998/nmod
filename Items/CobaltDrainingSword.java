package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CobaltDrainingSword extends ItemSword{
	private final String name = "CobaltDrainingSword";
	
	public CobaltDrainingSword(ToolMaterial Mat){
		super(Mat);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
		
	}
	
	public String getName(){
		return name;
	}
	
}
