/**
 * 
 */
package main.java;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main extends Empty_windows{
	public static void main(String[] args) throws SlickException {
	        new AppGameContainer(new Empty_windows(), 640, 480, false).start();
	   }
}
