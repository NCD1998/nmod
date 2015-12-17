package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Util.EntityIdentifier;
import com.ncd1998.nmod.Util.ParticleHelper;
import com.ncd1998.nmod.World.WorldGenMysticTree;
import com.ncd1998.nmod.Structures.Tree.FruitTree;
import com.ncd1998.nmod.Structures.Tree.MysticTree;
import com.ncd1998.nmod.TileEntities.*;

import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WandOfGrowth extends NItem{
	private final String name = "WandOfGrowth";
	private final Random rand = new Random();
	
	public WandOfGrowth(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		//Get block at position pos
		IBlockState block = worldIn.getBlockState(pos);
		if(block.equals(NBlocks.MysticTreeSapling.getDefaultState())){
			MysticTree tree = new MysticTree(pos);
	        worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	       tree.grow(worldIn, pos);
	        	stack.damageItem(1, playerIn);
	        
	        
		}
		
		if(block.equals(NBlocks.MagicFruitTreeSapling.getDefaultState())){
			FruitTree tree = new FruitTree(pos);
	        worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	       tree.grow(worldIn, pos);
	        	stack.damageItem(1, playerIn);
		}
        return false;
    }
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if(EntityIdentifier.isZombie(target.getClass().getName())){
			if(!target.worldObj.isRemote){
			EntityGiantZombie giant = new EntityGiantZombie(target.getEntityWorld());
			giant.setLocationAndAngles(target.getPosition().getX(), target.getPosition().getY(),target.getPosition().getZ(),0 , 0);
			target.worldObj.spawnEntityInWorld(giant);
			target.setDead();
			stack.damageItem(101, attacker);
			}
		}else{
			System.out.println("Those are not equal.." + target.getClass().getName());
		}
        return false;
    }
}
