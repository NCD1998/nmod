package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpellPaperDeathBeam extends Item{
	private final String name = "SpellPaperDeathBeam";
	public SpellPaperDeathBeam(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName(){
		return name;
	}
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	/*public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	   {
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		 return itemStackIn;
	    }*/
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World WorldIn,EntityPlayer PlayerIn) {
	        if (!WorldIn.isRemote)
	        {
	        	EntityWitherSkull skull = new EntityWitherSkull(WorldIn, PlayerIn.getPosition().getX() + 1, PlayerIn.getPosition().getY() + 1, PlayerIn.getPosition().getZ() + 1, PlayerIn.getLookVec().xCoord, PlayerIn.getLookVec().yCoord, PlayerIn.getLookVec().zCoord);
	            WorldIn.spawnEntityInWorld(skull);
	        }
	        return stack;
	    }
	
	
}
