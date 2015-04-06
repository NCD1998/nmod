package com.ncd1998.nmod.Items;


import java.util.List;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Projectile.DeathRayProjectile;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpellPaperDragonSoul extends NItem{
	private final String name = "SpellPaperDragonSoul";
	
	public SpellPaperDragonSoul(){
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
		par3List.add("Spell Class: Buff");
		par3List.add("Spell Danger: Harmless");
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
	    {playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;}
	 @Override
		public ItemStack onItemUseFinish(ItemStack stack, World WorldIn,EntityPlayer PlayerIn) {
		 	SpellHandler.dragonSkin(WorldIn, PlayerIn);
		 	stack.stackSize--;
		 	return stack;
	 }
	
	
}
