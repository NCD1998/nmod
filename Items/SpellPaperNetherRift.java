package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpellPaperNetherRift extends Item{
	private final String name = "SpellPaperNetherRift";
	
	public SpellPaperNetherRift(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName(){
		return name;
	}
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	    {
		 stack.stackSize--;
		 for(int i = 0; i < 6; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 6; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 6; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 6; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
	        return stack;
	    }
	/*public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() + i,pos.getY() + i,pos.getZ() + i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() - i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() + i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() - i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		return true;
    }*/
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	 public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 32;
	    }
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
	        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
	        return itemStackIn;
	    }
}
