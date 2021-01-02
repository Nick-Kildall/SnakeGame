package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Random r = new Random();
   Handler handler = new Handler();
   
	public Player(int x, int y, ID id, Handler handler) {
		super(x,y,id);
      this.handler = handler;
	}
	
   public Rectangle getBounds() {
      return new Rectangle((int) x, (int) y, 32, 32);
   }
    
	public void tick() {
		x += velX;
		y += velY;
      
      x = Game.clamp(x, 0, Game.WIDTH - 32);
      y = Game.clamp(y, 0, Game.HEIGHT - 52);
      
      collision();
      
	}
	
   public void collision() {
      for (GameObject temp : handler.object) {
         if(temp.getId() == ID.BasicEnemy || temp.getId() == ID.FastEnemy || temp.getId() == ID.SmartEnemy){
            if(getBounds().intersects(temp.getBounds())) {
               HUD.HEALTH -= 2;
            }
         }
      }
   }
   
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);
	}

}
