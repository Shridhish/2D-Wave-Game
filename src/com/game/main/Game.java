package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -473349850293143017L;
	
	public static final int WIDTH= 640, HEIGHT= WIDTH/12*9;
	private Thread thread;
	private boolean running=false;
	
	private Handler handler;
	
	//handler=new Handler();
	private  Random rand;
	
	public Game() {
		handler=new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Lets build a game!", this);
		
		rand=new Random();
		
		
			handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player));
			
			for(int i=0;i<20;i++) {
				handler.addObject(new BasicEnemy(WIDTH/2-32+i+5,HEIGHT/2-32+i+5,ID.BasicEnemy));
			}
			
			
			
			//handler.addObject(new BasicEnemy(WIDTH/2-32,HEIGHT/2-32,ID.BasicEnemy));
		
		
		
	
	}
	
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop() {
		
		try {
			thread.join();
			running =false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void run() {
	//	System.out.println("hhh");

		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns= 1000000000/ amountOfTicks;
		double delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		
		
		//Game loop
		while(running){
			
			long now=System.nanoTime();
			delta=delta+(now-lastTime)/ns;
		//	delta += (now - lastTime) / ns / amountOfTicks;
			lastTime=now;
			
			while(delta>=1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000) {
				
				timer=timer+1000;
			//	System.out.println("FPS: "+frames);
				frames=0;
			}
		
		}
		stop();
		
	}
	
	private void tick() {
		handler.tick();
	}
	private void render() {
		
		BufferStrategy bs=this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
		
		
		
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Game();
		
		
		
		



	}

}
