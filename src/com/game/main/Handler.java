package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {


	LinkedList<GameObject> gameObjects=new LinkedList<>();
	
	

	public void tick() {
	//	System.out.println(gameObjects.size());

		for(int i=0;i<gameObjects.size();i++) {

			GameObject tempObject=gameObjects.get(i);
			tempObject.tick();
		}


	}
	public void render(Graphics g) {
		for(int i=0;i<gameObjects.size();i++) {
			
			GameObject tempObject=gameObjects.get(i);
			tempObject.render(g);

		}

	}

	public void addObject(GameObject object) {
		gameObjects.add(object);
	}

	public void remove(GameObject object) {
		gameObjects.remove(object);
	}












}
