package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleBaseFloor2 implements IRoom{
	//Name
	private final String NAME = "Sky Temple Floor 2";
	//Room Dimension Holder
	private final BoxSizer sizer = new BoxSizer(16,16,5);
	//All Possible chest Locations
	//!!!!!!!!!!!!!THIS ROOM HAS HARDCODED CHESTS AS WELL THAT ALWAYS SPAWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private final int[][] possiblechestlocations = {{14,2,1},{14,13,1},{9,6,1},{9,9,1}};
	//All Possible levels of loot to spawn in the chests in this room
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON};
	//Max random chests to generate
	private final int maxChests = 2;
	//Min random chests to generate
	private final int minChests = 0;
	//The schematic array
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Floor Block
	private final IBlockState floorBase = Blocks.quartz_block.getDefaultState();
	//Wall Block
	private final IBlockState wallBase = Blocks.quartz_block.getDefaultState();
	//Block to make tables out of
	private final IBlockState tableBlock = Blocks.quartz_block.getStateFromMeta(1);
	//Hardcoded Loot Boxes
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	//Glass Base
	private final IBlockState glassBase = Blocks.glass.getDefaultState();
	
	public SkyTempleBaseFloor2(){
		fillOutArray();
	}
	private void fillOutArray(){
		//FLoor
				for(int length = 0; length < sizer.getLength(); length++){
					for(int width = 0; width < sizer.getWidth(); width++){
						blocks[length][width][0] = floorBase;
					}
				}
				//Cut out floor edges
				blocks[0][0][0] = blocks[1][0][0] = blocks[0][1][0] = Blocks.air.getDefaultState();
				blocks[0][15][0] = blocks[1][15][0] = blocks[0][14][0] = Blocks.air.getDefaultState();
				blocks[15][15][0] = blocks[14][15][0] = blocks[15][14][0] = Blocks.air.getDefaultState();
				blocks[15][0][0] = blocks[15][1][0] = blocks[14][0][0] = Blocks.air.getDefaultState();
				//Generate Walls
				/*
				 * X_____
				 * X    _
				 * X    _
				 * X_   _
				 */
				for(int length = 2; length < 14; length++){
					for(int height = 1; height < 5; height++){
						blocks[length][0][height] = wallBase;
					}
				}
				/*
				 * _____X
				 * _    X
				 * _    X
				 * __   X
				 */
				for(int length = 2; length < 14; length++){
					for(int height = 1; height < 5; height++){
						blocks[length][15][height] = wallBase;
					}
				}
				/*
				 * XXXXX
				 * _   _
				 * _   _
				 * _   _
				 */
				for(int width = 2; width < 14; width++){
					for(int height = 1; height < 5; height++){
						blocks[15][width][height] = wallBase;
					}
				}
				/*______
				 *_    _
				 *_    _
				 *X    X
				 */
				for(int width = 2; width < 14; width++){
					for(int height = 1; height < 5; height++){
						blocks[0][width][height] = wallBase;
					}
				}
				//Corners of walls
				for(int height = 1; height < 5; height++){
					blocks[1][14][height] = wallBase;
					blocks[1][1][height] = wallBase;
					blocks[14][1][height] = wallBase;
					blocks[14][14][height] = wallBase;
				}
		//Glass
		for(int length = 3; length < 7; length++){
			for(int width = 3; width < 7; width++){
				if(!(length == 3 && width == 3)){
					blocks[length][width][0] = glassBase;
				}
			}
		}
		for(int length = 3; length < 7; length++){
			for(int width = 9; width < 13; width++){
				if(!(length == 3 && width == 12)){
					blocks[length][width][0] = glassBase;
				}
			}
		}
		for(int length = 9; length < 13; length++){
			for(int width = 3; width < 7; width++){
				if(!(length == 12 && width == 3)){
					blocks[length][width][0] = glassBase;
				}
			}
		}
		for(int length = 9; length < 13; length++){
			for(int width = 9; width < 13; width++){
				if(!(length == 12 && width == 12)){
					blocks[length][width][0] = glassBase;
				}
			}
		}
		//Center column surroundings
				for(int height = 1; height < 5; height++){
					blocks[7][6][height] = wallBase;
					blocks[8][6][height] = wallBase;
					blocks[9][7][height] = wallBase;
					blocks[9][8][height] = wallBase;
					blocks[7][9][height] = wallBase;
					blocks[8][9][height] = wallBase;
				}
				//Sunbeam Column
				for(int height = 0; height < 5; height++){
					blocks[7][7][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[7][8][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[8][7][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[8][8][height] = NBlocks.SunBeamBlock.getDefaultState();
				}
		//Table and chests
				blocks[1][7][1] = blocks[1][8][1] = tableBlock;
				blocks[1][7][2] = blocks[1][8][2] = chestBase;
	}
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public BoxSizer getDimensions() {
		return sizer;
	}

	@Override
	public int[][] getPossibleChestLocations() {
		return possiblechestlocations;
	}

	@Override
	public ChestRarity[] getPossibleLootLevels() {
		return lootLevels;
	}

	@Override
	public IBlockState getBlock(int l, int w, int h) {
		return blocks[l][w][h];
	}

	@Override
	public int getMaxChests() {
		return maxChests;
	}

	@Override
	public int getMinChests() {
		return minChests;
	}

}
