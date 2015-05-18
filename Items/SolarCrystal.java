package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Util.SpellHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SolarCrystal extends NItem{
	private final String name = "SolarCrystal";
	private Random rand = new Random();
	
	public SolarCrystal(){
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
		if(stack.isItemDamaged() && worldIn.getLightFor(EnumSkyBlock.SKY, entityIn.getPosition()) - worldIn.getSkylightSubtracted() > 4 && worldIn.canSeeSky(entityIn.getPosition()) && !worldIn.isRaining()){
			stack.setItemDamage(stack.getItemDamage() - 1);
		}
		if(worldIn.getLightFor(EnumSkyBlock.SKY, entityIn.getPosition()) - worldIn.getSkylightSubtracted() == 4 &&stack.getItemDamage() != 1000 && worldIn.canSeeSky(entityIn.getPosition()) && !worldIn.isRaining()){
			stack.setItemDamage(stack.getItemDamage() + 1);
		}
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
