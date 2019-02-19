
package main.java;


import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Input;


public class Empty_windows extends BasicGame {

	 private GameContainer container;
	private TiledMap map;


	public Empty_windows() {
	        super("main.java :: Empty_windows");
	    }
	
	 
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		 this.map.render(0, 0);

	}

	
	
	public void init(GameContainer container) throws SlickException {
		
		 this.container = container;
		 this.map = new TiledMap("main/java/map/tuiles/test05.tmx");
	}

	
	
	public void update(GameContainer container, int delta) throws SlickException {
	

	}
	  public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	    }

}
