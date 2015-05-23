package com.ncd1998.nmod.Structures.SkyTemple;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Structures.RoomType;
import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public class SkyTempleLootRoomSmall implements IRoom{
	//Name
	private final String NAME = "Sky Temple Small Loot Room";
	//Type
	private final EnumSkyTempleRooms type = EnumSkyTempleRooms.LOOT;
	//Box Sizer for this room
	private final BoxSizer sizer = new BoxSizer(4,4,4);
	//Possible Loot Levels
	private final ChestRarity[] lootLevels = {ChestRarity.COMMON, ChestRarity.UNCOMMON, ChestRarity.SEMIRARE, ChestRarity.RARE};
	//Block Schematic
	private final IBlockState[][][] blocks = new IBlockState[sizer.getLength()][sizer.getWidth()][sizer.getHeight()];
	//Main Floor Block
	private final IBlockState floorBase = ReferenceSTBlocks.BRICKMATERIAL;
	//Main Wall Block
	private final IBlockState wallBase = ReferenceSTBlocks.TEMPLESTONE;
	//Main Glass Block
	private final IBlockState glassBase = ReferenceSTBlocks.TEMPLEGLASS;
	//Main Slab Block
	private final IBlockState slabBase = Blocks.stone_slab.getStateFromMeta(5);
	//Main Chest Block
	private final IBlockState chestBase = Blocks.chest.getDefaultState();
	
	public SkyTempleLootRoomSmall(){
		fillOutArray();
	}
	private void fillOutArray() {
		//Floor
		for(int length = 0; length < sizer.getLength(); length++){
			for(int width = 0; width < sizer.getWidth(); width++){
				blocks[length][width][0] = floorBase;
			}
		}
		//Walls
		for(int length = 0; length < sizer.getLength(); length++){
			for(int height = 1; height < sizer.getHeight(); height++){
				blocks[length][0][height] = wallBase;
				blocks[length][sizer.getWidth() - 1][height] = wallBase;
			}
		}
		for(int width = 1; width < 3; width++){
			for(int height = 1; height < sizer.getHeight(); height++){
				blocks[sizer.getLength() - 1][width][height] = wallBase;
			}
		}
		//Glass Cieling
		for(int length = 0; length < sizer.getLength() - 1; length++){
			blocks[length][1][sizer.getHeight() - 1] = glassBase;
			blocks[length][2][sizer.getHeight() - 1] = glassBase;
		}
		blocks[1][1][1] =  blocks[1][2][1] = slabBase;
		blocks[2][1][1] = blocks[2][2][1] = NBlocks.SunBeamBlock.getDefaultState();
		blocks[2][1][2] = blocks[2][2][2] = chestBase;
		
		
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

}
