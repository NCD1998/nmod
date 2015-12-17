package com.ncd1998.nmod.Structures.Tree;

import java.util.Random;



import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Util.MatrixTransformer;
import com.ncd1998.nmod.TileEntities.*;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class FruitTree {
	private static IBlockState[][][] blocks = new IBlockState[5][5][10];
	Random Rand = new Random();
	
	
	public FruitTree(BlockPos pos){
		int heightVar1 = pos.getY() % 3;
		int heightVar2 = pos.getX() % 3;
		int heightVar3 = pos.getZ() % 3;
		
		int heightInc = (heightVar1 + heightVar2 + heightVar3) / 3;
		int height = heightInc + 7;
		for(int x = 0; x < height; x++){
			blocks[2][2][x] = NBlocks.MagicFruitTreeLog.getDefaultState();
		}
		for(int x = 0; x < 5; x++){
			for(int z = 0; z < 5; z++){
				if(!(((z == 4) && ((x == 0) || (x == 4))) || (z == 0 && x == 4))){
					blocks[x][z][4 + heightInc] = NBlocks.MagicFruitLeaves.getDefaultState();
				}
			}
		}
		for(int x = 0; x < 5; x++){
			for(int z = 0; z < 5; z++){
				if(!(x == 0 && z == 0)){
					blocks[x][z][5 + heightInc] = NBlocks.MagicFruitLeaves.getDefaultState();
				}
			}
		}
		for(int x = 1; x < 4; x++){
			for(int z = 1; z < 4; z++){
				if(!(x == 1 && z == 1) && !(x == 3 && z == 1)){
					blocks[x][z][6 + heightInc] = NBlocks.MagicFruitLeaves.getDefaultState();
				}
			}
		}
		for(int x = 1; x < 4; x++){
			for(int z = 1; z < 4; z++){
				if(!(x == 1 && z == 1) && !(x == 3 && z == 1) && !(x == 1 && z == 3) && !(x == 3 && z == 3)){
					blocks[x][z][7 + heightInc] = NBlocks.MagicFruitLeaves.getDefaultState();
				}
			}
		}
		for(int x = 0; x < height; x++){
			blocks[2][2][x] = NBlocks.MagicFruitTreeLog.getDefaultState();
		}
	}
	
	public void grow(World world, BlockPos pos){
		MatrixTransformer.buildStandard(blocks, world, pos.add(-2,0,-2), true);
	}
	
	
}
