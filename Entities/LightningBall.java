package com.ncd1998.nmod.Entities;

import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class LightningBall extends EntityMob{

	public LightningBall(World worldIn) {
		super(worldIn);
		this.setSize(.5F, .5F);
		this.tasks.addTask(0, new EntityAIWander(this, 1));
		this.setEntityBoundingBox(new AxisAlignedBB(this.getPosition().add(-1,-1,-1), this.getPosition().add(1,1,1)));
		this.setAIMoveSpeed(.3F);
		this.setInvisible(true);
		this.setHealth(1F);
	}
	public void onUpdate(){
		if(this.worldObj.getWorldTime() < 13000){
			this.setDead();
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() + modif, this.getPosition().getY()  + .5 + modif, this.getPosition().getZ() + modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() - modif, this.getPosition().getY() + .5 + modif, this.getPosition().getZ() - modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() + modif, this.getPosition().getY() + .5 + modif, this.getPosition().getZ() - modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() - modif, this.getPosition().getY() + .5 + modif, this.getPosition().getZ() + modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() + modif, this.getPosition().getY() + .5   - modif, this.getPosition().getZ() + modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() - modif, this.getPosition().getY() + .5  - modif, this.getPosition().getZ() - modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() + modif, this.getPosition().getY() + .5 - modif, this.getPosition().getZ() - modif,0,0,0);
			}
		}
		if(this.worldObj.isRemote){
			for(int i = -2; i < 2; i ++){
				double modif = ((double) i) / 10;
				this.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.getPosition().getX() - modif, this.getPosition().getY() + .5 - modif, this.getPosition().getZ() + modif,0,0,0);
			}
		}
		super.onUpdate();
		if(!this.worldObj.isRemote){
			List entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.getPosition().add(-1,-1,-1), this.getPosition().add(1,1,1)));
			if(!entities.isEmpty()){
				for(int i = 0; i < entities.size(); i++){
					Entity current = (Entity) entities.get(i);
					current.attackEntityFrom(DamageSource.lightningBolt, 5);
				}
				this.setDead();
			}
		}
		
	}
	@Override
	public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return new AxisAlignedBB(entityIn.getPosition().add(-1,-1,-1), entityIn.getPosition().add(1,1,1));
    }

}
