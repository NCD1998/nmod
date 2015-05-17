package com.ncd1998.nmod.Projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ElectronSnowballEntity extends EntitySnowball{

	public ElectronSnowballEntity(World worldIn, EntityLivingBase player) {
		super(worldIn, player);
	}
	@Override
	protected void onImpact(MovingObjectPosition movepos)
    {
		this.worldObj.createExplosion(this, this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), 15, true);
        if (movepos.entityHit != null)
        {
            byte b0 = 50;


            movepos.entityHit.attackEntityFrom(DamageSource.lightningBolt, b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
        this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        this.worldObj.addWeatherEffect((new EntityLightningBolt(this.worldObj, posX , getGroundBlock(this.getPosition(), this.worldObj) , posZ)));
        
    }
	
	public static double getGroundBlock(BlockPos pos, World world){
		double block = -1;
		for(int i = pos.getY(); i >= 0; i--){
			if(!world.isAirBlock(new BlockPos(pos.getX(), i, pos.getZ()))){
				block = i;
				i = -1;
			}
			
		}
		if(block != -1){
			return block;
		}else{
			return 0;
		}
	}

}
