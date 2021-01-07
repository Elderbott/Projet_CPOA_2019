import java.awt.BorderLayout;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class AjoutCommande extends JFrame implements ActionListener{

private JLabel client;
private JLabel produits;
private JLabel dated;
private JLabel datef;


private int prix_cd, prix_dvd,c=1, prix_bd,prix_dico,prix_manuel,prix_roman,prix_pr;

private JButton valider_type;
private JButton valider_commande;
private JButton ajout_prod;
private JButton supprimer;

private  String ligne;

private JTextField jdated;
private JTextField jdatef;

private float prix_commande;

private String ident_cd,titre_cd,tarif_cd, ident_cl,nom_cl,prenom_cl,fidele,cd,aujourdhui,ident_co,ident_dvd,titre_dvd,tarif_dvd,dvd;
private String ident_bd,titre_bd,tarif_bd,bd,ident_dico,titre_dico,tarif_dico,dico, ident_manuel,titre_manuel,tarif_manuel,manuel;
private String ident_roman,titre_roman,tarif_roman,roman,ajout_produit,titre_pr,tarif_pr,prod,verif,somme_commande;

private  JComboBox<String> cb_client;
private  JComboBox<String> cb_produit;
private  JComboBox<String> cb_type;


private Date debut=null,fin=null;

private ArrayList<String>txt_commande;
private ArrayList<String>txt_stock;

private boolean cdselection=false,dvdselection=false,bdselection=false,dicoselection=false,manuelselection=false,romanselection=false,reduc=false,ajouterselection=false;

	 public AjoutCommande()
	   {
		   this.setTitle("Passer commande");
		   this.setSize(600,600);
		   this.setLocation(50, 100);
		   
		   
		   JPanel panneauNord= new JPanel();
		   panneauNord.setLayout(new FlowLayout());
		   client= new JLabel("Veuillez sélectionner qui vous-ètes :");
		   panneauNord.add(client);
		   cb_client=new JComboBox<String>();
		   cb_client.addItem("");
		   panneauNord.add(cb_client);
			  
		   
			  BufferedReader br = null;
			  try { br = new BufferedReader(new FileReader("bdd/client.txt"));
			   while((ligne = br.readLine()) != null) {
					   cb_client.addItem(ligne); 
			   }
			    
			   br.close();
				
			} catch(IOException E) {
				E.printStackTrace();
			}
			  panneauNord.setPreferredSize(new Dimension(100, 100));
			  this.add(panneauNord, BorderLayout.NORTH);
			   panneauNord.setBackground(Color.white);
			   
	
			   //paneau contenant la liste des produits
			   JPanel panneauProduits = new JPanel();
			   panneauProduits.setLayout(new FlowLayout());
			   panneauProduits.setPreferredSize(new Dimension(600,100));
			   produits = new JLabel("Veuillez choisir un type de produits : ");
			   panneauProduits.add(produits);
			   cb_type=new JComboBox<String>();
			   cb_type.addItem("");
			   cb_type.addItem("CD");cb_type.addItem("DVD");
			   cb_type.addItem("BD");cb_type.addItem("Dictionnaire");
			   cb_type.addItem("Manuel scolaire");cb_type.addItem("Roman");
			   panneauProduits.add(cb_type);
			   valider_type=new JButton("Valider");
			   panneauProduits.add(valider_type);
			   panneauProduits.setBackground(Color.white);
			   
			   
			   //panel qui va contenir le choix du produits a choisir 
			   JPanel panneauChoix = new JPanel();
			   panneauChoix.setLayout(new FlowLayout());
			   cb_produit =new JComboBox<String>();
			   cb_produit.setPreferredSize(new Dimension(450,25));
			   panneauChoix.setPreferredSize(new Dimension(600,100));
			   cb_produit.addItem("");
			   panneauChoix.add(cb_produit);
			   panneauChoix.setBackground(Color.white);
			   
			   JPanel emprunt_debut = new JPanel();
			   emprunt_debut.setLayout(new FlowLayout());
			   emprunt_debut.setPreferredSize(new Dimension(600,100));
			   dated = new JLabel("Date d'aujourd'hui : ");
			   dated.setPreferredSize(new Dimension(150, 25));
			   emprunt_debut.add(dated);
			   jdated = new JTextField();
			   aujourdhui=  LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			   jdated.setPreferredSize(new Dimension(100, 25));
			   emprunt_debut.add(jdated);
			   jdated.setText(aujourdhui);
			   jdated.setEnabled(false);
			   emprunt_debut.setBackground(Color.white);
			   	
   
			   JPanel emprunt_fin = new JPanel();
			   emprunt_fin.setLayout(new FlowLayout());
			   emprunt_fin.setPreferredSize(new Dimension(600,100));
			   datef = new JLabel("Date fin emprunt : ");
			   datef.setPreferredSize(new Dimension(150, 25));
			   emprunt_fin.add(datef);
			   jdatef = new JTextField();
			   jdatef.setPreferredSize(new Dimension(100, 25));
			   emprunt_fin.add(jdatef);
			   emprunt_fin.setBackground(Color.white);
			   
			   //le panneau au centre qui va contenir tout les panneaux de selection
			   JPanel container = new JPanel();
			   container.setLayout(new FlowLayout());
			   container.add(panneauProduits);
			   container.add(panneauChoix);
			   container.add(emprunt_debut);
			   container.add(emprunt_fin);
			   this.add(container, BorderLayout.CENTER);
			   
			   
			   JPanel bouton = new JPanel();
			   bouton.setLayout(new FlowLayout());
			   valider_commande = new JButton("Valider la commande");
			   ajout_prod = new JButton("Modifier la commande");
			   supprimer = new JButton("Supprimer la commande");
			   bouton.add(supprimer);
			   bouton.add(ajout_prod);
			   bouton.add(valider_commande);
			   this.add(bouton, BorderLayout.SOUTH);
			   bouton.setBackground(Color.white);
			   
			  
			  
			  valider_type.addActionListener(this);
			  valider_commande.addActionListener(this);
			   ajout_prod.addActionListener(this);
			  supprimer.addActionListener(this); 
			  
			  
			//remplissage de larraylist pour modifier les commandes
				 txt_stock = new ArrayList<String>();
				  try { br = new BufferedReader(new FileReader("bdd/stock.txt"));
				   while((ligne = br.readLine()) != null) {
						   txt_stock.add(ligne);
				   }
				   br.close();
					} catch(IOException E) {
						E.printStackTrace();
					}
			   
		   
}
	 

	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource();
		 String produit=(String) cb_type.getSelectedItem();
		 BufferedReader br = null;
			
		 if(obj==valider_type)
		 {
			  String ligne;
			 if(produit == "CD") 
				//lorsque l'on appuie sur le bouton a coter de la premiere jcombo box on verifie litem selectionner 
			  try { br = new BufferedReader(new FileReader("bdd/cd.txt"));
			   while((ligne = br.readLine()) != null) {
				cb_produit.addItem(ligne); //si litem est un CD on remplie la deuxieme jcombobox avec tout les CD
				cdselection=true; //si litem est un cd notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit dun CD
				
			   }
			    
				
				
			} catch(IOException i) {
				i.printStackTrace();
			}
			 if(produit == "DVD") 
				  try { br = new BufferedReader(new FileReader("bdd/dvd.txt"));
				   while((ligne = br.readLine()) != null) {
					   cb_produit.addItem(ligne);  //si litem est un DVD on remplie la deuxieme jcombobox avec tout les DVD
					   dvdselection=true; //si litem est un DVD notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit dun DVD
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
			 if(produit == "BD") 
				  try { br = new BufferedReader(new FileReader("bdd/bd.txt"));
				   while((ligne = br.readLine()) != null) {
					   cb_produit.addItem(ligne);
					   bdselection=true;//si litem est un BD notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit d'une BD
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
			 if(produit == "Dictionnaire") 
				  try { br = new BufferedReader(new FileReader("bdd/dictionnaire.txt"));
				   while((ligne = br.readLine()) != null) {
					   cb_produit.addItem(ligne);
					   dicoselection=true; //si litem est un Dictionnaire notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit dun dictionnaire
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
			 if(produit == "Manuel scolaire") 
				  try { br = new BufferedReader(new FileReader("bdd/manuel.txt"));
				   while((ligne = br.readLine()) != null) {
					   cb_produit.addItem(ligne);
					   manuelselection=true;//si litem est un manuel scolaire notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit dun manuel scolaire
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
			 if(produit == "Roman") 
				  try { br = new BufferedReader(new FileReader("bdd/roman.txt"));
				   while((ligne = br.readLine()) != null) {
					   cb_produit.addItem(ligne);
					   romanselection=true;//si litem est un roman notre boolean vaut vrais et ce boolean nous permet de creer une nouvelle commande  a partit dun roman
				   }
				    
					
					
				} catch(IOException i) {
					i.printStackTrace();
				}
		
	 }
		 if(obj==ajout_prod)
			{
				ajouterselection=true;
			}
		 if(obj==valider_commande)
		 {
			 //si aucun texte na ete remplie le programme affiche un message derreur
			 if(((String) cb_client.getSelectedItem()).length()==0 || ((String) cb_produit.getSelectedItem()).length()==0 || jdatef.getText().length()==0 )
			 {
				 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
			 }
			 else
			 {
				try { 
					//on prend le contenu de la premiere combo box et on decoupe cette chaine 
					String parties=(String) cb_client.getSelectedItem();
					String mots[] = parties.split("-");
					 for (int i = 0; i < mots.length; i++) {
				     
						if(mots[i].startsWith("Identifiant"))
						{
						 ident_cl =mots[i].substring(14,18);
						}
					    if(mots[i].startsWith(" nom"))
						{
					    nom_cl =mots[i].substring(7);
						}
					    if(mots[i].startsWith("  prenom"))
						{
					     prenom_cl =mots[i].substring(11);
						}
					    if(mots[i].startsWith(" client"))
						{
					     fidele =mots[i].substring(16);
					     String verif="true";
					     if(fidele.equals(verif))
						    {
						    	reduc=true;
						    }
						}
					 }
				
				}catch(NullPointerException n) {
					System.out.println("pas fou");
				}
				if(cdselection==true)
				{
					//on parcours la deuxieme combobox qui contient le produit selectionner , on coupe cette chaine pour recuperer toutes les valeurs nécessaire
					 cd=(String) cb_produit.getSelectedItem();
					String cd_couper[] = cd.split("-");
					 for (int i = 0; i < cd_couper.length; i++) {
				     
						if(cd_couper[i].startsWith("CD"))
						{
						 ident_cd =cd_couper[i].substring(5,9);
						}
						if(cd_couper[i].startsWith(" titre"))
						{
						titre_cd=cd_couper[i].substring(8);
						}
						if(cd_couper[i].startsWith(" tarif"))
						{
							tarif_cd=cd_couper[i].substring(8,10);
							prix_cd= Integer.parseInt(tarif_cd);
						}
					 }
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					 try {
					     debut = dateFormat.parse(aujourdhui);
					     fin = dateFormat.parse(jdatef.getText());
					     Commande co=new Commande(ident_cd,titre_cd,prix_cd,ident_co);
					     Emprunt em=new Emprunt(debut,fin);
						float delai= em.delai(debut, fin);
						//si la date de fin est egale a la date de debut on ne peut pas passer commande
						if(delai !=0)
						{
						 try {
								new FileWriter(new File("bdd/stock.txt")).close();
							} catch (IOException e2) {
								e2.printStackTrace();
							}
						 //on parcours larraylist qui contient tout les stock a la recherche du produits selectionner
						 for(int i=0;i<txt_stock.size();i++)
						 {
							 String test=txt_stock.get(i);
							 try { FileWriter file = new FileWriter("bdd/stock.txt",true);
								String Nl=System.getProperty("line.separator");
							    BufferedWriter bufferedwriter = new BufferedWriter(file);
							if(test.startsWith(ident_cd))
							{
							String cd_qte=txt_stock.get(i);
							cd_qte=cd_qte.substring(16);
							int stock_cd=Integer.parseInt(cd_qte);
							//si le stock de ce produit est egales a 0 on ne peut plus passer commande
							if(stock_cd !=0)
							{
								stock_cd=stock_cd-1;
								 ident_co="CO"+c;
								 //on cree une commande
									co.AjoutCommande(ident_cd, titre_cd, prix_cd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
									c++;
									//on cree une chaine contenant la commande pour la modifier ensuite
								 prod=co.commande(ident_cd, titre_cd, prix_cd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
								 JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
							}
							    	bufferedwriter.write(ident_cd+"- quantité :"+stock_cd+Nl);
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
						else
						{
							JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 	
						}
					     
					 } catch (Exception d) {
					     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
					     System.err.println(d.getMessage());
					 }
					 cdselection=false;
					 	}
				
				if(dvdselection==true)
				{
					//on decoupe la chaine dcontenant le contenu de la combobox
					//on recupere toutes les variables que nous avons besoin pour passer une commande
					 dvd=(String) cb_produit.getSelectedItem();
					String dvd_couper[] = dvd.split("-");
					 for (int i = 0; i < dvd_couper.length; i++) {
					
						 if(dvd_couper[i].startsWith("DVD"))
							{
							 ident_dvd =dvd_couper[i].substring(6,10);
							}
							if(dvd_couper[i].startsWith(" titre"))
							{
							titre_dvd=dvd_couper[i].substring(8);
							}
							if(dvd_couper[i].startsWith(" tarif"))
							{
								tarif_dvd=dvd_couper[i].substring(8,10);
								prix_dvd= Integer.parseInt(tarif_dvd);
							}
							 
					 }
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					 try {
					     debut = dateFormat.parse(aujourdhui);
					     fin = dateFormat.parse(jdatef.getText());
					     Commande co=new Commande(ident_dvd,titre_dvd,prix_dvd,ident_co);
					     Emprunt em=new Emprunt(debut,fin);//on cree un nouvelle emprunt a partir de la date daujurdhui et la date de fin de lemprunt
						float delai= em.delai(debut, fin);
						if(delai !=0)
						{
							 try {
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
								if(test.startsWith(ident_dvd))
								{
								String dvd_qte=txt_stock.get(i);
								dvd_qte=dvd_qte.substring(16);
								int stock_dvd=Integer.parseInt(dvd_qte);
								if(stock_dvd !=0)
								{
									stock_dvd=stock_dvd-1;
									ident_co="CO"+c;
									co.AjoutCommande(ident_dvd, titre_dvd, prix_dvd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc); //on cree une nouvelle commande
									prod=co.commande(ident_dvd, titre_dvd, prix_dvd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
									JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
								c++;
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
								}
								    	bufferedwriter.write(ident_dvd+" - quantité :"+stock_dvd+Nl);
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
						else
						{
							JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 	
						}
					
					     
					 } catch (Exception d) {
					     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
					     System.err.println(d.getMessage());
					 }
					 dvdselection=false;
				}
				if(bdselection==true)
				{
					//on fait la meme chose que pour les cd 
					 bd=(String) cb_produit.getSelectedItem();
					String bd_couper[] = bd.split("-");
					 for (int i = 0; i < bd_couper.length; i++) {	
						 if(bd_couper[i].startsWith("BD"))
						 {
							ident_bd=bd_couper[i].substring(5);
						 }
						 if(bd_couper[i].startsWith(" titre"))
						 {
							 titre_bd=bd_couper[i].substring(8);
						 }
						 if(bd_couper[i].startsWith(" tarif"))
						 {
							 tarif_bd=bd_couper[i].substring(8,10);
							 prix_bd= Integer.parseInt(tarif_bd);
						 }
					 }
					 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					 try {
					     debut = dateFormat.parse(aujourdhui);
					     fin = dateFormat.parse(jdatef.getText());
					     Commande co=new Commande(ident_bd,titre_bd,prix_bd,ident_co);
					     Emprunt em=new Emprunt(debut,fin);
						float delai= em.delai(debut, fin);
						if(delai !=0)
						{
							try {
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
							if(test.startsWith(ident_bd))
							{
							String bd_qte=txt_stock.get(i);
							bd_qte=bd_qte.substring(16);
							int stock_bd=Integer.parseInt(bd_qte);
							if(stock_bd !=0)
							{
							stock_bd=stock_bd-1;
							
								ident_co="CO"+c;
								co.AjoutCommande(ident_bd, titre_bd, prix_bd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
								prod=co.commande(ident_bd, titre_bd, prix_bd, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
								JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
							c++;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
							}
							    	bufferedwriter.write(ident_bd+"- quantité :"+stock_bd+Nl);
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
						else
						{
							JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 		
						}
					
					     
					 } catch (Exception d) {
					     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
					     System.err.println(d.getMessage());
					 }
					 bdselection=false;
				}
		if(dicoselection==true)
		{
			//on fait la meme chose que les cd
			dico=(String) cb_produit.getSelectedItem();
			String dico_couper[] = dico.split("-");
			 for (int i = 0; i < dico_couper.length; i++) {	
				 if(dico_couper[i].startsWith("Dictionnaire"))
				 {
					ident_dico=dico_couper[i].substring(15);
				 }
				 if(dico_couper[i].startsWith(" titre"))
				 {
					 titre_dico=dico_couper[i].substring(8);
				 }
				 if(dico_couper[i].startsWith(" tarif"))
				 {
					 tarif_dico=dico_couper[i].substring(8,10);
					 prix_dico= Integer.parseInt(tarif_dico);
				 }
			 }
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			 try {
			     debut = dateFormat.parse(aujourdhui);
			     fin = dateFormat.parse(jdatef.getText());
			     Commande co=new Commande(ident_dico,titre_dico,prix_dico,ident_co);
			     Emprunt em=new Emprunt(debut,fin);
				float delai= em.delai(debut, fin);
				if(delai!=0)
				{
						try {
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
						if(test.startsWith(ident_dico))
						{
						String dico_qte=txt_stock.get(i);
						dico_qte=dico_qte.substring(18);
						int stock_dico=Integer.parseInt(dico_qte);
						if(stock_dico !=0)
						{
						stock_dico=stock_dico-1;
						
						ident_co="CO"+c;
						co.AjoutCommande(ident_dico, titre_dico, prix_dico, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
						prod=co.commande(ident_dico, titre_dico, prix_dico, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
						JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
					    c++; 
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
						}
						    	bufferedwriter.write(ident_dico+"- quantité :"+stock_dico+Nl);
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
					
				
				else
				{
					JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 		
				}
			
			     
			 } catch (Exception d) {
			     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
			     System.err.println(d.getMessage());
			 }
			dicoselection=false;
		}
		if(manuelselection==true)
		{
			//on fait la meme chose que les cd
			 manuel=(String) cb_produit.getSelectedItem();
			String manuel_couper[] = manuel.split("-");
			 for (int i = 0; i < manuel_couper.length; i++) {	
				 if(manuel_couper[i].startsWith("Manuel"))
				 {
					ident_manuel=manuel_couper[i].substring(18);
					
				 }
				 if(manuel_couper[i].startsWith(" titre"))
				 {
					 titre_manuel=manuel_couper[i].substring(8);
				 }
				 if(manuel_couper[i].startsWith(" tarif"))
				 {
					 tarif_manuel=manuel_couper[i].substring(8,10);
					 prix_manuel= Integer.parseInt(tarif_manuel);
				 }
			 }
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			 try {
			     debut = dateFormat.parse(aujourdhui);
			     fin = dateFormat.parse(jdatef.getText());
			     Commande co=new Commande(ident_manuel,titre_manuel,prix_manuel,ident_co);
			     Emprunt em=new Emprunt(debut,fin);
				float delai= em.delai(debut, fin);
				if(delai != 0)
				{
					
					try {
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
					if(test.startsWith(ident_manuel))
					{
					String manuel_qte=txt_stock.get(i);
					manuel_qte=manuel_qte.substring(15);
					int stock_manuel=Integer.parseInt(manuel_qte);
					if(stock_manuel !=0)
					{
					stock_manuel=stock_manuel-1;
					
					ident_co="CO"+c;
					co.AjoutCommande(ident_manuel, titre_manuel, prix_manuel, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
					prod=co.commande(ident_manuel, titre_manuel, prix_manuel, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
					JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
				c++; 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
					}
					    	bufferedwriter.write(ident_manuel+"- quantité :"+stock_manuel+Nl);
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
				else
				{
					JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 		
				}
			
			     
			 } catch (Exception d) {
			     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
			     System.err.println(d.getMessage());
			 }
			 manuelselection=false;
		}
		if(romanselection==true)
		{
			//on fait la meme chose que les cd
		     roman=(String) cb_produit.getSelectedItem();
			String roman_couper[] = roman.split("-");
			 for (int i = 0; i < roman_couper.length; i++) {	
				 if(roman_couper[i].startsWith("Roman"))
				 {
					ident_roman=roman_couper[i].substring(8);
				 }
				 if(roman_couper[i].startsWith(" titre"))
				 {
					 titre_roman=roman_couper[i].substring(8);
				 }
				 if(roman_couper[i].startsWith(" tarif"))
				 {
					 tarif_roman=roman_couper[i].substring(8,10);
					 prix_roman= Integer.parseInt(tarif_roman);
				 }
			 }
			
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			 try {
			     debut = dateFormat.parse(aujourdhui);
			     fin = dateFormat.parse(jdatef.getText());
			     Commande co=new Commande(ident_roman,titre_roman,prix_roman,ident_co);
			     Emprunt em=new Emprunt(debut,fin);
				float delai= em.delai(debut, fin);
				if(delai !=0)
				{
					try {
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
					if(test.startsWith(ident_roman))
					{
					String roman_qte=txt_stock.get(i);
					roman_qte=roman_qte.substring(15);
					int stock_roman=Integer.parseInt(roman_qte);
					if(stock_roman !=0)
					{
					stock_roman=stock_roman-1;
					
					ident_co="CO"+c;
					co.AjoutCommande(ident_roman, titre_roman, prix_roman, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
					prod=co.commande(ident_roman, titre_roman, prix_roman, ident_co,delai , ident_cl, nom_cl, prenom_cl,reduc);
					JOptionPane.showMessageDialog(null, "Une commande a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
				    c++;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Commande impossible ce produit n'existe plus", "Erreur", JOptionPane.ERROR_MESSAGE); 		
					}
					    	bufferedwriter.write(ident_roman+"- quantité :"+stock_roman+Nl);
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
				else
				{
					JOptionPane.showMessageDialog(null, "La date de fin est mal saisie !!", "Erreur", JOptionPane.ERROR_MESSAGE); 		
				}
			
			     
			 } catch (Exception d) {
			     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
			     System.err.println(d.getMessage());
			 }
			 
		}
		
			//remplissage de larraylist pour modifier les commandes
			 txt_commande = new ArrayList<String>();
			  try { br = new BufferedReader(new FileReader("bdd/commande.txt"));
			   while((ligne = br.readLine()) != null) {
					   txt_commande.add(ligne);
			   }
			   br.close();
				} catch(IOException E) {
					E.printStackTrace();
				}
			  
			  
		
			 }
			//remplissage de larraylist pour modifier le stock
			 txt_stock = new ArrayList<String>();
			  try { br = new BufferedReader(new FileReader("bdd/stock.txt"));
			   while((ligne = br.readLine()) != null) {
					   txt_stock.add(ligne);
			   }
			   br.close();
				} catch(IOException E) {
					E.printStackTrace();
				}
			 
					 }
			
		 

		 if(ajouterselection==true)
			{
				ajout_produit=(String) cb_produit.getSelectedItem();
				String produits_couper[] = ajout_produit.split("-");
				 for (int i = 0; i < produits_couper.length; i++) {
					 if(produits_couper[i].startsWith(" titre"))
					 {
						 titre_pr=produits_couper[i].substring(8);
					 } 
					 if(produits_couper[i].startsWith(" tarif"))
					 {
						 tarif_pr=produits_couper[i].substring(8,10);
						 prix_pr= Integer.parseInt(tarif_pr);
					 }
				 }
				 String commande_couper[]=prod.split("-");
				 for (int i = 0; i < commande_couper.length; i++) {
					 if(commande_couper[i].startsWith(" tarif"))
					 {
						 somme_commande=commande_couper[i].substring(23,26);
						 prix_commande=Float.parseFloat(somme_commande);
					 }
				 }
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				 try {
				     debut = dateFormat.parse(aujourdhui);
				     fin = dateFormat.parse(jdatef.getText());
				     Emprunt em=new Emprunt(debut,fin);
					float delai= em.delai(debut, fin);
					if(reduc==true)
					{
						//si le client est fidele ont calcule ca reduction
						float prix=(float) (prix_pr)*(delai);
						float sous_prix=prix;
						float reduction=prix*10/100;
						prix=prix-reduction;
						prix=prix+prix_commande;
						//on rajoute la nouvelle commande a lancienne
					 verif=prod+" - titre du produit :"+titre_pr+" - tarif avec réduction :"+sous_prix+"€ - prix total de la commande :"+prix+" €";
					 String Nl=System.getProperty("line.separator");
					 
					 try { //on supprime le contenu du fichier et on le remplie avec soit notre nouvelle commande soit les autres commandes contenut dans larray list
							new FileWriter(new File("bdd/commande.txt")).close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					 
					 for (int i = 0; i < txt_commande.size(); i++) {
					    try { FileWriter file = new FileWriter("bdd/commande.txt",true);
					    BufferedWriter bufferedwriter = new BufferedWriter(file);
					    if(txt_commande.get(i).equals(prod))
					    {
					    	bufferedwriter.write(verif+Nl);
					        bufferedwriter.flush();
					        bufferedwriter.close();
					    }
					    else
					    {
					        bufferedwriter.write(txt_commande.get(i)+Nl);
					        bufferedwriter.flush();
					        bufferedwriter.close();
					    }
					    } catch(IOException e23) {
							e23.printStackTrace();
						}
						
					    
					} 
					 JOptionPane.showMessageDialog(null, "Votre commande a bien été modifier", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						 float prix=(float)(prix_pr)*(delai);
						 float total=prix_commande+prix;
						 verif=prod+" - titre du produit :"+titre_pr+"- tarif sans réduction :"+prix+"€ - prix total de la commande :"+total+" €";
						 String Nl=System.getProperty("line.separator");
							
						 try {
								new FileWriter(new File("bdd/commande.txt")).close();
							} catch (IOException e3) {
								e3.printStackTrace();
							}
						 
						    for (int i = 0; i < txt_commande.size(); i++) {
						    try { FileWriter file = new FileWriter("bdd/commande.txt",true);
							   BufferedWriter bufferedwriter = new BufferedWriter(file);
						    	if(txt_commande.get(i).equals(prod))
						    	{
						        bufferedwriter.write(verif+Nl);
						        bufferedwriter.flush();
						        bufferedwriter.close();
						    	}
						    	else
						    	{
				        		bufferedwriter.write(txt_commande.get(i)+Nl);
						        bufferedwriter.flush();
								bufferedwriter.close();	
						    	}    
						    }
						    catch(IOException e23) {
								e23.printStackTrace();
						    } 
							}
				   JOptionPane.showMessageDialog(null, "Votre commande a bien été modifier", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				
				     
				 } catch (Exception d) {
				     System.err.println("date1 et/ou date2 invalide. Format à utiliser : dd-MM-YYYY");
				     System.err.println(d.getMessage());
				 }
				 ajouterselection=false;
			}
	if(obj==supprimer)
	{
	SupprimerCommande sc = new SupprimerCommande();
	sc.setVisible(true);
	}
	
	}
}
