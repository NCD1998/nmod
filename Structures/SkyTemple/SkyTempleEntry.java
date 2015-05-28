package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class SkyTempleEntry implements IRoom{
	//Name
	private final String NAME = "SkyTempleEntry";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.ENTRY;
	//Box Size that Room is limited to 
	private final BoxSizer sizeLimits = new BoxSizer(16,16,16);
	//Blockstate array;
	private IBlockState[][][] blocks;
	//Block to use as floor of room
	private final IBlockState baseFloorMaterial = ReferenceSTBlocks.BRICKMATERIAL;;
	//Block to use as walls of room
	private final IBlockState baseWallMaterial = ReferenceSTBlocks.TEMPLESTONE;
	//Block to use as ceiling of room
	private final IBlockState baseRoofMaterial = ReferenceSTBlocks.TEMPLEGLASS;
	//Blocks to carpet the room's floor in
	private final IBlockState baseCarpetColor = Blocks.carpet.getStateFromMeta(11);
	//Blocks to create a design in the rooms carpet with
	private final IBlockState designCarpetColor = Blocks.carpet.getStateFromMeta(0);
	//Possible locations for chests to spawn
	private final int[][] POSSIBLECHESTLOCATIONS = {{6,5,1},{1,10,1},{12,10,1}};
	//Possible levels of loot to spawn
	private final ChestRarity[] possibleLootLevels = {ChestRarity.COMMON};
	//Maximum amount of chests to spawn, can not be greater than the amount of locations specified
	private final int maxChests = 2;
	//Minimum amount of chests to spawn, can be 0, cannot be greater than maxChests
	private final int minChests = 1;
	//Random
	private Random rand = new Random();
	/*
	 * Room Description:
	 * A 16x8x8 Hallway
	 * Carpeted, with design
	 */
	public SkyTempleEntry(){
		fillOutArray();
		addRandomChests();
	}
	
	
	public String getName(){
		return NAME;
	}
	public BoxSizer getDimensions(){
		return sizeLimits;
	}
	/**
	 * Generates the BlockStructureArray
	 */
	private void fillOutArray(){
		blocks = new IBlockState[16][16][16];
		//Fillout floor
		for(int length = 0; length <= 15; length++){
			for(int width = 4; width <= 11; width++){
				blocks[length][width][0] = baseFloorMaterial;
			}
		}
		//Lengthwise walls
		for(int length = 0; length <= 15; length++){
			for(int height = 1; height <= 8; height++){
				blocks[length][4][height] = baseWallMaterial;
			}
		}
		for(int length = 0; length <= 15; length++){
			for(int height = 1; height <= 8; height++){
				blocks[length][11][height] = baseWallMaterial;
			}
		}
		//Fillout Cieling
		for(int length = 0; length <= 15; length++){
			for(int width = 5; width <= 10; width++){
				blocks[length][width][8] = baseRoofMaterial;
			}
		}
		//Construct Enterence
			//Build Walls
		for(int width = 5; width <= 11; width++){
			for(int height = 1; height <=8; height++){
				blocks[0][width][height] = baseWallMaterial;
			}
		}
			//Clear Path
		for(int width = 6; width <= 9; width++){
			for(int height = 1; height <= 4; height++){
				blocks[0][width][height] = Blocks.air.getDefaultState();
			}
		}
		//Carpet the floor
			//Fill entry Carpet
				//Doorway base
		for(int width = 6; width <= 9; width++){
			blocks[0][width][1] = baseCarpetColor;
		}
				//Doorway design
		blocks[0][6][1] = blocks[0][9][1] = designCarpetColor;
			//Fill main area
				//Base Color
		for(int width = 5; width <= 10; width++){
			for(int length = 1; length <= 15; length++){
				blocks[length][width][1] = baseCarpetColor;
			}
		}
				//Design Color
		blocks[1][5][1] = blocks[2][5][1] = blocks[3][5][1] = blocks[4][5][1] = blocks[8][5][1] = blocks[9][5][1] = blocks[10][5][1] = blocks[13][5][1] = blocks[14][5][1] = blocks[15][5][1] = designCarpetColor;
		blocks[1][6][1] = blocks[2][6][1] = blocks[5][6][1] = blocks[7][6][1] = blocks[11][6][1] = blocks[13][6][1] = designCarpetColor;
		blocks[5][7][1] = blocks[6][7][1] = blocks[12][7][1] = blocks[13][7][1] = designCarpetColor;
		blocks[5][8][1] = blocks[6][8][1] = blocks[12][8][1] = blocks[13][8][1] = designCarpetColor;
		blocks[1][9][1] = blocks[2][9][1] = blocks[5][9][1] = blocks[7][9][1] = blocks[11][9][1] = blocks[13][9][1] = designCarpetColor;
		blocks[1][10][1] = blocks[2][10][1] = blocks[3][10][1] = blocks[4][10][1] = blocks[8][10][1] = blocks[9][10][1] = blocks[10][10][1] = blocks[13][10][1] = blocks[14][10][1] = blocks[15][10][1] = designCarpetColor;
		
	}
	private void addRandomChests() {
		int actuallRandomChestNumber = rand.nextInt(maxChests - minChests) + minChests;
		if(actuallRandomChestNumber != 0){
			List list = new ArrayList();
			for(int i = 0; i < POSSIBLECHESTLOCATIONS.length; i++){
				list.add(POSSIBLECHESTLOCATIONS[i]);
			}
			for(int i = 0; i <= actuallRandomChestNumber; i++){
				
				int[] current = (int[]) list.remove(rand.nextInt(list.size()));
				blocks[current[0]][current[1]][current[2]] = ReferenceSTBlocks.COMMONCHEST;
			}
		}
		
	}
	public int[][] getPossibleChestLocations(){
		return POSSIBLECHESTLOCATIONS;
	}
	public ChestRarity[] getPossibleLootLevels(){
		return possibleLootLevels;
	}
	public IBlockState getBlock(int l, int w, int h){
		return blocks[l][w][h];
	}
	public int getMaxChests(){
		return maxChests;
	}
	public int getMinChests(){
		return minChests;
	}


	@Override
	public RoomType getType() {
		return type;
	}
}
