/**
 * 
 */
package main.java;


/**
 * @author chevalier
 *
 */
public class CreateCharacter {
	public String sprite;
    short Hp = 20;
	short Mp = 5;
	short Atk_P = 4;
	short Atk_M = 4;
	float Def_P = 0.02f;
	float Def_M = 0.02f;
	float Dex = 0.05f;
	
	public  CreateCharacter( String username , byte classe, String sprite  ) {
    
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
		
	} 
}


