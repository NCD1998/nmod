package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleClosedJunction extends Bridge implements IRoom {
	//Name
	private final String NAME = "Sky Temple Closed Junction";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.JUNCTION;
	//Room Dimension Holder
	private final BoxSizer sizer = new BoxSizer(8,8,5);
	//Possible Chest Locations
	private final int[][] possiblechestlocations = {};
	//Possible loot levels
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON};
	//Max Random Chests
	private final int maxChest = 1;
	//Min Random Chests
	private final int minChest = 0;
	//The schematic array
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Floor Block
	private final IBlockState floorBase = Blocks.quartz_block.getDefaultState();
	//Wall Block
	private final IBlockState wallBase = Blocks.quartz_block.getDefaultState();
	//Glass Block
	private final IBlockState glassBase = Blocks.glass.getDefaultState();
	
	public SkyTempleClosedJunction(){
		fillOutArray();
	}
	private void fillOutArray() {
		// TODO Auto-generated method stub
		
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
		return maxChest;
	}

	@Override
	public int getMinChests() {
		return minChest;
	}

	@Override
	public RoomType getType() {
		return type;
	}

	@Override
	public void setEroded(int l, int w, int h) {
		blocks[l][w][h] = Blocks.air.getDefaultState();

	}

}
