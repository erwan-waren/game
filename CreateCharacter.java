/**
 * 
 */
package main.java;

/**
 * @author chevalier
 *
 */
public class CreateCharacter {
	short CharacterHp;
	short CharacterMp;
	short CharacterAtk_P;
	short CharacterAtk_M ;
	float CharacterDef_P ;
	float CharacterDef_M ;
	float CharacterDex;
    short Hp = 20;
	short Mp = 5;
	short Atk_P = 4;
	short Atk_M = 4;
	float Def_P = 0.02f;
	float Def_M = 0.02f;
	float Dex = 0.05f;
	
	public  CreateCharacter( String username , byte classe) {
	
		switch (classe) {
		case 0: {//Guerrier
			 CharacterHp = (short) (Hp*6);
			 CharacterMp = (short) (Mp*2);
		     CharacterAtk_P = (short) (Atk_P*4);
			 CharacterAtk_M = (short) (Atk_M);
			 CharacterDef_P = (float) (Def_P*5);
			 CharacterDef_M = (float) (Def_M);
			 CharacterDex = (float) (Dex*2);
			 break;
		}
		case 1:{ //Mage
			 CharacterHp = (short) (Hp*3);
			 CharacterMp = (short) (Mp*5);
			 CharacterAtk_P = (short) (Atk_P*2);
			 CharacterAtk_M = (short) (Atk_M*5);
			 CharacterDef_P = (float) (Def_P);
			 CharacterDef_M = (float) (Def_M*4);
			 CharacterDex = (float) (Dex);
			 break;
		}
		case 2:{ //paladin
			 CharacterHp = (short) (Hp*5);
			 CharacterMp = (short) (Mp*5);
			 CharacterAtk_P = (short) (Atk_P);
			 CharacterAtk_M = (short) (Atk_M);
			 CharacterDef_P = (float) (Def_P*4);
			 CharacterDef_M = (float) (Def_M*4);
			 CharacterDex = (float) (Dex*2);
			 break;
		}
		case 3: {//Troubadour
			CharacterHp = (short) (Hp*3);
			CharacterMp = (short) (Mp*3);
			CharacterAtk_P = (short) (Atk_P*3);
			CharacterAtk_M = (short) (Atk_M*3);
		    CharacterDef_P = (float) (Def_P*3);
		    CharacterDef_M = (float) (Def_M*3);
		    CharacterDex = (float) (Dex*3);
		    break;
		}
		case 4:{ //Brigand
			CharacterHp = (short) (Hp*3);
			CharacterMp = (short) (Mp*3);
			CharacterAtk_P = (short) (Atk_P*5);
			CharacterAtk_M = (short) (Atk_M);
			CharacterDef_P = (float) (Def_P*2);
			CharacterDef_M = (float) (Def_M*2);
			CharacterDex = (float) (Dex*5);
			break;
		}
		}
		
	} 
}


