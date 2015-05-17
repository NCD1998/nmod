package com.ncd1998.nmod.Projectile;

import javax.swing.text.html.parser.Entity;

import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ShootingStarEntity extends EntityFireball{

	public ShootingStarEntity(World worldIn) {
		super(worldIn);
		
	}
	public ShootingStarEntity(World worldIn, EntityLivingBase shooter,
			double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		
	}
	public ShootingStarEntity(World worldIn, int x, int y, int z,
			double accelX, double accelY, double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
		
	}

	@Override
	protected void onImpact(MovingObjectPosition movingObject) {
		/*if(this.worldObj.isRemote){
			ParticleHelper.burstOut(movingObject.getBlockPos(), this.worldObj, EnumParticleTypes.FLAME);
			ParticleHelper.upwardBeam(movingObject.getBlockPos(), this.worldObj, EnumParticleTypes.FLAME);
		}*/
		if(movingObject.entityHit != null && !movingObject.entityHit.equals(this.shootingEntity)){
			
		
		this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 5.0F, false, true);
		
		if(!this.worldObj.isRemote){
			if (movingObject.entityHit != null){
				byte b10 = 10;
				movingObject.entityHit.setFire(10);
				movingObject.entityHit.attackEntityFrom(DamageSource.magic, b10);
			}
		}
		this.setDead();
		
		}else{
			this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 5.0F, false, true);
			ParticleHelper.burstOut(this.getPosition(), this.worldObj, EnumParticleTypes.SMOKE_NORMAL);
			if(!this.worldObj.isRemote){
				if (movingObject.entityHit != null){
					byte b10 = 10;
					movingObject.entityHit.attackEntityFrom(DamageSource.magic, b10);
				}
			}
			this.setDead();
		}
		
		
	}

}
