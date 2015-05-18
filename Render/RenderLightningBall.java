package com.ncd1998.nmod.Render;

import com.ncd1998.nmod.nmod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLightningBall extends Render {

private static final ResourceLocation textureLocation = new ResourceLocation(nmod.MODID + ":" + "textures/models/LightningBallModel.png");

public RenderLightningBall(RenderManager manager) {
super(manager);
}

@Override
protected ResourceLocation getEntityTexture(Entity par1Entity)
{
return textureLocation;
}
}