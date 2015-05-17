package com.ncd1998.nmod.Blocks;
 
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

public class BlockSkyCobaltBlock extends NBlock
{
	private final String name = "SkyCobaltBlock";
	protected boolean translucent = true;
	public BlockSkyCobaltBlock()
	{
		super(Material.glass);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(10F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(0.0F);
		setHarvestLevel("pickaxe", 3);
		setResistance(50F);
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
	public boolean isVisuallyOpaque()
    {
        return false;
    }
	 @SideOnly(Side.CLIENT)
	    public EnumWorldBlockLayer getBlockLayer()
	    {
	        return EnumWorldBlockLayer.TRANSLUCENT;
	    }
	 public boolean isBeaconBase(){
		 return true;
	 }
	 @Override 
	 public boolean isOpaqueCube(){
		 return false;
	 }
}