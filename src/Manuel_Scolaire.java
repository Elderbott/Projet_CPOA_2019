import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Manuel_Scolaire extends Livre{

	public Manuel_Scolaire(String identifiant_produit, String titre, int tarif, String auteur) {
		super(identifiant_produit, titre, tarif, auteur);
	
	}
	public void Ajoutmanuel(String ident, String Titre, int Tarif, String auteur_manuel)
	{
		
		String Nl=System.getProperty("line.separator");
		

		    try { FileWriter file = new FileWriter("bdd/manuel.txt",true);
		    BufferedWriter bufferedwriter = new BufferedWriter(file);
		    	
		        bufferedwriter.write("Manuel scolaire : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - auteur du manuel: "+auteur_manuel+Nl);
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
