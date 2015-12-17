package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireCrystal extends NItem{
	private final String name = "FireCrystal";
	private final Random rand = new Random();
	private final int MaxDamage = 200;
	public FireCrystal(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setMaxDamage(MaxDamage);
		this.setMaxStackSize(1);
		
	}
	
	public String getName(){
		return name;
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
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {	if(stack.isItemDamaged()){
		if(worldIn.getBlockState(pos) == Blocks.lava.getDefaultState()){
			worldIn.setBlockState(pos, Blocks.air.getDefaultState());
			stack.setItemDamage(stack.getItemDamage() - 10);
		}else{
			if(side == EnumFacing.UP && worldIn.getBlockState(pos.up()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.up(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			}else if(side == EnumFacing.DOWN && worldIn.getBlockState(pos.down()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.down(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			}else if(side == EnumFacing.EAST && worldIn.getBlockState(pos.east()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.east(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			}else if(side == EnumFacing.WEST && worldIn.getBlockState(pos.west()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.west(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			
			}else if(side == EnumFacing.NORTH && worldIn.getBlockState(pos.north()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.north(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			}else if(side == EnumFacing.SOUTH && worldIn.getBlockState(pos.south()) == Blocks.lava.getDefaultState()){
				worldIn.setBlockState(pos.south(), Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - 10);
			}
		}
    }return true;
    }
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(stack.isItemDamaged() && entityIn.isBurning() && !entityIn.isImmuneToFire()){
			if(rand.nextInt(100) == 0){
				stack.setItemDamage(stack.getItemDamage() - 1);
			}
		}
		if(stack.getMetadata() != 200 && entityIn.isInWater() && isSelected){
			stack.setItemDamage(stack.getItemDamage() + 1);
		}
		if(stack.isItemDamaged() && entityIn.worldObj.provider.getDimensionId() == -1){
			if(rand.nextInt(10000) == 0){
				stack.setItemDamage(stack.getItemDamage() - 1);
			}
		}
	}
	@Override
	public double getDurabilityForDisplay(ItemStack stack)
    {
        return (double)stack.getItemDamage() / (double)stack.getMaxDamage();
    }
	@Override
	public boolean isDamageable()
    {
        return true;
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(!itemStackIn.isItemDamaged()){
		//Fire
		BlockPos pos = null;
		BlockPos playerPos = playerIn.getPosition();
		for(int x = -5; x <= 5; x++){
			for(int y = -3; y <= 3; y++){
				for(int z = -5; z <= 5; z++){
					pos = new BlockPos(playerPos.getX() + x,playerPos.getY() + y,playerPos.getZ() + z);
					if(worldIn.getBlockState(pos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
					}
				}
			}
		}
		}
		itemStackIn.setItemDamage(MaxDamage);
        return itemStackIn;
    }
}
