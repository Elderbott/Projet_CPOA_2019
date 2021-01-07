import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Dictionnaire extends Document{

private String Langue;



public Dictionnaire(String identifiant_produit, String titre, int tarif, String langue) {
	super(identifiant_produit, titre, tarif);
	Langue = langue;
}

public String getLangue() {
	return Langue;
}

public void setLangue(String langue) {
	Langue = langue;
}


public void Ajoutdico(String ident, String Titre, int Tarif, String langue)
{
	
	String Nl=System.getProperty("line.separator");
	

	    try { FileWriter file = new FileWriter("bdd/dictionnaire.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("Dictionnaire : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - langue: "+langue+Nl);
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
