
abstract class Livre extends Document{
	
protected String auteur;



public Livre(String identifiant_produit, String titre, int tarif, String auteur) {
	super(identifiant_produit, titre, tarif);
	this.auteur = auteur;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}



}
