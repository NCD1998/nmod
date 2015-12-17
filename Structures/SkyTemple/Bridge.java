package com.ncd1998.nmod.Structures.SkyTemple;

import com.ncd1998.nmod.Structures.IRoom;

public abstract class Bridge implements IRoom{
	//Class allows all child classes to be counted as Bridges by the generator/eroder
	public abstract void setEroded(int l,int w,int h);
}
