import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Client {

protected String identifiant;
protected String nom;
protected String prenom;



public Client(String identifiant, String nom, String prenom) {
	super();
	this.identifiant = identifiant;
	this.nom = nom;
	this.prenom = prenom;
}








public String getIdentifiant() {
	return identifiant;
}








public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}








public String getNom() {
	return nom;
}








public void setNom(String nom) {
	this.nom = nom;
}








public String getPrenom() {
	return prenom;
}








public void setPrenom(String prenom) {
	this.prenom = prenom;
}



public void AjoutClient(String ident, String Nom, String Prenom, boolean fidele)
{
	
	String Nl=System.getProperty("line.separator");
	

	    try { FileWriter file = new FileWriter("bdd/client.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    	
	        bufferedwriter.write("Identifiant : "+ident+" - nom : "+Nom+" -  prenom : "+Prenom+" - "+"client fidèle :"+fidele+Nl);
	        bufferedwriter.flush();
	        bufferedwriter.close();
		
		
	} catch(IOException e) {
		e.printStackTrace();
	}
    
}


}
