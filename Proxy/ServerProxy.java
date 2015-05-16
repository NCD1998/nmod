package com.ncd1998.nmod.Proxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ServerProxy extends CommonProxy{

	@Override
	public void genererateBurst(BlockPos pos, World world,
			EnumParticleTypes type) {
		// NOOP
		
	}

	@Override
	public void registerRenders() {
		//NOOP
		
	}

	@Override
	public void genererateBurst(BlockPos pos, World world,
			EnumParticleTypes type, int num1, int num2, int num3) {
		//NOOP
		
	}


}
