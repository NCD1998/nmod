package com.ncd1998.nmod.Init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class NMaterials {
	public static ToolMaterial CobaltMaterial;
	public static ToolMaterial AbsorbiumMaterial;
	public static ToolMaterial VolitiumMaterial;
	public static void init(){
		CobaltMaterial = new EnumHelper().addToolMaterial("Cobalt", 4, 1700, 9.0F, 4.0F, 11);
		AbsorbiumMaterial = new EnumHelper().addToolMaterial("Absorbium", 2, 500, 7.0F, 2.5F, 18);
		VolitiumMaterial = new EnumHelper().addToolMaterial("Volitium", 3, 550, 3.0F, 0F, 3);
	}
}
