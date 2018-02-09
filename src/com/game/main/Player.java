package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		
		x+=velX;
		y+=velY;
		
		
		if(x<=0 || x>=Game.WIDTH-37)
			velX=velX*-1;
		if(y<=0 || y>=Game.HEIGHT-60)
			velY=velY*-1;
		
		
		
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);
		
	}
	
//	public static int clamp(int var,int min,int max) {
//		
//		
//	}
	
	
	
	
	
	
	
	

}
