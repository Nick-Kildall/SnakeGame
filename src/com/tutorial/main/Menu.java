package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter {
   
   public void mousePressed(MouseEvent e) {
      
   }
   
   public void mouseReleased(MouseEvent e) {
      
   }
   
   public void tick() {
   
   }
   
   public void render(Graphics g) {
      Font fnt = new Font("arial", 1, 50);
      Font fnt2 = new Font("arial", 1, 30);

      
      g.setColor(Color.white);
      
      g.setFont(fnt);
      

      g.drawString("Menu", Game.WIDTH / 2 - 75, 70);
      
      g.setFont(fnt2);
      
      g.drawRect(Game.WIDTH / 2 - 100, 150, 200, 64);
      g.drawString("Play", Game.WIDTH / 2 - 30, 190);
      
      g.drawRect(Game.WIDTH / 2 - 100, 250, 200, 64);
      g.drawString("Help", Game.WIDTH / 2 - 30, 290);
      
      g.drawRect(Game.WIDTH / 2 - 100, 350, 200, 64);
      g.drawString("Quit", Game.WIDTH / 2 - 30, 390);
   }


}