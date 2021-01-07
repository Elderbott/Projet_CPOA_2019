import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BD extends Livre{

	public BD(String identifiant_produit, String titre, int tarif, String auteur) {
		super(identifiant_produit, titre, tarif, auteur);
		
	}
	public void AjoutBD(String ident, String Titre, int Tarif, String auteur_bd)
	{
		
		String Nl=System.getProperty("line.separator");
		

		    try { FileWriter file = new FileWriter("bdd/bd.txt",true);
		    BufferedWriter bufferedwriter = new BufferedWriter(file);
		    	
		        bufferedwriter.write("BD : "+ident+" - titre: "+Titre+" - tarif: "+Tarif+"€ - auteur:"+auteur_bd+Nl);
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
