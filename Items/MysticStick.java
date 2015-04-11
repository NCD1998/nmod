package com.ncd1998.nmod.Items;


import java.util.Stack;

import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MysticStick extends NItem{
	private final String name = "MysticStick";
	
	public MysticStick(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		/*for(int i = 0; i < 10; i++){
			//if(!playerIn.worldObj.isRemote){
			int xdir;
			int zdir;
			if(playerIn.getLookVec().xCoord >= 0){
				xdir = 1;
			}else{
				xdir = -1;
			}
			if(playerIn.getLookVec().zCoord >= 0){
				zdir = 1;
			}else{
				zdir = -1;
			}
			EntityLightningBolt bolt = new EntityLightningBolt(worldIn, (playerIn.getPosition().getX() + (i * xdir)), playerIn.getPosition().getY(),(playerIn.getPosition().getZ() + (i * zdir)));
			worldIn.spawnEntityInWorld(bolt);
			//System.out.println(playerIn.getLookVec());
			//}
		}*/
		System.out.println(worldIn.getBiomeGenForCoords(playerIn.getPosition()).getBiomeClass().getName());
		System.out.println(worldIn.getBiomeGenForCoords(playerIn.getPosition()).biomeName);
        return itemStackIn;
    }
}
