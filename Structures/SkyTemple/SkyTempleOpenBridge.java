package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleOpenBridge extends Bridge implements IRoom {
	//Name
			private final String NAME = "Sky Temple Open Hallway";
			//Type
			private final EnumSkyTempleRooms type = EnumSkyTempleRooms.HALLWAY;
			//Room Dimension Holder
			private final BoxSizer sizer = new BoxSizer(4,8,2);
			//The schematic array
			private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
			//Floor Block
			private final IBlockState floorBase = Blocks.quartz_block.getDefaultState();
			//Wall Block
			private final IBlockState wallBase = Blocks.quartz_block.getDefaultState();
	public SkyTempleOpenBridge(){
		fillOutArray();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				blocks[length][width][0] = floorBase;
				//gaurdrail
				blocks[0][width][1] = wallBase;
				blocks[sizer.getLength() - 1][width][1] = wallBase;
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

}
