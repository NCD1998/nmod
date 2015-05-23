package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;

public class ReferenceSTBlocks {
	public static final IBlockState TEMPLESTONE = NBlocks.SkyTempleStone.getDefaultState();
	public static final IBlockState BRICKMATERIAL = Blocks.stonebrick.getDefaultState();
	public static final IBlockState TEMPLEGLASS = NBlocks.SkyTempleGlass.getDefaultState();
	public static final IBlockState SPIRITGLASS = NBlocks.SpiritGlass.getDefaultState();
	public static final IBlockState COMMONCHEST = NBlocks.LockedSkyChestCommon.getDefaultState();
	public static final IBlockState UNCOMMONCHEST = NBlocks.LockedSkyChestUncommon.getDefaultState();
	public static final IBlockState SEMIRARECHEST = NBlocks.LockedSkyChestSemirare.getDefaultState();
}
