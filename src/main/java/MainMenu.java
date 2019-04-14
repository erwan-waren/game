package main.java;
import org.newdawn.slick.*;




import java.awt.Font;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;

public class MainMenu extends BasicGame implements GameState {
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
		super("Menu Principal");
	}

	public void init(GameContainer gc) throws SlickException {
		
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

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
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
				
				AppGameContainer Jeu =
				new AppGameContainer(new Empty_windows());
				
				Jeu.isFullscreen();
				Jeu.start();
		
			
				
				
			   break;
			case SAVE:
		
				 
				
				
			
			default:
				
				
				break;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		
		
		if (exit) {
			gc.exit();
		}
		Image background = new Image("/src/main/java/image/menu.png"); 
	
		g.drawImage(background, -200, 0);
	
	g.drawString("Stroheim Adventure", 350, 50);
	

	

		renderPlayersOptions();

	}

	public static void main(String[] args)
			throws SlickException {
		AppGameContainer app =
				new AppGameContainer(new MainMenu());
		app.setDisplayMode(900, 700, false);
		app.start();
		
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
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}
}

