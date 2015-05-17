package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import com.ncd1998.nmod.nmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShadowGlass extends NBlock
{
	private final String name = "ShadowGlass";
	protected boolean translucent = true;
	public ShadowGlass()
	{
		super(Material.glass);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(.5F);
		setStepSound(Block.soundTypeGlass);
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