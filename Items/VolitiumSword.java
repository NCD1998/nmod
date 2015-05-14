package com.ncd1998.nmod.Items;


import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NMaterials;
import com.ncd1998.nmod.Util.EntityIdentifier;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VolitiumSword extends NItemSword{
	private final String name = "VolitiumSword";
	private final static ToolMaterial material = NMaterials.VolitiumMaterial;
	private Random random = new Random();
	public VolitiumSword(){
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		stack.damageItem(1, attacker);
		float interestingValue =  2 + random.nextFloat() * 10;
		if(random.nextInt(100) == 0){
			interestingValue += 20;	
		}
		System.out.println(interestingValue);
		target.attackEntityFrom(DamageSource.causeMobDamage(attacker), interestingValue);
        return true;
    }
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Sword will do random damage each hit!");
		tooltip.add("Chance to do massive damage.");
	}
	


	
}
