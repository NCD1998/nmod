package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ncd1998.nmod.nmod;


public class SunBeamBlock extends NBlock
{
	private final String name = "SunbeamBlock";
	public SunBeamBlock()
	{
		super(Material.portal);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(.5F);
		setStepSound(Block.soundTypeSnow);
		setResistance(5F);
		setLightLevel(1.0F);
		this.setLightOpacity(0);
	}
	public String getName()
	{
		return name;
	}
	@Override
	public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity){
		return true;
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
	 @Override
	 public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return null;
	    }
	 @Override
	 public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return true;
	    }
}