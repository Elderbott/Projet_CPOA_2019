import java.awt.BorderLayout;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class AjoutClient extends JFrame implements ActionListener{
	private JLabel lnom;
	private JLabel lprenom;
	private JLabel lidentifiant;
	
	
	private JTextField nom;
	private JTextField prenom;
	private JTextField jidentifiant;
	
	private JButton btn_valider; 
	private JButton btn_annuler;
	
	
	
	
	
	private JCheckBox fidele = new JCheckBox("Client fidèle");
  
   public AjoutClient()
   {
	   this.setTitle("Ajouter un client");
	   this.setSize(550,270);
	   this.setLocation(50, 100);
	   
	   this.setLayout(new BorderLayout());
	   

	   
	   //identifiant du client
	   //refaire toute les dimensions des panel
	   JPanel panneauident= new JPanel();
	   panneauident.setPreferredSize(new Dimension(220, 60));
	   panneauident.setLayout(new FlowLayout());
	   lidentifiant= new JLabel();
	   lidentifiant.setPreferredSize(new Dimension(100, 25));
	   lidentifiant.setText("Identifiant : ");
	   jidentifiant = new JTextField();
	   jidentifiant.setPreferredSize(new Dimension(80, 20));
	   panneauident.add(lidentifiant);
	   panneauident.add(jidentifiant);
	   panneauident.setBackground(Color.white);
	  
	   
	   
	   //nom du client
	   JPanel panneauNom = new JPanel();
	   panneauNom.setPreferredSize(new Dimension(500, 60));
	   panneauNom.setLayout(new FlowLayout());
	   lnom= new JLabel("Nom :");
	   nom = new JTextField();
	   nom.setPreferredSize(new Dimension(140, 20));
	   panneauNom.add(lnom);
	   panneauNom.add(nom);
	   panneauNom.setBackground(Color.white);
	  
	   
	   
	   //prenom du client
	   JPanel panneauPrenom = new JPanel();
	   panneauPrenom.setPreferredSize(new Dimension(305, 60));
	   panneauPrenom.setLayout(new FlowLayout());
	   lprenom= new JLabel("Prenom :");
	   prenom = new JTextField();
	   prenom.setPreferredSize(new Dimension(140, 20));
	   panneauPrenom.add(lprenom);
	   panneauPrenom.add(prenom);
	   panneauPrenom.setBackground(Color.white);
	   
	   //client fidele ou non
	   JPanel Fidele = new JPanel();
	   Fidele.setPreferredSize(new Dimension(140, 60));
	   Fidele.add(fidele);
	   fidele.setBackground(Color.white);
	   Fidele.setBackground(Color.white);
	
	   
	  
	   
	   JPanel client = new JPanel();
	   client.add(panneauNom);
	   client.add(panneauPrenom);
	   client.add(panneauident);
	   client.add(Fidele);
	   client.setBackground(Color.white);
	   this.add(client, BorderLayout.CENTER);
	 
	    
	    //bouton
	    JPanel control = new JPanel();
	    btn_valider = new JButton("Valider");
	    control.add(btn_valider);
	    btn_annuler = new JButton("Anuller");
	    control.add(btn_annuler);
	    control.setBackground(Color.white);
	    this.add(control, BorderLayout.SOUTH);
	    
	    
	   
	    btn_annuler.addActionListener(this);
	    btn_valider.addActionListener(this);
   }

   public void videtexte() {

		jidentifiant.setText("");
		nom.setText("");
		prenom.setText("");


	}

public void actionPerformed(ActionEvent e) {
Object obj = e.getSource();
 if(( obj==btn_annuler))
		 {
	 		setVisible(false);
		 }

if ((obj==btn_valider))
{

	 String ident = jidentifiant.getText();
	 String n = nom.getText();
	 String p = prenom.getText();
	 boolean cl_fi=fidele.isSelected();
	
	 if(jidentifiant.getText().length()==0 ||nom.getText().length()==0 || prenom.getText().length()==0)
	 {
		 JOptionPane.showMessageDialog(null, "Un champ n'est pas remplie", "Erreur", JOptionPane.ERROR_MESSAGE); 
	 }
		 else
		 {
			 JOptionPane.showMessageDialog(null, "Le cllient a bien été ajouter", "Information", JOptionPane.INFORMATION_MESSAGE);
	 Client cl = new Client(ident,n,p);
	 cl.AjoutClient(ident,n,p,cl_fi);
	
	 }
	
	 videtexte();
}
	
}

}
