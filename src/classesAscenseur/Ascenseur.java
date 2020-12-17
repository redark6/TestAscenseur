package classesAscenseur;

/* 
 * En l'abscence de sp�cification sur la capacit� de l'ascenseur de se d�placer de plusieurs �tages avec la fonction goUP()
 * et goDown() on prend le partie que ces fonctions ne peuvent bouger l'ascenseur que d'un seul �tage.
 * On suppose aussi que l'ascenseur s'initialise � la position au rez-de-chauss�e.
 */

public class Ascenseur {
	
	int �tageActuelAscenseur=0;
	
	public Ascenseur() {}

	public void goUp() {
		�tageActuelAscenseur++;
	}
	
	public void goDown() {
		�tageActuelAscenseur--;
	}
	
	public int get�tageActuelAscenseur() {
		return �tageActuelAscenseur;
	}

}
