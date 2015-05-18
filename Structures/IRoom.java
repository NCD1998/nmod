package com.ncd1998.nmod.Structures;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.ncd1998.nmod.Util.BoxSizer;
import com.ncd1998.nmod.Util.ChestRarity;

public interface IRoom {
	/**
	 * Get the name of the room.
	 * @return String containing room name
	 */
	public String getName();
	/**
	 * Gets the BoxSizer Object used for getting the box dimensions of the room.
	 * @return BoxSizer containing the constraints of the room
	 */
	public BoxSizer getDimensions();
	/**
	 * Returns possible locations in the room for chests
	 * @return an int[][] with the outer array holding int arrays that represent relative locations in the room
	 */
	public int[][] getPossibleChestLocations();
	/**
	 * Returns an array to be used in determining loot in the chests in the room
	 * @return an array of ChestRarity values
	 */
	public ChestRarity[] getPossibleLootLevels();
}
