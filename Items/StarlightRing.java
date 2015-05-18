package com.ncd1998.nmod.Items;


import ibxm.Player;

import java.util.List;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Entities.LightningBall;
import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Projectile.ElectronSnowballEntity;
import com.ncd1998.nmod.Projectile.ShootingStarEntity;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
/*Item Description
 * Under Night Sky it will:
 * 	On Sneak Right Click: Fire a Shooting Star
 * 	On Right Click: Summon 4 Lightning Balls
 *  On Sneak Left Click: Lights Up the Area	
 * 	On Left Click: Summons Torches
 * At Night Indoors, or underground
 * 	On Sneak Right Click: Ignite Mobs around player and hurt them
 * 	On Right Click: Give player and nearby players and pets fire resistance, regeneration, and night vision
 * */

public class StarlightRing extends NItem{
	private final String name = "StarlightRing";
	private int counter = 0;
	
	public StarlightRing(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setMaxStackSize(1);
		setMaxDamage(900);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		//, and It is Night, and You are under open sky
		if(  worldIn.getLightFor(EnumSkyBlock.SKY, playerIn.getPosition()) - worldIn.getSkylightSubtracted() == 4 && worldIn.canBlockSeeSky(playerIn.getPosition())){
				//If the player is sneaking && If the Item has enough Power To cast Shooting Star
				if(stack.getItemDamage() < 600 && !playerIn.isSneaking()){
					stack.damageItem(300, playerIn);
					if(!worldIn.isRemote){
						worldIn.spawnEntityInWorld(new ShootingStarEntity(worldIn, playerIn.getPosition().getX() + (int) (playerIn.getLookVec().xCoord * 4), playerIn.getPosition().getY() + 3, playerIn.getPosition().getZ() + (int) (playerIn.getLookVec().xCoord * 4), (playerIn.getLookVec().xCoord * 2), (playerIn.getLookVec().yCoord * 2), (playerIn.getLookVec().zCoord * 2)));
					}
					
				}else if(stack.getItemDamage() < 700){
					stack.damageItem(200, playerIn);
					if(!worldIn.isRemote){
						BlockPos plp = playerIn.getPosition();
						LightningBall ball1 = new LightningBall(worldIn);
						LightningBall ball2 = new LightningBall(worldIn);
						LightningBall ball3 = new LightningBall(worldIn);
						LightningBall ball4 = new LightningBall(worldIn);
						ball1.setLocationAndAngles(plp.getX() + 5, plp.getY() + 1, plp.getZ() + 5, 0, 0);
						worldIn.spawnEntityInWorld(ball1);
						ball2.setLocationAndAngles(plp.getX() - 5, plp.getY() + 1, plp.getZ() + 5, 0, 0);
						worldIn.spawnEntityInWorld(ball2);
						ball3.setLocationAndAngles(plp.getX() + 5, plp.getY() + 1, plp.getZ() - 5, 0, 0);
						worldIn.spawnEntityInWorld(ball3);
						ball4.setLocationAndAngles(plp.getX() - 5, plp.getY() + 1, plp.getZ() - 5, 0, 0);
						worldIn.spawnEntityInWorld(ball4);
						System.out.println("SPAWNED");
					}
				}
		}else if((worldIn.getLightFor(EnumSkyBlock.SKY, playerIn.getPosition()) - worldIn.getSkylightSubtracted() == 4 && !worldIn.canBlockSeeSky(playerIn.getPosition()) && playerIn.getPosition().getY() > 50) ||(!worldIn.canBlockSeeSky(playerIn.getPosition()) && playerIn.getPosition().getY() <= 50)){
			if(playerIn.isSneaking()){
				if(stack.getItemDamage() < 100){
					stack.damageItem(800, playerIn);
					ParticleHelper.burstOut(playerIn.getPosition(), worldIn, EnumParticleTypes.REDSTONE, 5, 0, 5, 10);
					List entities = worldIn.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(playerIn.getPosition().add(-10,-10,-10), playerIn.getPosition().add(10,10,10)));
					if(!entities.isEmpty()){
						for(int i = 0; i < entities.size(); i++){
							EntityMob current = (EntityMob) entities.get(i);
							if(playerIn.worldObj.isRemote){
								nmod.Proxy.genererateBurst(current.getPosition(), playerIn.worldObj, EnumParticleTypes.REDSTONE, 5, 0, 5);
							}
							current.setFire(10);
							current.attackEntityFrom(DamageSource.inFire, 10F);
						}
					}
				}
				
			}else{
				//Glowing Fire thing
				if(stack.getItemDamage() < 800){
					stack.damageItem(100, playerIn);
					playerIn.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 1000, 1));
					playerIn.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 500, 1));
					playerIn.setFire(3);
					playerIn.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 200, 2));
					if(playerIn.worldObj.isRemote){
						nmod.Proxy.genererateBurst(playerIn.getPosition(), playerIn.worldObj, EnumParticleTypes.REDSTONE, 5, 0, 5);
					}
					List entities = worldIn.getEntitiesWithinAABB(EntityPlayerMP.class, new AxisAlignedBB(playerIn.getPosition().add(-5, -5, -5), playerIn.getPosition().add(5, 5, 5)));
					if(!entities.isEmpty()){
						for(int i = 0; i < entities.size(); i++){
							EntityPlayerMP current = (EntityPlayerMP) entities.get(i);
							if(playerIn.worldObj.isRemote){
								nmod.Proxy.genererateBurst(current.getPosition(), playerIn.worldObj, EnumParticleTypes.REDSTONE, 5, 0, 5);
							}
							current.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 1000, 1));
							current.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 500, 1));
							current.setFire(3);
							current.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 200, 2));
						}
					}
					List entities2 = worldIn.getEntitiesWithinAABB(EntityWolf.class, new AxisAlignedBB(playerIn.getPosition().add(-5, -5, -5), playerIn.getPosition().add(5, 5, 5)));
					entities2.addAll(worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB(playerIn.getPosition().add(-5, -5, -5), playerIn.getPosition().add(5, 5, 5))));
					if(!entities2.isEmpty()){
						for(int i = 0; i < entities2.size(); i++){
							EntityTameable current = (EntityTameable) entities2.get(i);
							if(playerIn.worldObj.isRemote){
								nmod.Proxy.genererateBurst(current.getPosition(), playerIn.worldObj, EnumParticleTypes.REDSTONE, 5, 0, 5);
							}
							current.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 1000, 1));
							current.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 500, 1));
							current.setFire(3);
							current.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 200, 2));
						}
					}
				}
			}
		}else{
			if(worldIn.isRemote){
				ParticleHelper.notReadyEffect(stack, playerIn, playerIn.getPosition());
			}
		}
        return stack;
    }
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(counter == 20){
			counter = 0;
			stack.setItemDamage(stack.getItemDamage() - 1);
		}else{
			counter++;
		}
	}
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
		if(stack.getItemDamage() < 850 && entityLiving.worldObj.getLightFor(EnumSkyBlock.SKY, entityLiving.getPosition()) - entityLiving.worldObj.getSkylightSubtracted() == 4 && entityLiving.worldObj.canBlockSeeSky(entityLiving.getPosition()) && !entityLiving.isSneaking()){
			stack.damageItem(50, entityLiving);
			for(int i = -5; i <= 5; i++){
				for(int k = -5; k <= 5; k++)
				entityLiving.worldObj.setLightFor(EnumSkyBlock.BLOCK, entityLiving.getPosition().add(i, 0, k), 15);
			}
			
		}else if(stack.getItemDamage() < 890 && entityLiving.worldObj.getLightFor(EnumSkyBlock.SKY, entityLiving.getPosition()) - entityLiving.worldObj.getSkylightSubtracted() == 4 && entityLiving.worldObj.canBlockSeeSky(entityLiving.getPosition()) && entityLiving.isSneaking()){
			stack.damageItem(10, entityLiving);
			BlockPos pos1 = entityLiving.getPosition().add(0,0,5);
			BlockPos pos2 = entityLiving.getPosition().add(0,0,-5);
			BlockPos pos3 = entityLiving.getPosition().add(5,0,0);
			BlockPos pos4 = entityLiving.getPosition().add(-5,0,0);
			if(!entityLiving.worldObj.isRemote){
			if(entityLiving.worldObj.isAirBlock(pos1)){
				entityLiving.worldObj.setBlockState(pos1, Blocks.torch.getDefaultState());
			}
			if(entityLiving.worldObj.isAirBlock(pos2)){
				entityLiving.worldObj.setBlockState(pos2, Blocks.torch.getDefaultState());
			}
			if(entityLiving.worldObj.isAirBlock(pos3)){
				entityLiving.worldObj.setBlockState(pos3, Blocks.torch.getDefaultState());
			}
			if(entityLiving.worldObj.isAirBlock(pos4)){
				entityLiving.worldObj.setBlockState(pos4, Blocks.torch.getDefaultState());
			}
			}
		}else{
			if(entityLiving.worldObj.isRemote){
				ParticleHelper.notReadyEffect(stack, (EntityPlayer) entityLiving, entityLiving.getPosition());
			}
		}
        return false;
    }
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
        return false;
    }
}
