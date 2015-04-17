package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Init.NMaterials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AbsorbiumPickaxe extends NPickaxe{
	private final String name = "AbsorbiumPickaxe";
	private final static ToolMaterial mat = NMaterials.AbsorbiumMaterial;
	//Values
	private final int CoalValue = 10;
	private final int IronValue = 20;
	private final int LapisValue = 40;
	private final int RedstoneValue = 30;
	private final int GoldValue = 50;
	private final int DiamondValue = 100;
	private final int EmeraldValue = 140;
	private final int AbsorbiumValue = 20;
	private final int VoiditeValue = 100;
	private final int VolitiumValue = 50;
	
	public AbsorbiumPickaxe(){
		super(mat);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(stack.isItemDamaged()){
			//Absorb Coal
			if(worldIn.getBlockState(pos).equals(Blocks.coal_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - CoalValue);
			}
			//Absorb Iron
			if(worldIn.getBlockState(pos).equals(Blocks.iron_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - IronValue);
			}
			//Absorb Lapis
			if(worldIn.getBlockState(pos).equals(Blocks.lapis_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - LapisValue);
			}
			//Absorb Redstone
			if(worldIn.getBlockState(pos).equals(Blocks.redstone_ore.getDefaultState()) || worldIn.getBlockState(pos).equals(Blocks.lit_redstone_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - RedstoneValue);
			}
			//Absorb Gold
			if(worldIn.getBlockState(pos).equals(Blocks.gold_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - GoldValue);
			}
			//Absorb Diamonds
			if(worldIn.getBlockState(pos).equals(Blocks.diamond_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - DiamondValue);
			}
			//Absorb Emerald
			if(worldIn.getBlockState(pos).equals(Blocks.emerald_ore.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - EmeraldValue);
			}
			//Absorb Absorbium
			if(worldIn.getBlockState(pos).equals(NBlocks.AbsorbiumOre.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - AbsorbiumValue);
			}
			//Absorb Voidite
			if(worldIn.getBlockState(pos).equals(NBlocks.VoiditeOre.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - VoiditeValue);
			}
			//Absorb Volitium 
			if(worldIn.getBlockState(pos).equals(NBlocks.VolitiliumOre.getDefaultState())){
				worldIn.setBlockState(pos, Blocks.air.getDefaultState());
				stack.setItemDamage(stack.getItemDamage() - VolitiumValue);
			}
		}
        return false;
    }
}
