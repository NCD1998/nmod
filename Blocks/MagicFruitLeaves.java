package com.ncd1998.nmod.Blocks;
 
import java.util.List;

import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Items.MagicFruit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.ITileEntityProvider;
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
import net.minecraft.tileentity.TileEntity;
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

public class MagicFruitLeaves extends BlockLeavesBase
{
	private final String name = "MagicFruitLeaves";
	private Random rand = new Random();
	public MagicFruitLeaves()
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
		 return null;
	 }
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
        return false;
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
	 public void breakBlock(World world, BlockPos pos, IBlockState state) {
		 if(rand.nextInt(3) == 0){
			 ItemStack Fruit = new ItemStack(NItems.MagicFruit, 1);
			Fruit.clearCustomName();
			if(!world.isRemote){
				EntityItem itemS= new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), Fruit);
				world.spawnEntityInWorld(itemS);
			}
		 }
	     world.removeTileEntity(pos);
	  }
	@Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
	       super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
	       TileEntity tileentity = worldIn.getTileEntity(pos);
	       return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
	   }
	 @SideOnly(Side.CLIENT)
	 @Override
	    public int getBlockColor()
	    {
	        return ColorizerFoliage.getFoliageColor(0.1D, 0.1D);
	    }
}