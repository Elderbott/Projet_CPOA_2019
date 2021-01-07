import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListeProduits extends JFrame implements ActionListener{
	private JLabel liste;

	private JButton btn_annuler,btn_liste;
	
	private  JComboBox<String> cb1;

	private JTextArea Liste_cl;
		 public ListeProduits()
		   {
			   this.setTitle("Liste des produits");
			   this.setSize(700,500);
			   this.setLocation(50, 100);
			   
			   
			   JPanel panneauNord= new JPanel();
			   panneauNord.setLayout(new FlowLayout());
			   liste = new JLabel("Veuillez choisir un type de produits :");
			   cb1=new JComboBox<String>();
			   cb1.addItem("CD");cb1.addItem("DVD");
			   cb1.addItem("BD");cb1.addItem("Dictionnaire");
			   cb1.addItem("Manuel scolaire");cb1.addItem("Roman");
			   panneauNord.add(liste);
			   panneauNord.add(cb1);
			   this.add(panneauNord, BorderLayout.NORTH);
			   panneauNord.setBackground(Color.white);
			   
			   
			   JPanel panneauCentre= new JPanel();
			   panneauCentre.setLayout(new FlowLayout());
			   Liste_cl = new JTextArea();
			   panneauCentre.add(Liste_cl);
			   this.add(panneauCentre, BorderLayout.CENTER);
			   panneauCentre.setBackground(Color.white);
			   
			   
			   JPanel panneauBas= new JPanel();
			   panneauBas.setLayout(new FlowLayout());
			   btn_liste= new JButton("Liste produits");
			   panneauBas.add(btn_liste);
			   btn_annuler= new JButton("Annuler");
			   panneauBas.add(btn_annuler);
			   this.add(panneauBas, BorderLayout.SOUTH);
			   panneauBas.setBackground(Color.white);
			   
			   btn_annuler.addActionListener(this);
			   btn_liste.addActionListener(this);
			   
	}
		 
		 public void actionPerformed(ActionEvent e) {
	 
			 Object obj = e.getSource();
			  if(( obj==btn_annuler))
			 		 {
			 	 		setVisible(false);
			 		 }
			  if((obj==btn_liste))
			  {
				  
				  String produit=(String) cb1.getSelectedItem();
				  BufferedReader br = null;
				  String ligne;
				  Liste_cl.setText("");
				 if(produit == "CD") 
				  try { br = new BufferedReader(new FileReader("bdd/cd.txt"));
				   while((ligne = br.readLine()) != null) {
					   Liste_cl.append(ligne);
					   Liste_cl.append("\n");
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
				 if(produit == "DVD") 
					  try { br = new BufferedReader(new FileReader("bdd/dvd.txt"));
					   while((ligne = br.readLine()) != null) {
						   Liste_cl.append(ligne);
						   Liste_cl.append("\n");
					   }
					    
						
						
					} catch(IOException i) {
						i.printStackTrace();
					}
				 if(produit == "BD") 
					  try { br = new BufferedReader(new FileReader("bdd/bd.txt"));
					   while((ligne = br.readLine()) != null) {
						   Liste_cl.append(ligne);
						   Liste_cl.append("\n");
					   }
					    
						
						
					} catch(IOException i) {
						i.printStackTrace();
					}
				 if(produit == "Dictionnaire") 
					  try { br = new BufferedReader(new FileReader("bdd/dictionnaire.txt"));
					   while((ligne = br.readLine()) != null) {
						   Liste_cl.append(ligne);
						   Liste_cl.append("\n");
					   }
					    
						
						
					} catch(IOException i) {
						i.printStackTrace();
					}
				 if(produit == "Manuel scolaire") 
					  try { br = new BufferedReader(new FileReader("bdd/manuel.txt"));
					   while((ligne = br.readLine()) != null) {
						   Liste_cl.append(ligne);
						   Liste_cl.append("\n");
					   }
					    
						
						
					} catch(IOException i) {
						i.printStackTrace();
					}
				 if(produit == "Roman") 
					  try { br = new BufferedReader(new FileReader("bdd/roman.txt"));
					   while((ligne = br.readLine()) != null) {
						   Liste_cl.append(ligne);
						   Liste_cl.append("\n");
					   }
					    
						
						
					} catch(IOException i) {
						i.printStackTrace();
					}
			
			  }
			
	}
	}


