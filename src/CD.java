import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CD extends Support_Numerique{
private int annee_sortie;



public CD(String identifiant_produit, String titre, int tarif, int annee_sortie) {
	super(identifiant_produit, titre, tarif);
	this.annee_sortie = annee_sortie;
}

public int getAnnee_sortie() {
	return annee_sortie;
}

public void setAnnee_sortie(int annee_sortie) {
	this.annee_sortie = annee_sortie;
}

public void AjoutCD(String ident, String Titre, int Tarif, int sortie)
{
	
	String Nl=System.getProperty("line.separator");
	

	    try { FileWriter file = new FileWriter("bdd/cd.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("CD : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - année de sortie: "+sortie+Nl);
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
    	
        bufferedwriter.write(ident+" - quantité :"+qte+Nl);
        bufferedwriter.flush();
        bufferedwriter.close();
        

	
	
} catch(IOException e) {
	e.printStackTrace();
}	
}
}
