package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
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
	//Glass Block
	private final IBlockState glassBase = ReferenceSTBlocks.TEMPLEGLASS;
	//Random
	private Random rand = new Random();
	
	public SkyTempleClosedJunction(){
		fillOutArray();
		addRandomChests();
	}
	private void fillOutArray() {
		//Floor Edges and ceiling edges
		for(int length = 0; length < sizer.getLength(); length++){
			blocks[length][0][0] = blocks[length][sizer.getWidth() - 1][0] = wallBase;
			blocks[length][0][sizer.getHeight() - 1] = blocks[length][sizer.getWidth() - 1][sizer.getHeight() - 1] = wallBase;
		}
		for(int width = 0; width < sizer.getWidth(); width++){
			blocks[0][width][0] = blocks[sizer.getLength() - 1][width][0] = wallBase;
			blocks[0][width][sizer.getHeight() - 1] = blocks[sizer.getLength() - 1][width][sizer.getHeight() - 1] = wallBase;
		}
		//Glass Floor
		for(int length = 1; length < sizer.getLength() - 1; length++){
			for(int width = 1; width < sizer.getWidth() - 1; width++){
				blocks[length][width][0] = glassBase;
			}
		}
		//Center Column
		for(int height = 0; height < sizer.getHeight(); height++){
			blocks[3][3][height] = blocks[3][4][height] = blocks[4][3][height] = blocks[4][4][height] = wallBase;
		}
		//Doorways
			//pillar
			for(int height = 1; height < sizer.getHeight(); height++){
				blocks[0][2][height] = blocks[0][5][height] = wallBase;
				blocks[7][2][height] = blocks[7][5][height] = wallBase;
				blocks[2][0][height] = blocks[5][0][height] = wallBase;
				blocks[2][7][height] = blocks[5][7][height] = wallBase;
			}
			//Arc
			blocks[0][3][sizer.getHeight() - 1] = blocks[0][4][sizer.getHeight() - 1] = blocks[0][3][sizer.getHeight() - 2] = blocks[0][4][sizer.getHeight() - 2] = wallBase;
			blocks[7][3][sizer.getHeight() - 1] = blocks[7][4][sizer.getHeight() - 1] = blocks[7][3][sizer.getHeight() - 2] = blocks[7][4][sizer.getHeight() - 2] = wallBase;
			blocks[3][0][sizer.getHeight() - 1] = blocks[4][0][sizer.getHeight() - 1] = blocks[3][0][sizer.getHeight() - 2] = blocks[4][0][sizer.getHeight() - 2] = wallBase;
			blocks[3][7][sizer.getHeight() - 1] = blocks[4][7][sizer.getHeight() - 1] = blocks[3][7][sizer.getHeight() - 2] = blocks[4][7][sizer.getHeight() - 2] = wallBase;
		//GlassWalls
		for(int height = 1; height < sizer.getHeight() - 1; height++){
			blocks[0][0][height] = blocks[0][1][height] = blocks[1][0][height] = glassBase;
			blocks[7][7][height] = blocks[7][6][height] = blocks[6][7][height] = glassBase;
			blocks[0][7][height] = blocks[1][7][height] = blocks[0][6][height] = glassBase;
			blocks[7][0][height] = blocks[7][1][height] = blocks[6][0][height] = glassBase;
		}
		//Sunbeam Roof
		for(int length = 1; length < sizer.getLength() - 1; length++){
			for(int width = 1; width < sizer.getWidth() - 1; width++){
				if(!((length == 3 && width == 3) || (length == 3 && width == 4) || (length == 4 && width == 3) ||(length == 4 && width == 4))){
					blocks[length][width][sizer.getHeight() - 1] = NBlocks.SunBeamBlock.getDefaultState();
				}
			}
		}
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
