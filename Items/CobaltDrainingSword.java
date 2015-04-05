package com.ncd1998.nmod.Items;


import java.util.List;

import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CobaltDrainingSword extends ItemSword{
	private final String name = "CobaltDrainingSword";
	
	public CobaltDrainingSword(ToolMaterial Mat){
		super(Mat);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabCombat);
		
		
		
	}
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	    if( par1ItemStack.hasTagCompound() == false ){
	        par1ItemStack.setTagCompound(new NBTTagCompound());
	    	par1ItemStack.getTagCompound().setInteger("PowerLevel", 0);
	    	par1ItemStack.getTagCompound().setString("Crystal", "NONE");
	    }
	}
	public String getName(){
		return name;
	}
	@SideOnly(Side.CLIENT)
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
		 playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		 if(playerIn.isSneaking()){
			 if(itemStackIn.hasTagCompound()){
				 if(itemStackIn.getTagCompound().getString("Crystal") != "NONE"){
					 if(itemStackIn.getTagCompound().getInteger("PowerLevel") == 10){
						 if(itemStackIn.getTagCompound().getString("Crystal") == "ENDER"){
						 		playerIn.inventory.addItemStackToInventory(new ItemStack(nmod.EnderCrystal, 1, 0));
						 		itemStackIn.getTagCompound().setInteger("PowerLevel", 0);
						 		itemStackIn.getTagCompound().setString("Crystal", "NONE");
						 	}
					 }else{
						 if(itemStackIn.getTagCompound().getString("Crystal") == "ENDER"){
							 	EntityItem item = new EntityItem(worldIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), new ItemStack(nmod.EnderCrystal));
						 		itemStackIn.getTagCompound().setInteger("PowerLevel", 0);
						 		itemStackIn.getTagCompound().setString("Crystal", "NONE");
						 	}
					 }
				 }else{
					 if(playerIn.inventory.hasItem(nmod.EnderCrystal)){
							 playerIn.inventory.consumeInventoryItem(nmod.EnderCrystal);
							 itemStackIn.getTagCompound().setInteger("PowerLevel", 0);
							 itemStackIn.getTagCompound().setString("Crystal", "Ender");
						 }
					 
			 }
		 }else{
			 this.onCreated(itemStackIn, worldIn, playerIn);
			 
		 }
		 }else{
			 printInfo(playerIn,itemStackIn);
		 }
	        return itemStackIn;
	    }
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if(stack.getTagCompound().getString("Crystal") != "NONE"){
			if(stack.getTagCompound().getString("Crystal") == "ENDER" && (target.worldObj.provider.getDimensionId() == 1 || ((Entity)target instanceof EntityEnderman))) {
				
			
				if(stack.getTagCompound().getInteger("PowerLevel") == 10){
					attacker.addChatMessage(new ChatComponentTranslation("The Crystal is fully charged!"));
				}else{
					int pow = stack.getTagCompound().getInteger("PowerLevel");
					pow++;
					stack.getTagCompound().setInteger("PowerLevel", pow);
					attacker.addChatMessage(new ChatComponentTranslation("Power Level: " + stack.getTagCompound().getInteger("PowerLevel")));
				}
			}
		}
        stack.damageItem(1, attacker);
        return true;
    }
	@SideOnly(Side.CLIENT)
	public static void printInfo(EntityPlayer playerIn,ItemStack itemStackIn){
		if(itemStackIn.hasTagCompound()){
		 playerIn.addChatMessage(new ChatComponentTranslation("Crystal: : " + itemStackIn.getTagCompound().getString("Crystal")));
		 playerIn.addChatMessage(new ChatComponentTranslation("Power Level: " + itemStackIn.getTagCompound().getInteger("PowerLevel")));
		}
		
	}
}
