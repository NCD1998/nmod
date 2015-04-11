package com.ncd1998.nmod.Items;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;

public class CobaltDrainingSwordHandle extends NItem{
private final String name = "CobaltDrainingSwordHandle";
	
	public CobaltDrainingSwordHandle(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
}
