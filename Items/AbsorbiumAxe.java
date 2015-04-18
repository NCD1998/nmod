package com.ncd1998.nmod.Items;


import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NMaterials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AbsorbiumAxe extends NAxe{
	private final String name = "AbsorbiumAxe";
	private final static ToolMaterial material = NMaterials.AbsorbiumMaterial;
	
	public AbsorbiumAxe(){
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(worldIn.getBlockState(pos).getBlock().isLeaves(worldIn, pos)){
			int xpos = -2;
			while(xpos <= 2){
				int zpos = -2;
				while(zpos <= 2){
					int ypos = -2;
					while(ypos <= 2){
						if(worldIn.getBlockState(pos.add(xpos, ypos, zpos)).getBlock().isLeaves(worldIn, pos.add(xpos, ypos, zpos))){
							worldIn.setBlockState(pos.add(xpos, ypos, zpos), Blocks.air.getDefaultState());
							stack.attemptDamageItem(3, new Random());
						}
						ypos++;
					}
					zpos++;
				}
				xpos++;
			}
		}
		if(stack.getItemDamage() >= stack.getMaxDamage()){
			stack.stackSize--;
		}
		return false;
		
    }
}
