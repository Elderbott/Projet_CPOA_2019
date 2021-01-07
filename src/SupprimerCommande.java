import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SupprimerCommande extends JFrame implements ActionListener{

	private  JComboBox<String> cb_commande;	
	private String ligne;
	private JButton valider;
    private ArrayList<String> commande;
    private String produit,ident_pr,produit_qte;
    private ArrayList<String>txt_stock;
    private int stock_pr;
    private JLabel commande_choix;
public SupprimerCommande()
{
	 this.setTitle("Fenetre de suppresion");
	   this.setSize(1400,300);
	   this.setLocation(50, 100);
	   

	   
	   this.setLayout(new BorderLayout());
	   
	   
	   
	   JPanel panneauNord = new JPanel();
	   panneauNord.setLayout(new FlowLayout());
	   commande_choix= new JLabel("Veuillez choisir une commande a supprimer :");
	   panneauNord.add(commande_choix);
	   this.add(panneauNord, BorderLayout.NORTH);
	   panneauNord.setBackground(Color.white);
	   
	   
	   
	   
	   
	   JPanel panneauCentre = new JPanel();
	   panneauCentre.setLayout(new FlowLayout());
	   cb_commande = new JComboBox<String>();
	   cb_commande.addItem("");
	   panneauCentre.add(cb_commande);
	   panneauCentre.setBackground(Color.white);
	   this.add(panneauCentre, BorderLayout.CENTER);
	   BufferedReader br = null;
	   commande = new ArrayList<String>();
		  try { br = new BufferedReader(new FileReader("bdd/commande.txt"));
		   while((ligne = br.readLine()) != null) {
				   cb_commande.addItem(ligne); 
				   commande.add(ligne);
		   }
			br.close();
			
		} catch(IOException E) {
			E.printStackTrace();
		}
		  
		  JPanel bouton = new JPanel();
		  bouton.setLayout(new FlowLayout());
		  valider = new JButton("Valider");
		  bouton.add(valider);
		  this.add(bouton, BorderLayout.SOUTH);
		  bouton.setBackground(Color.white);
		  valider.addActionListener(this);
		  
}

public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();

if(obj==valider)
{
	//remplissage de larraylist pour modifier les commandes
	 txt_stock = new ArrayList<String>();
	 BufferedReader br = null;
	  try { br = new BufferedReader(new FileReader("bdd/stock.txt"));
	   while((ligne = br.readLine()) != null) {
			   txt_stock.add(ligne);
	   }
	   br.close();
		} catch(IOException E) {
			E.printStackTrace();
		}		
	int option=JOptionPane.showConfirmDialog(null, "Etes vous sure de vouloir supprimer cette commande?", "suppresion d'une commande", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
	if(option == JOptionPane.OK_OPTION){
		{
			//on parcours la chaine qui contient la commande a supprimer
			produit=(String) cb_commande.getSelectedItem();
			String produits_couper[] = produit.split("-");
			 for (int i = 0; i < produits_couper.length; i++) {
				 if(produits_couper[i].startsWith(" produit"))
				 {
					ident_pr=produits_couper[i].substring(10);
				 }
			 }
			try {
				//on supprime le contenu de notre fichier text
				new FileWriter(new File("bdd/stock.txt")).close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		 for(int i=0;i<txt_stock.size();i++)
		 {
			 String test=txt_stock.get(i);
			 try { FileWriter file = new FileWriter("bdd/stock.txt",true);
				String Nl=System.getProperty("line.separator");
			    BufferedWriter bufferedwriter = new BufferedWriter(file);
			if(test.startsWith(ident_pr))
			{
				//on verifie si la commande asupprimer contient quellet type de produit
				if(ident_pr.startsWith("DI"))
				{
					 produit_qte=txt_stock.get(i);
					produit_qte=produit_qte.substring(18);	
					stock_pr=Integer.parseInt(produit_qte);
					stock_pr=stock_pr+1;
				}
				if(ident_pr.startsWith("M")||ident_pr.startsWith("R"))
				{
					 produit_qte=txt_stock.get(i);
					produit_qte=produit_qte.substring(15);	
					stock_pr=Integer.parseInt(produit_qte);
					stock_pr=stock_pr+1;
				}
				if(ident_pr.startsWith("B")||ident_pr.startsWith("C"))
				{
					 produit_qte=txt_stock.get(i);
					produit_qte=produit_qte.substring(16);	
					stock_pr=Integer.parseInt(produit_qte);
					stock_pr=stock_pr+1;
				}
				if(ident_pr.startsWith("DV"))
				{
					 produit_qte=txt_stock.get(i);
					produit_qte=produit_qte.substring(17);	
					stock_pr=Integer.parseInt(produit_qte);
					stock_pr=stock_pr+1;
				}
			
			
			    	bufferedwriter.write(ident_pr+"- quantité :"+stock_pr+Nl);
			        bufferedwriter.flush();
			        bufferedwriter.close();
			       
			}
			else
			{
				    	bufferedwriter.write(txt_stock.get(i)+Nl);
				        bufferedwriter.flush();
				        bufferedwriter.close();
				        	
		      
			}
		 } catch(IOException e23) {
				e23.printStackTrace();
		}
			
		 }
		 }
	try {
		//on supprime toute les commandes du fichier texte
		new FileWriter(new File("bdd/commande.txt")).close();
	} catch (IOException e2) {
		e2.printStackTrace();
	}
	for (int i = 0; i < commande.size(); i++) {
		String Nl=System.getProperty("line.separator");
		

	    try { 
	    FileWriter file = new FileWriter("bdd/commande.txt",true);
	    BufferedWriter bufferedwriter = new BufferedWriter(file);
	    if(commande.get(i)==cb_commande.getSelectedItem())	
	    {
	    	//si la commande est egale a lindice i de larraylist on ne fait rien comme ca le fichier ne contiendra pas la commande a supprimer
	    }
	    else
	    {
	        bufferedwriter.write(commande.get(i)+Nl);
	        bufferedwriter.flush();
	        bufferedwriter.close();
	    }
	    
		
		
	} catch(IOException e1) {
		e1.printStackTrace();
	}
		
		
		
	}
}
}
}
}
