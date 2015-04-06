package com.ncd1998.nmod.Items;


import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Util.ParticleHelper;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.DamageSource;
import net.minecraft.block.BlockPortal;
public class SpellPaperEnderRift extends NItem{
	private final String name = "SpellPaperEnderRift";
	
	public SpellPaperEnderRift(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	//add Info
		@Override
		public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
		{
		par3List.add("Spell Class: Reality Warping");
		par3List.add("Spell Danger: High");
		}
	//On finish Use
	@Override
	@SideOnly(Side.CLIENT)
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	    {
		if(worldIn.provider.getDimensionId() != 1){
		 //Use Paper
		 stack.stackSize--;
		 SpellHandler.enderRift(stack, worldIn, playerIn);
		}else{
			playerIn.addChatMessage(new ChatComponentTranslation("You can't open a rift to a dimension you are already in...."));
		}
			return stack;
	    }
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	@Override
	 public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 64;
	    }
	@Override
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
	        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
	        return itemStackIn;
	    }
	 @Override
	 public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
	    {
		ParticleHelper.portalAndSuspendedDepth(stack, player, count);
		 
	    }
}
