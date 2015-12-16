package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTemplePillarBridge extends Bridge implements IRoom {
	//Name
			private final String NAME = "Sky Temple Pillar Hallway";
			//Type
			private final EnumSkyTempleRooms type = EnumSkyTempleRooms.HALLWAY;
			//Room Dimension Holder
			private final BoxSizer sizer = new BoxSizer(4,8,5);
			//The schematic array
			private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
			//Door Locations
			private final int[][][] doorLocations = {{{1,0,1},{2,0,1},{1,0,2},{2,0,2}},{{1,7,1},{2,7,1},{1,7,2},{2,7,2}}};
			//Floor Block
			private final IBlockState floorBase = ReferenceSTBlocks.TEMPLESTONE;
			//Wall Block
			private final IBlockState wallBase = Blocks.quartz_block.getStateFromMeta(2);
	public SkyTemplePillarBridge(){
		fillOutArray();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				for(int height = 1; height < sizer.getHeight() - 1; height++){
					blocks[length][width][0] = floorBase;
				
				
				//pillars
					blocks[0][2][height] = blocks[sizer.getLength() - 1][2][height] = wallBase;
					blocks[0][4][height] = blocks[sizer.getLength() - 1][4][height] = wallBase;
					blocks[0][6][height] = blocks[sizer.getLength() - 1][6][height] = wallBase;
				
				//Roof edge
				blocks[0][width][sizer.getHeight() - 1] = floorBase;
				blocks[sizer.getLength() - 1][width][sizer.getHeight() - 1] = floorBase;
				}
			}
		}
		
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
		return null;
	}

	@Override
	public ChestRarity[] getPossibleLootLevels() {
		return null;
	}

	@Override
	public IBlockState getBlock(int l, int w, int h) {
		return blocks[l][w][h];
	}

	@Override
	public int getMaxChests() {
		return 0;
	}

	@Override
	public int getMinChests() {
		return 0;
	}
	@Override
	public void setEroded(int l, int w, int h) {
		blocks[l][w][h] = Blocks.air.getDefaultState();
	}
	@Override
	public RoomType getType() {
		return type;
	}
	@Override
	public int[][][] getDoorLocations() {
		return doorLocations;
	}

}
