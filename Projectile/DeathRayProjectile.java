package com.ncd1998.nmod.Projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class DeathRayProjectile extends EntityWitherSkull{

	public DeathRayProjectile(World worldIn, double xpos,
			double ypos, double zpos, double xrot,
			double yrot, double zrot) {
		super(worldIn, xpos, ypos, zpos, xrot, yrot,
				zrot);
		
	}
	@Override
	protected void onImpact(MovingObjectPosition movingObject){
		if (!this.worldObj.isRemote)
        {
            if(movingObject.typeOfHit == MovingObjectType.ENTITY){
            	movingObject.entityHit.setDead();
            	movingObject.entityHit.attackEntityFrom(DamageSource.cactus, 100000);
            }
        }

            this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 10.0F, false, true);
            this.setDead();
	}
	protected float getMotionFactor()
    {
        return 1F;
    }

}
