package com.ncd1998.nmod.Init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class NMaterials {
	public static ToolMaterial CobaltMaterial;
	public static void init(){
		CobaltMaterial = new EnumHelper().addToolMaterial("Cobalt", 4, 1700, 9.0F, 4.0F, 11);
	}
}
