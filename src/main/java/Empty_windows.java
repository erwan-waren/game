
package main.java;

import org.*;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import java.*;

public  class Empty_windows extends BasicGameState  {

	public final static int ID = 2;
	
	private GameContainer container;
	private TiledMap map;
	private float x = 300, y = 300;
	private float x1=300,y1=500;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	private float xCamera = x, yCamera = y;
	String sprite ="/src/main/java/sprites/char_01.png";
	String png1 = "/src/main/java/sprites/char_03.png";

	String Png2 = "/src/main/java/sprites/char_03.png";
	String Png3 = "/src/main/java/sprites/char_04.png";
	String Png4 = "/src/main/java/sprites/char_05.png";
	String Username = "Stroheim";
	byte classe = 0;
	CreateCharacter hero = new CreateCharacter (Username,classe,sprite);


	public Empty_windows() {
		super();
		System.out.println("le hero se nomme "+Username);
		System.out.println("Il a "+hero.Hp+" Hp");

	}



	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.translate(container.getWidth() / 2 - (int) this.xCamera,container.getHeight() / 2 - (int) this.yCamera); 
		this.map.render(0,0);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
		Image Png1 = new Image("/src/main/java/sprites/char_03.png");
		g.drawImage(Png1, x1, y1);
	}

	
	
	


	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {

		this.hero.sprite = sprite;
		this.container = container;
this.map = new TiledMap("main/java/map/test_collision_01.tmx");
		Music background = new Music("main/java/sound/low_sound.ogg");
		background.loop();
		
		SpriteSheet spriteSheet = new 
				SpriteSheet(hero.sprite, 26, 36);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);
		this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
		this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
		container.setFullscreen(true);
	}
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		Animation animation = new Animation();
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 200);
		}
		return animation;

	}



	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{

		if (this.moving) {
			float futurX = getFuturX(delta);
			float futurY = getFuturY(delta);
			boolean collision = isCollision(futurX, futurY);
			if (collision) {
				this.moving = false;
			} else {
				this.x = futurX;
				this.y = futurY;
			}


		}

	}

	
	boolean isCollision(float x, float y) {
		int tileW = this.map.getTileWidth();
		int tileH = this.map.getTileHeight();
		int logicLayer = this.map.getLayerIndex("collision");
		Image tile = this.map.getTileImage((int) (x / tileW)+1, (int) (y / tileH)+1, logicLayer);
		boolean collision = tile != null;
		if (collision) {
			Color color = tile.getColor((int) x % tileW, (int) y % tileH);
			collision = color.getAlpha() > 0;
		}
		return collision;
	}

	private float getFuturX(int delta) {
		int w = container.getWidth() / 4;
		this.xCamera = this.x;
		float futurX = this.x;
		switch (this.direction) {
		case 1: futurX = this.x - .1f * delta; break;
		case 3: futurX = this.x + .1f * delta; break;

		}
		if (this.x > this.xCamera + w)
			this.xCamera = this.x - w;
		if (this.x < this.xCamera - w)
			this.xCamera = this.x + w;
		return futurX;

	}

	private float getFuturY(int delta) {
		int h = container.getHeight() / 4;
		this.yCamera = this.y;
		float futurY = this.y;
		switch (this.direction) {
		case 0: futurY = this.y - .1f * delta; break;
		case 2: futurY = this.y + .1f * delta; break;
		}

		if (this.y > this.yCamera + h)
			this.yCamera = this.y - h;
		if (this.y < this.yCamera - h)
			this.yCamera = this.y + h;
		return futurY;
	}


	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			container.exit();

		}
		this.moving = false;
	}
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_UP:    
			this.direction = 0; 
			this.moving = true; 
			break;
		case Input.KEY_LEFT:  
			this.direction = 1; 
			this.moving = true;
			break;
		case Input.KEY_DOWN:  
			this.direction = 2; 
			this.moving = true; 
			break;
		case Input.KEY_RIGHT: 
			this.direction = 3; 
			this.moving = true;
			break;
		}
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}



	

}
