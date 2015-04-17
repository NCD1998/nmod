package com.ncd1998.nmod;

import com.ibm.icu.text.DisplayContext.Type;
import com.ncd1998.nmod.Blocks.BlockSkyCobaltBlock;
import com.ncd1998.nmod.Items.ItemSkyCobalt;
import com.ncd1998.nmod.Items.SkyCobaltCrystal;
import com.ncd1998.nmod.Blocks.SkyCobaltOre;
import com.ncd1998.nmod.Items.*;
import com.ncd1998.nmod.Proxy.IProxy;
import com.ncd1998.nmod.Reference.Reference;
import com.ncd1998.nmod.World.NWorldGen;
import com.ncd1998.nmod.World.Biomes.GlassTreeBiome.GTBiomeGenBase;
import com.ncd1998.nmod.Blocks.*;
import com.ncd1998.nmod.Init.*;
import com.ncd1998.nmod.Projectile.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = nmod.MODID, version = nmod.VERSION, name = nmod.NAME)

public class nmod
{
	@Mod.Instance(nmod.MODID)
	public static nmod instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_PATH, serverSide = Reference.SERVER_PROXY_PATH)
	public static IProxy Proxy;
	
    public static final String MODID = Reference.MOD_ID;
    public static final String VERSION = Reference.MOD_VERSION;
    public static final String NAME = Reference.MOD_NAME;
    
    public static IWorldGenerator NWorldGen;
    
    //Biomes
    public static BiomeGenBase Glasstreebiome;
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//Tool Materials
    	NMaterials.init();
    	//Items
    	NItems.init();
    	//Blocks
    	NBlocks.init();
    	//Ore Dictionary
    	NInitOreDic.init();
    	//WorldGen
    	NWorldGen = new NWorldGen();
    	//Biome
    	Glasstreebiome = new GTBiomeGenBase(40, true);
    	BiomeDictionary.registerBiomeType(Glasstreebiome, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
    	BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(Glasstreebiome, 100)); 
    	
    	
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
    		//Blocks
    		NBlocks.render();
    		NItems.render();
    	}
    	//Register Entities
    	EntityRegistry.registerGlobalEntityID(DeathRayProjectile.class, "DeathRayProjectile", EntityRegistry.findGlobalUniqueEntityId());
    	//hooks
    	ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(NItems.VoidBook, 1), 1, 1, 5));
    }
    
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
}
