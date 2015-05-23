package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleBaseFloor1 implements IRoom{
	//Name
	private final String NAME = "Sky Temple Floor 1";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.FLOOR1;
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
	private final IBlockState floorBase = ReferenceSTBlocks.BRICKMATERIAL;
	//Wall Block
	private final IBlockState wallBase = ReferenceSTBlocks.TEMPLESTONE;
	//Block to make tables out of
	private final IBlockState tableBlock = Blocks.stonebrick.getStateFromMeta(3);
	//Hardcoded Loot Boxes
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	
	public SkyTempleBaseFloor1(){
		fillArray();
	}
	private void fillArray(){
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
		for(int height = 1; height < 5; height++){
			blocks[0][2][height] = wallBase;
			blocks[0][3][height] = wallBase;
			blocks[0][12][height] = wallBase;
			blocks[0][13][height] = wallBase;
		}
		//Corners of walls
		for(int height = 1; height < 5; height++){
			blocks[1][14][height] = wallBase;
			blocks[1][1][height] = wallBase;
			blocks[14][1][height] = wallBase;
			blocks[14][14][height] = wallBase;
		}
		//Table
		blocks[3][7][1] = blocks[3][8][1] = tableBlock;
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
		for(int height = 1; height < 5; height++){
			blocks[7][7][height] = NBlocks.SunBeamBlock.getDefaultState();
			blocks[7][8][height] = NBlocks.SunBeamBlock.getDefaultState();
			blocks[8][7][height] = NBlocks.SunBeamBlock.getDefaultState();
			blocks[8][8][height] = NBlocks.SunBeamBlock.getDefaultState();
		}
		//!!!!!!!!!!!!!!!!!!!!HARDCODED CHESTS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		blocks[3][7][2] = blocks[3][8][2] = chestBase;
		
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
	@Override
	public RoomType getType() {
		return type;
	}

}
