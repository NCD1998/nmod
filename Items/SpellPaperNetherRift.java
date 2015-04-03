package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.DamageSource;
import net.minecraft.block.BlockPortal;
public class SpellPaperNetherRift extends Item{
	private final String name = "SpellPaperNetherRift";
	
	public SpellPaperNetherRift(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public String getName(){
		return name;
	}
	
	//On finish Use
	@SideOnly(Side.CLIENT)
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	    {
		 //Shout
		 playerIn.addChatMessage(new ChatComponentTranslation("NETHER RIFT!!!"));
		 playerIn.playSound("ambient.weather.thunder", 10, 0);
		 //Use Paper
		 stack.stackSize--;
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
			return stack;
	    }
	/*public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() + i,pos.getY() + i,pos.getZ() + i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() - i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() + i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		for(int i = 0; i < 6; i++){
			EntityBlaze Blaze = new EntityBlaze(worldIn);
			Blaze.setLocationAndAngles(pos.getX() - i,pos.getY() + i,pos.getZ() - i,0 , 0);
			worldIn.spawnEntityInWorld(Blaze);
		}
		return true;
    }*/
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
	 public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 64;
	    }
	 public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	    {
		 Random rand = new Random();
	        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
	        for(int i = 0; i <=20; i++){
	        	worldIn.spawnParticle(EnumParticleTypes.PORTAL, playerIn.getPosition().getX() + rand.nextInt(5), playerIn.getPosition().getY() + 2 + rand.nextInt(5), playerIn.getPosition().getZ() + rand.nextInt(5), 0, 0, 0);
	        	worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.getPosition().getX() + rand.nextInt(5), playerIn.getPosition().getY() + 2 + rand.nextInt(5), playerIn.getPosition().getZ() + rand.nextInt(5), 0, 0, 0);
	        }
	        for(int i = 0; i <=20; i++){
	        	worldIn.spawnParticle(EnumParticleTypes.PORTAL, playerIn.getPosition().getX() - rand.nextInt(5), playerIn.getPosition().getY() + 2 - rand.nextInt(5), playerIn.getPosition().getZ() - rand.nextInt(5), 0, 0, 0);
	        	worldIn.spawnParticle(EnumParticleTypes.FLAME, playerIn.getPosition().getX() - rand.nextInt(5), playerIn.getPosition().getY() + 2 - rand.nextInt(5), playerIn.getPosition().getZ() - rand.nextInt(5), 0, 0, 0);
	        }
	        
	        return itemStackIn;
	    }
	 
	 public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
	    {
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
