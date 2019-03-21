
package main.java;


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


public class Empty_windows extends BasicGame  {
   short CharacterHp;
	short CharacterMp;
	short CharacterAtk_P;
	short CharacterAtk_M ;
	float CharacterDef_P ;
	float CharacterDef_M ;
	float CharacterDex;
			
		
	

	private GameContainer container;
	private TiledMap map;
	private float x = 300, y = 300;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	private String Username ="Tom";
    private byte classe = 4;
	CreateCharacter hero =new CreateCharacter(Username, classe);
	
	  
	public Empty_windows() {
		super("main.java :: Empty_windows");
		System.out.println("Le hero se nomme "+ Username );
		System.out.println("Il a "+hero.CharacterHp+"Hp" );
		System.out.println("Il a "+hero.CharacterMp+"Mp" );
		System.out.println("Il a "+hero.CharacterAtk_P+"de point d'attaque" );
		System.out.println("Il a "+hero.CharacterAtk_M+"de potentielle d'attaque magique" );
		System.out.println("Il a "+hero.CharacterDef_P+"de point de defence" );
		System.out.println("Il a "+hero.CharacterDef_M+"de defence magique" );
		System.out.println("Il a "+hero.CharacterDex+"coup crit" );
	
	}



	public void render(GameContainer container, Graphics g) throws SlickException {
		this.map.render(0, 0);
		
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
		
	}



	public void init(GameContainer container) throws SlickException {
	
		
		this.container = container;
		Music background = new Music("main/java/sound/low_sound.ogg");
	    background.loop();
		this.map = new TiledMap("main/java/map/test_collision_01.tmx");
		SpriteSheet spriteSheet = new 
				SpriteSheet("main/java/sprites/char_01.png", 26, 36);
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

	public void update(GameContainer container, int delta) throws SlickException 
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
		    // [... mise à jour de la camera ...]
		}

		private boolean isCollision(float x, float y) {
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
		    float futurX = this.x;
		    switch (this.direction) {
		    case 1: futurX = this.x - .1f * delta; break;
		    case 3: futurX = this.x + .1f * delta; break;
		    }
		    return futurX;
		}

		private float getFuturY(int delta) {
		    float futurY = this.y;
		    switch (this.direction) {
		    case 0: futurY = this.y - .1f * delta; break;
		    case 2: futurY = this.y + .1f * delta; break;
		    }
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
	
	
}
