package com.ncd1998.nmod.Items;


import java.util.List;
import java.util.Random;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Init.NBlocks;
import com.ncd1998.nmod.Reference.EnumFruitEffects;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicFruit extends ItemFood{
	private final String name = "MagicFruit";
	private final static int HungerRemove = 4;
	private final static float saturation = .03f;
	private final static boolean isWolfFood = true;
	private Random rand = new Random();
	private final EnumFruitEffects[] effects = EnumFruitEffects.values();
	private final int effectsNum = EnumFruitEffects.values().length;
	private final static int ABSORPTIONLVL = 5;
	private final static int MAXTELEDISTANCE = 30;
	private final static int MAXXPAMOUNT = 50;
	private final static int FIRETIME = 5;
	private final static int DAMAGEAMOUNT = 10;
	private final static int HEALAMOUNT = 10;
	private final static int HASTELVL = 3;
	private final static int HEALTHBOOSTLVL = 5;
	private final static int HUNGERLVL = 1;
	private final static int JUMPLVL = 2;
	private final static int MINESLOWLVL = 3;
	private final static int POISONLVL = 2;
	private final static int REGENLVL = 2;
	private final static int RESISTLVL = 2;
	private final static int SATURATIONLVL = 1;
	private final static int SLOWLVL = 2;
	private final static int SPEEDLVL = 2;
	private final static int STRENGTHLVL = 3;
	private final static int WEAKLVL = 3;
	private final static int WITHERLVL = 2;
	
	public MagicFruit(){
		super(HungerRemove, saturation, isWolfFood);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setAlwaysEdible();
		this.setHasSubtypes(true);
		setMaxStackSize(1);
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
			activateEffects(stack, player, worldIn);
		super.onFoodEaten(stack, worldIn, player);
	}


	private void activateEffects(ItemStack stack, EntityPlayer player, World world) {
		NBTTagCompound tag = stack.getTagCompound();
		int count = 1;
		while(tag.hasKey("EFFECT" + count)){
			String currentKey = "EFFECT" + count;
			if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.ABSORPTION.name())){
				player.addPotionEffect(new PotionEffect(Potion.absorption.getId(), 600, ABSORPTIONLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.BLINDING.name())){
				player.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.DEADLY.name())){
				player.attackEntityFrom(DamageSource.outOfWorld, 500000);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.ENDER.name())){
				int xpos = rand.nextInt(MAXTELEDISTANCE);
				int ypos = rand.nextInt(MAXTELEDISTANCE);
				int zpos = rand.nextInt(MAXTELEDISTANCE);
				if(rand.nextBoolean()){
					xpos *= -1;
				}
				if(rand.nextBoolean()){
					ypos *= -1;
				}
				if(rand.nextBoolean()){
					zpos *= -1;
				}
				int tryfailcount = 0;
				boolean flag = false;
				while(!flag && tryfailcount < 100){
					if(player.worldObj.isAirBlock(player.getPosition().add(xpos, ypos, zpos))){
						player.setPositionAndUpdate(player.getPosition().getX() + xpos, player.getPosition().getY() + ypos, player.getPosition().getZ() + zpos);
						flag = true;
					}
					tryfailcount++;
				}
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.ENLIGHTENING.name())){
				player.addExperience(rand.nextInt(MAXXPAMOUNT));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.EXPLODING.name())){
				player.worldObj.createExplosion(player, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 3, true);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.EXTINGUISHING.name())){
				player.extinguish();
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.FLAMERESIST.name())){
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.FLAMING.name())){
				player.setFire(FIRETIME);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.HARM.name())){
				player.attackEntityFrom(DamageSource.magic, DAMAGEAMOUNT);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.HASTE.name())){
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 600, HASTELVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.HEAL.name())){
				player.heal(HEALAMOUNT);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.HEALTHBOOST.name())){
				player.addPotionEffect(new PotionEffect(Potion.healthBoost.getId(), 600, HEALTHBOOSTLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.HUNGER.name())){
				player.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 600, HUNGERLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.INVISIBLE.name())){
				player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.JUMP.name())){
				player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 600, JUMPLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.MINESLOW.name())){
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 600, MINESLOWLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.NIGHTVISION.name())){
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.POISON.name())){
				player.addPotionEffect(new PotionEffect(Potion.poison.getId(), 600, POISONLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.REGEN.name())){
				player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 600, REGENLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.RESIST.name())){
				player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 600, RESISTLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SATURATING.name())){
				player.addPotionEffect(new PotionEffect(Potion.saturation.getId(), 600, SATURATIONLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SICK.name())){
				player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SLOW.name())){
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 600, SLOWLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SMITING.name())){
				EntityLightningBolt bolt = new EntityLightningBolt(player.worldObj, player.getPosition().getX(),  player.getPosition().getY(),  player.getPosition().getZ());
				player.worldObj.spawnEntityInWorld(bolt);
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SPEED.name())){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 600, SPEEDLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.STRENGTH.name())){
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 600, STRENGTHLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.STUPIFYING.name())){
				player.addExperience(-rand.nextInt(MAXXPAMOUNT));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.SUMMONING.name())){
				if(!world.isRemote){
					EntityZombie Zombie = new EntityZombie(player.worldObj);
					Zombie.setLocationAndAngles(player.getPosition().getX(), player.getPosition().getY(),player.getPosition().getZ(),0 , 0);
					Zombie.addPotionEffect(new PotionEffect(Potion.absorption.getId(), 6000, 50));
					Zombie.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000, 5));
					Zombie.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 6000, 1));
					world.spawnEntityInWorld(Zombie);
					
				}
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.WATERBREATHING.name())){
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 600, 0));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.WEAK.name())){
				player.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 600, WEAKLVL));
			}else if(tag.getString(currentKey).equalsIgnoreCase(EnumFruitEffects.WITHER.name())){
				player.addPotionEffect(new PotionEffect(Potion.wither.getId(), 600, WITHERLVL));
			}
			count++;
		}
		
	}

	public String getName(){
		return name;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn,
			int itemSlot, boolean isSelected) {
		
		if(!stack.hasTagCompound()){
			activateNBT(stack);
		}else{
			if(stack.getMetadata() != stack.getTagCompound().getInteger("Meta")){
				stack.setItemDamage(stack.getTagCompound().getInteger("Meta"));
			}
			if(entityIn.isSneaking()){
				study(stack);
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	public void activateNBT(ItemStack stack) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			NBTTagCompound tag = stack.getTagCompound();
			for(int i = 1; i <= rand.nextInt(6); i++){
				tag.setString("EFFECT" + i, getNewEffect(stack, i));	
			}
			tag.setBoolean("STUDIED", false);
		}
	}
	public static void activateNBT(ItemStack stack, NBTTagCompound tag) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(tag);
		}
	}

	private String getNewEffect(ItemStack stack, int num) {
		while(true){
			int nextEffectNum = rand.nextInt(effectsNum);
			if(!hasEffect(stack, effects[nextEffectNum].name())){
				stack.getTagCompound().setString("NAME" + num, effects[nextEffectNum].getDesc());
				stack.setItemDamage(effects[nextEffectNum].getMeta());
				stack.getTagCompound().setInteger("Meta", effects[nextEffectNum].getMeta());
				return effects[nextEffectNum].name();
			}
		}
	}

	private boolean hasEffect(ItemStack stack, String checkingString) {
		boolean flag = false;
		int counter = 1;
		while(stack.getTagCompound().hasKey("EFFECT" + counter)){
			if(stack.getTagCompound().getString("EFFECT" + counter).equalsIgnoreCase(checkingString)){
				flag = true;
			}
			counter++;
		}
		return flag;
	}
	
	public void study(ItemStack stack){
		if(!stack.getTagCompound().getBoolean("STUDIED")){
			String NewFruitName = "";
			int current = 1;
			NBTTagCompound tag = stack.getTagCompound();
			while(tag.hasKey("NAME"+current)){
				if(rand.nextInt(3) == 0){
					NewFruitName += "" + tag.getString("NAME" + current) + " ";
				}
				current++;
			}
			NewFruitName += "" + "Fruit";
			stack.setStackDisplayName(NewFruitName);
		}
		stack.getTagCompound().setBoolean("STUDIED", true);
		
	}
	@Override
	public void addInformation(ItemStack Stack, EntityPlayer Player, List IList, boolean wow)
	{
		if(Stack.hasTagCompound()){
			if(Stack.getTagCompound().getBoolean("STUDIED")){
				IList.add("ANALYSED");
			}
		}
	}
	@Override
	public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
    {
        for (int i = 0; i < 32; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
