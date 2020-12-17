package classesAscenseur;

import java.util.Scanner;

public class TableauDeCommande {

	private Scanner scanner;

	public TableauDeCommande() {
		scanner= new Scanner(System.in);
	}

	public int demanderDestinationAUtilisateur () {
		boolean erreur;
		int étageDestination;
		do {
			erreur=false;
			étageDestination=0;
			System.out.println("A quel étage voulez-vous aller ?");
			try {
				étageDestination=scanner.nextInt();
				scanner.reset();
			}
			catch (Exception exception) {
				erreur=true;
				System.out.println("Votre saisie est incorrect !");
				scanner.nextLine();
			}
		}
		while(erreur);

		return étageDestination;
	}

	public void indicationPostion(int étageActuel,int étageBas ,int  étageHaut) {
		System.out.println("vous êtes à l'étage "+étageActuel+", l'étage les plus bas est l'étage "+étageBas +" et l'étage le plus haut est l'étage "+étageHaut+".");
	}

	public boolean ContinuerAUtiliserAscenseur() {
		boolean erreur;
		char continuer;
		do {
			erreur=false;
			System.out.println("voulez-vous continuer à utiliser l'ascenseur ? O/N");
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
		System.out.println("l'étage que vous essayez d'atteindre n'existe pas !");
	}

	public void afficherMessageDéjaALétage() {
		System.out.println("Vous êtes déjà à cette étage !");
	}

	public void MessageSucces(int étage) {
		System.out.println("vous êtes arrivé à l'étage "+étage+" !");
	}
	
	public void messageFin() {
		System.out.println("Au revoir !");
	}

}
