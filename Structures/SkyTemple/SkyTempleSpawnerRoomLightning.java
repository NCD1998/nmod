package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleSpawnerRoomLightning implements IRoom{
	//Name
	private final String NAME = "Sky Temple Lightning Spawner Room";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.SPAWNER;
	//Box Sizer for this room
	private final BoxSizer sizer = new BoxSizer(8,8,5);
	//Block Schematic
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Main Floor Block
	private final IBlockState floorBase = ReferenceSTBlocks.TEMPLESTONE;
	//Main Wall Block
	private final IBlockState wallBase = ReferenceSTBlocks.TEMPLESTONE;
	//Main Chest Block
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	//Table Block
	private final IBlockState tableBase = Blocks.quartz_block.getStateFromMeta(1);
	//Glass Block - Wall and Floor
	private final IBlockState glassBaseWF = ReferenceSTBlocks.SPIRITGLASS;
	//Glass Block - Ceiling
	private final IBlockState glassBaseC = ReferenceSTBlocks.TEMPLEGLASS;
	
	public SkyTempleSpawnerRoomLightning(){
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
			for(int height = 0; height < sizer.getHeight(); height++){
				blocks[length][0][height] = wallBase;
				blocks[length][sizer.getWidth() - 1][height] = wallBase;
			}
		}
		for(int width = 0; width < sizer.getWidth(); width++){
			for(int height = 0; height < sizer.getHeight(); height++){
				blocks[0][width][height] = wallBase;
				blocks[sizer.getLength() - 1][width][height] = wallBase;
			}
		}
		//Glass on Cieling and floor
		for(int width = 2; width < 6; width++){
			blocks[1][width][0] = glassBaseWF;
			blocks[1][width][sizer.getHeight() - 1] = glassBaseC;
			blocks[6][width][0] = glassBaseWF;
			blocks[6][width][sizer.getHeight() - 1] = glassBaseC;
		}
		for(int length = 2; length < 6; length++){
			blocks[length][1][0] = glassBaseWF;
			blocks[length][1][sizer.getHeight() - 1] = glassBaseC;
			blocks[length][6][0] = glassBaseWF;
			blocks[length][6][sizer.getHeight() - 1] = glassBaseC;
		}
		for(int width = 3; width < 5; width++){
			blocks[2][width][0] = glassBaseWF;
			blocks[2][width][sizer.getHeight() - 1] = glassBaseC;
			blocks[5][width][0] = glassBaseWF;
			blocks[5][width][sizer.getHeight() - 1] = glassBaseC;
		}
		for(int length = 3; length < 5; length++){
			blocks[length][2][0] = glassBaseWF;
			blocks[length][2][sizer.getHeight() - 1] = glassBaseC;
			blocks[length][5][0] = glassBaseWF;
			blocks[length][5][sizer.getHeight() - 1] = glassBaseC;
		}
		//Glass in three non door walls
		for(int height = 1; height < 4; height++){
			blocks[2][0][height] = glassBaseWF;
			blocks[5][0][height] = glassBaseWF;
			blocks[2][sizer.getWidth() - 1][height] = glassBaseWF;
			blocks[5][sizer.getWidth() - 1][height] = glassBaseWF;
			blocks[7][2][height] = glassBaseWF;
			blocks[7][5][height] = glassBaseWF;
			blocks[0][2][height] = glassBaseWF;
			blocks[0][5][height] = glassBaseWF;
		}
		blocks[0][3][3] = glassBaseWF;
		blocks[0][4][3] = glassBaseWF;
		blocks[0][3][1] = blocks[0][3][2] = blocks[0][4][1] = blocks[0][4][2] = Blocks.air.getDefaultState();
		
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
