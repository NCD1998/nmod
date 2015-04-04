package com.ncd1998.nmod;

import com.ncd1998.nmod.Blocks.BlockSkyCobaltBlock;
import com.ncd1998.nmod.Items.ItemSkyCobalt;
import com.ncd1998.nmod.Items.SkyCobaltCrystal;
import com.ncd1998.nmod.Blocks.SkyCobaltOre;
import com.ncd1998.nmod.Items.*;
import com.ncd1998.nmod.Blocks.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = nmod.MODID, version = nmod.VERSION, name = nmod.NAME)

public class nmod
{
	@Mod.Instance("nmod")
	public static nmod instance;
	//@SidedProxy(clientSide = "com.ncd1998.nmod.Proxy", serverSide = "com.ncd1998.nmod.Proxy")
	
    public static final String MODID = "nmod";
    public static final String VERSION = "0.0";
    public static final String NAME = "N's Mod";
    
    //items
    public static Item SkyCobalt;
    public static Item SkyCobaltCrystal;
    public static Item SpellPaperNetherRift;
    public static Item SpellPaperDeathBeam;
    public static Item SpellPaperDragonSoul;
    public static Item SpellPaperEnderRift;
    public static Item SpellPaperEscapeO;
    public static Item AbsorbiumDust;
    public static Item VolitiliumDust;
    public static Item VoiditeIngot;
    public static Item ChargedNetherQuartz;
    //blocks
    public static Block SkyCobaltBlock;
    public static Block SkyCobaltOre;
    public static Block AbsorbiumOre;
    public static Block VolitiliumOre;
    public static Block VoiditeOre;
    public static Block ChargedNetherQuartzOre;
    
    public static IWorldGenerator NWorldGen;
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//Blocks
    	SkyCobaltBlock = new BlockSkyCobaltBlock();
    	SkyCobaltOre = new SkyCobaltOre();
    	AbsorbiumOre = new AbsorbiumOre();
    	VolitiliumOre = new VolitiliumOre();
    	VoiditeOre = new VoiditeOre();
    	ChargedNetherQuartzOre = new ChargedNetherQuartzOre();
    	//Items
    	SkyCobalt = new ItemSkyCobalt();
    	SkyCobaltCrystal = new SkyCobaltCrystal();
    	SpellPaperNetherRift = new SpellPaperNetherRift();
    	SpellPaperDeathBeam = new SpellPaperDeathBeam();
    	SpellPaperDragonSoul = new SpellPaperDragonSoul();
    	SpellPaperEnderRift = new SpellPaperEnderRift();
    	SpellPaperEscapeO = new SpellPaperEscapeO();
    	AbsorbiumDust = new AbsorbiumDust();
    	VolitiliumDust = new VolitiliumDust();
    	VoiditeIngot = new VoiditeIngot();
    	ChargedNetherQuartz = new ChargedNetherQuartz();
    	//WorldGen
    	NWorldGen = new NWorldGen();
    	
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Adding recipies
		NmodRecipes.addRecipes();
    	NmodSmeltingRecipes.addRecipes();
    	//Adding World Gen
    	GameRegistry.registerWorldGenerator(NWorldGen, 1);
    	//render
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		//Blocks
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(SkyCobaltBlock), 0, new ModelResourceLocation(MODID + ":" + ((BlockSkyCobaltBlock) SkyCobaltBlock).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(SkyCobaltOre), 0, new ModelResourceLocation(MODID + ":" + ((SkyCobaltOre) SkyCobaltOre).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(AbsorbiumOre), 0, new ModelResourceLocation(MODID + ":" + ((AbsorbiumOre) AbsorbiumOre).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VolitiliumOre), 0, new ModelResourceLocation(MODID + ":" + ((VolitiliumOre) VolitiliumOre).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(VoiditeOre), 0, new ModelResourceLocation(MODID + ":" + ((VoiditeOre) VoiditeOre).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(ChargedNetherQuartzOre), 0, new ModelResourceLocation(MODID + ":" + ((ChargedNetherQuartzOre) ChargedNetherQuartzOre).getName(), "inventory"));
    		
    		//Items
    		renderItem.getItemModelMesher().register(SkyCobalt, 0, new ModelResourceLocation(MODID + ":" + ((ItemSkyCobalt) SkyCobalt).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SkyCobaltCrystal, 0, new ModelResourceLocation(MODID + ":" + ((SkyCobaltCrystal) SkyCobaltCrystal).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SpellPaperNetherRift, 0, new ModelResourceLocation(MODID + ":" + ((SpellPaperNetherRift) SpellPaperNetherRift).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SpellPaperDeathBeam, 0, new ModelResourceLocation(MODID + ":" + ((SpellPaperDeathBeam) SpellPaperDeathBeam).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SpellPaperDragonSoul, 0, new ModelResourceLocation(MODID + ":" + ((SpellPaperDragonSoul) SpellPaperDragonSoul).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SpellPaperEnderRift, 0, new ModelResourceLocation(MODID + ":" + ((SpellPaperEnderRift) SpellPaperEnderRift).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SpellPaperEscapeO, 0, new ModelResourceLocation(MODID + ":" + ((SpellPaperEscapeO) SpellPaperEscapeO).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(AbsorbiumDust, 0, new ModelResourceLocation(MODID + ":" + ((AbsorbiumDust) AbsorbiumDust).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(VolitiliumDust, 0, new ModelResourceLocation(MODID + ":" + ((VolitiliumDust) VolitiliumDust).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(VoiditeIngot, 0, new ModelResourceLocation(MODID + ":" + ((VoiditeIngot) VoiditeIngot).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(ChargedNetherQuartz, 0, new ModelResourceLocation(MODID + ":" + ((ChargedNetherQuartz) ChargedNetherQuartz).getName(), "inventory"));
    	}
    }
    
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
}
