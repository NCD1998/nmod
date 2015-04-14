package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NItems;


public class VoidAltar extends NBlock
{
	private final String name = "VoidAltar";
	public VoidAltar()
	{
		super(Material.iron);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
		setHarvestLevel("pickaxe", 3);
		setResistance(5F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}
	public String getName()
	{
		return name;
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.inventory.getCurrentItem() != null){
			if(playerIn.inventory.getCurrentItem().getItem().equals(NItems.VoidCrystal)){
				if(isCorrectStructure(pos, worldIn)){
					if(playerIn.inventory.getCurrentItem().isItemDamaged()){
					playerIn.inventory.getCurrentItem().setItemDamage(playerIn.inventory.getCurrentItem().getItemDamage() - 10);
					}
				}
			}
		}
        return false;
    }
	private static boolean isCorrectStructure(BlockPos pos, World worldIn){
		//Make sure it is 3 blocks above the void
		if(pos.getY() == 3){
			//Make sure the blocks below it is not blocking the void
			if(worldIn.getBlockState(pos.down(3)).equals(Blocks.air.getDefaultState()) && worldIn.getBlockState(pos.down()).equals(Blocks.air.getDefaultState()) && worldIn.getBlockState(pos.down(2)).equals(Blocks.air.getDefaultState())){
				if(isFirstBaseRight(pos.down(), worldIn)){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isFirstBaseRight(BlockPos pos, World worldIn){
		boolean flag = true;
		//Top Row X**
		if(!worldIn.getBlockState(pos.add(1, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Top Row *X*
		if(!worldIn.getBlockState(pos.add(1, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Top Row **X
		if(!worldIn.getBlockState(pos.add(1, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Mid Row X**
		if(!worldIn.getBlockState(pos.add(0, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Mid Row **X
		if(!worldIn.getBlockState(pos.add(0, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Bot Row X**
		if(!worldIn.getBlockState(pos.add(-1, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Bot Row *X*
		if(!worldIn.getBlockState(pos.add(-1, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//Bot Row **X
		if(!worldIn.getBlockState(pos.add(-1, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		return flag;
	}
	
	private static boolean isSecondBaseRight(BlockPos pos, World worldIn){
		boolean flag = true;
		//row 1 X****
		if(!worldIn.getBlockState(pos.add(2, 0, -2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 1 *X***
		if(!worldIn.getBlockState(pos.add(2, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 1 **X**
		if(!worldIn.getBlockState(pos.add(2, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 1 ***X*
		if(!worldIn.getBlockState(pos.add(2, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 1 ****X
		if(!worldIn.getBlockState(pos.add(2, 0, 2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 2 X****
		if(!worldIn.getBlockState(pos.add(1, 0, -2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 2 *X***
		if(!worldIn.getBlockState(pos.add(1, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}	
		//row 2 **X**
		if(!worldIn.getBlockState(pos.add(1, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 2 ***X*
		if(!worldIn.getBlockState(pos.add(1, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 2 ****X
		if(!worldIn.getBlockState(pos.add(1, 0, 2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 3 X****
		if(!worldIn.getBlockState(pos.add(0, 0, -2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 3 *X***
		if(!worldIn.getBlockState(pos.add(0, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 3 ***X*
		if(!worldIn.getBlockState(pos.add(0, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 3 ****X
		if(!worldIn.getBlockState(pos.add(0, 0, 2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 4 X****
		if(!worldIn.getBlockState(pos.add(-1, 0, -2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 4 *X***
		if(!worldIn.getBlockState(pos.add(-1, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}	
		//row 4 **X**
		if(!worldIn.getBlockState(pos.add(-1, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 4 ***X*
		if(!worldIn.getBlockState(pos.add(-1, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 4 ****X
		if(!worldIn.getBlockState(pos.add(-1, 0, 2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 5 X****
		if(!worldIn.getBlockState(pos.add(-2, 0, -2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 5 *X***
		if(!worldIn.getBlockState(pos.add(-2, 0, -1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}	
		//row 5 **X**
		if(!worldIn.getBlockState(pos.add(-2, 0, 0)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 5 ***X*
		if(!worldIn.getBlockState(pos.add(-2, 0, 1)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		//row 5 ****X
		if(!worldIn.getBlockState(pos.add(-2, 0, 2)).equals(Blocks.obsidian.getDefaultState())){
			flag = false;
		}
		return flag;
	}
}