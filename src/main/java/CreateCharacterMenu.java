/**
 * 
 */
package main.java;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author chevalier
 *
 */
public class CreateCharacterMenu extends BasicGameState {

	Image G1 = new Image ("/src/main/java/image/guerrier_01.png");
	Image G2 = new Image ("/src/main/java/image/guerrier_02.png");
	Image G3 = new Image ("/src/main/java/image/guerrier_03.png");
	Image G4 = new Image ("/src/main/java/image/guerrier_04.png");
	Image G5 = new Image ("/src/main/java/image/guerrier_05.png");

	Image M1 = new Image ("/src/main/java/image/mage_01.png");
	Image M2 = new Image ("/src/main/java/image/mage_02.png");
	Image M3 = new Image ("/src/main/java/image/mage_03.png");
	Image M4 = new Image ("/src/main/java/image/mage_04.png");
	Image M5 = new Image ("/src/main/java/image/mage_05.png");

	Image P1 = new Image ("/src/main/java/image/paladin_01.png");
	Image P2 = new Image ("/src/main/java/image/paladin_02.png");
	Image P3 = new Image ("/src/main/java/image/paladin_03.png");
	Image P4 = new Image ("/src/main/java/image/paladin_04.png");
	Image P5 = new Image ("/src/main/java/image/paladin_05.png");

	Image T1 = new Image ("/src/main/java/image/troubadour_01.png");
	Image T2 = new Image ("/src/main/java/image/troubadour_02.png");
	Image T3 = new Image ("/src/main/java/image/troubadour_03.png");
	Image T4 = new Image ("/src/main/java/image/troubadour_04.png");
	Image T5 = new Image ("/src/main/java/image/troubadour_05.png");

	Image B1 = new Image ("/src/main/java/image/brigand_01.png");
	Image B2 = new Image ("/src/main/java/image/brigand_02.png");
	Image B3 = new Image ("/src/main/java/image/brigand_03.png");
	Image B4 = new Image ("/src/main/java/image/brigand_04.png");
	Image B5 = new Image ("/src/main/java/image/brigand_05.png");

	Image renderChara1 = new Image("/src/main/java/image/troubadour_01.png");
	Image renderChara2 = new Image("/src/main/java/image/troubadour_02.png");
	Image renderChara3 = new Image("/src/main/java/image/troubadour_03.png");
	Image renderChara4 = new Image("/src/main/java/image/troubadour_04.png");
	Image renderChara5 = new Image("/src/main/java/image/troubadour_05.png");

	static String Username = "Stroheim";
	static String Sprite = "" ;
	static int classe = 3;

	private int playersChoice = 0;
	private static final int NOCHOICES = 6;
	private static final int Guerrier = 0;
	private static final int Mage = 1;
	private static final int Paladin = 2;
	private static final int Troubadour = 3;
	private static final int Brigand = 4;
	private static final int Exit = 5;
	
	private String[] playersOptions = new String[NOCHOICES];
	private Font font;
	private TrueTypeFont playersOptionsTTF, foo,consigneFont;
	private Color notChosen = new Color(25, 50, 255);

	private Color UsernameBoxColor= new Color(50, 50, 50);
	protected TextField UsernameBox;

	protected TextField spriteBox;

	public final static int ID = 3;

