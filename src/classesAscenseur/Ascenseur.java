package classesAscenseur;

/* 
 * En l'abscence de spécification sur la capacité de l'ascenseur de se déplacer de plusieurs étages avec la fonction goUP()
 * et goDown() on prend le partie que ces fonctions ne peuvent bouger l'ascenseur que d'un seul étage.
 * On suppose aussi que l'ascenseur s'initialise à la position au rez-de-chaussée.
 */

public class Ascenseur {
	
	int étageActuelAscenseur=0;
	
	public Ascenseur() {}

	public void goUp() {
		étageActuelAscenseur++;
	}
	
	public void goDown() {
		étageActuelAscenseur--;
	}
	
	public int getÉtageActuelAscenseur() {
		return étageActuelAscenseur;
	}

}
