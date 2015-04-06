package com.ncd1998.nmod.Items;


import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Projectile.DeathRayProjectile;
import com.ncd1998.nmod.Util.ParticleHelper;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpellPaperDeathBeam extends NItem{
	private final String name = "SpellPaperDeathBeam";
	public SpellPaperDeathBeam(){
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
		par3List.add("Spell Class: Beam");
		par3List.add("Spell Danger: Deadly");
		}
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	@Override
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World WorldIn,EntityPlayer PlayerIn) {
	        if (!WorldIn.isRemote)
	        {
	        	stack.stackSize--;
	        	SpellHandler.spellDeathBeam(WorldIn, PlayerIn);
	        }
	        return stack;
	    }
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
		ParticleHelper.flameAndSuspendedDepth(stack, player, count);
    }
	
	
}
