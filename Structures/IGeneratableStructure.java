package com.ncd1998.nmod.Structures;

public interface IGeneratableStructure {
	/**
	 * Returns the name of the structure
	 * @return String containing name of the structure
	 */
	public String getName();
	/**
	 * Returns the maximum number of rooms that are not essential/ all ways generated
	 * @return Max amount of random rooms
	 */
	public int getMaxRandomRooms();
	/**
	 * Returns the minimum number of rooms that are not essential/ all ways generated
	 * @return Minimum number of random rooms
	 */
	public int getMinRandomRooms();
}
