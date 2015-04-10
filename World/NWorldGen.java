package com.ncd1998.nmod.World;

import java.util.Random;

import akka.japi.Predicate;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Blocks.*;
import com.ncd1998.nmod.Init.NBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class NWorldGen implements IWorldGenerator {
   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
     
      switch(world.provider.getDimensionId()){
      case 1:
         generateEnd(world, random, chunkX, chunkZ);
         break;
      case 0:
         generateOverworld(world, random, chunkX, chunkZ);
         break;
      case -1:
         generateNether(world, random, chunkX, chunkZ);
         break;
      }
   }
   public void generateEnd(World world, Random random, int x, int z){
      
   }
   
   public void generateOverworld(World world, Random random, int x, int z){
	   generateRAREOre(NBlocks.SkyCobaltOre, world, random, x, z, 1, 4, 1, 249, 250, Blocks.air);
	   generateOre(NBlocks.AbsorbiumOre, world, random, x, z, 2, 8, 5, 1, 30, Blocks.stone);
	   generateOre(NBlocks.VolitiliumOre, world, random, x, z, 3, 7, 3, 1, 20, Blocks.stone);
	   generateOre(NBlocks.VoiditeOre, world, random, x, z, 3, 7, 5, 2, 8, Blocks.bedrock);
	   generateTree(1, world, random, 180, 50, x, z, false, 7, 0, 0, false, NBlocks.MysticWoodLog, NBlocks.MysticLeaves);
   }
   
   public void generateNether(World world, Random random, int x, int z){
      generateOre(NBlocks.ChargedNetherQuartzOre, world, random, x, z, 4, 8, 10, 1, 200, Blocks.netherrack);
      generateOre(NBlocks.GlimmerStone, world, random, x, z, 10,20, 100, 1, 200, Blocks.glowstone);
      }

   public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance , int minY, int maxY, Block generateIn){
      
      int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
      int hightRange = maxY - minY;
      WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, BlockHelper.forBlock(generateIn));
      for(int i = 0; i < chance; i++){
         int xRand = chunkX * 16 + random.nextInt(16);
         int yRand = random.nextInt(hightRange) + minY;
         int zRand = chunkZ * 16 + random.nextInt(16);
         gen.generate(world, random,new BlockPos(xRand, yRand, zRand));
      }
   }
   public void generateRAREOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance , int minY, int maxY, Block generateIn){
	      Random rare = new Random();
	      int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
	      int hightRange = maxY - minY;
	      WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, BlockHelper.forBlock(generateIn));
	      for(int i = 0; i < chance; i++){
	        if(rare.nextInt(20) == 0){
	        	int xRand = chunkX * 16 + random.nextInt(16);
	        
	         int yRand = random.nextInt(hightRange) + minY;
	         int zRand = chunkZ * 16 + random.nextInt(16);
	         gen.generate(world, random,new BlockPos(xRand, yRand, zRand));
	        }
	      }
	   }
   public void generateTree(int chance, World world, Random rand,int maxY, int minY,int ChunkX, int ChunkZ, boolean update,int height,int woodMeta,int leafMeta,boolean vinesGrow,Block LeafBlock, Block vineType){
	   WorldGenMysticTree tree = new WorldGenMysticTree(update, height, woodMeta, leafMeta, vinesGrow, LeafBlock, vineType);
	   int hightRange = maxY - minY;
	   for(int i = 0; i < chance; i++){
		   int xRand = ChunkX * 16 + rand.nextInt(16);
	         int yRand = rand.nextInt(hightRange) + minY;
	         int zRand = ChunkZ * 16 + rand.nextInt(16);
		   tree.generate(world, rand, new BlockPos(xRand, yRand, zRand));
	   }
   }
}