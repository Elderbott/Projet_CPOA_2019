import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListeClient extends JFrame implements ActionListener{

private JLabel liste;

private JButton btn_annuler,btn_liste;

private JTextArea Liste_cl;
	 public ListeClient()
	   {
		   this.setTitle("Liste des clients");
		   this.setSize(700,700);
		   this.setLocation(50, 100);
		   
		   
		   JPanel panneauNord= new JPanel();
		   panneauNord.setLayout(new FlowLayout());
		   liste = new JLabel("Liste des clients :");
		   panneauNord.add(liste);
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
		   btn_liste= new JButton("Liste clients");
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
			  BufferedReader br = null;
			  String ligne;
			  
			  try { br = new BufferedReader(new FileReader("bdd/client.txt"));
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

