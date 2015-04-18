package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.nmod;
import com.ncd1998.nmod.Items.*;
import com.ncd1998.nmod.Reference.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class NItems {
	//items
	//Crystals (not resources)
	public static NItem EnderCrystal;
    public static NItem NetherCrystal;
    public static NItem AbsorptionCrystal;
    public static NItem FireCrystal;
    public static NItem AirCrystal;
    public static NItem WaterCrystal;
    public static NItem EarthCrystal;
    public static NItem VoidCrystal;
    public static NItem EnergyCrystal;
    public static NItem OrderCrystal;
    public static NItem ChaosCrystal;
    public static NItem SolarCrystal;
    public static NItem LunarCrystal;
    public static NItem SappingCrystal;
	//Dusts/ Ingots/ Resource Crystals
    public static NItem SkyCobalt;    
    public static NItem SkyCobaltCrystal;
    public static NItem AbsorbiumDust;
    public static NItem VolitiliumDust;
    public static NItem VoiditeIngot;
    public static NItem ChargedNetherQuartz;
    public static NItem AbsorbiumIngot;
    //Dusts (Not Resources)
    public static NItem VoidDust;
    public static NItem LifeForce;
    //Spell Papers
    public static NItem SpellPaperNetherRift;
    public static NItem SpellPaperDeathBeam;
    public static NItem SpellPaperDragonSoul;
    public static NItem SpellPaperEnderRift;
    public static NItem SpellPaperEscapeO;
    //Swords
    public static NItemSword CobaltDrainingSword;
    public static NItemSword AbsorbiumSword;
    //Pickaxes
    public static NPickaxe AbsorbiumPickaxe;
    //Shovels
    public static NShovel AbsorbiumShovel;
    //Axes
    public static NAxe AbsorbiumAxe;
    //Wands
    public static NItem WandOfGrowth;
    //Crafting Objects(sticks, ...)
    public static NItem MysticStick;
    	//Cobalt Sword Componants
    	public static NItem CobaltDrainingSwordHandle;
    	public static NItem CobaltDrainingSwordCore;
    	public static NItem CobaltDrainingSwordEdge;
    	public static NItem CobaltDrainingSwordBlade;
    //Crafting Tools
    public static NItem Crusher;
    //Books
    public static NItem VoidBook;
    
  //Items
    public static void init(){
    	//Crystals (not resources)
    	EnderCrystal = new EnderCrystal();
		NetherCrystal = new NetherCrystal();
		AbsorptionCrystal = new AbsorptionCrystal();
		FireCrystal = new FireCrystal();
		AirCrystal = new AirCrystal();
		WaterCrystal = new WaterCrystal();
		EarthCrystal = new EarthCrystal();
		VoidCrystal = new VoidCrystal();
		EnergyCrystal = new EnergyCrystal();
		OrderCrystal = new OrderCrystal();
		ChaosCrystal = new ChaosCrystal();
		SolarCrystal = new SolarCrystal();
		LunarCrystal = new LunarCrystal();
		SappingCrystal = new SappingCrystal();
    	//Dusts/ Ingots/ Resource Crystals
		SkyCobalt = new ItemSkyCobalt();
    	SkyCobaltCrystal = new SkyCobaltCrystal();
    	AbsorbiumDust = new AbsorbiumDust();
		VolitiliumDust = new VolitiliumDust();
		VoiditeIngot = new VoiditeIngot();
		ChargedNetherQuartz = new ChargedNetherQuartz();
		AbsorbiumIngot = new AbsorbiumIngot();
		//Dusts (Not Resources)
		VoidDust = new VoidDust();
		LifeForce = new LifeForce();
		//Spell Papers
    	SpellPaperNetherRift = new SpellPaperNetherRift();
    	SpellPaperDeathBeam = new SpellPaperDeathBeam();
		SpellPaperDragonSoul = new SpellPaperDragonSoul();
		SpellPaperEnderRift = new SpellPaperEnderRift();
		SpellPaperEscapeO = new SpellPaperEscapeO();
		//Swords
		CobaltDrainingSword = new CobaltDrainingSword(NMaterials.CobaltMaterial);
		AbsorbiumSword = new AbsorbiumSword();
		//Pickaxes
		AbsorbiumPickaxe = new AbsorbiumPickaxe();
		//Shovels
		AbsorbiumShovel = new AbsorbiumShovel();
		//Axes
		AbsorbiumAxe = new AbsorbiumAxe();
		//Wands
		WandOfGrowth = new WandOfGrowth();
		//Crafting Objects(Sticks, ....)
		MysticStick = new MysticStick();
			//Cobalt Draining Sword Components
			CobaltDrainingSwordHandle = new CobaltDrainingSwordHandle();
			CobaltDrainingSwordCore = new CobaltDrainingSwordCore();
			CobaltDrainingSwordEdge = new CobaltDrainingSwordEdge();
			CobaltDrainingSwordBlade = new CobaltDrainingSwordBlade();
		//Crafting Tools
		Crusher = new Crusher();
		//Books
		VoidBook = new VoidBook();
    }
    public static void render(){
    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	//Items
    	//Crystals (not resource crystals)
    	renderItem.getItemModelMesher().register(EnderCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((EnderCrystal) EnderCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(NetherCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((NetherCrystal) NetherCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(AbsorptionCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorptionCrystal) AbsorptionCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(FireCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((FireCrystal) FireCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(AirCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AirCrystal) AirCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(WaterCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((WaterCrystal) WaterCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(EarthCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((EarthCrystal) EarthCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(VoidCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoidCrystal) VoidCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(EnergyCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((EnergyCrystal) EnergyCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(OrderCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((OrderCrystal) OrderCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(ChaosCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((ChaosCrystal) ChaosCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SolarCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SolarCrystal) SolarCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(LunarCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((LunarCrystal) LunarCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SappingCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SappingCrystal) SappingCrystal).getName(), "inventory"));
    	//Dusts/ Ingots/ Resource Crystals
		renderItem.getItemModelMesher().register(SkyCobalt, 0, new ModelResourceLocation(nmod.MODID + ":" + ((ItemSkyCobalt) SkyCobalt).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SkyCobaltCrystal, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SkyCobaltCrystal) SkyCobaltCrystal).getName(), "inventory"));
		renderItem.getItemModelMesher().register(AbsorbiumDust, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumDust) AbsorbiumDust).getName(), "inventory"));
		renderItem.getItemModelMesher().register(VolitiliumDust, 0, new ModelResourceLocation(nmod.MODID + ":" + ((VolitiliumDust) VolitiliumDust).getName(), "inventory"));
		renderItem.getItemModelMesher().register(VoiditeIngot, 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoiditeIngot) VoiditeIngot).getName(), "inventory"));
		renderItem.getItemModelMesher().register(ChargedNetherQuartz, 0, new ModelResourceLocation(nmod.MODID + ":" + ((ChargedNetherQuartz) ChargedNetherQuartz).getName(), "inventory"));
		renderItem.getItemModelMesher().register(AbsorbiumIngot, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumIngot) AbsorbiumIngot).getName(), "inventory"));
		//Dusts (Not Resources)
		renderItem.getItemModelMesher().register(VoidDust, 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoidDust) VoidDust).getName(), "inventory"));
		renderItem.getItemModelMesher().register(LifeForce, 0, new ModelResourceLocation(nmod.MODID + ":" + ((LifeForce) LifeForce).getName(), "inventory"));
		//Spell Papers
		renderItem.getItemModelMesher().register(SpellPaperNetherRift, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SpellPaperNetherRift) SpellPaperNetherRift).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SpellPaperDeathBeam, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SpellPaperDeathBeam) SpellPaperDeathBeam).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SpellPaperDragonSoul, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SpellPaperDragonSoul) SpellPaperDragonSoul).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SpellPaperEnderRift, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SpellPaperEnderRift) SpellPaperEnderRift).getName(), "inventory"));
		renderItem.getItemModelMesher().register(SpellPaperEscapeO, 0, new ModelResourceLocation(nmod.MODID + ":" + ((SpellPaperEscapeO) SpellPaperEscapeO).getName(), "inventory"));
		//Swords
		renderItem.getItemModelMesher().register(CobaltDrainingSword, 0, new ModelResourceLocation(nmod.MODID + ":" + ((CobaltDrainingSword) CobaltDrainingSword).getName(), "inventory"));
		renderItem.getItemModelMesher().register(AbsorbiumSword, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumSword) AbsorbiumSword).getName(), "inventory"));
		//Pickaxes
		renderItem.getItemModelMesher().register(AbsorbiumPickaxe, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumPickaxe) AbsorbiumPickaxe).getName(), "inventory"));
		//Shovels
		renderItem.getItemModelMesher().register(AbsorbiumShovel, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumShovel) AbsorbiumShovel).getName(), "inventory"));
		//Axes
		renderItem.getItemModelMesher().register(AbsorbiumAxe, 0, new ModelResourceLocation(nmod.MODID + ":" + ((AbsorbiumAxe) AbsorbiumAxe).getName(), "inventory"));
		//Wands
		renderItem.getItemModelMesher().register(WandOfGrowth, 0, new ModelResourceLocation(nmod.MODID + ":" + ((WandOfGrowth) WandOfGrowth).getName(), "inventory"));
		//Crafting Objects(Sticks, ...)
		renderItem.getItemModelMesher().register(MysticStick, 0, new ModelResourceLocation(nmod.MODID + ":" + ((MysticStick) MysticStick).getName(), "inventory"));
			//Cobalt Draining Sword Componants
			renderItem.getItemModelMesher().register(CobaltDrainingSwordHandle, 0, new ModelResourceLocation(nmod.MODID + ":" + ((CobaltDrainingSwordHandle) CobaltDrainingSwordHandle).getName(), "inventory"));
			renderItem.getItemModelMesher().register(CobaltDrainingSwordCore, 0, new ModelResourceLocation(nmod.MODID + ":" + ((CobaltDrainingSwordCore) CobaltDrainingSwordCore).getName(), "inventory"));
			renderItem.getItemModelMesher().register(CobaltDrainingSwordEdge, 0, new ModelResourceLocation(nmod.MODID + ":" + ((CobaltDrainingSwordEdge) CobaltDrainingSwordEdge).getName(), "inventory"));
			renderItem.getItemModelMesher().register(CobaltDrainingSwordBlade, 0, new ModelResourceLocation(nmod.MODID + ":" + ((CobaltDrainingSwordBlade) CobaltDrainingSwordBlade).getName(), "inventory"));
		//Crafting Tools
		renderItem.getItemModelMesher().register(Crusher, 0, new ModelResourceLocation(nmod.MODID + ":" + ((Crusher) Crusher).getName(), "inventory"));
		//Books
		renderItem.getItemModelMesher().register(VoidBook, 0, new ModelResourceLocation(nmod.MODID + ":" + ((VoidBook) VoidBook).getName(), "inventory"));
    }
	
	
}
