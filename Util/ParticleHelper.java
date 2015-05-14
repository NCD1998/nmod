package com.ncd1998.nmod.Util;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	public static void growthEffect(ItemStack stack, EntityPlayer player, BlockPos pos){
		World world = player.getEntityWorld();
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, 1, 0, 0);
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, -1, 0, 0);
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, 0, 1, 0);
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, 0, -1, 0);
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, 0, 0, 1);
		world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, xCoord, yCoord + 1, zCoord, 0, 0, -1);
		
	}
	public static void notReadyEffect(ItemStack stack, EntityPlayer player, BlockPos pos){
		World world = player.getEntityWorld();
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		world.spawnParticle(EnumParticleTypes.REDSTONE, xCoord, yCoord, zCoord, 0, 0, 0);
		
	}
	public static void upwardBeam(BlockPos pos, World world, EnumParticleTypes type){
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();
		int remain = 255 - xCoord;
		//Spawn
		for(double k = (double) yCoord; k < 255; k += 1){
			world.spawnParticle(type, xCoord, k, zCoord, 0, 0, 0);
		}
	}
	public static void burstOut(BlockPos pos, World world, EnumParticleTypes type){
		int xCoord = pos.getX();
		int yCoord = pos.getY();
		int zCoord = pos.getZ();
		//Y axis
		for(int i = -5; i < 5; i++){
			world.spawnParticle(type, xCoord, yCoord + i, zCoord, 0, 0, 0);
		}
		//Z axis
		for(int i = -5; i < 5; i++){
			world.spawnParticle(type, xCoord, yCoord, zCoord + i, 0, 0, 0);
		}
		//X axis
		for(int i = -5; i < 5; i++){
			world.spawnParticle(type, xCoord + i, yCoord, zCoord, 0, 0, 0);
		}
		//X/Y
		for(int i = 0; i < 5; i++){
			world.spawnParticle(type, xCoord + i, yCoord + i, zCoord, 0, 0, 0);
		}
		for(int i = 0; i < 5; i++){
			world.spawnParticle(type, xCoord - i, yCoord + i, zCoord, 0, 0, 0);
		}
		//Z/Y
		for(int i = 0; i < 5; i++){
			world.spawnParticle(type, xCoord , yCoord + i, zCoord + i, 0, 0, 0);
		}
		for(int i = 0; i < 5; i++){
			world.spawnParticle(type, xCoord, yCoord + i, zCoord - i, 0, 0, 0);
		}	
		//ZX
		for(int i = -5; i < 5; i++){
			world.spawnParticle(type, xCoord + i, yCoord, zCoord + i, 0, 0, 0);
		}
		for(int i = 0; i < 5; i++){
			world.spawnParticle(type, xCoord - i, yCoord, zCoord - i, 0, 0, 0);
		}
	}
}

