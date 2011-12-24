import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontoverwaltungsFenster extends JFrame
{
		JPanel panel;

   public KontoverwaltungsFenster()
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
						kundenAnlegenPanel();
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
						kontoAnlegenPanel();
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
   public void kundenAnlegenPanel(){
	   		
	   	//Entfernt alle zuvor hinzugef�gten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(200, 15, 215, 75);
		panel.add(lblLogo);

		//Alle Labels und Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtVorname = new JTextField();
	    JTextField txtNachname = new JTextField();
	    JTextField txtStra�e = new JTextField();
	    JTextField txtPlz = new JTextField();
	    JTextField txtOrt = new JTextField();
	    
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStra�e.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		txtStra�e.setBounds(320, 250, 150, 25);
		txtPlz.setBounds(320, 280, 150, 25);
		txtOrt.setBounds(320, 310, 150, 25);
		
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStra�e);
		panel.add(txtPlz);
		panel.add(txtOrt);
		
		
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
		JLabel lblStrasse = new JLabel("Strasse");
		JLabel lblPLZ = new JLabel("PLZ");
		JLabel lblOrt = new JLabel("Ort");
		
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblVorname.setBounds(150, 175, 150, 16);
		lblNachname.setBounds(150, 205, 150, 16);
		lblStrasse.setBounds(150, 255, 150, 16);
		lblPLZ.setBounds(150, 285, 150, 16);
		lblOrt.setBounds(150, 315, 150, 16);
		
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblStrasse);
		panel.add(lblPLZ);
		panel.add(lblOrt);
		
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		JButton btnKundenAnlegen = new JButton("anlegen");
		btnKundenAnlegen.setBounds(230, 400, 135, 30);
		panel.add(btnKundenAnlegen);
		
		panel.repaint();
   }
   
   public void kontoAnlegenPanel(){
	    
	    //Entfernt alle zuvor hinzugef�gten Objekte vom Panel
	    panel.removeAll();
	   
		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(200, 15, 215, 75);
		panel.add(lblLogo);

		//Alle Labels und Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtKontonummer = new JTextField();
	    JTextField txtKontostand = new JTextField();
	    
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtKontonummer.setBounds(320, 170, 150, 25);
		txtKontostand.setBounds(320, 250, 150, 25);
		
		panel.add(txtKundennummer);
		panel.add(txtKontonummer);
		panel.add(txtKontostand);
	
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblKontonummer = new JLabel("Kontonummer");
		JLabel lblKontoart = new JLabel("Kontoart");
		JLabel lblKontostand = new JLabel("Kontostand");
		JLabel lblEur = new JLabel("EUR");
		
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontoart.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblEur.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontonummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontoart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontostand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEur.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblKontonummer.setBounds(150, 175, 150, 16);
		lblKontoart.setBounds(150, 205, 150, 16);
		lblKontostand.setBounds(150, 255, 150, 16);
		lblEur.setBounds(470, 255, 30, 16);
		
		panel.add(lblKundennummer);
		panel.add(lblKontonummer);
		panel.add(lblKontoart);
		panel.add(lblKontostand);
		panel.add(lblEur);
		
		JRadioButton rdbtnGirokonto = new JRadioButton("Girokonto");
		JRadioButton rdbtnSparkonto = new JRadioButton("Sparkonto");
		
		rdbtnGirokonto.setBounds(320, 200, 141, 23);
		rdbtnSparkonto.setBounds(320, 220, 141, 23);
		
		panel.add(rdbtnGirokonto);
		panel.add(rdbtnSparkonto);
		
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		JButton btnKontoAnlegen = new JButton("anlegen");
		btnKontoAnlegen.setBounds(230, 400, 135, 30);
		panel.add(btnKontoAnlegen);
		
		panel.repaint();
   }
	
 }
