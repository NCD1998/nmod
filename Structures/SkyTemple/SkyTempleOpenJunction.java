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

public class SkyTempleOpenJunction extends Bridge implements IRoom {
	//Name
	private final String NAME = "Sky Temple Open Junction";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.JUNCTION;
	//Room Dimension Holder
	private final BoxSizer sizer = new BoxSizer(8,8,2);
	//Possible Chest Locations
	private final int[][] possiblechestlocations = {{1,2,1},{2,1,1},{6,2,1},{5,1,1},{1,5,1},{2,6,1},{5,6,1},{6,5,1}};
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
	
	public SkyTempleOpenJunction(){
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
			//Remove Corners
			blocks[0][0][0] = blocks[0][1][0] = blocks[1][0][0] = Blocks.air.getDefaultState();
			blocks[0][7][0] = blocks[0][6][0] = blocks[1][7][0] = Blocks.air.getDefaultState();
			blocks[7][0][0] = blocks[6][0][0] = blocks[7][1][0] = Blocks.air.getDefaultState();
			blocks[7][6][0] = blocks[6][7][0] = blocks[7][7][0] = Blocks.air.getDefaultState();
			//Glass Middle
			for(int length = 2; length < 6; length++){
				for(int width = 2; width < 6; width++){
					blocks[length][width][0] = glassBase;
				}
			}
			blocks[0][2][1] = blocks[1][1][1] = blocks[2][0][1] = wallBase;
			blocks[0][5][1] = blocks[1][6][1] = blocks[2][7][1] = wallBase;
			blocks[5][0][1] = blocks[6][1][1] = blocks[7][2][1] = wallBase;
			blocks[7][5][1] = blocks[6][6][1] = blocks[5][7][1] = wallBase;
		
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
	public void setEroded(int l, int w, int h) {
		blocks[l][w][h] = Blocks.air.getDefaultState();
	}
	@Override
	public RoomType getType() {
		return type;
	}

}
