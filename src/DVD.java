import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DVD extends Support_Numerique{

private String realisateur;



public DVD(String identifiant_produit, String titre, int tarif, String realisateur) {
	super(identifiant_produit, titre, tarif);
	this.realisateur = realisateur;
}

public String getRealisateur() {
	return realisateur;
}

public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
}

public void AjoutDVD(String ident, String Titre, int Tarif, String real)
{
	
	String Nl=System.getProperty("line.separator");
	

	    try { FileWriter file = new FileWriter("bdd/dvd.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("DVD : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - réalisateur: "+real+Nl);
	        bufferedwriter.flush();
	        bufferedwriter.close();
	        
		
		
	} catch(IOException e) {
		e.printStackTrace();
	}
    
}
public void ajoutstock(String ident,int qte)
{
	String Nl=System.getProperty("line.separator");
	

    try { FileWriter file = new FileWriter("bdd/stock.txt",true);
    BufferedWriter bufferedwriter = new BufferedWriter(file);
    	
        bufferedwriter.write(ident+"- quantité :"+qte+Nl);
        bufferedwriter.flush();
        bufferedwriter.close();
        

	
	
} catch(IOException e) {
	e.printStackTrace();
}	
}
}
