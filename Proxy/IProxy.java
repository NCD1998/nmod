package com.ncd1998.nmod.Proxy;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public interface IProxy {
	public void genererateBurst(BlockPos pos, World world, EnumParticleTypes type);
	public void genererateBurst(BlockPos pos, World world, EnumParticleTypes type, int num1, int num2, int num3);
	public void registerRenders();
}
