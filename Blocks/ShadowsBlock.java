package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShadowsBlock extends NBlock
{
	private final String name = "ShadowsBlock";
	protected boolean translucent = true;
	public ShadowsBlock()
	{
		super(Material.portal);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(.5F);
		setStepSound(Block.soundTypeSand);
		setLightLevel(0.0F);
		setResistance(1F);
		this.setLightOpacity(15);
	}
	public String getName()
	{
		return name;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isTranslucent()
    {
        return this.translucent;
    }
	@Override
	public boolean isVisuallyOpaque()
    {
        return false;
    }
	 @SideOnly(Side.CLIENT)
	    public EnumWorldBlockLayer getBlockLayer()
	    {
	        return EnumWorldBlockLayer.TRANSLUCENT;
	    }
	 @Override 
	 public boolean isOpaqueCube(){
		 return false;
	 }
	 @Override
	 public boolean isCollidable(){
		return true;
		 
		
	 }
	 public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return null;
	    }
	 public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return true;
	    }
}