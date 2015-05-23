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
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Init.NItems;


public class LockedSkyChestRare extends NBlock
{
	private final String name = "LockedSkyChestRare";
	private final Item[] items = {NItems.LesserSkyKey, NItems.DecentSkyKey,NItems.FineSkyKey,NItems.GlimmeringSkyKey,NItems.MobilityGauntlet,
			new ItemStack(NBlocks.VoidAltar).getItem(),NItems.EnderCrystal,NItems.NetherCrystal,NItems.SolarCrystal, NItems.LunarCrystal,
			NItems.VoidCrystal,NItems.EnergyCrystal, NItems.FireCrystal, NItems.WaterCrystal, NItems.EarthCrystal, NItems.AirCrystal,
			NItems.CobaltDrainingSword, NItems.SpellPaperDeathBeam, NItems.SpellPaperDragonSoul, NItems.SpellPaperEnderRift,
			NItems.SpellPaperEscapeO, NItems.SpellPaperNetherRift, NItems.SpellPaperSniperVeil, NItems.VoidBook, new ItemStack(Blocks.sponge).getItem(),
			new ItemStack(Blocks.lapis_block).getItem(), new ItemStack(Blocks.gold_block).getItem(), new ItemStack(Blocks.diamond_block).getItem(),
			new ItemStack(Blocks.emerald_block).getItem(),new ItemStack(Blocks.beacon).getItem(),new ItemStack(Blocks.packed_ice).getItem(),
			Items.golden_apple, Items.experience_bottle, Items.skull, Items.nether_star};
	private final int[] quantitymin = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,10,7,3,5,1,48,3,32,1,1};
	private final int[] quantitymax = {3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,10,20,10,5,7,1,64,5,64,1,1};
	//private final int[] rarity = {};
	private final int maxItems = 5;
	private final int minItems = 3;
	private Random rand = new Random();
	public LockedSkyChestRare()
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
		 if(playerIn.getCurrentEquippedItem().getItem().equals(NItems.GlimmeringSkyKey) && side.equals(EnumFacing.UP)){
			 playerIn.inventory.consumeInventoryItem(NItems.GlimmeringSkyKey);
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
			 if(currentItem.equals(NItems.EnderCrystal) || currentItem.equals(NItems.NetherCrystal) || currentItem.equals(NItems.EnergyCrystal) || currentItem.equals(NItems.VoidCrystal) ||
					 currentItem.equals(NItems.SolarCrystal) || currentItem.equals(NItems.LunarCrystal) || currentItem.equals(NItems.FireCrystal) || currentItem.equals(NItems.WaterCrystal) ||
					 currentItem.equals(NItems.AirCrystal) || currentItem.equals(NItems.EarthCrystal)){
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.EnderCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.NetherCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.SolarCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.LunarCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }for(int k = 0; k < itemList.size(); k++){
					 if(NItems.VoidCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.EnergyCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.FireCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.WaterCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.AirCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(NItems.EarthCrystal.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 }
			 if(currentItem.equals(Items.diamond_axe) || currentItem.equals(Items.diamond_boots) || currentItem.equals(Items.diamond_chestplate) || currentItem.equals(Items.diamond_helmet) ||
					 currentItem.equals(Items.diamond_leggings) || currentItem.equals(Items.diamond_pickaxe) || currentItem.equals(Items.diamond_shovel) || currentItem.equals(Items.diamond_sword)){
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_axe.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_boots.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_chestplate.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_helmet.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_leggings.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_pickaxe.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_shovel.equals(itemList.get(k))){
						 itemList.remove(k);
						 k = 500;
					 }
				 }
				 for(int k = 0; k < itemList.size(); k++){
					 if(Items.diamond_sword.equals(itemList.get(k))){
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
				 if(currentItem.equals(Items.golden_apple)){
					 returnItems[i] = new ItemStack(currentItem,quantity, 1);
				 }else if(currentItem.equals(Items.skull)){
					 int randskull = rand.nextInt(5);
					 if(randskull == 0){
						 returnItems[i] = new ItemStack(currentItem, quantity, 0);
					 }else if(randskull == 1){
						 returnItems[i] = new ItemStack(currentItem, quantity, 1);
					 }else if(randskull == 2){
						 returnItems[i] = new ItemStack(currentItem, quantity, 2);
					 }else if(randskull == 4){
						 returnItems[i] = new ItemStack(currentItem, quantity, 4);
					 }else{
						 returnItems[i] = new ItemStack(currentItem, quantity, 0);
					 }
				 }else{
					 returnItems[i] = new ItemStack(currentItem, quantity, 0);
				 }
		 }
		 return returnItems;
	 }
}