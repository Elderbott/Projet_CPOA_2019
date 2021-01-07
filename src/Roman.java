import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Roman extends Livre{

	public Roman(String identifiant_produit, String titre, int tarif, String auteur) {
		super(identifiant_produit, titre, tarif, auteur);
		
	}
	public void Ajoutroman(String ident, String Titre, int Tarif, String auteur_roman)
	{
		
		String Nl=System.getProperty("line.separator");
		

		  try { FileWriter file = new FileWriter("bdd/roman.txt",true);
		    BufferedWriter bufferedwriter = new BufferedWriter(file);
		    	
		        bufferedwriter.write("Roman : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - auteur du roman:  "+auteur_roman+Nl);
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
