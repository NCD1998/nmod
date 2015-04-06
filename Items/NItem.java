package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NItem extends Item{
	public NItem(){
		super();
		setCreativeTab(CreativeTabs.tabMisc);
		this.setNoRepair();
		}
}
