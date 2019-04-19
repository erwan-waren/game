
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

	//carte du jeu
	private TiledMap map;
	private float x = 300, y = 300;

	//camera
	private float xCamera = x, yCamera = y;

	// hero
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	String sprite ;
	String Username = "Stroheim";
	byte classe = 0;
	
	String pnj1 = "/src/main/java/image/brigand_02.png";
	String pnj2 = "/src/main/java/image/troubadour_05.png";
	private float x1=300,y1=500;
	private float x2=150,y2=500;






	public Empty_windows() throws SlickException {
		super();
		
	
		
	}



	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		// camera
		g.translate(container.getWidth() / 2 - (int) this.xCamera,container.getHeight() / 2 - (int) this.yCamera); 
		
		// carte du jeu
		this.map.render(0,0);
		// hero
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);

		// pnj
		Image Pnj1 = new Image(pnj1);
		g.drawImage(Pnj1, x1, y1);
		Image Pnj2 = new Image(pnj2);
		g.drawImage(Pnj2, x2, y2);
	}




	public void enter (GameContainer container, StateBasedGame sbg) throws SlickException {
		System.out.println("le hero se nomme "+MainMenu.Username+" dans le jeu");
		Music background1 = new Music("main/java/sound/low_sound.ogg");
		 background1.loop();
		this.sprite = MainMenu.Sprite;

		SpriteSheet spriteSheet = new 
				SpriteSheet(sprite, 26, 36);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);
		this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
		this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
		
	}

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
	
		
		this.container = container;
		this.map = new TiledMap("main/java/map/test_collision_01.tmx");
		

		//container.setFullscreen(true);
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