	public CreateCharacterMenu() throws SlickException {
		super();

	}
	public void enter(GameContainer container, StateBasedGame sbg) throws SlickException {
		Music background1 = new Music("main/java/sound/menu_sound.ogg");
		 background1.loop();
		UsernameBox = new TextField(container, container.getDefaultFont(), 100,150,100,20);
		UsernameBox.setMaxLength(10);
		UsernameBox.setBorderColor(null);
		UsernameBox.setCursorVisible(true);
		UsernameBox.setBackgroundColor( UsernameBoxColor);
		UsernameBox.setText("");

		spriteBox = new TextField(container, container.getDefaultFont(), 510,280,15,20);
		spriteBox.setMaxLength(1);
		spriteBox.setBorderColor(null);
		spriteBox.setCursorVisible(true);
		spriteBox.setBackgroundColor( UsernameBoxColor);
		spriteBox.setText("");

	}
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {

		font = new Font("LucidaSans",Font.BOLD,20);
		consigneFont = new TrueTypeFont(font, true);
		font = new Font("LucidaSans", Font.BOLD, 20);
		playersOptionsTTF = new TrueTypeFont(font, true);
		font = new Font ("LucidaSans", Font.PLAIN, 100);
		setFoo(new TrueTypeFont(font, true));


		playersOptions[0] = "Guerrier";
		playersOptions[1] = "Mage";
		playersOptions[2] = "Paladin";
		playersOptions[3] = "Troubadour";
		playersOptions[4] = "Brigand";
		playersOptions[5] = "Quitter";

	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Image background = new Image("/src/main/java/image/CreateCharacterMenu.png"); 

		g.drawImage(background, -420, -150);
		g.setFont(consigneFont);
		g.drawString("entrez le nom du Hero", 100, 100);
		g.drawString("choisisez la classe ", 100, 200);
		g.drawString("de votre Hero", 100, 220);
		g.drawString("personnage disponnible", 400, 100);
		g.drawImage(renderChara1, 425, 140);
		g.drawString("1", 430, 175);
		g.drawImage(renderChara2, 475, 140);
		g.drawString("2", 480, 175);
		g.drawImage(renderChara3, 525, 140);
		g.drawString("3", 530, 175);
		g.drawImage(renderChara4, 575, 140);
		g.drawString("4", 580, 175);
		g.drawImage(renderChara5, 625, 140);
		g.drawString("5", 630, 175);
		g.drawString("choisisez votre personnage", 400, 200);
		g.drawString("en ecrivant le numero", 400, 220);
		g.drawString("du personnage dans la ", 400, 240);
		g.drawString("zone de text ci-dessous", 400, 260);


		spriteBox.render(container, g);
		UsernameBox.render(container, g);
		renderPlayersOptions();
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		switch (classe) {
		case 0:
			renderChara1 = G1;
			renderChara2 = G2;
			renderChara3 = G3;
			renderChara4 = G4;
			renderChara5 = G5;
			break;
		case 1:
			renderChara1 = M1;
			renderChara2 = M2;
			renderChara3 = M3;
			renderChara4 = M4;
			renderChara5 = M5;
			break;
		case 2:
			renderChara1 = P1;
			renderChara2 = P2;
			renderChara3 = P3;
			renderChara4 = P4;
			renderChara5 = P5;
			break;
		case 3:
			renderChara1 = T1;
			renderChara2 = T2;
			renderChara3 = T3;
			renderChara4 = T4;
			renderChara5 = T5;
			break;
		case 4:
			renderChara1 = B1;
			renderChara2 = B2;
			renderChara3 = B3;
			renderChara4 = B4;
			renderChara5 = B5;
			break;
		default:
			renderChara1 = T1;
			renderChara2 = T2;
			renderChara3 = T3;
			renderChara4 = T4;
			renderChara5 = T5;
			break;

		}

		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			if (playersChoice == (NOCHOICES - 1)) {
				playersChoice = 0;
			} else {
				playersChoice++;
			}
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			if (playersChoice == 0) {
				playersChoice = NOCHOICES - 1;
			} else {
				playersChoice--;
			}
		}
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			switch (playersChoice) {
			case Guerrier:

				classe = (byte)0;
				

				break;

			case Mage:

				classe = (byte)1;

				
				break;
			case Paladin:
				classe=(byte)2;
			
				break;
			case Troubadour:
				classe=(byte)3;
			
				break;
			case Brigand:

				classe=(byte)4;
			
				break;
			case Exit:
				sbg.enterState(1);
				Sprite = spriteBox.getText(); 
				System.out.println(Sprite);
				Username = UsernameBox.getText();
				System.out.println(Username);
			//	byte heroclasse = classe ;
				break;
			default:


				classe=(byte)3;

			
				break;

			}
		}
	}

	public void leave() {
		
	}
	private void renderPlayersOptions() {
		
		for (int i = 0; i < NOCHOICES; i++) {
			if (playersChoice == i) {
				playersOptionsTTF.drawString(100, i * 40 + 270, playersOptions[i]);
			} else {
				playersOptionsTTF.drawString(100, i * 40 + 270, playersOptions[i], notChosen);
			}
		}
	}

	public TrueTypeFont getFoo() {
		return foo;
	}

	public void setFoo(TrueTypeFont foo) {
		this.foo = foo;
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

}
