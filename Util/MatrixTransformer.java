package com.ncd1998.nmod.Util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class MatrixTransformer {

	public static void buildStandard(IBlockState[][][] blockArray, World world, BlockPos startPos){
		for(int length = 0; length < blockArray.length; length++){
			for(int width = 0; width < blockArray[0].length; width++){
				for(int height = 0; height < blockArray[0][0].length; height++){
					if(blockArray[length][width][height] != null){
						world.setBlockState(startPos.add(length, height, width), blockArray[length][width][height]);
					}
					
				}
			}
		}
	}
	
	public static void buildStandard(IBlockState[][][] blockArray, World world, BlockPos startPos, boolean replaceSafe){
		for(int length = 0; length < blockArray.length; length++){
			for(int width = 0; width < blockArray[0].length; width++){
				for(int height = 0; height < blockArray[0][0].length; height++){
					if(blockArray[length][width][height] != null){
						if(replaceSafe && world.getBlockState(startPos.add(length, height, width)).getBlock().isReplaceable(world, startPos.add(length, height, width))){
							world.setBlockState(startPos.add(length, height, width), blockArray[length][width][height]);
						}
					}
					
				}
			}
		}
	}
	//Pivot 90 Degrees Counter Clockwise (Square Structures Rotate 90 Degrees Clockwise?)
	public static void buildLWSwap(IBlockState[][][] blockArray, World world, BlockPos startPos){
		for(int length = 0; length < blockArray.length; length++){
			for(int width = 0; width < blockArray[0].length; width++){
				for(int height = 0; height < blockArray[0][0].length; height++){
					if(blockArray[length][width][height] != null){
						world.setBlockState(startPos.add(width, height,length), blockArray[length][width][height]);
					}
					
				}
			}
		}
	}
	
	//Pivot 90 Degrees Clockwise (Square Structures Rotate 90 Degrees Clockwise and slide over)
	public static void buildOppositeLWSwap(IBlockState[][][] blockArray, World world, BlockPos startPos){
		for(int length = 0; length < blockArray.length; length++){
			for(int width = 0; width < blockArray[0].length; width++){
				for(int height = 0; height < blockArray[0][0].length; height++){
					if(blockArray[length][width][height] != null){
						world.setBlockState(startPos.add(-width, height,length), blockArray[length][width][height]);
					}
					
				}
			}
		}
	}
	//Reflect Object along length Axis
	public static void buildInvertL(IBlockState[][][] blockArray, World world, BlockPos startPos){
		for(int length = 0; length < blockArray.length; length++){
			for(int width = 0; width < blockArray[0].length; width++){
				for(int height = 0; height < blockArray[0][0].length; height++){
					if(blockArray[length][width][height] != null){
						world.setBlockState(startPos.add(blockArray.length - 1 - length , height,width), blockArray[length][width][height]);
					}
					
				}
			}
		}
	}
	
	//(Square Structures Rotate 90 Degrees Counterclockwise)
		public static void buildInvertWswap(IBlockState[][][] blockArray, World world, BlockPos startPos){
			for(int length = 0; length < blockArray.length; length++){
				for(int width = 0; width < blockArray[0].length; width++){
					for(int height = 0; height < blockArray[0][0].length; height++){
						if(blockArray[length][width][height] != null){
							world.setBlockState(startPos.add(width, height,blockArray.length - 1 -  length), blockArray[length][width][height]);
						}
						
					}
				}
			}
		}
}
