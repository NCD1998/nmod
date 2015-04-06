package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VolitiliumDust extends NItem{
	private final String name = "VolitiliumDust";
	
	public VolitiliumDust(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		stack.stackSize--;
		target.worldObj.createExplosion(target, target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ(), 2, true);
        return false;
    }
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
		Random rand = new Random();
		if(rand.nextInt(10) == 0){
			item.stackSize--;
			player.worldObj.createExplosion(player, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 2, true);
		}
        return true;
    }
	
}
