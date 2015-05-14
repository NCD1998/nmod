package com.ncd1998.nmod.Proxy;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public interface IProxy {
	public void genererateBurst(BlockPos pos, World world, EnumParticleTypes type);
}
