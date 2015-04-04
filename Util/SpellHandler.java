package com.ncd1998.nmod.Util;

import java.util.Random;

import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.ncd1998.nmod.Projectile.DeathRayProjectile;

public class SpellHandler {
	//Beam Spells / Projectile spells
	public static void spellDeathBeam(World WorldIn,EntityPlayer PlayerIn){
		if (!WorldIn.isRemote)
        {
        	for(int i = 0; i <= 50; i++){
        	WorldIn.spawnParticle(EnumParticleTypes.FLAME, PlayerIn.getPosition().getX(), PlayerIn.getPosition().getY(), PlayerIn.getPosition().getZ(), 0, 0, 0);
        	}
        	DeathRayProjectile skull = new DeathRayProjectile(WorldIn, PlayerIn.getPosition().getX(), PlayerIn.getPosition().getY() + 3, PlayerIn.getPosition().getZ(), PlayerIn.getLookVec().xCoord, PlayerIn.getLookVec().yCoord, PlayerIn.getLookVec().zCoord);
            WorldIn.spawnEntityInWorld(skull);
            
        
        }
	}
	//Teleport Spells
	public static void escapeToOverworld(EntityPlayer playerIn){
		playerIn.travelToDimension(0);
		playerIn.respawnPlayer();
	}
	
