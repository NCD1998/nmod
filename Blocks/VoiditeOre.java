package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VoiditeOre extends Block
{
	private final String name = "VoiditeOre";
	protected boolean translucent = false;
	public VoiditeOre()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(5F);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 3);
		setResistance(10F);
	}
	public String getName()
	{
		return name;
	}

}