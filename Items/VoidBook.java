package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VoidBook extends NItem{
	private final String name = "VoidBook";
	
	public VoidBook(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setMaxStackSize(1);
		setNoRepair();
	}
	
	public String getName(){
		return name;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		return false;
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	@Override
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		playerIn.stopUsingItem();
		playerIn.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 2000,1 ));
		return stack;
    }
	
}
