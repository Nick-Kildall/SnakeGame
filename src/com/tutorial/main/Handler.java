package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

// Maintains, updates and renders objects
public class Handler {

	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(GameObject tempObject : this.object) {
		    tempObject.tick();
		}
	}
	public void render(Graphics g) {
		for(GameObject tempObject : this.object) {
		    tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
}

