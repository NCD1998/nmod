package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VolitiliumOre extends NBlock
{
	private final String name = "VolitiliumOre";
	protected boolean translucent = false;
	public VolitiliumOre()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(8F);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 3);
		setResistance(10F);
	}
	public String getName()
	{
		return name;
	}
	 public Item getItemDropped(IBlockState state, Random rand, int fortune){
		 return NItems.VolitiliumDust;
	 }
	 /**
	     * Get the quantity dropped based on the given fortune level
	     */
	    public int quantityDroppedWithBonus(int fortune, Random random)
	    {
	        return this.quantityDropped(random) + random.nextInt(fortune + 1);
	    }
	    
	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    public int quantityDropped(Random random)
	    {
	        return 1 + random.nextInt(2);
	    }
	    @Override
	    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
	    	Random rand = new Random();
	    	if(rand.nextInt(20) == 0){
	    		worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2, true);
	    	}
	    }
}