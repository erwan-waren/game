/**
 * 
 */
package main.java;

import org.newdawn.slick.Font;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

/**
 * @author chevalier
 *
 */
public abstract class FieldPaste extends TextField {

	/**
	 * @param container
	 * @param font
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public FieldPaste(GUIContext container, Font font, int x, int y, int width, int height) {
		super(container, font, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param container
	 * @param font
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param listener
	 */
	public FieldPaste(GUIContext container, Font font, int x, int y, int width, int height,
			ComponentListener listener) {
		super(container, font, x, y, width, height, listener);
		// TODO Auto-generated constructor stub
	}

}
