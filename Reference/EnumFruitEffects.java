package com.ncd1998.nmod.Reference;

public enum EnumFruitEffects {
	ENDER,
	FLAMING,
	SPEED,
	SLOW,
	HASTE,
	MINESLOW,
	STRENGTH,
	HEAL,
	HARM,
	JUMP,
	SICK,
	REGEN,
	RESIST,
	FLAMERESIST,
	WATERBREATHING,
	INVISIBLE,
	BLINDING,
	NIGHTVISION,
	HUNGER,
	WEAK,
	POISON,
	WITHER,
	HEALTHBOOST,
	SATURATING,
	ABSORPTION,
	DEADLY,
	SUMMONING,
	ENLIGHTENING,
	STUPIFYING,
	SMITING,
	EXTINGUISHING,
	EXPLODING;
	
	  public String getDesc() {
	    switch(this) {
	      case ENDER: return "Ender";
	      case FLAMING: return "Glowing";
	      case SPEED: return "Crisp";
	      case SLOW: return "Oily";
	      case HASTE: return "Hard";
	      case MINESLOW: return "Soft";
	      case STRENGTH: return "Crunchy";
	      case HEAL: return "Healthy";
	      case HARM: return "Toxic";
	      case JUMP: return "Elastic";
	      case SICK: return "Fermented";
	      case REGEN: return "Growing";
	      case RESIST: return "Hardy";
	      case FLAMERESIST: return "Scorched";
	      case WATERBREATHING: return "Juicy";
	      case INVISIBLE: return "Wispy";
	      case BLINDING: return "Dark";
	      case NIGHTVISION: return "Illuminating";
	      case HUNGER: return "Wormy";
	      case POISON: return "Poisoned";
	      case WEAK: return "Sickly";
	      case WITHER: return "Decomposing";
	      case HEALTHBOOST: return "Invigorating";
	      case SATURATING: return "Large";
	      case ABSORPTION: return "Hallowed";
	      case DEADLY: return "Devouring";
	      case SUMMONING: return "Cursed";
	      case ENLIGHTENING: return "Enlightening";
	      case STUPIFYING: return "Stupifying";
	      case SMITING: return "Charged";
	      case EXTINGUISHING: return "Misty";
	      case EXPLODING: return "Primed";
	      default: throw new IllegalArgumentException();
	    }
	    }
		  public int getMeta() {
			    switch(this) {
			      case ENDER: return 0;
			      case FLAMING: return 1;
			      case SPEED: return 2;
			      case SLOW: return 3;
			      case HASTE: return 4;
			      case MINESLOW: return 5;
			      case STRENGTH: return 6;
			      case HEAL: return 7;
			      case HARM: return 8;
			      case JUMP: return 9;
			      case SICK: return 10;
			      case REGEN: return 11;
			      case RESIST: return 12;
			      case FLAMERESIST: return 13;
			      case WATERBREATHING: return 14;
			      case INVISIBLE: return 15;
			      case BLINDING: return 16;
			      case NIGHTVISION: return 17;
			      case HUNGER: return 18;
			      case POISON: return 19;
			      case WEAK: return 20;
			      case WITHER: return 21;
			      case HEALTHBOOST: return 22;
			      case SATURATING: return 23;
			      case ABSORPTION: return 24;
			      case DEADLY: return 25;
			      case SUMMONING: return 26;
			      case ENLIGHTENING: return 27;
			      case STUPIFYING: return 28;
			      case SMITING: return 29;
			      case EXTINGUISHING: return 30;
			      case EXPLODING: return 31;
			      default: throw new IllegalArgumentException();
			    }
	  }
}