package com.ncd1998.nmod.Init;

import com.ncd1998.nmod.TileEntities.MagicLeafTileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class NTileEntities {
	public static void init(){
		GameRegistry.registerTileEntity(MagicLeafTileEntity.class, "magic_leaf_tileentity");
	}

}
