package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Projectile.DeathRayProjectile;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpellPaperDeathBeam extends Item{
	private final String name = "SpellPaperDeathBeam";
	public SpellPaperDeathBeam(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName(){
		return name;
	}
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	/*public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	   {
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		 return itemStackIn;
	    }*/
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return itemStackIn;}
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World WorldIn,EntityPlayer PlayerIn) {
	        if (!WorldIn.isRemote)
	        {
	        	stack.stackSize--;
	        	for(int i = 0; i <= 50; i++){
	        	WorldIn.spawnParticle(EnumParticleTypes.FLAME, PlayerIn.getPosition().getX(), PlayerIn.getPosition().getY(), PlayerIn.getPosition().getZ(), 0, 0, 0);
	        	}
	        	DeathRayProjectile skull = new DeathRayProjectile(WorldIn, PlayerIn.getPosition().getX(), PlayerIn.getPosition().getY() + 3, PlayerIn.getPosition().getZ(), PlayerIn.getLookVec().xCoord, PlayerIn.getLookVec().yCoord, PlayerIn.getLookVec().zCoord);
	            WorldIn.spawnEntityInWorld(skull);
	            
	        }
	        return stack;
	    }
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
	 Random rand = new Random();
	 for(int i = 0; i <=1; i++){
        	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() + rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() + rand.nextInt(2), 0, 0.2, 0);
        	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() + rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() + rand.nextInt(2), 0, 2, 0);
        }
	 for(int i = 0; i <=1; i++){
     	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() - rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() - rand.nextInt(2), 0, 0.2, 0);
     	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() - rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() - rand.nextInt(2), 0, 2, 0);
     }
	 for(int i = 0; i <=1; i++){
	     	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() + rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() - rand.nextInt(2), 0, 0.2, 0);
	     	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() + rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() - rand.nextInt(2), 0, 2, 0);
	     }
	 for(int i = 0; i <=1; i++){
	     	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() - rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() + rand.nextInt(2), 0, 0.2, 0);
	     	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() - rand.nextInt(2), player.getPosition().getY(), player.getPosition().getZ() + rand.nextInt(2), 0, 2, 0);
	     }
	 
    }
	
	
}
