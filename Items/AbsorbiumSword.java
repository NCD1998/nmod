package com.ncd1998.nmod.Items;


import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NMaterials;
import com.ncd1998.nmod.Util.EntityIdentifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AbsorbiumSword extends NItemSword{
	private final String name = "AbsorbiumSword";
	private final static ToolMaterial material = NMaterials.AbsorbiumMaterial;
	private final static int toLevel = 12;
	public AbsorbiumSword(){
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			NBTTagCompound tag = stack.getTagCompound();
			tag.setInteger("SharpnessPro", 0);
			tag.setInteger("BanePro", 0);
			tag.setInteger("SmitePro", 0);
			tag.setInteger("FirePro", 0);
			tag.setInteger("KnockbackPro", 0);
			tag.setInteger("LootingPro", 0);
			tag.setInteger("UnbreakingPro", 0);
			tag.setInteger("Sharpnesslvl", 0);
			tag.setInteger("Banelvl", 0);
			tag.setInteger("Smitelvl", 0);
			tag.setInteger("Firelvl", 0);
			tag.setInteger("Knockbacklvl", 0);
			tag.setInteger("Lootinglvl", 0);
			tag.setInteger("Unbreakinglvl", 0);
		}
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(stack.hasTagCompound()){
        	NBTTagCompound tag = stack.getTagCompound();
        	if(EntityIdentifier.isEntityNetherMob(target.getClass().getName())){
        		int currentlvl = tag.getInteger("FirePro");
        		tag.setInteger("FirePro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "FirePro");
        	}
        	if(EntityIdentifier.isEntityHurtBySmite(target.getClass().getName())){
        		int currentlvl = tag.getInteger("SmitePro");
        		tag.setInteger("SmitePro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "SmitePro");
        	}
        	if(EntityIdentifier.isEntityHurtByBane(target.getClass().getName())){
        		int currentlvl = tag.getInteger("BanePro");
        		tag.setInteger("BanePro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "BanePro");
        	}
        	if(EntityIdentifier.isEntitySharpnessBoost(target.getClass().getName())){
        		int currentlvl = tag.getInteger("SharpnessPro");
        		tag.setInteger("SharpnessPro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "SharpnessPro");
        	}
        	if(EntityIdentifier.isEntityKnockbackBoost(target.getClass().getName())){
        		int currentlvl = tag.getInteger("KnockbackPro");
        		tag.setInteger("KnockbackPro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "KnockbackPro");
        	}
        	if(EntityIdentifier.isEntityLootingBoost(target.getClass().getName())){
        		int currentlvl = tag.getInteger("LootingPro");
        		tag.setInteger("LootingPro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "LootingPro");
        	}
        	if(EntityIdentifier.isEntityUnbreakingBoost(target.getClass().getName())){
        		int currentlvl = tag.getInteger("UnbreakingPro");
        		tag.setInteger("UnbreakingPro", currentlvl + 1);
        		upgradeIfReady(stack, attacker, "UnbreakingPro");
        	}
        	
        }else{
        	stack.setTagCompound(new NBTTagCompound());
        	NBTTagCompound tag = stack.getTagCompound();
			tag.setInteger("SharpnessPro", 0);
			tag.setInteger("BanePro", 0);
			tag.setInteger("SmitePro", 0);
			tag.setInteger("FirePro", 0);
			tag.setInteger("KnockbackPro", 0);
			tag.setInteger("LootingPro", 0);
			tag.setInteger("UnbreakingPro", 0);
			tag.setInteger("Sharpnesslvl", 0);
			tag.setInteger("Banelvl", 0);
			tag.setInteger("Smitelvl", 0);
			tag.setInteger("Firelvl", 0);
			tag.setInteger("Knockbacklvl", 0);
			tag.setInteger("Lootinglvl", 0);
			tag.setInteger("Unbreakinglvl", 0);
        }
        return true;
    }
	public static void upgradeIfReady(ItemStack stack, EntityLivingBase target, String Tagname){
		NBTTagCompound tag = stack.getTagCompound();
		if(tag.getInteger(Tagname) >= toLevel){
			tag.setInteger(Tagname, 0);
			if(Tagname.equals("SharpnessPro") && tag.getInteger("Sharpnesslvl") == 0){
					stack.addEnchantment(Enchantment.sharpness, 1);
					tag.setInteger("Sharpnesslvl", 1);
			}
			if(Tagname.equals("BanePro") && tag.getInteger("Banelvl") == 0){
				stack.addEnchantment(Enchantment.baneOfArthropods, 1);
				tag.setInteger("Banelvl", 1);
			}
			if(Tagname.equals("SmitePro") && tag.getInteger("Smitelvl") == 0){
				stack.addEnchantment(Enchantment.smite, 1);
				tag.setInteger("Smitelvl", 1);
			}
			if(Tagname.equals("FirePro") && tag.getInteger("Firelvl") == 0){
				stack.addEnchantment(Enchantment.fireAspect, 1);
				tag.setInteger("Firelvl", 1);
			}
			if(Tagname.equals("KnockbackPro") && tag.getInteger("Knockbacklvl") == 0){
				stack.addEnchantment(Enchantment.knockback, 1);
				tag.setInteger("Knockbocklvl", 1);
			}
			if(Tagname.equals("LootingPro") && tag.getInteger("Lootinglvl") == 0){
				stack.addEnchantment(Enchantment.looting, 1);
				tag.setInteger("Lootinglvl", 1);
			}
			if(Tagname.equals("UnbreakingPro") && tag.getInteger("Unbreakinglvl") == 0){
				stack.addEnchantment(Enchantment.unbreaking, 1);
				tag.setInteger("Unbreakinglvl", 1);
			}
		}
	}
}
