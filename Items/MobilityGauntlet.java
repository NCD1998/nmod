package com.ncd1998.nmod.Items;


import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MobilityGauntlet extends NItem{
	private final String name = "MobilityGauntlet";
	private int counter = 0;
	private Random rand = new Random();
	private final int chanceExplode = 9;
	private final int chanceLoseItem = 19;
	
	public MobilityGauntlet(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setNoRepair();
		setMaxDamage(1000);
		setMaxStackSize(1);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(!playerIn.isSneaking()){
			if(itemStackIn.getItemDamage() < 800){
				itemStackIn.damageItem(200, playerIn);
				MovingObjectPosition telepos = playerIn.rayTrace(50, 1.0F);
				playerIn.setPositionAndUpdate(telepos.getBlockPos().getX(), telepos.getBlockPos().getY(), telepos.getBlockPos().getZ());
			}else{
				if(worldIn.isRemote){
					ParticleHelper.notReadyEffect(itemStackIn, playerIn, playerIn.getPosition());	
				}
				
			}
		}else{
			if(itemStackIn.getItemDamage() < 500){
				itemStackIn.damageItem(500, playerIn);
				playerIn.addPotionEffect(new PotionEffect(Potion.jump.getId(), 6000, 3));
				playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000, 4));
			}else{
				if(worldIn.isRemote){
					ParticleHelper.notReadyEffect(itemStackIn, playerIn, playerIn.getPosition());	
				}
			}
			
		}
        return itemStackIn;
    }
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
		if(entityLiving.isSneaking()){
			if(stack.getItemDamage() < 900){
				stack.damageItem(100, entityLiving);
				MovingObjectPosition telepos = entityLiving.rayTrace(200, 1.0F);
				List entities = entityLiving.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(telepos.getBlockPos().add(-2,-2,-2), telepos.getBlockPos().add(2,2,2)));
				if(!entities.isEmpty()){
					EntityLiving target = (EntityLiving) entities.get(0);
					BlockPos targetPos = target.getPosition();
					BlockPos currentPos = entityLiving.getPosition();
					target.setPositionAndUpdate(currentPos.getX(), currentPos.getY(), currentPos.getZ());
					entityLiving.setPositionAndUpdate(targetPos.getX(), targetPos.getY(), targetPos.getZ());
				}else{
					stack.setItemDamage(stack.getItemDamage() - 100);
				}
			}
		}else{
			if(stack.getItemDamage() < 800){
				stack.damageItem(200, entityLiving);
				MovingObjectPosition telepos = entityLiving.rayTrace(100, 1.0F);
				List entities = entityLiving.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(telepos.getBlockPos().add(-2,-2,-2), telepos.getBlockPos().add(2,2,2)));
				if(!entities.isEmpty()){
					EntityLiving target = (EntityLiving) entities.get(0);
					BlockPos targetPos = target.getPosition();
					Vec3 Targvec = target.getLookVec();
					Vec3 newVec = new Vec3(Targvec.xCoord * -2, Targvec.yCoord * -2, Targvec.zCoord * -2);
					entityLiving.setPositionAndUpdate(targetPos.getX() + newVec.xCoord, targetPos.getY() + newVec.yCoord, targetPos.getZ() + newVec.zCoord);
				}else{
					stack.setItemDamage(stack.getItemDamage() - 200);
				}
			}
		}
        return false;
    }
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(counter == 20){
			counter = 0;
			stack.setItemDamage(stack.getItemDamage() - 5);
		}else{
			counter++;
		}
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if(stack.getItemDamage() < 850){
			stack.damageItem(150, attacker);
				BlockPos targetPos = target.getPosition();
				Vec3 Targvec = target.getLookVec();
				Vec3 newVec = new Vec3(Targvec.xCoord * -2, Targvec.yCoord * -2, Targvec.zCoord * -2);
				attacker.setPositionAndUpdate(targetPos.getX() + newVec.xCoord, targetPos.getY() + newVec.yCoord, targetPos.getZ() + newVec.zCoord);

		}
        return false;
    }
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if(!playerIn.inventory.hasItem(NItems.VoidBook)){
			if(chanceExplode != 0){
				if(rand.nextInt(chanceExplode) == 0){
					worldIn.createExplosion(playerIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 5, true);
					if(chanceLoseItem != 0){
						if(rand.nextInt(chanceLoseItem) == 0){
							stack.stackSize--;
						}
					}
				}
			}
		}
	}
	
}
