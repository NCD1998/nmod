package com.ncd1998.nmod.Items;


import java.util.List;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Projectile.ElectronSnowballEntity;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElectronSnowball extends NItem{
	private final String name = "ElectronSnowball";
	
	public ElectronSnowball(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setMaxStackSize(1);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.addVelocity((playerIn.getLookVec().xCoord * -15), playerIn.getLookVec().yCoord * -15, playerIn.getLookVec().zCoord * -15);
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }


        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new ElectronSnowballEntity(worldIn, playerIn));
        }
        playerIn.addStat(nmod.getESnow, 1);
        return itemStackIn;
        
    }
	//add Info
			@Override
			public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
			{
			par3List.add(EnumChatFormatting.YELLOW + "3.1329788e40 electrons packed into a nice 3 1/2 inch radius sphere");
			par3List.add(EnumChatFormatting.YELLOW + "Weight: 28539487.6 Metric tons");
			par3List.add(EnumChatFormatting.YELLOW + "Mass:  1.58552706e10 Bullet tuna fish");
			}
}
