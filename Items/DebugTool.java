package com.ncd1998.nmod.Items;


import java.util.ArrayList;
import java.util.List;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Entities.LightningBall;
import com.ncd1998.nmod.Init.NItems;
import com.ncd1998.nmod.Util.ParticleHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DebugTool extends Item{
	private final String name = "DebugTool";
	private final List<String> toggleList = new ArrayList();
	
	public DebugTool(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		//Add options to toggleList
		toggleList.add("NONE");
		toggleList.add("fastRecharge");
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		activateNBT(stack);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(playerIn.worldObj.isRemote){
			ParticleHelper.upwardBeam(playerIn.getPosition(), playerIn.worldObj , EnumParticleTypes.FLAME);
		}
		if(itemStackIn.hasTagCompound()){
			NBTTagCompound tag = itemStackIn.getTagCompound();
			if(playerIn.isSneaking()){
				//Switch Toggle
				tag.setString("currentToggle", switchToggle(tag.getString("currentToggle")));
				playerIn.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED + "Debug Tool: Set Toggle to " + tag.getString("currentToggle")));
			}else{
				//Toggle
				tag.setBoolean(tag.getString("currentToggle"), !tag.getBoolean(tag.getString("currentToggle")));
				playerIn.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED + "Debug Tool: Toggled " + tag.getString("currentToggle") + " to " + tag.getBoolean(tag.getString("currentToggle"))));
			}
		}else{
			activateNBT(itemStackIn);
		}
        return itemStackIn;
    }
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(stack.hasTagCompound()){
		NBTTagCompound tag = stack.getTagCompound();
		if(tag.getBoolean("fastRecharge")){
			//Starlight Ring
			EntityPlayer player = (EntityPlayer) entityIn;
			if(player.getCurrentEquippedItem().getItem().equals(NItems.StarlightRing)){
				if(player.getCurrentEquippedItem().isItemDamaged()){
					player.getCurrentEquippedItem().setItemDamage(player.getEquipmentInSlot(0).getItemDamage() - 5);
				}
			}
		}
		}else{
			activateNBT(stack);
		}
	}
	

	private static void activateNBT(ItemStack stack){
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tag = stack.getTagCompound();
		//Tags
		//Should Recharge be accelerated
		tag.setBoolean("fastRecharge", false);
		//Leftclick Mode (Tool Mode)
		tag.setString("leftClickMode", "NONE");
		//Rightclick Mode (Used for toggling)
		tag.setString("currentToggle", "NONE");
	}
	
	private String switchToggle(String Ctoggle) {
		//find current toggle index
		int index = 0;
		for(int i = 0; i < toggleList.size(); i++){
			if(toggleList.get(i).equals(Ctoggle)){
				if(i != toggleList.size() - 1){
					return toggleList.get(i + 1);
				}else{
					return toggleList.get(0);
				}
			}
		}
		return "YOU GOOFED";
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		target.setCurrentItemOrArmor(0, new ItemStack(NItems.MobilityGauntlet));
        return false;
    }
}
