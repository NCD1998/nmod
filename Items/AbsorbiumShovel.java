package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NMaterials;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AbsorbiumShovel extends NShovel{
	private final String name = "AbsorbiumShovel";
	private static final ToolMaterial material = NMaterials.AbsorbiumMaterial;
	
	public AbsorbiumShovel(){
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(side.equals(EnumFacing.NORTH)){
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.south(count))){
						worldIn.setBlockState(pos.south(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}else if(side.equals(EnumFacing.SOUTH)){
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.north(count))){
						worldIn.setBlockState(pos.north(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}else if(side.equals(EnumFacing.WEST)){
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.east(count))){
						worldIn.setBlockState(pos.east(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}else if(side.equals(EnumFacing.EAST)){
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.west(count))){
						worldIn.setBlockState(pos.west(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}else if(side.equals(EnumFacing.DOWN)){
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.up(count))){
						worldIn.setBlockState(pos.up(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}else{
			if(isItGood(worldIn, pos)){
				int count = 0;
				while(count <= 5){
					if(isItGood(worldIn, pos.down(count))){
						worldIn.setBlockState(pos.down(count), Blocks.air.getDefaultState());
						stack.attemptDamageItem(3, new Random());
					}
					count++;
				}
			}
		}
		if(stack.getItemDamage() >= stack.getMaxDamage()){
			stack.stackSize--;
		}
		return false;
		
    }
	private static boolean isItGood(World worldIn, BlockPos pos){
		boolean flag = false;
		IBlockState state =worldIn.getBlockState(pos);
		if(state.equals(Blocks.dirt.getDefaultState()) || state.equals(Blocks.grass.getDefaultState()) || state.equals(Blocks.sand.getDefaultState()) || state.equals(Blocks.gravel.getDefaultState()) || state.equals(Blocks.clay.getDefaultState()) || state.equals(Blocks.soul_sand.getDefaultState()) || state.equals(Blocks.mycelium.getDefaultState()) || state.equals(Blocks.snow.getDefaultState())){
			flag = true;
		}
		return flag;
		
	}
	
}
