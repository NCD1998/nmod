package com.ncd1998.nmod.Proxy;

import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy{

	@Override
	public void genererateBurst(BlockPos pos, World world,
			EnumParticleTypes type) {
		ParticleHelper.burstOut(pos, world, type);
		
	}
	

}
