package com.ncd1998.nmod.Util;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;

public class ParticleHelper {
	public static void flameAndSuspendedDepth(ItemStack stack, EntityPlayer player, int count){
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
	public static void portalOnly(ItemStack stack, EntityPlayer player, int count){
		 Random rand = new Random();
		 for(int i = 0; i <=2; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(3), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(3), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(3), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(3), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	}
	public static void portalAndSuspendedDepth(ItemStack stack, EntityPlayer player, int count){
		 Random rand = new Random();
		 for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	}
	public static void portalAndFlame(ItemStack stack, EntityPlayer player, int count){
		 Random rand = new Random();
		 for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() + rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() - rand.nextInt(10), 0, 0, 0);
	        }
	        for(int i = 0; i <=5; i++){
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.PORTAL, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        	player.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, player.getPosition().getX() - rand.nextInt(10), player.getPosition().getY() + rand.nextInt(5), player.getPosition().getZ() + rand.nextInt(10), 0, 0, 0);
	        }
	}
}

