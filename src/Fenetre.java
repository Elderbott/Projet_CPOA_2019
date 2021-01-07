
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame implements ActionListener{
	
	// attributs 
	
	//jtextfield
	private JTextField cl_nom;
	
	//label
	private JLabel icon;
	
	//menu
	 private JMenuBar menuBar = new JMenuBar();
	private JMenu mnu_cl = new JMenu("Client");
	private JMenu mnu_pr = new JMenu("Produit");
	private JMenu mnu_quitter = new JMenu("Quitter");
	private JMenu mnu_commande = new JMenu("Commande");
	
	//sous menu
	 private JMenuItem cl_ajout = new JMenuItem("Ajouter un client");
	 private JMenuItem commande = new JMenuItem("Passer commande");
	 private JMenuItem pr_ajout = new JMenuItem("Ajouter un produit");
	 private JMenuItem liste_prod = new JMenuItem("Liste des produit");
	 private JMenuItem fermer = new JMenuItem("fermer");
	 private JMenuItem liste_cl = new JMenuItem("Liste de client");
	 private JMenuItem liste_commande = new JMenuItem("Liste des commande");
	
	
	
	// constructeur 
   public Fenetre()
   {
	   this.setTitle("Facture vidéothèque");
	   this.setSize(700,380);
	   this.setLocation(50, 100);
	   this.setLayout(new BorderLayout());
	   this.mnu_cl.add(cl_ajout);
	   
	
	   //panneau du haut
	   JPanel panneauNord= new JPanel();
	   panneauNord.setLayout(new FlowLayout());
	   this.add(panneauNord, BorderLayout.NORTH);
	   
	  
	   //panneau centre
	   JPanel panneauCentre = new JPanel();
	   icon = new JLabel(new ImageIcon("images/VIDEOTHEQUE.png"));
	    panneauCentre.add(icon);
	   this.add(panneauCentre, BorderLayout.CENTER);
	   

	
	
	   //panneau du bas
	   JPanel panneauSud = new JPanel();
	  
	   this.initMenu();
	   this.setVisible(true); 
	   
   }
   
   public void initMenu(){
	    //Menu client
	   //racourcis clavier
	   cl_ajout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
	   fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
	   pr_ajout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
	   commande.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
	   liste_prod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
	   liste_cl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
	   liste_commande.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
	   
	   cl_ajout.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event)
		      {
		        AjoutClient ac = new AjoutClient();
		        ac.setVisible(true);
		      }});
	   
	   liste_commande.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event)
		      {
		        ListeCommande lc = new ListeCommande();
		        lc.setVisible(true);
		      }});
	   
	   pr_ajout.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent event)
		      {
		        AjoutProduit ap = new AjoutProduit();
		        ap.setVisible(true);
		      }});
	   
	   liste_cl.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent event)
	      {
	        ListeClient lc = new ListeClient();
	        lc.setVisible(true);
	      }});
	   
	   liste_prod.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent event)
		      {
		        ListeProduits lp = new ListeProduits();
		        lp.setVisible(true);
		      }});
	   
	   commande.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent event)
		      {
		        AjoutCommande ac = new AjoutCommande();
		        ac.setVisible(true);
		      }});
	    mnu_cl.add(cl_ajout);
	    mnu_cl.add(liste_cl);
	    mnu_cl.addSeparator();
	    //Pour quitter l'application
	    fermer.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event)
	      {
	        System.exit(0);
	      }});
	    mnu_quitter.add(fermer);
	    mnu_pr.add(pr_ajout);
	    mnu_pr.add(liste_prod);
	    mnu_commande.add(commande);
	    mnu_commande.add(liste_commande);
	    
	    //ajout du menu sur la barre
	    this.menuBar.add(mnu_cl);
	    this.menuBar.add(mnu_pr);
	    this.menuBar.add(mnu_commande);
	    this.menuBar.add(mnu_quitter);
	    this.setJMenuBar(menuBar);
	    }

public void actionPerformed(ActionEvent e) {
	
	
}

		 
		   
		
	}

	



