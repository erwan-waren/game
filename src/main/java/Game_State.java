/**
 * 
 */
package main.java;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;


public class Game_State extends StateBasedGame {

	
	public Game_State() {
		super("chargement");
		
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
new AppGameContainer(new Game_State(),900,600,false).start();


	



	}
	
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		addState(new MainMenu());
		addState(new Empty_windows());
		addState(new CreateCharacterMenu());
	}

}
