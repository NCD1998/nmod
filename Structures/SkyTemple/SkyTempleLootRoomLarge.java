package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleLootRoomLarge implements IRoom{
	//Name
	private final String NAME = "Sky Temple Large Loot Room";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.LOOT;
	//Box Sizer for this room
	private final BoxSizer sizer = new BoxSizer(8,8,5);
	//Possible Chest Locations
	private final int[][] possibleChestLocations = {{1,1,1},{1,7,1},{7,1,1},{7,7,1}};
	//Possible Loot Levels
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON, ChestRarity.SEMIRARE, ChestRarity.RARE};
	//Max Random Chests
	private final int maxChest = 4;
	//Min Random Chests
	private final int minChest = 2;
	//Block Schematic
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Main Floor Block
	private final IBlockState floorBase = Blocks.stonebrick.getDefaultState();
	//Main Wall Block
	private final IBlockState wallBase = Blocks.quartz_block.getDefaultState();
	//Design Block
	private final IBlockState designBlock = Blocks.quartz_block.getStateFromMeta(1);
	//Main Chest Block
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	//Table Block
	private final IBlockState tableBase = Blocks.stonebrick.getDefaultState();
	
	public SkyTempleLootRoomLarge(){
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
				blocks[length][0][height] = wallBase;
				blocks[length][sizer.getWidth() - 1][height] = wallBase;
			}
		}
		for(int width = 1; width < 7; width++){
			for(int height = 1; height < sizer.getHeight() - 1; height++){
				blocks[sizer.getLength() - 1][width][height] = wallBase;
			}
		}
		//Front wall normal layers
		for(int height = 1; height < sizer.getHeight() - 1; height++){
			blocks[0][1][height] = blocks[0][6][height] = wallBase;
			//Front wall Design Layer(full)
			blocks[0][2][height] = blocks[0][5][height] = designBlock;
		}
		//Front wall Design Layer(partial)
		blocks[0][3][3] = blocks[0][4][3] = designBlock;
		//Sunbeams
		for(int length = 2; length < 6; length++){
			for(int width = 2; width < 6; width++){
				blocks[length][width][sizer.getHeight() - 1] = NBlocks.SunBeamBlock.getDefaultState();
			}
		}
		//Table
		blocks[3][3][1] = blocks[3][4][1] = tableBase;
		//Chests
		blocks[3][3][2] = blocks[3][4][2] = chestBase;
		
		
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
		return possibleChestLocations;
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

}
