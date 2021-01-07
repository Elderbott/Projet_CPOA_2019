
public class Produit {
	
protected String identifiant_produit;
protected String titre;
protected int tarif;

public Produit(String identifiant_produit, String titre, int tarif) {
	super();
	this.identifiant_produit = identifiant_produit;
	this.titre = titre;
	this.tarif = tarif;
}
public String getIdentifiant_produit() {
	return identifiant_produit;
}
public void setIdentifiant_produit(String identifiant_produit) {
	this.identifiant_produit = identifiant_produit;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getTarif() {
	return tarif;
}
public void setTarif(int tarif) {
	this.tarif = tarif;
}





}
