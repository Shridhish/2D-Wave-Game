package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		velX=5;
		velY=5;
		
		
		
	}

	
	public void tick() {
		x=x+velX;
		y=y+velY;
		
		if(x<=0 || x>=Game.WIDTH-16) {
			velX=velX*-1;
		}
		if(y<=0 || y>=Game.HEIGHT-32) {
			velY=velY*-1;
		}
		
		
		
		
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect(x, y, 16, 16);
	}
	

}
