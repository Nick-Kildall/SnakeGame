package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

   private Handler handler;
   private GameObject player;

   public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x,y,id);
      this.handler = handler;
      
      for(int i = 0; i < handler.object.size(); i++) {
         if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
      }
      
      velX = 5;
      velY = 5;
	}
   
   public Rectangle getBounds() {
      return new Rectangle((int) x, (int) y, 16, 16);
   }
	
	public void tick() {
		x += velX;
		y += velY;
      
      // x & y values of this object to the player object
      float diffX = x - player.getX() - 16; // -16 aims at middle of player object
      float diffY = y - player.getY() - 16;
      // a^2 + b^2 = c^2
      float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) +
                                 (y - player.getY()) * (y - player.getY()));
      
      velX = (float) ((-1.0/distance) * diffX);
      velY = (float) ((-1.0/distance) * diffY);
      
      // if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
      // if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
      
      handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, .04f, handler));
       
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, 16, 16);
   }  
   
}

