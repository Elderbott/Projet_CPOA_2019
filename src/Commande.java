import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Commande extends Produit{

private String ident_commande;

public Commande(String identifiant_produit, String titre, int tarif, String ident_commande) {
	super(identifiant_produit, titre, tarif);
	this.ident_commande = ident_commande;
}

public String getIdent_commande() {
	return ident_commande;
}

public void setIdent_commande(String ident_commande) {
	this.ident_commande = ident_commande;
	
}

public void AjoutCommande(String ident,String Titre,int Tarif,String ident_co,float delai,String ident_cl,String nom,String prenom,boolean fidele)
{
	if(fidele==true)
	{
		float prix=(float) (Tarif)*(delai);
		float reduction=prix*10/100;
		prix=prix-reduction;
		
		String Nl=System.getProperty("line.separator");
		

	    try { FileWriter file = new FileWriter("bdd/commande.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("Commande : "+ident_co+" - produit: "+ident+"- titre: "+Titre+" - tarif avec reduction: "+prix+"€ - client: "+ident_cl+"- nom:"+nom+"- prenom:"+prenom+Nl);
	        bufferedwriter.flush();
	        bufferedwriter.close();
	        
	        
	    
	        
		
	} catch(IOException e) {
		e.printStackTrace();
	}
	}
	else
	{
		float prix=(float)(Tarif)*(delai);
		
String Nl=System.getProperty("line.separator");
		

	    try { FileWriter file = new FileWriter("bdd/commande.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("Commande : "+ident_co+" - produit: "+ident+"- titre: "+Titre+" - tarif sans réduction: "+prix+"€ - client: "+ident_cl+"- nom:"+nom+"- prenom:"+prenom+Nl);
	        bufferedwriter.flush();
	        bufferedwriter.close();
	    } catch(IOException e) {
			e.printStackTrace();
		}
		}
	}




public String commande(String ident,String Titre,int Tarif,String ident_co,float delai,String ident_cl,String nom,String prenom,boolean fidele)
{
	String produits;
	if(fidele==true)
	{
		float prix=(float) (Tarif)*(delai);
		float reduction=prix*10/100;
		prix=prix-reduction;
	produits="Commande : "+ident_co+" - produit: "+ident+"- titre: "+Titre+" - tarif avec reduction: "+prix+"€ - client: "+ident_cl+"- nom:"+nom+"- prenom:"+prenom;
	}
	else
	{
		float prix=(float)(Tarif)*(delai);
		produits="Commande : "+ident_co+" - produit: "+ident+"- titre: "+Titre+" - tarif sans réduction: "+prix+"€ - client: "+ident_cl+"- nom:"+nom+"- prenom:"+prenom;
	}
	return produits;
}	
}


