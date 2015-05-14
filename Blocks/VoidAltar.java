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
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Init.NItems;
import com.sun.media.jfxmedia.logging.Logger;


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
		this.setLightLevel(.3F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}
	public String getName()
	{
		return name;
	}
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	@Override
    public boolean isFullCube()
    {
        return false;
    }
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.inventory.getCurrentItem() != null){
			if(playerIn.inventory.getCurrentItem().getItem().equals(NItems.VoidCrystal)){
				if(isCorrectStructure(pos, worldIn)){
					if(playerIn.inventory.getCurrentItem().isItemDamaged()){
					playerIn.inventory.getCurrentItem().setItemDamage(playerIn.inventory.getCurrentItem().getItemDamage() - 10);
					playerIn.addStat(nmod.voided, 1);
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
			if(isSurroundedByAir(pos, worldIn, true) && isSurroundedByAir(pos.up(), worldIn, false)){
				if(isFirstBaseRight(pos.down(), worldIn) && isSecondBaseRight(pos.down(2), worldIn) && isBottomBaseRight(pos.down(3), worldIn)){
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isSurroundedByAir(BlockPos pos, World worldIn, boolean ignoreMid){
		boolean flag = true;
		int rowx;
		rowx = -4;
		while(rowx <= 4){
			int rowz = -4;
			while(rowz <= 4){
				if(((rowx != 0) && (rowz != 0)) || !ignoreMid){
					if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.air.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx++;
		}
		return flag;
	}
	
	private static boolean isFirstBaseRight(BlockPos pos, World worldIn){
		boolean flag = true;
		//Checking for Obsidian Loop
		int rowx = -1;
		while(rowx <= 1){
			int rowz = -1;
			while(rowz <= 1){
				if(rowx != 0 && rowz != 0){
					if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.obsidian.getDefaultState())){
						flag = false;
					}
				}else{
					if(!worldIn.getBlockState(pos).equals(Blocks.air.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx++;
		}
		//Check for Empty Space Around the first base layer
		rowx = -4;
		while(rowx <= 4){
			int rowz = -4;
			while(rowz <= 4){
				if((rowx < -1 || rowx > 1) || (rowz < -1 || rowz > 1)){
					if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.air.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx++;
		}
		return flag;
	}

	private static boolean isSecondBaseRight(BlockPos pos, World worldIn){
		boolean flag = true;
		//Checking for Obsidian Loop
		int rowx = -2;
		while(rowx <= 2){
			int rowz = -2;
			while(rowz <= 2){
				if(rowx != 0 && rowz != 0){
					if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.obsidian.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx++;
		}
		//Check for Air Loop
		rowx = -4;
		while(rowx <= 4){
			int rowz = -4;
			while(rowz <= 4){
				if((((rowx < -4 || rowx > 4) || (rowz < -4 || rowz > 4)) || (rowx == 0 && rowz == 0)) && (rowx != 3 || rowz != 3)){
					if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.air.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx++;
		}
		//Check for Void Dust
		rowx = -3;
		while(rowx <= 3){
			int rowz = -3;
			while(rowz <= 3){
				if((rowz == 3 || rowz == -3) || (rowx == 3 || rowx == -3)){
					if(!worldIn.getBlockState(pos.add(rowx,0,rowz)).equals(NBlocks.BVoidDust.getDefaultState())){
						flag = false;
					}
				}
				rowz++;
			}
			rowx ++;
		}
		return flag;
	}
	
	private static boolean isBottomBaseRight(BlockPos pos, World worldIn){
		boolean flag = true;
		//Checking for Obsidian Loop
				int rowx = -3;
				while(rowx <= 3){
					int rowz = -3;
					while(rowz <= 3){
						if(rowx != 0 && rowz != 0){
							if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.obsidian.getDefaultState())){
								flag = false;
							}
						}
						rowz++;
					}
					rowx++;
				}
		//Checking for Air Loop
				rowx = -4;
				while(rowx <= 4){
					int rowz = -4;
					while(rowz <= 4){
						if(((rowx == -4 || rowx == 4) || (rowz == -4 || rowz == 4)) || (rowx == 0 && rowz == 0)){
							if(!worldIn.getBlockState(pos.add(rowx, 0, rowz)).equals(Blocks.air.getDefaultState())){
								flag = false;
								System.out.println("Block at " + pos.add(rowx, 0, rowz) + " is not air");
							}
						}
						rowz++;
					}
					rowx++;
				}
		return flag;
	}
}