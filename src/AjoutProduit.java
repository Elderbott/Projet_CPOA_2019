

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjoutProduit extends JFrame implements ActionListener{
	
	
private JButton btn_quitter;
private JButton btn_ajout;
private JButton btn_cd;
private JButton btn_dvd;
private JButton btn_roman;
private JButton btn_manuel;
private JButton btn_bd;
private JButton btn_dictionnaire;


private JLabel ident_pr;
private JLabel ltitre;
private JLabel ltarif;
private JLabel lauteur;
private JLabel llangue;
private JLabel lrealisateur;
private JLabel lanne_sortie;
private JLabel lstock;



private JTextField jtitre;
private JTextField jident_pr;
private JTextField jtarif;
private JTextField jauteur;
private JTextField jlangue;
private JTextField jrealisateur;
private JTextField janne_sortie;
private JTextField jstock;

private boolean CDselection=false, DVDselection=false, bdselection=false, dicoselection=false, romanselection=false, manuelselection=false;



	public AjoutProduit()
	   {
		   this.setTitle("Ajouter un produit");
		   this.setSize(700,400);
		   this.setLocation(50, 100);
		   this.setLayout(new BorderLayout());
		   
		   //panneau gauche qui va contenir tout les boutons de selection de produits
		   JPanel panneauGauche = new JPanel();
		   panneauGauche.setPreferredSize(new Dimension(140, 140));
		   panneauGauche.setLayout(new FlowLayout());
		   btn_cd = new JButton("CD");
		   btn_cd.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_cd); 
		   btn_dvd = new JButton("DVD");
		   btn_dvd.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_dvd);
		   btn_roman = new JButton("Roman");
		   btn_roman.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_roman);
		   btn_manuel = new JButton("Manuel scolaire");
		   btn_manuel.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_manuel);
		   btn_bd = new JButton("BD");
		   btn_bd.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_bd);
		   btn_dictionnaire = new JButton("Dictionnaire");
		   btn_dictionnaire.setPreferredSize(new Dimension(130, 40));
		   panneauGauche.add(btn_dictionnaire);
		   this.add(panneauGauche, BorderLayout.WEST);
		   panneauGauche.setBackground(Color.white);
		  
		    
		    //panneau contenant l'identifiant du nouveau produit
		    JPanel identifiant = new JPanel();
		    ident_pr = new JLabel("Identifiant :");
		    ident_pr.setPreferredSize(new Dimension(80, 20));
		    jident_pr = new JTextField();
		    jident_pr.setPreferredSize(new Dimension(90, 20));
		    identifiant.add(ident_pr);
		    identifiant.add(jident_pr);
		    identifiant.setPreferredSize(new Dimension(190, 60));
		    identifiant.setBackground(Color.white);
		    
		    //panel contenant le titre du produit
		    JPanel titre = new JPanel();
		    ltitre = new JLabel("Titre du produit : ");
		    titre.add(ltitre);
		    jtitre = new JTextField();
		    jtitre.setPreferredSize(new Dimension(170, 20));
		    titre.add(jtitre);
		    titre.setPreferredSize(new Dimension(280, 60));
		    titre.setBackground(Color.white);
		    
		    //panel contenant le tarif du produit
		    JPanel tarif = new JPanel();
		    ltarif = new JLabel("Tarif :");
		    ltarif.setPreferredSize(new Dimension(70, 20));
		    tarif.add(ltarif);
		    jtarif = new JTextField();
		    jtarif.setPreferredSize(new Dimension(120, 20));
		    tarif.add(jtarif);
		    tarif.setPreferredSize(new Dimension(280, 30));
		    tarif.setBackground(Color.white);
		    
		    //panel contenant le nom de l'auteur
		    JPanel auteur = new JPanel();
		    lauteur = new JLabel("Auteur :");
		    lauteur.setPreferredSize(new Dimension(70, 20));
		    auteur.add(lauteur);
		    jauteur = new JTextField();
		    jauteur.setPreferredSize(new Dimension(120, 20));
		    auteur.add(jauteur);
		    auteur.setPreferredSize(new Dimension(220, 60));
		    auteur.setBackground(Color.white);
		    
		    //panel contenant la langue du dictionnaire
		    JPanel langue = new JPanel();
		    llangue = new JLabel("Langue :");
		    llangue.setPreferredSize(new Dimension(70, 20));
		    langue.add(llangue);
		    jlangue = new JTextField();
		    jlangue.setPreferredSize(new Dimension(120, 20));
		    langue.add(jlangue);
		    langue.setPreferredSize(new Dimension(220, 60));
		    langue.setBackground(Color.white);
		    
		    //panel contenant le réalisateur
		    JPanel realisateur = new JPanel();
		    lrealisateur = new JLabel("Réalisateur :");
		    lrealisateur.setPreferredSize(new Dimension(80, 40));
		    realisateur.add(lrealisateur);
		    jrealisateur = new JTextField();
		    jrealisateur.setPreferredSize(new Dimension(120, 20));
		    realisateur.add(jrealisateur);
		    realisateur.setPreferredSize(new Dimension(230, 60));
		    realisateur.setBackground(Color.white);
		    
		    
		    //panel contenant l'annee de sortie
		    JPanel annee = new JPanel();
		    lanne_sortie = new JLabel("Anné de sortie :");
		    lanne_sortie.setPreferredSize(new Dimension(100, 20));
		    annee.add(lanne_sortie);
		    janne_sortie = new JTextField();
		    janne_sortie.setPreferredSize(new Dimension(120, 20));
		    annee.add(janne_sortie);
		    annee.setPreferredSize(new Dimension(280, 60));
		    annee.setBackground(Color.white);
		    
		    JPanel stock = new JPanel();
		    lstock = new JLabel("Quantitée :");
		    lstock.setPreferredSize(new Dimension(80, 20));
		    stock.add(lstock);
		    jstock = new JTextField();
		    jstock.setPreferredSize(new Dimension(120, 20));
		    stock.add(jstock);
		    stock.setBackground(Color.white);
		    
		    //panel regroupeant tout les panel
		    JPanel produit = new JPanel();
		    produit.add(identifiant);
		    produit.add(tarif);
		    produit.add(titre);
		    produit.add(annee);
		    produit.add(auteur);
		    produit.add(langue);
		    produit.add(realisateur);
		    produit.add(stock);
		    this.add(produit, BorderLayout.CENTER);
		    produit.setBackground(Color.white);
		      
		    
		    
		    
		    //bouton
		    JPanel bouton = new JPanel();
		    btn_ajout = new JButton("Valider");
		    bouton.add(btn_ajout);
		    btn_quitter = new JButton("Anuller");
		    bouton.add(btn_quitter);
		    bouton.setBackground(Color.white);
		    this.add(bouton, BorderLayout.SOUTH);
		    
		 
		   
		    //actions sur chaque bouton
		    btn_quitter.addActionListener(this);
		    btn_cd.addActionListener(this);
		    btn_dvd.addActionListener(this);
		    btn_bd.addActionListener(this);
		    btn_dictionnaire.addActionListener(this);
            btn_manuel.addActionListener(this);
            btn_roman.addActionListener(this);
            btn_ajout.addActionListener(this);
            
		   
			lrealisateur.setEnabled(false);
			jrealisateur.setEnabled(false);
			lanne_sortie.setEnabled(false);
			janne_sortie.setEnabled(false);
			llangue.setEnabled(false);
			jlangue.setEnabled(false);
			jauteur.setEnabled(false);
			lauteur.setEnabled(false);
			ltitre.setEnabled(false);
			jtitre.setEnabled(false);
			jtarif.setEnabled(false);
			ltarif.setEnabled(false);
			ident_pr.setEnabled(false);
			jident_pr.setEnabled(false);
			lstock.setEnabled(false);
			jstock.setEnabled(false);
	
		  
	   } 
	   public void videtexte() {

			jtitre.setText("");
			jident_pr.setText("");
			jtarif.setText("");
			jauteur.setText("");
			jlangue.setText("");
			jrealisateur.setText("");
			janne_sortie.setText("");
			jstock.setText("");
			

		}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		

	 if(( obj==btn_quitter))
			 {
		 		setVisible(false);
			 }

	 if(( obj==btn_cd))    
	   
	{
		    CDselection=true;
		    lrealisateur.setEnabled(false);
			jrealisateur.setEnabled(false);
			lanne_sortie.setEnabled(true);
			janne_sortie.setEnabled(true);
			llangue.setEnabled(false);
			jlangue.setEnabled(false);
			jauteur.setEnabled(false);
			lauteur.setEnabled(false);
			ltitre.setEnabled(true);
			jtitre.setEnabled(true);
			jtarif.setEnabled(true);
			ltarif.setEnabled(true);
			ident_pr.setEnabled(true);
			jident_pr.setEnabled(true);
			lstock.setEnabled(true);
			jstock.setEnabled(true);
		   
		  
		   
	}
	 if ((obj==btn_dvd))
	 {
		    DVDselection=true;
		    lrealisateur.setEnabled(true);
			jrealisateur.setEnabled(true);
			lanne_sortie.setEnabled(false);
			janne_sortie.setEnabled(false);
			llangue.setEnabled(false);
			jlangue.setEnabled(false);
			jauteur.setEnabled(false);
			lauteur.setEnabled(false);
			ltitre.setEnabled(true);
			jtitre.setEnabled(true);
			jtarif.setEnabled(true);
			ltarif.setEnabled(true);
			ident_pr.setEnabled(true);
			jident_pr.setEnabled(true);
			lstock.setEnabled(true);
			jstock.setEnabled(true);
	 }

	 if(( obj==btn_bd))    
	   
	{
		 bdselection=true;
		    lrealisateur.setEnabled(false);
			jrealisateur.setEnabled(false);
			lanne_sortie.setEnabled(false);
			janne_sortie.setEnabled(false);
			llangue.setEnabled(false);
			jlangue.setEnabled(false);
			jauteur.setEnabled(true);
			lauteur.setEnabled(true);
			ltitre.setEnabled(true);
			jtitre.setEnabled(true);
			jtarif.setEnabled(true);
			ltarif.setEnabled(true);
			ident_pr.setEnabled(true);
			jident_pr.setEnabled(true);
			lstock.setEnabled(true);
			jstock.setEnabled(true);
		  
	}
	 
	 if(( obj==btn_dictionnaire))    
		   
		{
		        dicoselection=true;
			    lrealisateur.setEnabled(false);
				jrealisateur.setEnabled(false);
				lanne_sortie.setEnabled(false);
				janne_sortie.setEnabled(false);
				llangue.setEnabled(true);
				jlangue.setEnabled(true);
				jauteur.setEnabled(false);
				lauteur.setEnabled(false);
				ltitre.setEnabled(true);
				jtitre.setEnabled(true);
				jtarif.setEnabled(true);
				ltarif.setEnabled(true);
				ident_pr.setEnabled(true);
				jident_pr.setEnabled(true);
				lstock.setEnabled(true);
				jstock.setEnabled(true);
			  
		}
	 if(( obj==btn_roman))    
		   
		{
		 		romanselection=true;
			    lrealisateur.setEnabled(false);
				jrealisateur.setEnabled(false);
				lanne_sortie.setEnabled(false);
				janne_sortie.setEnabled(false);
				llangue.setEnabled(false);
				jlangue.setEnabled(false);
				jauteur.setEnabled(true);
				lauteur.setEnabled(true);
				ltitre.setEnabled(true);
				jtitre.setEnabled(true);
				jtarif.setEnabled(true);
				ltarif.setEnabled(true);
				ident_pr.setEnabled(true);
				jident_pr.setEnabled(true);
				lstock.setEnabled(true);
				jstock.setEnabled(true);
			  
		}
	 
	 if(( obj==btn_manuel))    
		   
		{
		 		manuelselection=true;
			    lrealisateur.setEnabled(false);
				jrealisateur.setEnabled(false);
				lanne_sortie.setEnabled(false);
				janne_sortie.setEnabled(false);
				llangue.setEnabled(false);
				jlangue.setEnabled(false);
				jauteur.setEnabled(true);
				lauteur.setEnabled(true);
				ltitre.setEnabled(true);
				jtitre.setEnabled(true);
				jtarif.setEnabled(true);
				ltarif.setEnabled(true);
				ident_pr.setEnabled(true);
				jident_pr.setEnabled(true);
				lstock.setEnabled(true);
				jstock.setEnabled(true);
			  
		}
	 if((obj==btn_ajout))
	 {
		
	 if((CDselection == true))
	 {
		 
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||janne_sortie.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
				 String titre = jtitre.getText();
				 String pr_ident = jident_pr.getText();
				 int tarif = Integer.parseInt(jtarif.getText());
				 int sortie = Integer.parseInt(janne_sortie.getText());
				 int qte =  Integer.parseInt(jstock.getText());
				 JOptionPane.showMessageDialog(null, "Un CD a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 CD cd = new CD(pr_ident,titre,tarif,sortie);
		 cd.AjoutCD(pr_ident,titre,tarif,sortie); 
		 cd.ajoutstock(pr_ident,qte );
	 }	 
		 CDselection=false;
	 }
	 
	 if((DVDselection == true))
	 {
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||jrealisateur.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
		 String titre = jtitre.getText();
		 String pr_ident = jident_pr.getText();
		 int tarif = Integer.parseInt(jtarif.getText());
		 int qte =  Integer.parseInt(jstock.getText());
		 String realisateur = jrealisateur.getText();
		 JOptionPane.showMessageDialog(null, "Un DVD a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 DVD dvd = new DVD(pr_ident,titre,tarif,realisateur);
		 dvd.AjoutDVD(pr_ident,titre,tarif,realisateur);
		 dvd.ajoutstock(pr_ident,qte );
			 }
		 DVDselection=false;
	 }
	 
	 if((bdselection == true))
	 {
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||jauteur.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
		 String titre = jtitre.getText();
		 String pr_ident = jident_pr.getText();
		 int tarif = Integer.parseInt(jtarif.getText());
		 String auteur = jauteur.getText();
		 int qte =  Integer.parseInt(jstock.getText());
		 JOptionPane.showMessageDialog(null, "Une BD a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 BD bd = new BD(pr_ident,titre,tarif,auteur);
		 bd.AjoutBD(pr_ident,titre,tarif,auteur); 
		 bd.ajoutstock(pr_ident,qte );
			 }
		 bdselection=false;
	 }
	 
	 if((dicoselection == true))
	 {
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||jlangue.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
		 String titre = jtitre.getText();
		 String pr_ident = jident_pr.getText();
		 int tarif = Integer.parseInt(jtarif.getText());
		 int qte =  Integer.parseInt(jstock.getText());
		 String langue = jlangue.getText();
		 JOptionPane.showMessageDialog(null, "Un dictionnaire a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 Dictionnaire dico = new Dictionnaire(pr_ident,titre,tarif,langue);
		 dico.Ajoutdico(pr_ident,titre,tarif,langue); 
		 dico.ajoutstock(pr_ident,qte );
			 }
		 dicoselection=false;
	 }
	 
	 if((romanselection == true))
	 {
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||jauteur.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
		 String titre = jtitre.getText();
		 String pr_ident = jident_pr.getText();
		 int tarif = Integer.parseInt(jtarif.getText());
		 int qte =  Integer.parseInt(jstock.getText());
		 String auteur = jauteur.getText();
		 JOptionPane.showMessageDialog(null, "Un roman a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 Roman roman = new Roman(pr_ident,titre,tarif,auteur);
		 roman.Ajoutroman(pr_ident,titre,tarif,auteur);
		 roman.ajoutstock(pr_ident,qte );
			 }
		 romanselection=false;
	 }
	 
	 if((manuelselection == true))
	 {
		 if(jtitre.getText().length()==0 ||jident_pr.getText().length()==0||jtarif.getText().length()==0||jauteur.getText().length()==0 )
		 {
			 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
		 }
			 else
			 { 
		 int qte =  Integer.parseInt(jstock.getText());
		 String titre = jtitre.getText();
		 String pr_ident = jident_pr.getText();
		 int tarif = Integer.parseInt(jtarif.getText());
		 String auteur = jauteur.getText();
		 JOptionPane.showMessageDialog(null, "Un manuel a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
		 Manuel_Scolaire manuel = new Manuel_Scolaire(pr_ident,titre,tarif,auteur);
		 manuel.Ajoutmanuel(pr_ident,titre,tarif,auteur);
		 manuel.ajoutstock(pr_ident,qte );
			 }
		 manuelselection=false;
	 }
	 videtexte();
	 }
	 
}

	   }