	//Buff Spells
	public static void dragonSkin(World WorldIn, EntityPlayer PlayerIn){
		WorldIn.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, PlayerIn.getPosition().getX(), PlayerIn.getPosition().getY(), PlayerIn.getPosition().getZ(), 0, 0, 0);
		PlayerIn.addPotionEffect(new PotionEffect(Potion.absorption.getId(), 6000, 45));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 6000, 5));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.jump.getId(), 6000, 5));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 6000, 1));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 6000, 2));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 6000, 2));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000, 5));
	 	PlayerIn.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 6000, 45));
	}
	
	//Reality Warping Spells
	public static void enderRift(ItemStack stack, World worldIn, EntityPlayer playerIn){
		//Shout
		 playerIn.addChatMessage(new ChatComponentTranslation("ENDER RIFT!!!"));
		 playerIn.playSound("ambient.weather.thunder", 10, 0);
		//Explode 
		 worldIn.createExplosion(playerIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 5, true);
		//Spawn Endermen
		 for(int i = 0; i < 3; i++){
				EntityEnderman Enderman = new EntityEnderman(worldIn);
				Enderman.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Enderman);
			}
			for(int i = 0; i < 3; i++){
				EntityEnderman Enderman = new EntityEnderman(worldIn);
				Enderman.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Enderman);
			}
			for(int i = 0; i < 3; i++){
				EntityEnderman Enderman = new EntityEnderman(worldIn);
				Enderman.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Enderman);
			}
			for(int i = 0; i < 3; i++){
				EntityEnderman Enderman = new EntityEnderman(worldIn);
				Enderman.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Enderman);
			}
			//Spawn EnderCrystal
			EntityEnderCrystal Crystal = new EntityEnderCrystal(worldIn);
			Crystal.setLocationAndAngles(playerIn.getPosition().getX(), playerIn.getPosition().getY() + 10,playerIn.getPosition().getZ(),0 , 0);
			worldIn.spawnEntityInWorld(Crystal);
			
			//Spawn Endermite
			for(int i = 0; i < 3; i++){
				EntityEndermite mite = new EntityEndermite(worldIn);
				mite.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY(),playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(mite);
			}
			for(int i = 0; i < 3; i++){
				EntityEndermite mite = new EntityEndermite(worldIn);
				mite.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY(),playerIn.getPosition().getZ(),0 , 0);
				worldIn.spawnEntityInWorld(mite);
			}
			//Spawn Blocks in radius
			BlockPos PlayerPos = playerIn.getPosition();
			float playerx = PlayerPos.getX();
			float playery = PlayerPos.getY();
			float playerz = PlayerPos.getZ();
			Random rand = new Random();
			//Spawn EndPortals
			for(int i=0; i <= 20; i++){
				float Portx;
				float Porty;
				float Portz;
				if(rand.nextBoolean() == true){
					Portx = playerx + rand.nextInt(20);
				}else{
					Portx = playerx - rand.nextInt(20);	
				}
				if(rand.nextBoolean() == true){
					Porty = playery + rand.nextInt(20);
				}else{
					Porty = playery - rand.nextInt(20);	
				}
				if(rand.nextBoolean() == true){
					Portz = playerz + rand.nextInt(20);
				}else{
					Portz = playerz - rand.nextInt(20);	
				}
				BlockPos portpos = new BlockPos(Portx, Porty, Portz);
				if(worldIn.getBlockState(portpos) == Blocks.air.getDefaultState()){
					worldIn.setBlockState(portpos, Blocks.end_portal.getDefaultState());
				}
			}
			//spawn Obsidian
				for(int i=0; i <= 20; i++){
					float Portx;
					float Porty;
					float Portz;
					if(rand.nextBoolean() == true){
						Portx = playerx + rand.nextInt(20);
					}else{
						Portx = playerx - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Porty = playery + rand.nextInt(20);
					}else{
						Porty = playery - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Portz = playerz + rand.nextInt(20);
					}else{
						Portz = playerz - rand.nextInt(20);	
					}
					BlockPos Obspos = new BlockPos(Portx, Porty, Portz);
					if(worldIn.getBlockState(Obspos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(Obspos, Blocks.obsidian.getDefaultState());
					}
			}
				//spawn Endstone
				for(int i=0; i <= 20; i++){
					float Portx;
					float Porty;
					float Portz;
					if(rand.nextBoolean() == true){
						Portx = playerx + rand.nextInt(20);
					}else{
						Portx = playerx - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Porty = playery + rand.nextInt(20);
					}else{
						Porty = playery - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Portz = playerz + rand.nextInt(20);
					}else{
						Portz = playerz - rand.nextInt(20);	
					}
					BlockPos nethpos = new BlockPos(Portx, Porty, Portz);
					if(worldIn.getBlockState(nethpos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(nethpos, Blocks.end_stone.getDefaultState());
					}
				}
	}
	
	public static void netherRift(ItemStack stack, World worldIn, EntityPlayer playerIn){
		//Shout
		 playerIn.addChatMessage(new ChatComponentTranslation("NETHER RIFT!!!"));
		 playerIn.playSound("ambient.weather.thunder", 10, 0);
		//Explode 
		 worldIn.createExplosion(playerIn, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), 5, true);
		 //Spawn Blazes
		 for(int i = 0; i < 3; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 3; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 3; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() - i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			for(int i = 0; i < 3; i++){
				EntityBlaze Blaze = new EntityBlaze(worldIn);
				Blaze.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY() + i,playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Blaze);
			}
			//Spawn Ghast
			EntityGhast Ghast = new EntityGhast(worldIn);
			Ghast.setLocationAndAngles(playerIn.getPosition().getX(), playerIn.getPosition().getY() + 10,playerIn.getPosition().getZ(),0 , 0);
			worldIn.spawnEntityInWorld(Ghast);
			
			//Spawn Pigmen
			for(int i = 0; i < 3; i++){
				EntityPigZombie Pigman = new EntityPigZombie(worldIn);
				Pigman.setLocationAndAngles(playerIn.getPosition().getX() - i, playerIn.getPosition().getY(),playerIn.getPosition().getZ() + i,0 , 0);
				worldIn.spawnEntityInWorld(Pigman);
			}
			for(int i = 0; i < 3; i++){
				EntityPigZombie Pigman = new EntityPigZombie(worldIn);
				Pigman.setLocationAndAngles(playerIn.getPosition().getX() + i, playerIn.getPosition().getY(),playerIn.getPosition().getZ(),0 , 0);
				worldIn.spawnEntityInWorld(Pigman);
				Pigman.setRevengeTarget(playerIn);
			}
			//Spawn MagmaCubes
			for(int i = 0; i < 1; i++){
				EntityMagmaCube Cube = new EntityMagmaCube(worldIn);
				Cube.setLocationAndAngles(playerIn.getPosition().getX() + 5, playerIn.getPosition().getY(),playerIn.getPosition().getZ(),0 , 0);
				worldIn.spawnEntityInWorld(Cube);
			}
			//Spawn Blocks in radius
			BlockPos PlayerPos = playerIn.getPosition();
			float playerx = PlayerPos.getX();
			float playery = PlayerPos.getY();
			float playerz = PlayerPos.getZ();
			Random rand = new Random();
			//Spawn NetherPortals
			for(int i=0; i <= 20; i++){
				float Portx;
				float Porty;
				float Portz;
				if(rand.nextBoolean() == true){
					Portx = playerx + rand.nextInt(20);
				}else{
					Portx = playerx - rand.nextInt(20);	
				}
				if(rand.nextBoolean() == true){
					Porty = playery + rand.nextInt(20);
				}else{
					Porty = playery - rand.nextInt(20);	
				}
				if(rand.nextBoolean() == true){
					Portz = playerz + rand.nextInt(20);
				}else{
					Portz = playerz - rand.nextInt(20);	
				}
				BlockPos portpos = new BlockPos(Portx, Porty, Portz);
				if(worldIn.getBlockState(portpos) == Blocks.air.getDefaultState()){
					worldIn.setBlockState(portpos, Blocks.portal.getDefaultState());
				}
			}
			//spawn Obsidian
				for(int i=0; i <= 20; i++){
					float Portx;
					float Porty;
					float Portz;
					if(rand.nextBoolean() == true){
						Portx = playerx + rand.nextInt(20);
					}else{
						Portx = playerx - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Porty = playery + rand.nextInt(20);
					}else{
						Porty = playery - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Portz = playerz + rand.nextInt(20);
					}else{
						Portz = playerz - rand.nextInt(20);	
					}
					BlockPos Obspos = new BlockPos(Portx, Porty, Portz);
					if(worldIn.getBlockState(Obspos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(Obspos, Blocks.obsidian.getDefaultState());
					}
			}
				//spawn Netherrack
				for(int i=0; i <= 20; i++){
					float Portx;
					float Porty;
					float Portz;
					if(rand.nextBoolean() == true){
						Portx = playerx + rand.nextInt(20);
					}else{
						Portx = playerx - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Porty = playery + rand.nextInt(20);
					}else{
						Porty = playery - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Portz = playerz + rand.nextInt(20);
					}else{
						Portz = playerz - rand.nextInt(20);	
					}
					BlockPos nethpos = new BlockPos(Portx, Porty, Portz);
					if(worldIn.getBlockState(nethpos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(nethpos, Blocks.netherrack.getDefaultState());
					}
			}
				//Spawn Lava
				for(int i=0; i <= 10; i++){
					float Portx;
					float Porty;
					float Portz;
					if(rand.nextBoolean() == true){
						Portx = playerx + rand.nextInt(20);
					}else{
						Portx = playerx - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Porty = playery + rand.nextInt(20);
					}else{
						Porty = playery - rand.nextInt(20);	
					}
					if(rand.nextBoolean() == true){
						Portz = playerz + rand.nextInt(20);
					}else{
						Portz = playerz - rand.nextInt(20);	
					}
					BlockPos Lavapos = new BlockPos(Portx, Porty, Portz);
					if(worldIn.getBlockState(Lavapos) == Blocks.air.getDefaultState()){
						worldIn.setBlockState(Lavapos, Blocks.lava.getDefaultState());
					}
				}
	}
	
}
