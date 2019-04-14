/**
 * 
 */
package main.java;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game_State extends StateBasedGame {

	/**
	 * @param name
	 */
	public Game_State() {
		super("state of game");
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
new AppGameContainer(new Game_State()).start();





	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		addState(new MainMenu());
		addState(new Empty_windows());
	}

}
