package com.ncd1998.nmod.TileEntities;

import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Items.MagicFruit;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class MagicLeafTileEntity extends TileEntity{
	private NBTTagCompound tag;
	
	public MagicLeafTileEntity(){
		randomFruit();
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		tag.merge(compound);;
		
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.merge(tag);;
	}
	public void replaceTag(NBTTagCompound newTag){
		tag = (NBTTagCompound) newTag.copy();
		this.markDirty();
	}
	
	public NBTTagCompound getTag(){
		tag.setBoolean("STUDIED", false);
		return tag;
	}
	
	public void randomFruit(){
		if(this.tag == null){
		ItemStack Fruit = new ItemStack(NItems.MagicFruit, 1);
		((MagicFruit) Fruit.getItem()).activateNBT(Fruit);
		tag = (NBTTagCompound) Fruit.getTagCompound().copy();
		}
	}
}
