package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

// Maintains, updates and renders objects
public class Handler {

	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
      for(int i = 0; i < object.size(); i++) {
		    GameObject tempObject = object.get(i);
		    tempObject.tick();
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
		    GameObject tempObject = object.get(i);
          tempObject.render(g);
		}
	}
   
   public void clearEnemies() {
      for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() != ID.Player || Game.gameState == Game.STATE.End) {
                this.removeObject(tempObject);
                i--;
            }
        }
   }
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}

