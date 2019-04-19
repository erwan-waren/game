package main.java;
import org.newdawn.slick.*;




import java.awt.Font;

import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState   {
	
	static String Sprite = "/src/main/java/sprites/B5.png";
	private int Classe;
	
	private StateBasedGame sbg;
	
	private final static int ID = 1;
	
	private int playersChoice = 0;
	private static final int NOCHOICES = 6;
	private static final int START = 0;
	private static final int HERO = 1;
	private static final int SAVE = 2;
	private static final int LOAD = 3;
	private static final int OPTIONS = 4;
	private static final int QUIT = 5;
	private String[] playersOptions = new String[NOCHOICES];
	private Font font;
	private TrueTypeFont playersOptionsTTF, foo;
	private Color notChosen = new Color(25, 50, 255);
	
	private boolean exit = false;
	
	
	
	static String Username ;

	
	private Color bord = new Color(7,111,21);
	
	public MainMenu() throws SlickException {
		super();
		
	}
	
	public void enter (GameContainer container, StateBasedGame sbg) throws SlickException{
		Music background1 = new Music("main/java/sound/menu_sound.ogg");
		 background1.loop();
		
		this.Sprite = CreateCharacterMenu.Sprite;
		this.Username = CreateCharacterMenu.Username;
		this.Classe = CreateCharacterMenu.classe;
		CreateCharacter hero = new CreateCharacter (Username, Classe, Sprite);
		this.Sprite = hero.Sprite;
		
		this.Classe = hero.Classe;
		System.out.println(Username+"  "+Classe+"  "+this.Sprite );
	}



	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
	
		
		
		font = new Font("Verdana", Font.BOLD, 40);
		playersOptionsTTF = new TrueTypeFont(font, true);
		font = new Font ("Verdana", Font.PLAIN, 100);
		setFoo(new TrueTypeFont(font, true));
		
		playersOptions[0] = "Nouvelle Partie";
		playersOptions[1] = "creer un hero";
		playersOptions[2] = "Sauvegarder";
		playersOptions[3] = "Charger";
		playersOptions[4] = "Options";
		playersOptions[5] = "Sortie";
		
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException  {
	
		
		
		
		
		
		
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
			case QUIT:
			
			
				
						
				exit = true;
				break;
			case START:
				sbg.enterState(2);
			
				System.out.println("le hero se nomme "+CreateCharacterMenu.Username);
				
				
			   break;
			case SAVE:
		
				 
				
				
			
			default:
				
				
				break;
			case HERO:
				sbg.enterState(3);
				
				break;
			
			}
		}
	}


	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {

		
		
		if (exit) {
			container.exit();
		}
		Image background = new Image("/src/main/java/image/menu.png"); 
	
		g.drawImage(background, -200, 0);
	
	
	

	

		renderPlayersOptions();

		
	//	commandBox.setText("Stroheim");



	}
public void leave(GameContainer container, StateBasedGame sbg) throws SlickException {
	
}
	

	private void renderPlayersOptions() {
		for (int i = 0; i < NOCHOICES; i++) {
			if (playersChoice == i) {
				playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i]);
			} else {
				playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i], notChosen);
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

