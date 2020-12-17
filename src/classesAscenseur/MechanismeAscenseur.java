package classesAscenseur;

public class MechanismeAscenseur {

	/*
	 * Dans notre cas, on initialise les valeur en supposant que cela correspond
	 * aux donn�es r�el d'un batiment d�servie par l'engin.
	 */

	private Ascenseur ascenseur;
	private TableauDeCommande tableauDeCommande;

	int �tageMin=-2, �tageMax=5;

	public int get�tageMin() {
		return �tageMin;
	}

	public int get�tageMax() {
		return �tageMax;
	}

	public MechanismeAscenseur() {
		this.ascenseur= new Ascenseur();
		this.tableauDeCommande = new TableauDeCommande();
	}

	public void BoucleSyst�me() {
		int �tageDestination;
		boolean pasACetEtage;
		do{
			this.tableauDeCommande.indicationPostion(this.ascenseur.�tageActuelAscenseur,this.�tageMin,this.�tageMax);
			do {
				do {
					�tageDestination=this.tableauDeCommande.demanderDestinationAUtilisateur();
				}
				while(verifierAscenseurDansIntervale(�tageDestination)==false);
				if((pasACetEtage=D�placerAscenseur(�tageDestination)))
					this.tableauDeCommande.MessageSucces(�tageDestination);
			}while(!pasACetEtage);

		}while(this.tableauDeCommande.ContinuerAUtiliserAscenseur());
		this.tableauDeCommande.messageFin();
	}

	//verifie si l'utilisateur etre bien une valeur qui correspond au parcours possible par l'ascenseur
	private boolean verifierAscenseurDansIntervale(int destination) {
		if(destination <= �tageMax && destination >= �tageMin)
			return true;
		else {
			this.tableauDeCommande.messageHorsLimite();
			return false;
		}
	}

	private boolean D�placerAscenseur(int destination) {

		int d�placement=destination-this.ascenseur.get�tageActuelAscenseur();
		if(d�placement>0) {
			for(int deplacer=0;deplacer<d�placement;deplacer++)
				this.ascenseur.goUp();
			return true;
		}
		else if(d�placement<0) {
			for(int deplacer=0;deplacer>d�placement;deplacer--)
				this.ascenseur.goDown();
			return true;
		}
		else {
			this.tableauDeCommande.afficherMessageD�jaAL�tage();
			return false;
		}

	}


}
