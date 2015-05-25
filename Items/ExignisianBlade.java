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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExignisianBlade extends NItemSword{
	private final String name = "ExignisianBlade";
	private final static ToolMaterial material = NMaterials.ExignisianMaterial;
	private static int globalTimer = 0;
	private Random random = new Random();
	public ExignisianBlade(){
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(stack.hasTagCompound()){
			stack.getTagCompound().setString("User", entityIn.getName());
			if(stack.getTagCompound().getString("User").equalsIgnoreCase("NCD1998") && isSelected){
				List entities = worldIn.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(entityIn.getPosition().add(-3,-3,-3), entityIn.getPosition().add(3, 3, 3)));
				if(!entities.isEmpty()){
					for(int i = 0; i < entities.size(); i++){
						if(!entities.get(i).equals(entityIn)){
							 EntityLiving current = (EntityLiving) entities.get(i);
							 current.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 5, 1));
							 
						}
					}
					if(globalTimer == 100){
						globalTimer = 0;
						for(int i = 0; i < entities.size(); i++){
							if(!entities.get(i).equals(entityIn)){
								 EntityLiving current = (EntityLiving) entities.get(i);
								current.attackEntityFrom(DamageSource.magic, 3);
								 
							}
						}
						
					}else{
					 globalTimer++;
					}
				}
			}else if(isSelected){
				List entities = worldIn.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(entityIn.getPosition().add(-3,-3,-3), entityIn.getPosition().add(3, 3, 3)));
				if(!entities.isEmpty()){
					for(int i = 0; i < entities.size(); i++){
						if(!entities.get(i).equals(entityIn)){
							 EntityLiving current = (EntityLiving) entities.get(i);
							 current.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 5));
						}
					}
				}
			}
		}else{
			activateNBT(stack);
		}
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		activateNBT(stack);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		stack.damageItem(20, playerIn);
		for(int length = -3; length < 4; length++){
			if(worldIn.isAirBlock(pos.add(length, 1, 0))){
				worldIn.setBlockState(pos.add(length, 1, 0), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(0,1,length))){
				worldIn.setBlockState(pos.add(0, 1, length), Blocks.ice.getDefaultState());
			}
		}
		for(int length = -2; length < 3; length++){
			if(worldIn.isAirBlock(pos.add(length, 1, -1))){
				worldIn.setBlockState(pos.add(length, 1, -1), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(-1, 1, length))){
				worldIn.setBlockState(pos.add(-1, 1, length), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(length, 1, 1))){
				worldIn.setBlockState(pos.add(length, 1, 1), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(1, 1, length))){
				worldIn.setBlockState(pos.add(1, 1, length), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(length, 2, 0))){
				worldIn.setBlockState(pos.add(length, 2, 0), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(0,2,length))){
				worldIn.setBlockState(pos.add(0, 2, length), Blocks.ice.getDefaultState());
			}
		}
		for(int length = -1; length < 2; length++){
			if(worldIn.isAirBlock(pos.add(length, 2, -1))){
				worldIn.setBlockState(pos.add(length, 2, -1), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(length, 2, 1))){
				worldIn.setBlockState(pos.add(length, 2, 1), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(length, 3, 0))){
				worldIn.setBlockState(pos.add(length, 3, 0), Blocks.ice.getDefaultState());
			}
			if(worldIn.isAirBlock(pos.add(0, 3, length))){
				worldIn.setBlockState(pos.add(0, 3, length), Blocks.ice.getDefaultState());
			}
		}
		if(worldIn.isAirBlock(pos.add(0,4,0))){
			worldIn.setBlockState(pos.up(4), Blocks.ice.getDefaultState());
		}
        return false;
    }
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		super.hitEntity(stack, target, attacker);
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().getString("User").equalsIgnoreCase("NCD1998")){
				target.addVelocity(attacker.getLookVec().xCoord, attacker.getLookVec().yCoord, attacker.getLookVec().zCoord);
				attacker.heal(1);
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 40, 4));
			}
		}else{
			activateNBT(stack);
		}
		return true;
    }
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().getString("User").equalsIgnoreCase("NCD1998")){
				tooltip.add("The Blade awakens in your hand and will do your bidding!");
			}else{
				tooltip.add("You feel a dormant force in the Blade as you hold it in your hand.");
				tooltip.add("It will make a fine weapon even in this state.");
			}
		}else{
			activateNBT(stack);
		}
	}

	private void activateNBT(ItemStack stack) {
		stack.setTagCompound(new NBTTagCompound());
    	NBTTagCompound tag = stack.getTagCompound();
    	tag.setString("User", "NONE");
		
	}
	


	
}
