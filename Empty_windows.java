
package main.java;


import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;


public class Empty_windows extends BasicGame {

	 private GameContainer container;


	public Empty_windows() {
	        super("main.java :: Empty_windows");
	    }
	
	 
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		

	}

	
	
	public void init(GameContainer container) throws SlickException {
		
		 this.container = container;
	}

	
	
	public void update(GameContainer container, int delta) throws SlickException {
	

	}
	  public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	    }

}
