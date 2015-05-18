package com.ncd1998.nmod.Proxy;

import com.ncd1998.nmod.Entities.LightningBall;
import com.ncd1998.nmod.Render.RenderLightningBall;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void genererateBurst(BlockPos pos, World world,
			EnumParticleTypes type) {
		ParticleHelper.burstOut(pos, world, type);
		
	}
	

	@Override
	public void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(LightningBall.class, new RenderLightningBall(Minecraft.getMinecraft().getRenderManager()));
		
	}
	@Override
	public void genererateBurst(BlockPos pos, World world,
			EnumParticleTypes type, int num1, int num2, int num3) {
		ParticleHelper.burstOut(pos, world, type, num1, num2, num3);
		
	}
	

}
