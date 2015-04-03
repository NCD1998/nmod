package com.ncd1998.nmod;

import com.ncd1998.nmod.Blocks.BlockSkyCobaltBlock;
import com.ncd1998.nmod.Items.ItemSkyCobalt;
import com.ncd1998.nmod.Items.SkyCobaltCrystal;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

@Mod(modid = nmod.MODID, version = nmod.VERSION, name = nmod.NAME)
public class nmod
{
    public static final String MODID = "nmod";
    public static final String VERSION = "0.0";
    public static final String NAME = "N's Mod";
    
    public static Item SkyCobalt;
    public static Block SkyCobaltBlock;
    public static Item SkyCobaltCrystal;
    public static IWorldGenerator NWorldGen;
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//Blocks
    	SkyCobaltBlock = new BlockSkyCobaltBlock();
    	//Items
    	SkyCobalt = new ItemSkyCobalt();
    	SkyCobaltCrystal = new SkyCobaltCrystal();
    	//WorldGen
    	NWorldGen = new NWorldGen();
    	
    }
    
    @EventHandler
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
    		//Items
    		renderItem.getItemModelMesher().register(SkyCobalt, 0, new ModelResourceLocation(MODID + ":" + ((ItemSkyCobalt) SkyCobalt).getName(), "inventory"));
    		renderItem.getItemModelMesher().register(SkyCobaltCrystal, 0, new ModelResourceLocation(MODID + ":" + ((SkyCobaltCrystal) SkyCobaltCrystal).getName(), "inventory"));
    	}
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
}
