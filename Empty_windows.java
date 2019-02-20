
package main.java;


import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Input;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Color;

public class Empty_windows extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	private float x = 300, y = 300;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];

	public Empty_windows() {
		super("main.java :: Empty_windows");
	}



	public void render(GameContainer container, Graphics g) throws SlickException {
		this.map.render(0, 0);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
	}



	public void init(GameContainer container) throws SlickException {

		this.container = container;
		this.map = new TiledMap("main/java/map/test05.tmx");
		SpriteSheet spriteSheet = new 
				SpriteSheet("main/java/sprites/bonus1.png", 26, 36);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);
		this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
		this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
	}
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		Animation animation = new Animation();
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 200);
		}
		return animation;
	}

	public void update(GameContainer container, int delta) throws SlickException {
		if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
	        }
	    }

	}
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			container.exit();
			
		}
		this.moving = false;
	}
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;
	    }
	}
	
	
}
