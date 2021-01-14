package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;



public class Menu extends MouseAdapter {

   private Game game;
   private Handler handler;
   private Random r = new Random();
   private HUD hud;
   
   public Menu(Game game, Handler handler, HUD hud) {
      this.game = game;
      this.handler = handler;
      this.hud = hud;
   }
   
   public void mousePressed(MouseEvent e) {
      int mx = e.getX();
      int my = e.getY();
      
      if (game.gameState == STATE.Menu) {
         
         // Play Button
         if (mouseOver(mx, my, Game.WIDTH / 2 - 100, 150, 200, 64)) {
            game.gameState = STATE.Game;
            handler.clearEnemies();
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
         }
         
         // Help Button
         if (mouseOver(mx, my,Game.WIDTH / 2 - 100, 250, 200, 64)) {
            game.gameState = STATE.Help;
         }
         
         // Quit Button
         if (mouseOver(mx, my, Game.WIDTH / 2 - 100, 350, 200, 64)) {
            System.exit(1);
         }
      }
      
      // Help Button Back
      if (game.gameState == STATE.Help) {
         if (mouseOver(mx, my, 210, 350, 200, 64)) {
            game.gameState = STATE.Menu;
            return;
         }
      }
      
      // End Button Back
      if (game.gameState == STATE.End) {
         if (mouseOver(mx, my, 210, 350, 200, 64)) {
            game.gameState = STATE.Game;
            hud.setScore(0);
            hud.setLevel(0);
            handler.clearEnemies();
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
         }
      }
      
   }
   
   public void mouseReleased(MouseEvent e) {
      
   }
   
   private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
   
      boolean xBounds = mx > x && mx < (width + x);
      boolean yBounds = my > y && my < (height + y);
      
      if (xBounds && yBounds) {
         return true;
      } else {
         return false;
      }
   
   }
   
   public void tick() {
   
   }
   
   public void render(Graphics g) {
      Font fnt = new Font("arial", 1, 50);
      Font fnt2 = new Font("arial", 1, 30);
      
      if(game.gameState == STATE.Menu) {
         
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
      } else if (game.gameState == STATE.Help) {

         g.setColor(Color.white);
         g.setFont(fnt);
         g.drawString("HELP", 240, 70);
         
         g.setFont(fnt2);
         g.drawString("Use the wsad keys to dodge enemies", 50, 200);
         g.drawString("for as long as you can", 50, 250);
         
         g.drawRect(210, 350, 200, 64);
         g.drawString("Back", 270, 390);

      } else if (game.gameState == STATE.End) {
         
         g.setColor(Color.white);
         g.setFont(fnt);
         g.drawString("Game Over", 180, 70);
         
         g.setFont(fnt2);
         g.drawString("You lost with a score of " + hud.getScore(), 175, 200);
         
         g.drawRect(210, 350, 200, 64);
         g.drawString("Try again", 245, 390);

      }

      
   }


}