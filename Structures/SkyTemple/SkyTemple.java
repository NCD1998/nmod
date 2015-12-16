package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.ncd1998.nmod.Structures.IGeneratableStructure;
import com.ncd1998.nmod.Structures.IRoom;
import com.ncd1998.nmod.Util.BoxSizer;

public class SkyTemple implements IGeneratableStructure{
	//Name
	private final String NAME = "SkyTemple";
	//Random Object
	private Random rand = new Random();
	
	
	@Override
	public String getName(){
		return NAME;
	}
	
	public static void generate(World world, BlockPos startpos){
		SkyTempleEntry entry = new SkyTempleEntry();
		entry.build(world, startpos);
		BlockPos builderPointer = startpos.add(16,0,0);
		SkyTempleBaseFloor1 floor1 = new SkyTempleBaseFloor1();
		
		
		
		floor1.build(world, builderPointer);
		builderPointer.add(0,16,0);
		SkyTempleBaseFloor2 floor2 = new SkyTempleBaseFloor2();
		floor2.build(world, builderPointer);
		builderPointer.add(0,16,0);
		SkyTempleBaseFloor3 floor3 = new SkyTempleBaseFloor3();
		floor3.build(world, builderPointer);
		builderPointer.add(0,16,0);
		SkyTempleBossRoof bossfloor = new SkyTempleBossRoof();
		bossfloor.build(world, builderPointer);
	}

	
	
}
