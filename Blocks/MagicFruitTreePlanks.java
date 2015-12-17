package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;


public class MagicFruitTreePlanks extends NBlock
{
	private final String name = "MagicFruitTreePlanks";
	public MagicFruitTreePlanks()
	{
		super(Material.wood);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(2F);
		setStepSound(Block.soundTypeWood);
		setHarvestLevel("axe", 0);
		setResistance(5F);
	}
	public String getName()
	{
		return name;
	}
}