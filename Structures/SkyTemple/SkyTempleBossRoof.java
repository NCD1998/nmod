package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;
import com.ncd1998.nmod.Util.MatrixTransformer;

public class SkyTempleBossRoof implements IRoom{
	//Name
		private final String NAME = "Sky Temple Boss Roof";
		//Type
		private final EnumSkyTempleRooms type = EnumSkyTempleRooms.BOSS;
		//Room Dimension Holder
		private final BoxSizer sizer = new BoxSizer(16,16,16);
		//All Possible chest Locations
		//!!!!!!!!!!!!!THIS ROOM HAS HARDCODED CHESTS AS WELL THAT ALWAYS SPAWN!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		private final int[][] possiblechestlocations = {{13,5,1},{13,10,1},{2,5,1},{2,10,1},{5,2,1},{10,2,1},{10,13,1},{5,13,1}};
		//All Possible levels of loot to spawn in the chests in this room
		private final ChestRarity[] lootLevels = {ChestRarity.UNCOMMON, ChestRarity.SEMIRARE, ChestRarity.RARE};
		//Max random chests to generate
		private final int maxChests = 4;
		//Min random chests to generate
		private final int minChests = 2;
		//The schematic array
		private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
		//Floor Block
		private final IBlockState floorBase = ReferenceSTBlocks.TEMPLESTONE;
		//Wall Block
		private final IBlockState wallBase = ReferenceSTBlocks.TEMPLESTONE;
		//Block to make tables out of
		private final IBlockState tableBlock = Blocks.quartz_block.getStateFromMeta(1);
		//Hardcoded Loot Boxes
		private final IBlockState chestBase = ReferenceSTBlocks.RARECHEST;
		//Glass Base
		private final IBlockState glassBase = ReferenceSTBlocks.TEMPLEGLASS;
		//Boss Spawner Block
		private final IBlockState bossSpawner = Blocks.diamond_block.getDefaultState();
		//Random
		private Random rand = new Random();
		
		public SkyTempleBossRoof(){
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
		//Cut out floor edges
		blocks[0][0][0] = blocks[1][0][0] = blocks[0][1][0] = Blocks.air.getDefaultState();
		blocks[0][15][0] = blocks[1][15][0] = blocks[0][14][0] = Blocks.air.getDefaultState();
		blocks[15][15][0] = blocks[14][15][0] = blocks[15][14][0] = Blocks.air.getDefaultState();
		blocks[15][0][0] = blocks[15][1][0] = blocks[14][0][0] = Blocks.air.getDefaultState();
		//Glass
				for(int length = 3; length < 7; length++){
					for(int width = 3; width < 7; width++){
						if(!(length == 3 && width == 3)){
							blocks[length][width][0] = glassBase;
						}
					}
				}
				for(int length = 3; length < 7; length++){
					for(int width = 9; width < 13; width++){
						if(!(length == 3 && width == 12)){
							blocks[length][width][0] = glassBase;
						}
					}
				}
				for(int length = 9; length < 13; length++){
					for(int width = 3; width < 7; width++){
						if(!(length == 12 && width == 3)){
							blocks[length][width][0] = glassBase;
						}
					}
				}
				for(int length = 9; length < 13; length++){
					for(int width = 9; width < 13; width++){
						if(!(length == 12 && width == 12)){
							blocks[length][width][0] = glassBase;
						}
					}
				}
		//Sun Beam Pillar
				for(int height = 0; height < 14; height++){
					blocks[7][7][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[7][8][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[8][7][height] = NBlocks.SunBeamBlock.getDefaultState();
					blocks[8][8][height] = NBlocks.SunBeamBlock.getDefaultState();
				}
				blocks[7][8][14] = blocks[8][7][14] = blocks[8][8][14] = NBlocks.SunBeamBlock.getDefaultState();
				blocks[8][8][15] = NBlocks.SunBeamBlock.getDefaultState();
		//Outer arcs
				for(int height = 1; height < 4; height++){
					blocks[2][4][height] = blocks[2][6][height] = blocks[9][2][height] = blocks[11][2][height] = wallBase;
					blocks[4][2][height] = blocks[6][2][height] = blocks[2][9][height] = blocks[2][11][height] = wallBase;
					blocks[4][13][height] = blocks[6][13][height] = blocks[13][9][height] = blocks[13][11][height] = wallBase;
					blocks[13][4][height] = blocks[13][6][height] = blocks[9][13][height] = blocks[11][13][height] = wallBase;
					
				}
				for(int width = 3; width < 13; width++){
					blocks[2][width][4] = wallBase;
					blocks[13][width][4] = wallBase;
				}
				for(int length = 3; length < 13; length++){
					blocks[length][2][4] = wallBase;
					blocks[length][13][4] = wallBase;
				}
				blocks[3][3][4] = blocks[3][12][4] = wallBase;
				blocks[12][3][4] = blocks[12][12][4] = wallBase;
			//CenterPiece
				for(int length = 5; length < 11; length++){
					blocks[length][10][1] = wallBase;
					blocks[length][9][1] = wallBase;
					blocks[length][8][1] = wallBase;
				}
				for(int length = 6; length < 11; length++){
					blocks[length][7][1] = wallBase;
					blocks[length][6][1] = wallBase;
				}
				for(int length = 8; length < 11; length++){
					blocks[length][5][1] = wallBase;
				}
				blocks[9][10][2] = blocks[10][10][2] = wallBase;
				for(int length = 6; length < 11; length++){
					blocks[length][9][2] = wallBase;
				}
				blocks[9][8][2] = blocks[9][7][2] = blocks[9][6][2] = wallBase;
				blocks[10][10][3] = wallBase;
				for(int length = 7; length < 10; length++){
					blocks[length][9][3] = wallBase;
				}
				blocks[9][8][3] = blocks[9][7][3] = wallBase;
				blocks[8][9][4] = blocks[9][9][4] = blocks[9][8][4]= wallBase;
				blocks[9][9][5] = wallBase;
			//Spawner Block
			blocks[9][9][6] = bossSpawner;
			//HARDCODED CHESTS
			blocks[7][10][2] = blocks[8][10][2] = blocks[10][7][2] = blocks[10][8][2] = chestBase;
			//Fix beam
			blocks[7][7][1] = blocks[7][8][1] = blocks[8][7][1] = blocks[8][8][1] = NBlocks.SunBeamBlock.getDefaultState();
		}
	private void addRandomChests() {
		int actuallRandomChestNumber = rand.nextInt(maxChests - minChests) + minChests;
		if(actuallRandomChestNumber != 0){
			List list = new ArrayList();
			for(int i = 0; i < possiblechestlocations.length; i++){
				list.add(possiblechestlocations[i]);
			}
			for(int i = 0; i < actuallRandomChestNumber; i++){
				
				int[] current = (int[]) list.remove(rand.nextInt(list.size()));
				IBlockState currentChest;
				int randomWeight = rand.nextInt(100);
				if(rand.nextInt(100) < 75){
					currentChest = ReferenceSTBlocks.SEMIRARECHEST;
				}else if(randomWeight < 90){
					currentChest = ReferenceSTBlocks.RARECHEST;
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
		int[][][] Thing = new int[0][0][0];
		return Thing;
	}

	public IBlockState[][][] getBlockArray(){
		return blocks;
	}
	
	public void build(World world, BlockPos pos){
		MatrixTransformer.buildStandard(blocks, world, pos);
	}
}
