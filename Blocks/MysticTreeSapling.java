package com.ncd1998.nmod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.World.WorldGenMysticTree;

public class MysticTreeSapling extends BlockBush
{
	private final String name = "MysticTreeSapling";
	private Random rand = new Random();
	public MysticTreeSapling()
	{
		super(Material.plants);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setBlockBounds(0F,0F,0F,1F,1F, 1F);
		setStepSound(Block.soundTypeGrass);
		
	}
	public String getName()
	{
		return name;
	}
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        WorldGenMysticTree object;
        worldIn.setBlockState(pos, Blocks.air.getDefaultState());
        object = new WorldGenMysticTree(false, 5, 0, 0, false);
        if(object.generate(worldIn, rand, pos) == true){
        	
        }else{
        	worldIn.setBlockState(pos, NBlocks.MysticTreeSapling.getDefaultState());
        }
    }
	@Override
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return worldIn.getBlockState(pos).getBlock().getMaterial().isSolid();
    }
	@Override
	public boolean getTickRandomly()
    {
        return this.needsRandomTick;
    }
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
        this.updateTick(worldIn, pos, state, random);
    }
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(rand.nextInt(100) == 0){
			
			this.generateTree(worldIn, pos, state, rand);
		}
	}
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {	
		if(worldIn.getBlockState(pos.down()).equals(Blocks.dirt.getDefaultState()) || worldIn.getBlockState(pos.down()).equals(Blocks.grass.getDefaultState())){
			return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
		}
		return false;
        
    }
	/*@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
			this.generateTree(worldIn, pos, state, rand);
        return false;
    }*/
}