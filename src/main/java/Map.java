/**
 * 
 */
package main.java;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author chevalier
 *
 */
public class Map {
	
	private TiledMap map;
	
	public void init() throws SlickException {
		this.map = new TiledMap("main/java/map/test_collision_01.tmx");
	}
	public void rendermap() throws SlickException {
		this.map.render(0,0);
	}
	public void renderfront() throws SlickException {
		
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
}
