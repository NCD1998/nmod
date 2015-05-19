package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;

import com.ncd1998.nmod.Structures.IGeneratableStructure;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Util.BoxSizer;

public class SkyTemple implements IGeneratableStructure{
	//Name
	private final String NAME = "SkyTemple";
	//Maximum Number of Random Rooms
	private final int maxRandomRooms = 9;
	//Minimum Number of Random Rooms
	private final int minRandomRooms = 5;
	//Structure layout
	private IBlockState[][][] structureBlocks;
	//Bounds of Structure
	private BoxSizer structureSizer;
	//Actuall Number of Random Rooms
	private final int RandomRooms;
	//Random Object
	private Random rand = new Random();
	//Entry way
	private final IRoom entry;
	//Room Array
	List<IRoom> rooms = new ArrayList();
	
	SkyTemple(){
		RandomRooms = rand.nextInt(10) - minRandomRooms;
		entry = new SkyTempleEntry();
		rooms.add(entry);
	}
	
	@Override
	public String getName(){
		return NAME;
	}

	@Override
	public int getMaxRandomRooms() {
		return maxRandomRooms;
	}

	@Override
	public int getMinRandomRooms() {
		return minRandomRooms;
	}
	
	
}
