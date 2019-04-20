/**
 * 
 */
package main.java;

import org.newdawn.slick.Image;
//import static main.java.Consts.PATH_TO_IMAGES;

/**
 * @author chevalier
 *
 */
public class CreateCharacter {
	
	
	String G1 = new String ("/src/main/java/spritesG1.png");
	String G2 = new String ("/src/main/java/sprites/G2.png");
	String G3 = new String ("/src/main/java/sprites/G3.png");
	String G4 = new String ("/src/main/java/sprites/G4.png");
	String G5 = new String ("/src/main/java/sprites/G5.png");

	String M1 = new String ("/src/main/java/sprites/M1.png");
	String M2 = new String ("/src/main/java/sprites/M2.png");
	String M3 = new String ("/src/main/java/sprites/M3.png");
	String M4 = new String ("/src/main/java/sprites/M4.png");
	String M5 = new String ("/src/main/java/sprites/M5.png");

	String P1 = new String ("/src/main/java/sprites/P1.png");
	String P2 = new String ("/src/main/java/sprites/P2.png");
	String P3 = new String ("/src/main/java/sprites/P3.png");
	String P4 = new String ("/src/main/java/sprites/P4.png");
	String P5 = new String ("/src/main/java/sprites/P5.png");

	String T1 = new String ("/src/main/java/sprites/T1.png");
	String T2 = new String ("/src/main/java/sprites/T2.png");
	String T3 = new String ("/src/main/java/sprites/T3.png");
	String T4 = new String ("/src/main/java/sprites/T4.png");
	String T5 = new String ("/src/main/java/sprites/T5.png");

	String B1 = new String ("/src/main/java/sprites/B1.png");
	String B2 = new String ("/src/main/java/sprites/B2.png");
	String B3 = new String ("/src/main/java/sprites/B3.png");
	String B4 = new String ("/src/main/java/sprites/B4.png");
	String B5 = new String ("/src/main/java/sprites/B5.png");

	
	short Hp = 20;
	short Mp = 5;
	short Atk_P = 4;
	short Atk_M = 4;
	float Def_P = 0.02f;
	float Def_M = 0.02f;
	float Dex = 0.05f;
	static String Sprite;
	//private String renderSprite;
	static int Classe;

	public  CreateCharacter( String username , int classe, String sprite) {
		this.Classe = classe;
 this.Sprite = sprite;
		switch (classe) {
		case 0: //Guerrier
			Hp = (short) (Hp*6);
			Mp = (short) (Mp*2);
			Atk_P = (short) (Atk_P*4);
			Atk_M = (short) (Atk_M);
			Def_P = (float) (Def_P*5);
			Def_M = (float) (Def_M);
			Dex = (float) (Dex*2);
			break;

		case 1: //Mage
			Hp = (short) (Hp*3);
			Mp = (short) (Mp*5);
			Atk_P = (short) (Atk_P*2);
			Atk_M = (short) (Atk_M*5);
			Def_P = (float) (Def_P);
			Def_M = (float) (Def_M*4);
			Dex = (float) (Dex);
			break;

		case 2://paladin
			Hp = (short) (Hp*5);
			Mp = (short) (Mp*5);
			Atk_P = (short) (Atk_P);
			Atk_M = (short) (Atk_M);
			Def_P = (float) (Def_P*4);
			Def_M = (float) (Def_M*4);
			Dex = (float) (Dex*2);
			break;

		case 3: //Troubadour
			Hp = (short) (Hp*3);
			Mp = (short) (Mp*3);
			Atk_P = (short) (Atk_P*3);
			Atk_M = (short) (Atk_M*3);
			Def_P = (float) (Def_P*3);
			Def_M = (float) (Def_M*3);
			Dex = (float) (Dex*3);
			break;

		case 4: //Brigand
			Hp = (short) (Hp*3);
			Mp = (short) (Mp*3);
			Atk_P = (short) (Atk_P*5);
			Atk_M = (short) (Atk_M);
			Def_P = (float) (Def_P*2);
			Def_M = (float) (Def_M*2);
			Dex = (float) (Dex*5);
			break;
		}
		switch (Classe) {
		case 0:
			switch (this.Sprite) {
			case"1":
				Sprite = this.G1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.G2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.G3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.G4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.G5;
				System.out.println(Sprite);
				break;
				
				default:
					Sprite = this.G1;
					System.out.println(Sprite);
					break;
				
			}
		case 1:
			switch (this.Sprite) {
			case"1":
				Sprite = this.M1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.M2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.M3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.M4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.M5;
				System.out.println(Sprite);
				break;
				
				default:
					Sprite = this.M1;
					System.out.println(Sprite);
					break;
				
			}

		case 2:
			
			switch (this.Sprite) {
			case"1":
				Sprite = this.P1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.P2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.P3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.P4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.P5;
				System.out.println(Sprite);
				break;
				
			}
			
			break;

		case 3:
			switch (this.Sprite) {
			case"1":
				Sprite = this.T1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.T2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.T3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.T4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.T5;
				System.out.println(Sprite);
				break;
				
				default:
					Sprite = this.T1;
					System.out.println(Sprite);
					break;
				
			}
		case 4:
			switch (this.Sprite) {
			case"1":
				Sprite = this.B1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.B2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.B3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.B4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.B5;
				System.out.println(Sprite);
				break;
				
				default:
					Sprite = this.B1;
					System.out.println(Sprite);
					break;
				
			}

		default:
			switch (this.Sprite) {
			case"1":
				Sprite = this.T1;
				System.out.println(Sprite);
				break;
			case "2":
				Sprite = this.T2;
				System.out.println(Sprite);
				break;
				
			case"3":
				Sprite = this.T3;
				System.out.println(Sprite);
				break;
				
			case"4":
				Sprite = this.T4;
				System.out.println(Sprite);
				break;
			case"5":
				Sprite = this.T5;
				System.out.println(Sprite);
				break;
				
				default:
					Sprite = this.T1;
					System.out.println(Sprite);
					break;
				
			}

		}
	} 
}


