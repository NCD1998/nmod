package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyTempleGlass extends NBlock
{
	private final String name = "SkyTempleGlass";
	protected boolean translucent = true;
	public SkyTempleGlass()
	{
		super(Material.glass);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(.5F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(1.0F);
		setResistance(1F);
		this.setLightOpacity(0);
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
	 public int quantityDropped(Random random)
	    {
	        return 0;
	    }
	 @Override
	 protected boolean canSilkHarvest()
	    {
	        return true;
	    }
	 
}