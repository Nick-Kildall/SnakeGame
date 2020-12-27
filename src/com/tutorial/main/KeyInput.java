package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
   
   private Handler handler;
   private boolean[] keyDown = new boolean[4];
   
   public KeyInput(Handler handler) {
      this.handler = handler;
      
      for(int i = 0; i < keyDown.length; i++) {
         keyDown[i] = false;
      }
      
   }
   
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode(); // assci value
      
      for (int i = 0; i < handler.object.size(); i++) {
         GameObject temp = handler.object.get(i);
         if(temp.getId() == ID.Player) {
            if(key == KeyEvent.VK_W) { temp.setVelY(-5); keyDown[0] = true; }
            if(key == KeyEvent.VK_S) { temp.setVelY(5); keyDown[1] = true; }
            if(key == KeyEvent.VK_D) { temp.setVelX(5); keyDown[2] = true; }
            if(key == KeyEvent.VK_A) { temp.setVelX(-5); keyDown[3] = true; }
         }
      }
   }
   
   public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      
      for (int i = 0; i < handler.object.size(); i++) {
         GameObject temp = handler.object.get(i);
         if(temp.getId() == ID.Player) {
            if(key == KeyEvent.VK_W) keyDown[0] = false; // temp.setVelY(0);
            if(key == KeyEvent.VK_S) keyDown[1] = false; // temp.setVelY(0);
            if(key == KeyEvent.VK_D) keyDown[2] = false; // temp.setVelX(0);
            if(key == KeyEvent.VK_A) keyDown[3] = false; // temp.setVelX(0);
            
            // Vertical 
            if(!keyDown[0] && !keyDown[1]) temp.setVelY(0);
            // Horizontal
            if(!keyDown[2] && !keyDown[3]) temp.setVelX(0);
         }
      
      }
      
      if (key == KeyEvent.VK_ESCAPE) System.exit(1);
   }
 
}