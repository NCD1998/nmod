package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;


public class SkyTempleStone extends NBlock
{
	private final String name = "SkyTempleStone";
	public SkyTempleStone()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(3F);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 2);
		setResistance(6F);
	}
	public String getName()
	{
		return name;
	}
}