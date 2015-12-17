package com.ncd1998.nmod.Util;

public class BoxSizer {
	private final int LENGTH;
	private final int WIDTH;
	private final int HEIGHT;
	
	public BoxSizer(int length, int width, int height){
		LENGTH = length;
		WIDTH = width;
		HEIGHT = height;
	}
	public int getHeight(){
		return HEIGHT;
	}
	
	public int getWidth(){
		return WIDTH;
	}
	
	public int getLength(){
		return LENGTH;
	}
	
}
