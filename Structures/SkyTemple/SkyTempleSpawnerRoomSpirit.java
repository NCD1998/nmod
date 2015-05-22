package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleSpawnerRoomSpirit implements IRoom{
	//Name
	private final String NAME = "Sky Temple Spirit Spawner Room";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.SPAWNER;
	//Box Sizer for this room
	private final BoxSizer sizer = new BoxSizer(8,8,5);
	//Block Schematic
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Main Floor Block
	private final IBlockState floorBase = Blocks.quartz_block.getDefaultState();
	//Main Wall Block
	private final IBlockState wallBase = Blocks.quartz_block.getDefaultState();
	//Main Chest Block
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	//Table Block
	private final IBlockState tableBase = Blocks.quartz_block.getStateFromMeta(1);
	//Glass Block
	private final IBlockState glassBase = Blocks.glass.getDefaultState();
	
	public SkyTempleSpawnerRoomSpirit(){
		fillOutArray();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				blocks[length][width][0] = floorBase;
			}
		}
		//Roof
				for(int length = 0; length < sizer.getLength(); length++){
					for(int width = 0; width < sizer.getWidth(); width++){
						blocks[length][width][sizer.getHeight() - 1] = wallBase;
					}
				}
		//Walls
		for(int length = 0; length < sizer.getLength(); length++){
			for(int height = 1; height < sizer.getHeight() - 1; height++){
				blocks[length][0][height] = glassBase;
				blocks[length][sizer.getWidth() - 1][height] = glassBase;
			}
		}
		for(int width = 1; width < 7; width++){
			for(int height = 1; height < sizer.getHeight() - 1; height++){
				blocks[sizer.getLength() - 1][width][height] = glassBase;
			}
		}
		//Front wall normal layers
		for(int height = 1; height < sizer.getHeight() - 1; height++){
			blocks[0][1][height] = blocks[0][6][height] = glassBase;
			blocks[0][2][height] = blocks[0][5][height] = glassBase;
		}
		blocks[0][3][3] = blocks[0][4][3] = glassBase;
		//Table
		blocks[3][3][1] = blocks[3][4][1] = blocks[4][3][1] = blocks[4][4][1] = tableBase;
		
		
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
	public RoomType getType() {
		return type;
	}

}
