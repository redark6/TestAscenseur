package classesAscenseur;

public class MechanismeAscenseur {

	/*
	 * Dans notre cas, on initialise les valeur en supposant que cela correspond
	 * aux données réel d'un batiment déservie par l'engin.
	 */

	private Ascenseur ascenseur;
	private TableauDeCommande tableauDeCommande;

	int étageMin=-2, étageMax=5;

	public int getÉtageMin() {
		return étageMin;
	}

	public int getÉtageMax() {
		return étageMax;
	}

	public MechanismeAscenseur() {
		this.ascenseur= new Ascenseur();
		this.tableauDeCommande = new TableauDeCommande();
	}

	public void BoucleSystème() {
		int étageDestination;
		boolean pasACetEtage;
		do{
			this.tableauDeCommande.indicationPostion(this.ascenseur.étageActuelAscenseur,this.étageMin,this.étageMax);
			do {
				do {
					étageDestination=this.tableauDeCommande.demanderDestinationAUtilisateur();
				}
				while(verifierAscenseurDansIntervale(étageDestination)==false);
				if((pasACetEtage=DéplacerAscenseur(étageDestination)))
					this.tableauDeCommande.MessageSucces(étageDestination);
			}while(!pasACetEtage);

		}while(this.tableauDeCommande.ContinuerAUtiliserAscenseur());
		this.tableauDeCommande.messageFin();
	}

	//verifie si l'utilisateur etre bien une valeur qui correspond au parcours possible par l'ascenseur
	private boolean verifierAscenseurDansIntervale(int destination) {
		if(destination <= étageMax && destination >= étageMin)
			return true;
		else {
			this.tableauDeCommande.messageHorsLimite();
			return false;
		}
	}

	private boolean DéplacerAscenseur(int destination) {

		int déplacement=destination-this.ascenseur.getÉtageActuelAscenseur();
		if(déplacement>0) {
			for(int deplacer=0;deplacer<déplacement;deplacer++)
				this.ascenseur.goUp();
			return true;
		}
		else if(déplacement<0) {
			for(int deplacer=0;deplacer>déplacement;deplacer--)
				this.ascenseur.goDown();
			return true;
		}
		else {
			this.tableauDeCommande.afficherMessageDéjaALétage();
			return false;
		}

	}


}
