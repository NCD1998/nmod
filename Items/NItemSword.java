package com.ncd1998.nmod.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class NItemSword extends ItemSword{

	public NItemSword(ToolMaterial material) {
		super(material);
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
