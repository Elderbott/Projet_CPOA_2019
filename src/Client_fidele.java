
public class Client_fidele extends Client{

private int reduction;





public Client_fidele(String identifiant, String nom, String prenom, int reduction) {
	super(identifiant, nom, prenom);
	this.reduction = reduction;
}

public int getReduction() {
	return reduction;
}

public void setReduction(int reduction) {
	this.reduction = reduction;
}


}
