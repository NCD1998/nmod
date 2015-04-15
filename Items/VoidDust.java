package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VoidDust extends NItem{
	private final String name = "VoidDust";
	
	public VoidDust(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(side.equals(EnumFacing.UP)){
			if(worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.getBlockState(pos.down()).getBlock().isSolidFullCube()){
				worldIn.setBlockState(pos, NBlocks.BVoidDust.getDefaultState());
				stack.stackSize--;
			}else if(worldIn.getBlockState(pos).getBlock().isSolidFullCube() && worldIn.getBlockState(pos.up()).getBlock().equals(Blocks.air)){
				worldIn.setBlockState(pos.up(), NBlocks.BVoidDust.getDefaultState());
				stack.stackSize--;
			}
			
		}
        return false;
    }
	
}
