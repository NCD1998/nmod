package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleLootRoomMedium implements IRoom{
	//Name
	private final String NAME = "Sky Temple Medium Loot Room";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.LOOT;
	//Box Sizer for this room
	private final BoxSizer sizer = new BoxSizer(6,6,6);
	//Possible Loot Levels
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON, ChestRarity.SEMIRARE, ChestRarity.RARE};
	//Door Locations
	private final int[][][] doorLocations = {{{2,0,1},{3,0,1},{2,0,2},{3,0,2}},{{0,2,1},{0,3,1},{0,2,2},{0,3,2}},{{2,5,1},{3,5,1},{2,5,2},{3,5,2}},{{5,2,1},{5,3,1},{5,2,2},{5,3,2}}};
	//Block Schematic
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Main Floor Block
	private final IBlockState floorBase = ReferenceSTBlocks.TEMPLESTONE;
	//Main Wall Block
	private final IBlockState wallBase = Blocks.quartz_block.getStateFromMeta(2);
	//Main Chest Block
	private final IBlockState chestBase;
	//Random
	private Random rand = new Random();
	
	public SkyTempleLootRoomMedium(){
		int chestrare = rand.nextInt(100);
		if(chestrare < 50){
			chestBase = ReferenceSTBlocks.COMMONCHEST;
		}else if(chestrare < 75){
			chestBase = ReferenceSTBlocks.UNCOMMONCHEST;
		}else if(chestrare < 90){
			chestBase = ReferenceSTBlocks.SEMIRARECHEST;
		}else{
			chestBase = ReferenceSTBlocks.RARECHEST;
		}
		fillOutArray();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				blocks[length][width][0] = floorBase;
			}
		}
		//Pillars
		for(int height = 1; height < sizer.getHeight() - 1; height++){
			blocks[0][0][height] = wallBase;
			blocks[0][sizer.getWidth() - 1][height] = wallBase;
			blocks[sizer.getLength() - 1][0][height] = wallBase;
			blocks[sizer.getLength() - 1][sizer.getWidth() - 1][height] = wallBase;
		}
		//Arch
		for(int length = 0; length < sizer.getLength(); length++){
			blocks[length][0][sizer.getHeight() - 1] = floorBase;
			blocks[length][sizer.getWidth() - 1][sizer.getHeight() - 1] = floorBase;
		}
		for(int width = 1; width < sizer.getWidth() - 1; width++){
			blocks[0][width][sizer.getHeight() - 1] = floorBase;
			blocks[sizer.getLength() - 1][width][sizer.getHeight() - 1] = floorBase;
		}
		//Chests
		blocks[1][1][1] = blocks[4][1][1] = blocks[1][4][1] = blocks[4][4][1] = chestBase;
		
	}
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public BoxSizer getDimensions() {
		return sizer;
	}

	//No possible Random Chest Locations!
	@Override
	public int[][] getPossibleChestLocations() {
		return null;
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
		return 0;
	}

	@Override
	public int getMinChests() {
		return 0;
	}

	@Override
	public RoomType getType() {
		return type;
	}
	@Override
	public int[][][] getDoorLocations() {
		return doorLocations;
	}
	
	public IBlockState[][][] getBlockArray(){
		return blocks;
	}

}
