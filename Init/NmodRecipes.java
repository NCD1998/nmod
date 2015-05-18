package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
public class NmodRecipes {
	public static void addRecipes(){
		//SkyCobalt to block
		GameRegistry.addRecipe(new ItemStack(NBlocks.SkyCobaltBlock), 
				"SSS",
				"SSS",
				"SSS",
				'S', new ItemStack(NItems.SkyCobalt));
		//SkyCobalt from block
		GameRegistry.addShapelessRecipe(new ItemStack(NBlocks.SkyCobaltBlock, 1), new ItemStack(NItems.SkyCobalt, 9));
		//Absorption Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorptionCrystal),
				"AAA",
				"ASA",
				"AAA",
				'A', new ItemStack(NItems.AbsorbiumDust),
				'S', new ItemStack(NItems.SkyCobaltCrystal));
		//Absorbium Ingot
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumIngot, 1),
				" A ",
				"AIA",
				" A ",
				'A', new ItemStack(NItems.AbsorbiumDust),
				'I', new ItemStack(Items.iron_ingot));
		//Nether Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.NetherCrystal, 1, 1),
				"CBC",
				"GAG",
				"CBC",
				'C', new ItemStack(NItems.ChargedNetherQuartz),
				'B', new ItemStack(Items.blaze_rod),
				'G', new ItemStack(Items.ghast_tear),
				'A', new ItemStack(NItems.AbsorptionCrystal));
		//Ender Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.EnderCrystal, 1, 1),
				" E ",
				"EAE",
				" E ",
				'E', new ItemStack(Items.ender_pearl),
				'A', new ItemStack(NItems.AbsorptionCrystal));
		//Mystic Wood Planks
		GameRegistry.addShapelessRecipe(new ItemStack(NBlocks.MysticWoodPlanks, 4), new ItemStack(NBlocks.MysticWoodLog));
		//Mystic Stick
		GameRegistry.addRecipe(new ItemStack(NItems.MysticStick, 4),
				"P",
				"P",
				'P', new ItemStack(NBlocks.MysticWoodPlanks));
		//Cobalt Draining Sword Recipe Tree
			//Cobalt Draining Sword Handle
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordHandle, 1),
					"V",
					"S",
					"V",
					'V', new ItemStack(NItems.VoiditeIngot),
					'S', new ItemStack(NItems.MysticStick));
			//Cobalt Draining Sword Core
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordCore, 1),
					"III",
					"AEA",
					"III",
					'I', new ItemStack(NItems.AbsorbiumIngot),
					'A', new ItemStack(NItems.AbsorptionCrystal),
					'E', new ItemStack(Items.ender_eye));
			//Cobalt Draining Sword Edge
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordEdge, 1),
					"III",
					" IE",
					"  I",
					'I', new ItemStack(NItems.AbsorbiumIngot),
					'E', new ItemStack(Items.ender_pearl));
			//Cobalt Draining Sword Blade
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSwordBlade, 1),
					" I ",
					"IAI",
					"IAI",
					'I', new ItemStack(NItems.VoiditeIngot),
					'A', new ItemStack(NItems.AbsorbiumIngot));
			//Cobalt Draining Sword
			GameRegistry.addRecipe(new ItemStack(NItems.CobaltDrainingSword, 1),
					" B ",
					"ECE",
					" H ",
					'B', new ItemStack(NItems.CobaltDrainingSwordBlade),
					'E', new ItemStack(NItems.CobaltDrainingSwordEdge),
					'C', new ItemStack(NItems.CobaltDrainingSwordCore),
					'H', new ItemStack(NItems.CobaltDrainingSwordHandle));
		
		//Fire Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.FireCrystal, 1, 200),
				"LFL",
				"FCF",
				"LFL",
				'L', new ItemStack(Items.lava_bucket),
				'F', new ItemStack(Items.fire_charge),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Air Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.AirCrystal, 1, 1000),
				" F ",
				"FCF",
				" F ",
				'F', new ItemStack(Items.feather),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Water Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.WaterCrystal, 1, 1000),
				"PWP",
				"WCW",
				"PWP",
				'P', new ItemStack(Items.prismarine_crystals),
				'W', new ItemStack(Items.water_bucket),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Earth Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.EarthCrystal, 1, 1000),
				"DSD",
				"RCR",
				"DSD",
				'D', new ItemStack(Blocks.diamond_ore),
				'S', new ItemStack(Blocks.stone),
				'C', new ItemStack(NItems.AbsorptionCrystal),
				'R', new ItemStack(Blocks.dirt));
		//Void Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.VoidCrystal, 1, 1000),
				"AVA",
				"VCV",
				"AVA",
				'A', new ItemStack(NItems.AbsorbiumDust),
				'V', new ItemStack(NItems.VoiditeIngot),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Energy Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.EnergyCrystal, 1, 64),
				"RVR",
				"VCV",
				"RVR",
				'R', new ItemStack(Items.redstone),
				'V', new ItemStack(NItems.VolitiliumDust),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Order Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.OrderCrystal, 1, 1000),
				" I ",
				"ICI",
				" I ",
				'I', new ItemStack(Blocks.iron_block),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Chaos Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.ChaosCrystal, 1, 1000),
				"EVE",
				"VCV",
				"EVE",
				'E', new ItemStack(Items.emerald),
				'V', new ItemStack(NItems.VolitiliumDust),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Solar Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.SolarCrystal,1,1000),
				"LGL",
				"ICI",
				"LGL",
				'L', new ItemStack(Items.lava_bucket),
				'G', new ItemStack(Blocks.glowstone),
				'I', new ItemStack(NBlocks.GlimmerStone),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Lunar Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.LunarCrystal,1,1000),
				"ONO",
				"NCN",
				"ONO",
				'O', new ItemStack(Blocks.obsidian),
				'N', new ItemStack(Items.quartz),
				'C', new ItemStack(NItems.AbsorptionCrystal));
		//Crusher
		GameRegistry.addRecipe(new ItemStack(NItems.Crusher),
				"   ",
				"IFI",
				"   ",
				'I', new ItemStack(Items.iron_ingot),
				'F', new ItemStack(Items.flint_and_steel));
		//Void Dust
		GameRegistry.addShapelessRecipe(new ItemStack(NItems.VoidDust, 16), new ItemStack(NItems.Crusher,1,OreDictionary.WILDCARD_VALUE), new ItemStack(NItems.VoiditeIngot));
		//Void Altar
		GameRegistry.addRecipe(new ItemStack(NBlocks.VoidAltar),
				"VAV",
				"OEO",
				"VOV",
				'V', new ItemStack(NItems.VoiditeIngot),
				'A', new ItemStack(NItems.AbsorptionCrystal),
				'O', new ItemStack(Blocks.obsidian),
				'E', new ItemStack(Blocks.enchanting_table));
		//Sapping Crystal
		GameRegistry.addRecipe(new ItemStack(NItems.SappingCrystal, 1),
				"LDV",
				"DAD",
				"VDL",
				'L', new ItemStack(Items.dye, 1, 4),
				'A', new ItemStack(NItems.AbsorptionCrystal),
				'D', new ItemStack(NItems.AbsorbiumDust),
				'V', new ItemStack(NItems.VoidDust));
		//Absorbium Pickaxe
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumPickaxe),
				"AAA",
				" S ",
				" S ",
				'A', new ItemStack(NItems.AbsorbiumIngot),
				'S', new ItemStack(NItems.MysticStick));
		//Absorbium Shovel
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumShovel),
				"A",
				"S",
				"S",
				'A', new ItemStack(NItems.AbsorbiumIngot),
				'S', new ItemStack(NItems.MysticStick));
		//Absorbium Axe
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumAxe),
				"AA ",
				"AS ",
				" S ",
				'A', new ItemStack(NItems.AbsorbiumIngot),
				'S', new ItemStack(NItems.MysticStick));
		//Absorbium Sword
		GameRegistry.addRecipe(new ItemStack(NItems.AbsorbiumSword),
				"A",
				"A",
				"S",
				'A', new ItemStack(NItems.AbsorbiumIngot),
				'S', new ItemStack(NItems.MysticStick));
		//Volitile Compound
		GameRegistry.addRecipe(new ItemStack(NItems.VolitileCompound), 
				"GVG",
				"VRV",
				"GVG",
				'G', new ItemStack(Items.gunpowder),
				'V', new ItemStack(NItems.VolitiliumDust),
				'R', new ItemStack(Items.redstone));
		//Volitile Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(NItems.VolitileIngot), new ItemStack(NItems.VolitileCompound), new ItemStack(Items.iron_ingot));
		//Volitile Sword
		GameRegistry.addRecipe(new ItemStack(NItems.VolitiumSword),
				"V",
				"V",
				"S",
				'V', new ItemStack(NItems.VolitileIngot),
				'S', new ItemStack(NItems.MysticStick));
		//MobilityGauntlet
		GameRegistry.addRecipe(new ItemStack(NItems.MobilityGauntlet),
				"PVP",
				"LEL",
				"LLL",
				'P', new ItemStack(Items.ender_pearl),
				'V', new ItemStack(NItems.VoidCrystal, 1, 0),
				'L', new ItemStack(Items.leather),
				'E', new ItemStack(NItems.EnderCrystal, 1, 0));
	}
}
