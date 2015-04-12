package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OrderCrystal extends NItem{
	private final String name = "OrderCrystal";
	
	public OrderCrystal(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
	}
	
	public String getName(){
		return name;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(!stack.isItemDamaged()){
		return true;
        }
        return false;
    }
	
}
