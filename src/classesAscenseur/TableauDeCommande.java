package classesAscenseur;

import java.util.Scanner;

public class TableauDeCommande {

	private Scanner scanner;

	public TableauDeCommande() {
		scanner= new Scanner(System.in);
	}

	public int demanderDestinationAUtilisateur () {
		boolean erreur;
		int �tageDestination;
		do {
			erreur=false;
			�tageDestination=0;
			System.out.println("A quel �tage voulez-vous aller ?");
			try {
				�tageDestination=scanner.nextInt();
				scanner.reset();
			}
			catch (Exception exception) {
				erreur=true;
				System.out.println("Votre saisie est incorrect !");
				scanner.nextLine();
			}
		}
		while(erreur);

		return �tageDestination;
	}

	public void indicationPostion(int �tageActuel,int �tageBas ,int  �tageHaut) {
		System.out.println("vous �tes � l'�tage "+�tageActuel+", l'�tage les plus bas est l'�tage "+�tageBas +" et l'�tage le plus haut est l'�tage "+�tageHaut+".");
	}

	public boolean ContinuerAUtiliserAscenseur() {
		boolean erreur;
		char continuer;
		do {
			erreur=false;
			System.out.println("voulez-vous continuer � utiliser l'ascenseur ? O/N");
			continuer=scanner.next().toUpperCase().charAt(0);
			if(continuer != 'O' && continuer != 'N') {
				erreur=true;
				System.out.println("Votre saisie ne correspond pas au standard O/N !");
			}

		}
		while(erreur);
		if(continuer=='O')
			return true;
		else
			return false;
	}
	
	public void messageHorsLimite() {
		System.out.println("l'�tage que vous essayez d'atteindre n'existe pas !");
	}

	public void afficherMessageD�jaAL�tage() {
		System.out.println("Vous �tes d�j� � cette �tage !");
	}

	public void MessageSucces(int �tage) {
		System.out.println("vous �tes arriv� � l'�tage "+�tage+" !");
	}
	
	public void messageFin() {
		System.out.println("Au revoir !");
	}

}
