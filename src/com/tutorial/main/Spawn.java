package com.tutorial.main;
import java.util.Random;

public class Spawn {

   private Handler handler;
   private HUD hud;
   private Random r;
   
   private int scoreKeep = 0;
   
   public Spawn(Handler handler, HUD hud) {
      this.handler = handler;
      this.hud = hud;
      r = new Random();
   }
   
   public void tick() {
      scoreKeep++;
      if(scoreKeep > 150) {
         scoreKeep = 0;
         hud.setLevel(hud.getLevel() + 1);
         if(hud.getLevel() % 10 == 2) {
             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
         } else if(hud.getLevel() % 10 == 3) {
             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
         } else if(hud.getLevel() % 10 == 4) {
             handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
         } else if (hud.getLevel() % 10 == 5) {
             handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
         } else if (hud.getLevel() % 10 == 6) {
             handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
         } else if (hud.getLevel() % 10 == 7) {
             handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
         } else if (hud.getLevel() == 10) {
            handler.clearEnemies();
            handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -200, ID.EnemyBoss, handler));
         } 



         
         
      }
   }
}