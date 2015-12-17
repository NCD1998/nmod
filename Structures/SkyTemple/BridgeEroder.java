package com.ncd1998.nmod.Structures.SkyTemple;

import java.util.Random;

import com.ncd1998.nmod.Util.BoxSizer;

/**
 * Used to Erode Bridges (Removes random blocks to make them look older
 * @author NCD1998
 *
 */
public class BridgeEroder {
	static Random rand = new Random();
	/**
	 * Erodes a bridge
	 * @param inBridge (a bridge to erode)
	 * @param level (the severity of damage to do 1 - 100)
	 * @return an eroded bridge
	 */
	public static Bridge erode(Bridge inBridge, int level){
		BoxSizer sizer = inBridge.getDimensions();
		int area = sizer.getHeight() * sizer.getLength() * sizer.getWidth();
		if(level < 1 || level > 100){
			return inBridge;
		}
		Bridge outBridge = inBridge;
		double percent = (int) level / 100.0;
		double blockNum = area * percent;
		int blockNumInt = (int) blockNum;
		for(int i = 0; i<= blockNumInt; i++){
			int l = rand.nextInt(sizer.getLength());
			int w = rand.nextInt(sizer.getWidth());
			int h = rand.nextInt(sizer.getHeight());
			outBridge.setEroded(l, w, h);
		}
		return inBridge;
	}
}
