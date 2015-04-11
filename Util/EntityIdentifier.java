package com.ncd1998.nmod.Util;

import com.ncd1998.nmod.Reference.MCEntityPaths;

import net.minecraft.entity.Entity;

public class EntityIdentifier {
	public static boolean isEntityEnderMob(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.ENDERMAN)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERMITE)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERDRAGON)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntityNetherMob(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.BLAZE)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.GHAST)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.MAGMACUBE)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.PIGMAN)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isZombie(String entClassName){
		return(entClassName.equals(MCEntityPaths.ZOMBIE));
	}
}
