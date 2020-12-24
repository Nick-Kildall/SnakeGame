package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

   public static int HEALTH = 100;
   
   private int greenValue = 255;
   private int redValue = 0;
   
   
   public void tick() {
      HEALTH = Game.clamp(HEALTH, 0, 100);
      
      greenValue = Game.clamp(greenValue, 0, 255);
      greenValue = HEALTH * 2;
      
      redValue = Game.clamp(redValue, 0, 255);
      redValue = 180 - greenValue;
      
   }
   
   public void render(Graphics g) {
      g.setColor(Color.white);
      g.drawString("Health: " + HEALTH + "%", 15, 10);
      g.setColor(Color.gray);
      g.fillRect(15, 15, 200, 32);
      g.drawString("red " + redValue + "green" + greenValue, 100, 100);
      g.setColor(new Color(redValue, greenValue, 0));
      g.fillRect(15, 15, HEALTH * 2, 32);
      g.setColor(Color.white);
      g.drawRect(15, 15, HEALTH * 2, 32);
   }
   
}