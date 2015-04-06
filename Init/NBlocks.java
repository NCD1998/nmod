package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Blocks.AbsorbiumOre;
import com.ncd1998.nmod.Blocks.BlockSkyCobaltBlock;
import com.ncd1998.nmod.Blocks.ChargedNetherQuartzOre;
import com.ncd1998.nmod.Blocks.GlimmerStone;
import com.ncd1998.nmod.Blocks.SkyCobaltOre;
import com.ncd1998.nmod.Blocks.VoiditeOre;
import com.ncd1998.nmod.Blocks.VolitiliumOre;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class NBlocks {
	 //blocks
    public static Block SkyCobaltBlock;
    public static Block SkyCobaltOre;
    public static Block AbsorbiumOre;
    public static Block VolitiliumOre;
    public static Block VoiditeOre;
    public static Block ChargedNetherQuartzOre;
    public static Block GlimmerStone;
    public static void init(){
    	//Blocks
    	SkyCobaltBlock = new BlockSkyCobaltBlock();
    	SkyCobaltOre = new SkyCobaltOre();
    	AbsorbiumOre = new AbsorbiumOre();
    	VolitiliumOre = new VolitiliumOre();
    	VoiditeOre = new VoiditeOre();
    	ChargedNetherQuartzOre = new ChargedNetherQuartzOre();
    	GlimmerStone = new GlimmerStone();
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
    }
}
