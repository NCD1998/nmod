package com.ncd1998.nmod.Blocks;
 
import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Init.NItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MysticLeaves extends BlockLeavesBase
{
	private final String name = "MysticLeaves";
	private Random rand = new Random();
	public MysticLeaves()
	{
		super(Material.leaves, true);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setLightOpacity(1);
		this.setHardness(.5F);
		this.setStepSound(soundTypeGrass);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	public String getName()
	{
		return name;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		 return new ItemStack(NBlocks.MysticTreeSapling).getItem();
	 }
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
        return true;
    }
	@Override
	 public boolean isLeaves(IBlockAccess world, BlockPos pos)
    {
       
        return true;
    }
	@Override
	public int quantityDropped(Random random)
    {
     
		return random.nextInt(11) == 0 ? 1 : 0;
    }
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(rand.nextInt(50) == 0 && !worldIn.isRemote){
			EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.golden_apple));
			worldIn.spawnEntityInWorld(item);
		}
	}
}