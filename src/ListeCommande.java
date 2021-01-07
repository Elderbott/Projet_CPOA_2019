import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListeCommande extends JFrame{
	private JLabel liste;
	private JTextArea Liste_cl;
	 public ListeCommande()
	   {
		   this.setTitle("Liste des clients");
		   this.setSize(1400,700);
		   this.setLocation(50, 100);
		   
		   
		   JPanel panneauNord= new JPanel();
		   panneauNord.setLayout(new FlowLayout());
		   liste = new JLabel("Liste des commandes :");
		   panneauNord.add(liste);
		   this.add(panneauNord, BorderLayout.NORTH);
		   panneauNord.setBackground(Color.white);
		   
		   
		   JPanel panneauCentre= new JPanel();
		   panneauCentre.setLayout(new FlowLayout());
		   Liste_cl = new JTextArea();
		   panneauCentre.add(Liste_cl);
		   this.add(panneauCentre, BorderLayout.CENTER);
		   panneauCentre.setBackground(Color.white);
		   
		   BufferedReader br = null;
			  String ligne;
			  
			  try { br = new BufferedReader(new FileReader("bdd/commande.txt"));
			   while((ligne = br.readLine()) != null) {
				   Liste_cl.append(ligne);
				   Liste_cl.append("\n");
			   }
			    
				
				
			} catch(IOException i) {
				i.printStackTrace();
			}
	   }
}
