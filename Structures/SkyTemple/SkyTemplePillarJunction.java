package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTemplePillarJunction extends Bridge implements IRoom {
	//Name
	private final String NAME = "Sky Temple Pillar Junction";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.JUNCTION;
	//Room Dimension Holder
	private final BoxSizer sizer = new BoxSizer(8,8,6);
	//Possible Chest Locations
	private final int[][] possiblechestlocations = {{1,1,1},{1,6,1},{6,6,1},{6,1,1}};
	//DoorLocations
	private final int[][][] doorLocations = {{{3,0,1},{4,0,1},{3,0,2},{4,0,2}},{{0,3,1},{0,4,1},{0,3,2},{0,4,2}},{{3,7,1},{4,7,1},{3,7,2},{4,7,2}},{{7,3,1},{7,4,1},{7,3,2},{7,4,2}}};
	//Possible loot levels
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON};
	//Max Random Chests
	private final int maxChest = 1;
	//Min Random Chests
	private final int minChest = 0;
	//The schematic array
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Floor Block
	private final IBlockState floorBase = ReferenceSTBlocks.TEMPLESTONE;
	//Wall Block
	private final IBlockState wallBase = ReferenceSTBlocks.TEMPLESTONE;
	//Pillar Block
	private final IBlockState pillarBase = Blocks.quartz_block.getStateFromMeta(2);
	//Slab Blocks
	private final IBlockState slabBase = Blocks.stone_slab.getStateFromMeta(7);
	//Fluid Block
	private final IBlockState waterBlock = Blocks.flowing_water.getDefaultState();
	//Random
	private Random rand = new Random();
	public SkyTemplePillarJunction(){
		fillOutArray();
		addRandomChests();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				blocks[length][width][0] = floorBase;
			}
		}
		//Pillars
		for(int height = 1; height < 4; height++){
			blocks[0][0][height] = blocks[0][2][height] = blocks[0][5][height] = blocks[0][7][height] = pillarBase;
			blocks[2][0][height] = blocks[2][7][height] = pillarBase;
			blocks[5][0][height] = blocks[5][7][height] = pillarBase;
			blocks[7][7][height] = blocks[7][5][height] = blocks[7][2][height] = blocks[7][0][height] = pillarBase;
		}
		//Bottom Arch level
			for(int width = 0; width < 3; width++){
				blocks[0][width][4] = wallBase;
				blocks[7][width][4] = wallBase;
			}
			for(int width = 5; width < 8; width++){
				blocks[0][width][4] = wallBase;
				blocks[7][width][4] = wallBase;
			}
			for(int length = 1; length < 3; length++){
				blocks[length][0][4] = wallBase;
				blocks[length][7][4] = wallBase;
			}
			for(int length = 5; length < 7; length++){
				blocks[length][0][4] = wallBase;
				blocks[length][7][4] = wallBase;
			}
		//Top arch Layer
			//Slabs
			blocks[0][0][5] = blocks[0][1][5] = blocks[1][0][5] = slabBase;
			blocks[7][7][5] = blocks[7][6][5] = blocks[6][7][5] = slabBase;
			blocks[0][7][5] = blocks[0][6][5] = blocks[1][7][5] = slabBase;
			blocks[7][0][5] = blocks[6][0][5] = blocks[7][1][5] = slabBase;
			//SolidBlocks
			for(int width = 2; width < 6; width++){
				blocks[0][width][5] = wallBase;
				blocks[7][width][5] = wallBase;
			}
			for(int length = 2; length < 6; length++){
				blocks[length][0][5] = wallBase;
				blocks[length][7][5] = wallBase;
			}
		//Center Fountain
			for(int width = 2; width < 6; width++){
				blocks[1][width][1] = slabBase;
				blocks[6][width][1] = slabBase;
			}
			for(int length = 2; length < 6; length++){
				blocks[length][1][1] = slabBase;
				blocks[length][6][1] = slabBase;
			}
			for(int height = 1; height < 3; height++){
				blocks[3][3][height] = blocks[3][4][height] = blocks[4][3][height] = blocks[4][4][height] = wallBase;
			}
			blocks[3][3][3] = blocks[3][4][3] = blocks[4][3][3] = blocks[4][4][3] = waterBlock;
			
		
	}
	private void addRandomChests() {
		int actuallRandomChestNumber = rand.nextInt(maxChest - minChest + 1) + minChest;
		if(actuallRandomChestNumber != 0){
			List list = new ArrayList();
			for(int i = 0; i < possiblechestlocations.length; i++){
				list.add(possiblechestlocations[i]);
			}
			for(int i = 0; i <= actuallRandomChestNumber; i++){
				
				int[] current = (int[]) list.remove(rand.nextInt(list.size()));
				IBlockState currentChest;
				int randomWeight = rand.nextInt(100);
				if(rand.nextInt(100) < 75){
					currentChest = ReferenceSTBlocks.COMMONCHEST;
				}else{
					currentChest = ReferenceSTBlocks.UNCOMMONCHEST;
				}
				blocks[current[0]][current[1]][current[2]] = currentChest;
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
	@Override
	public int[][][] getDoorLocations() {
		return doorLocations;
	}
	
	public IBlockState[][][] getBlockArray(){
		return blocks;
	}

}
