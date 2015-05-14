package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Projectile.ElectronSnowballEntity;
import com.ncd1998.nmod.Projectile.ShootingStarEntity;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		if( worldIn.getWorldTime() > 13000 && worldIn.canBlockSeeSky(playerIn.getPosition())){
				//If the player is sneaking && If the Item has enough Power To cast Shooting Star
				if(stack.getItemDamage() <= 600 && !playerIn.isSneaking()){
				stack.damageItem(300, playerIn);
				if(!worldIn.isRemote){
					worldIn.spawnEntityInWorld(new ShootingStarEntity(worldIn, playerIn.getPosition().getX() + (int) (playerIn.getLookVec().xCoord * 4), playerIn.getPosition().getY() + 3, playerIn.getPosition().getZ() + (int) (playerIn.getLookVec().xCoord * 4), (playerIn.getLookVec().xCoord * 2), (playerIn.getLookVec().yCoord * 2), (playerIn.getLookVec().zCoord * 2)));
				}else{
					//Add Lightning Ball effect
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
		if(stack.getItemDamage() < 100 && entityLiving.worldObj.getWorldTime() > 13000 && entityLiving.worldObj.canBlockSeeSky(entityLiving.getPosition())){
			stack.damageItem(50, entityLiving);
			entityLiving.worldObj.setLightFor(EnumSkyBlock.BLOCK, entityLiving.getPosition(), 15);
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
