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
	public static boolean isEntityHurtBySmite(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.ZOMBIE)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.PIGMAN)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.SKELETON)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.WITHER)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntityHurtByBane(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.SPIDER)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERMITE)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.CAVESPIDER)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.SILVERFISH)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntitySharpnessBoost(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.CREEPER)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERMAN)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.SLIME)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntityKnockbackBoost(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.CREEPER)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERMAN)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.IRONGOLEM)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntityLootingBoost(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.WITCH)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERDRAGON)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.WITHER)){
			flag = true;
		}
		
		return flag;
	}
	public static boolean isEntityUnbreakingBoost(String entClassName){
		boolean flag = false;
		if(entClassName.equals(MCEntityPaths.SLIME)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.ENDERDRAGON)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.WITHER)){
			flag = true;
		}
		if(entClassName.equals(MCEntityPaths.GAURDIAN)){
			flag = true;
		}
		return flag;
	}
	public static boolean isZombie(String entClassName){
		return(entClassName.equals(MCEntityPaths.ZOMBIE));
	}
}
