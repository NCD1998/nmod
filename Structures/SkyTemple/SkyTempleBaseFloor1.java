package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Reference.Reference;
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
	//All Possible Door Locations
	private final int[][][] possibleDoorLocations = {{{8,0,1},{7,0,1},{8,0,2},{7,0,2}},{{15,7,2},{15,7,1},{15,8,1},{15,8,2}},{{7,15,1},{7,15,2},{8,15,1},{8,15,2}}};
	//Door Locations (Actuall)
	private int[][][] doorLocations;
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
	private final IBlockState chestBase = ReferenceSTBlocks.COMMONCHEST;
	//Random
	private Random rand = new Random();
	
	public SkyTempleBaseFloor1(){
		fillArray();
		addRandomChests();
		initiateDoors();
	}
	private void initiateDoors() {
		int actuallNumOfDoors = rand.nextInt(possibleDoorLocations.length);
		if(actuallNumOfDoors != 0){
		List doorList = new ArrayList();
		List choosenDoorList = new ArrayList();
		for(int i = 0; i <= actuallNumOfDoors; i++){
			doorList.add(possibleDoorLocations[i]);
		}
		for(int i = 0; i <= actuallNumOfDoors; i++){
				int choosenIndex = rand.nextInt(doorList.size());
				int[][] choosenDoor =(int[][]) doorList.remove(choosenIndex);
				choosenDoorList.add(choosenDoor);
				//Make a door Opening
				blocks[choosenDoor[0][0]][choosenDoor[0][1]][choosenDoor[0][2]] = Blocks.air.getDefaultState();
				blocks[choosenDoor[1][0]][choosenDoor[1][1]][choosenDoor[1][2]] = Blocks.air.getDefaultState();
				blocks[choosenDoor[2][0]][choosenDoor[2][1]][choosenDoor[2][2]] = Blocks.air.getDefaultState();
				blocks[choosenDoor[3][0]][choosenDoor[3][1]][choosenDoor[3][2]] = Blocks.air.getDefaultState();
		}
			doorLocations = new int[choosenDoorList.size()][4][3];
			for(int i = 0; i < choosenDoorList.size(); i++){
				doorLocations[i] = (int[][]) choosenDoorList.get(i);
			}
		}else{
			//HURRAY FOR EMPTY ARRAYS
			doorLocations = new int[0][0][0];	
		}
	}
	private void addRandomChests() {
		int actuallRandomChestNumber = rand.nextInt(maxChests - minChests + 1) + minChests;
		if(actuallRandomChestNumber != 0){
			List list = new ArrayList();
			for(int i = 0; i < possiblechestlocations.length; i++){
				list.add(possiblechestlocations[i]);
			}
			for(int i = 0; i <= actuallRandomChestNumber; i++){
				
				int[] current = (int[]) list.remove(rand.nextInt(list.size()));
				IBlockState currentChest;
				if(rand.nextInt(100) < 75){
					currentChest = ReferenceSTBlocks.COMMONCHEST;
				}else{
					currentChest = ReferenceSTBlocks.UNCOMMONCHEST;
				}
				blocks[current[0]][current[1]][current[2]] = currentChest;
			}
		}
		
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
	@Override
	public int[][][] getDoorLocations() {
		return doorLocations;
	}

}
