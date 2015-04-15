package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crusher extends NItem{
	private final String name = "Crusher";
	
	public Crusher(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setContainerItem(this);
		this.setMaxDamage(30);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
    {
        if (!hasContainerItem(itemStack))
        {
            return null;
        }
        return new ItemStack(getContainerItem(), 1, itemStack.getItemDamage() + 1);
    }
	
}
