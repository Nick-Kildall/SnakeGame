package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
   
   private Handler handler;
   
   public KeyInput(Handler handler) {
      this.handler = handler;
   }
   
   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode(); // assci value
      
      for (GameObject temp : handler.object) {
         if(temp.getId() == ID.Player) {
            if(key == KeyEvent.VK_W) temp.setVelY(-5);
            if(key == KeyEvent.VK_S) temp.setVelY(5);
            if(key == KeyEvent.VK_D) temp.setVelX(5);
            if(key == KeyEvent.VK_A) temp.setVelX(-5);
         }
         if(temp.getId() == ID.Player2) {
            if(key == KeyEvent.VK_UP) temp.setVelY(-5);
            if(key == KeyEvent.VK_DOWN) temp.setVelY(5);
            if(key == KeyEvent.VK_RIGHT) temp.setVelX(5);
            if(key == KeyEvent.VK_LEFT) temp.setVelX(-5);         
         }
      }
   }
   
   public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
      
      for (GameObject temp : handler.object) {
         if(temp.getId() == ID.Player) {
            if(key == KeyEvent.VK_W) temp.setVelY(0);
            if(key == KeyEvent.VK_S) temp.setVelY(0);
            if(key == KeyEvent.VK_D) temp.setVelX(0);
            if(key == KeyEvent.VK_A) temp.setVelX(0);
         }
         if(temp.getId() == ID.Player2) {
            if(key == KeyEvent.VK_UP) temp.setVelY(0);
            if(key == KeyEvent.VK_DOWN) temp.setVelY(0);
            if(key == KeyEvent.VK_RIGHT) temp.setVelX(0);
            if(key == KeyEvent.VK_LEFT) temp.setVelX(0);         
         }
      }
   }
 
}