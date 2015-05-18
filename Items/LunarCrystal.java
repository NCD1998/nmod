package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LunarCrystal extends NItem{
	private final String name = "LunarCrystal";
	private Random rand = new Random();
	
	public LunarCrystal(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(worldIn.getLightFor(EnumSkyBlock.SKY, entityIn.getPosition()) - worldIn.getSkylightSubtracted() == 4 && worldIn.canSeeSky(entityIn.getPosition()) && stack.getItemDamage() != 1000 && !worldIn.isRaining()){
			stack.damageItem(1, (EntityLivingBase) entityIn);
		}else if(worldIn.getLightFor(EnumSkyBlock.SKY, entityIn.getPosition()) - worldIn.getSkylightSubtracted() > 4 && worldIn.canSeeSky(entityIn.getPosition()) && stack.isItemDamaged() && !worldIn.isRaining()){
			stack.setItemDamage(stack.getItemDamage() - 1);
		}
		/*if(entityIn instanceof EntityPlayer || entityIn instanceof EntityPlayerMP){
			if(entityIn.isSprinting()){
				EntityPlayer player = (EntityPlayer) entityIn;
				if(player.getActivePotionEffect(Potion.moveSpeed) != null){
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, player.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1));
				}else{
					player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 1));
				}
			}
		} Testing Stuffs*/ 
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if(!stack.isItemDamaged()){
		return true;
        }
        return false;
    }
	
}
