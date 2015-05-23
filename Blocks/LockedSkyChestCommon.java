package com.ncd1998.nmod.Blocks;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NItems;


public class LockedSkyChestCommon extends NBlock
{
	private final String name = "LockedSkyChestCommon";
	private final Item[] items = {NItems.VoidDust, NItems.ChargedNetherQuartz,NItems.AbsorbiumAxe, NItems.AbsorbiumPickaxe, NItems.AbsorbiumShovel,
			NItems.AbsorbiumSword,NItems.SkyCobaltCrystal, NItems.LesserSkyKey, NItems.LifeForce, NItems.SpellPaperSniperVeil, NItems.VoiditeIngot,
			NItems.WandOfGrowth, Items.gold_ingot, Items.diamond, Items.apple, Items.golden_apple, Items.book, Items.ender_pearl, Items.experience_bottle,
			Items.emerald, Items.name_tag};
	private final int[] quantitymin = {16,5,1,1,1,1,1,1,5,1,5,1,1,5,3,1,1,5,2,10,2,1};
	private final int[] quantitymax = {32,7,1,1,1,1,3,1,7,1,8,1,1,9,5,1,1,7,3,15,3,2};
	//private final int[] rarity = {4,4,4,4,4,4,6,6,5,5,4,5,2,3,1,3,1,1,4,3,4};
	private final int maxItems = 5;
	private final int minItems = 3;
	private Random rand = new Random();
	public LockedSkyChestCommon()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(100F);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel("pickaxe", 3);
		setResistance(6F);
	}
	public String getName()
	{
		return name;
	}
	@Override
	 public int quantityDropped(Random random)
	    {
	        return 0;
	    }
	 @Override
	 protected boolean canSilkHarvest()
	    {
	        return false;
	    }
	 @Override
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
		 if(playerIn.getCurrentEquippedItem() != null){
		 if(playerIn.getCurrentEquippedItem().getItem().equals(NItems.LesserSkyKey) && side.equals(EnumFacing.UP)){
			 playerIn.inventory.consumeInventoryItem(NItems.LesserSkyKey);
			 ItemStack[] itemsToDrop = this.getItemsToDrop();
			 for(int i = 0; i < itemsToDrop.length; i++){
				 EntityItem currentItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemsToDrop[i]);
				 if(!worldIn.isRemote){
					 worldIn.spawnEntityInWorld(currentItem);
				 }
				 
			 }
			 worldIn.setBlockToAir(pos);
			 
		 }
		 if(playerIn.getCurrentEquippedItem().getItem().equals(NItems.DecentSkyKey) && side.equals(EnumFacing.UP)){
			 playerIn.inventory.consumeInventoryItem(NItems.DecentSkyKey);
			 ItemStack[] itemsToDrop = this.getItemsToDrop();
			 for(int i = 0; i < itemsToDrop.length; i++){
				 EntityItem currentItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemsToDrop[i]);
				 if(!worldIn.isRemote){
					 worldIn.spawnEntityInWorld(currentItem);
				 }
				 
			 }
			 worldIn.setBlockToAir(pos);
			 
		 }
		 if(playerIn.getCurrentEquippedItem().getItem().equals(NItems.FineSkyKey) && side.equals(EnumFacing.UP)){
			 playerIn.inventory.consumeInventoryItem(NItems.FineSkyKey);
			 ItemStack[] itemsToDrop = this.getItemsToDrop();
			 for(int i = 0; i < itemsToDrop.length; i++){
				 EntityItem currentItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemsToDrop[i]);
				 if(!worldIn.isRemote){
					 worldIn.spawnEntityInWorld(currentItem);
				 }
				 
			 }
			 worldIn.setBlockToAir(pos);
			 
		 }
		 }
	        return false;
	    }
	 /**
	  * Returns Items to drop when Unlocked
	  * @return ItemStack[] with Items in it
	  */
	 private ItemStack[] getItemsToDrop(){
		 ItemStack[] returnItems = new ItemStack[rand.nextInt(maxItems - minItems) + minItems];
		 List<Item> itemList = new ArrayList();
			 for(Item current:items){
				 itemList.add(current);
			 }
		 for(int i = 0; i < returnItems.length; i++){
			 int nextItemIndex = rand.nextInt(itemList.size());
			 Item currentItem = itemList.remove(nextItemIndex);
			 if(currentItem.equals(NItems.AbsorbiumAxe) || currentItem.equals(NItems.AbsorbiumPickaxe) || currentItem.equals(NItems.AbsorbiumShovel) || currentItem.equals(NItems.AbsorbiumSword)){
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.AbsorbiumAxe.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.AbsorbiumPickaxe.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.AbsorbiumShovel.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.AbsorbiumSword.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 }
				 int quantity = 0;
				 for(int h = 0; h < items.length; h++){
					 if(currentItem.equals(items[h])){
						 if(quantitymin[h] != quantitymax[h]){
							 quantity = rand.nextInt(quantitymax[h] - quantitymin[h]) + quantitymin[h];
						 }else{
							 quantity = quantitymin[h];
						 }
						 
					 }
				 }
				 returnItems[i] = new ItemStack(currentItem, quantity, 0);
			 
		 }
		 return returnItems;
	 }
}