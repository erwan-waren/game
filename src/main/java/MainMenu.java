package main.java;
import org.newdawn.slick.*;




import java.awt.Font;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGameState  {
	private StateBasedGame sbg;
	private final static int ID = 1;
	private int playersChoice = 0;
	private static final int NOCHOICES = 5;
	private static final int START = 0;
	private static final int SAVE = 1;
	private static final int LOAD = 2;
	private static final int OPTIONS = 3;
	private static final int QUIT = 4;
	private String[] playersOptions = new String[NOCHOICES];
	private boolean exit = false;
	private Font font;
	private TrueTypeFont playersOptionsTTF, foo;
	private Color notChosen = new Color(153, 204, 255);
	TextField commandBox;
	  
	public MainMenu() {
		super();
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		commandBox = new TextField(gc,null,20,20,80,5);
		
		 Music background1 = new Music("main/java/sound/menu_sound.ogg");
		    background1.loop();
		 //   String texte = "";
		
		font = new Font("Verdana", Font.BOLD, 40);
		playersOptionsTTF = new TrueTypeFont(font, true);
		font = new Font ("Verdana", Font.PLAIN, 100);
		setFoo(new TrueTypeFont(font, true));
		
		playersOptions[0] = "Nouvelle Partie";
		playersOptions[1] = "Sauvegarder";
		playersOptions[2] = "Charger";
		playersOptions[3] = "Options";
		playersOptions[4] = "Sortie";

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
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
				sbg.enterState(Empty_windows.ID);
				
	/*			AppGameContainer Jeu =
				new AppGameContainer(new Empty_windows());
				
				Jeu.isFullscreen();
				Jeu.start();*/
		
			
				
				
			   break;
			case SAVE:
		
				 
				
				
			
			default:
				
				
				break;
			}
		}
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		
		
		if (exit) {
			gc.exit();
		}
		Image background = new Image("/src/main/java/image/menu.png"); 
	
		g.drawImage(background, -200, 0);
	
	g.drawString("Stroheim Adventure", 350, 50);
	

	

		renderPlayersOptions();

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

