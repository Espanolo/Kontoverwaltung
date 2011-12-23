import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstGUI extends JFrame
{
		JPanel panel;

   public FirstGUI()
   {
       super("Kontoverwaltung");
       setSize(600,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout(5,5));

       panel = new JPanel();
       panel.setLayout(null);
       super.add(panel); 
  
       
       
       /**
		 * Die Men�Bar wird erstellt und die einzelnen Items werden hinzugef�gt
		 * @author DMF
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		fileMenu.addSeparator();
		
		
		
		JMenuItem close = new JMenuItem("Beenden");
		fileMenu.add(close);
		
		/**
		 * Actionlistener f�rs beenden 
		 * @author DMF
		 */
		close.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
		);
		
		/**
		 * Erstellt den Men�Eintrag Kunde mit allen n�tigen Items
		 * @author DMF
		 */
		JMenu customerMenu = new JMenu("Kunde");
		menuBar.add(customerMenu);
		JMenuItem newCustomer = new JMenuItem("Neue Kunden erstellen");
		customerMenu.add(newCustomer);
		JMenuItem allCustomers = new JMenuItem("Alle Kunden anzeigen");
		customerMenu.add(allCustomers);
		JMenuItem editCustomer = new JMenuItem("Kunde bearbeiten");
		customerMenu.add(editCustomer);
		JMenuItem deleteCustomer = new JMenuItem("Kunde l�schen");
		customerMenu.add(deleteCustomer);
		
		/**
		 * ActionListner f�r die Kunden Items hinzuf�gen
		 * @author DMF
		 */
		newCustomer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						newCustomerPanel();
					}
				}
		);
		allCustomers.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		editCustomer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		deleteCustomer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		
		/**
		 * Erstellt den Men�Eintrag Konto mit allen n�tigen Items
		 * @author DMF
		 */
		JMenu accoutMenu = new JMenu("Konto");
		menuBar.add(accoutMenu);
		JMenuItem newAccount = new JMenuItem("Neues Konto erstellen");
		accoutMenu.add(newAccount);
		JMenuItem allAccounts = new JMenuItem("Alle Konten anzeigen");
		accoutMenu.add(allAccounts);
		JMenuItem editAccount = new JMenuItem("Konto bearbeiten");
		accoutMenu.add(editAccount);
		JMenuItem deleteAccount = new JMenuItem("Konto l�schen");
		accoutMenu.add(deleteAccount);
		
		/**
		 * ActionListner f�r die Konten Items hinzuf�gen
		 * @author DMF
		 */
		newAccount.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		allAccounts.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		editAccount.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		deleteAccount.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		
		/**
		 * Hier soll eine kleine Programmerkl�rung, sowie Versionsnumemr und Autoren stehen
		 * @author DMF
		 */
		JMenu helpMenu = new JMenu("Hilfe");
		menuBar.add(helpMenu);
		JMenuItem info = new JMenuItem("�ber das Programm");
		helpMenu.add(info);
		
		/**
		 * ActionListner f�r Info
		 * @author DMF
		 */
		info.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//Funktionen fehlen
					}
				}
		);
		
		
		
		
		/**
		 * Das Hauptfenster wird dargestellt
		 * @author DMF
		 */
		setVisible(true);
		
		
	}
   public void newCustomerPanel(){
	  
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(200, 16, 214, 74);
		panel.add(lblLogo);
		
	    JTextField txtVorname = new JTextField();
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtVorname.setBounds(310, 169, 134, 28);
		panel.add(txtVorname);
		txtVorname.setColumns(10);
		
		JTextField txtNachname = new JTextField();
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtNachname.setBounds(310, 197, 134, 28);
		panel.add(txtNachname);
		txtNachname.setColumns(10);
		
		JTextField txtStra�e = new JTextField();
		txtStra�e.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtStra�e.setBounds(310, 249, 134, 28);
		panel.add(txtStra�e);
		txtStra�e.setColumns(10);
		
		JTextField txtPlz = new JTextField();
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtPlz.setBounds(310, 277, 134, 28);
		panel.add(txtPlz);
		txtPlz.setColumns(10);
		
		JTextField txtOrt = new JTextField();
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtOrt.setBounds(310, 306, 134, 28);
		panel.add(txtOrt);
		txtOrt.setColumns(10);
		
		JTextField txtKundennummer = new JTextField();
		txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtKundennummer.setBounds(310, 140, 134, 28);
		panel.add(txtKundennummer);
		txtKundennummer.setColumns(10);
		
		JLabel lblKundennummer = new JLabel("Kundennummer");
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKundennummer.setBounds(129, 146, 151, 16);
		panel.add(lblKundennummer);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setBounds(129, 175, 151, 16);
		panel.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setBounds(129, 203, 151, 16);
		panel.add(lblNachname);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setBounds(129, 312, 151, 16);
		panel.add(lblOrt);
		
		JLabel lblPLZ = new JLabel("PLZ");
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setBounds(129, 283, 151, 16);
		panel.add(lblPLZ);
		
		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setBounds(129, 255, 151, 16);
		panel.add(lblStrasse);
		
		JSeparator sepOben = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepOben.setBounds(55, 360, 490, 20);
		panel.add(sepOben);
		
		JSeparator sepUnten = new JSeparator();
		sepUnten.setBackground(Color.BLACK);
		sepUnten.setBounds(55, 102, 490, 20);
		panel.add(sepUnten);
		
		JButton btnKundenAnlegen = new JButton("anlegen");
		btnKundenAnlegen.setBounds(231, 404, 134, 29);
		panel.add(btnKundenAnlegen);
		panel.repaint();
   }
	
 }
