package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class NBlocks {
	 //blocks
    public static NBlock SkyCobaltBlock;
    public static NBlock SkyCobaltOre;
    public static NBlock AbsorbiumOre;
    public static NBlock VolitiliumOre;
    public static NBlock VoiditeOre;
    public static NBlock ChargedNetherQuartzOre;
    public static NBlock GlimmerStone;
    public static NBlock MysticWoodLog;
    public static Block MysticLeaves;
    public static Block MysticTreeSapling;
    public static NBlock MysticWoodPlanks;
    public static Block VoidAltar;
    public static NBlock BVoidDust;
    public static NBlock LightningBlock;
    //Void Runes
    public static NBlock VoidCrosshairRune;
    public static void init(){
    	//Blocks
    	SkyCobaltBlock = new BlockSkyCobaltBlock();
    	SkyCobaltOre = new SkyCobaltOre();
    	AbsorbiumOre = new AbsorbiumOre();
    	VolitiliumOre = new VolitiliumOre();
    	VoiditeOre = new VoiditeOre();
    	ChargedNetherQuartzOre = new ChargedNetherQuartzOre();
    	GlimmerStone = new GlimmerStone();
    	MysticWoodLog = new MysticWoodLog();
    	MysticLeaves = new MysticLeaves();
    	MysticTreeSapling = new MysticTreeSapling();
    	MysticWoodPlanks = new MysticWoodPlanks();
    	VoidAltar = new VoidAltar();
    	BVoidDust = new BVoidDust();
    	LightningBlock = new LightningBlock();
    	//Void Runes
    	VoidCrosshairRune = new VoidCrosshairRune();
    }
    public static void render(){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(SkyCobaltBlock), 0, new ModelResourceLocation(nmod.MODID + ":" + ((BlockSkyCobaltBlock) SkyCobaltBlock).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(SkyCobaltOre), 0, new ModelResourceLocation(nmod.MODID + ":" + ((SkyCobaltOre) SkyCobaltOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(AbsorbiumOre), 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumOre) AbsorbiumOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VolitiliumOre), 0, new ModelResourceLocation(nmod.MODID + ":" + ((VolitiliumOre) VolitiliumOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VoiditeOre), 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoiditeOre) VoiditeOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ChargedNetherQuartzOre), 0, new ModelResourceLocation(nmod.MODID + ":" + ((ChargedNetherQuartzOre) ChargedNetherQuartzOre).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(GlimmerStone), 0, new ModelResourceLocation(nmod.MODID + ":" + ((GlimmerStone) GlimmerStone).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MysticWoodLog), 0, new ModelResourceLocation(nmod.MODID + ":" + ((MysticWoodLog) MysticWoodLog).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MysticLeaves), 0, new ModelResourceLocation(nmod.MODID + ":" + ((MysticLeaves) MysticLeaves).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MysticTreeSapling), 0, new ModelResourceLocation(nmod.MODID + ":" + ((MysticTreeSapling) MysticTreeSapling).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MysticWoodPlanks), 0, new ModelResourceLocation(nmod.MODID + ":" + ((MysticWoodPlanks) MysticWoodPlanks).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VoidAltar), 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoidAltar) VoidAltar).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(BVoidDust), 0, new ModelResourceLocation(nmod.MODID + ":" + ((BVoidDust) BVoidDust).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(LightningBlock), 0, new ModelResourceLocation(nmod.MODID + ":" + ((LightningBlock) LightningBlock).getName(), "inventory"));
		//Void Runes
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VoidCrosshairRune), 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoidCrosshairRune) VoidCrosshairRune).getName(), "inventory"));
    }
}