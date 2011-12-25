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
       setResizable(false);

       panel = new JPanel();
       panel.setLayout(null);
       super.add(panel); 
  
       //Logo laden
     	JLabel lblLogo = new JLabel();
     	lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
   		lblLogo.setBounds(300-107,250-75, 215, 75);
   		panel.add(lblLogo);
       
   		//Datei Item
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		fileMenu.addSeparator();
		
		//Beenden Item
		JMenuItem close = new JMenuItem("Beenden");
		fileMenu.add(close);
		
		//Actionlistener fürs beenden 
		close.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
		);
		
		//Erstellt den MenüEintrag Kunde mit allen nötigen Items
		JMenu customerMenu = new JMenu("Kunde");
		menuBar.add(customerMenu);
		JMenuItem newCustomer = new JMenuItem("Neue Kunden erstellen");
		customerMenu.add(newCustomer);
		JMenuItem allCustomers = new JMenuItem("Alle Kunden anzeigen");
		customerMenu.add(allCustomers);
		JMenuItem editCustomer = new JMenuItem("Kunde bearbeiten");
		customerMenu.add(editCustomer);
		JMenuItem deleteCustomer = new JMenuItem("Kunde löschen");
		customerMenu.add(deleteCustomer);
		
		
		//ActionListner für die Kunden Items hinzufügen
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
						alleKundenAnzeigenPanel();
					}
				}
		);
		editCustomer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						kundenBearbeitenPanel();
					}
				}
		);
		deleteCustomer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						kundenLoeschenPanel();
					}
				}
		);
		
		//Erstellt den MenüEintrag Konto mit allen nötigen Items
		JMenu accoutMenu = new JMenu("Konto");
		menuBar.add(accoutMenu);
		JMenuItem newAccount = new JMenuItem("Neues Konto erstellen");
		accoutMenu.add(newAccount);
		JMenuItem allAccounts = new JMenuItem("Alle Konten anzeigen");
		accoutMenu.add(allAccounts);
		
		//ActionListner für die Konten Items hinzufügen
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
						alleKontenAnzeigenPanel();
					}
				}
		);
		
		//Info Menü
		JMenu helpMenu = new JMenu("Hilfe");
		menuBar.add(helpMenu);
		JMenuItem info = new JMenuItem("Über das Programm");
		helpMenu.add(info);
		
		//ActionListner für Info
		info.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						infoPanel();
					}
				}
		);
		
		//Sichtbarkeit des Hauptfensters wird aktiviert 
		setVisible(true);
	}
   
   /**
	 * Kundenanlegen-Panel um neue Kunden anzulegen
	 * @author DMF
	 */	
   public void kundenAnlegenPanel(){
	   	
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label anzeigen
		JLabel lblKundenAnlegen = new JLabel("Kunde anlegen");
		lblKundenAnlegen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenAnlegen.setBounds(340, 75, 200, 16);
		panel.add(lblKundenAnlegen);
		
		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtVorname = new JTextField();
	    JTextField txtNachname = new JTextField();
	    JTextField txtStraße = new JTextField();
	    JTextField txtPlz = new JTextField();
	    JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStraße.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		txtStraße.setBounds(320, 250, 150, 25);
		txtPlz.setBounds(320, 280, 150, 25);
		txtOrt.setBounds(320, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStraße);
		panel.add(txtPlz);
		panel.add(txtOrt);
		
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
		JLabel lblStrasse = new JLabel("Strasse");
		JLabel lblPLZ = new JLabel("PLZ");
		JLabel lblOrt = new JLabel("Ort");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label positionieren
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblVorname.setBounds(150, 175, 150, 16);
		lblNachname.setBounds(150, 205, 150, 16);
		lblStrasse.setBounds(150, 255, 150, 16);
		lblPLZ.setBounds(150, 285, 150, 16);
		lblOrt.setBounds(150, 315, 150, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblStrasse);
		panel.add(lblPLZ);
		panel.add(lblOrt);
		
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Kundenanlegen Button erstellen
		JButton btnKundenAnlegen = new JButton("anlegen");
		btnKundenAnlegen.setBounds(230, 400, 135, 30);
		panel.add(btnKundenAnlegen);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Kundenanlegen-Panel um neue Kunden anzulegen
	 * @author DMF
	 */	
   public void alleKundenAnzeigenPanel(){
	   	
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblAlleKundenAnzeigen = new JLabel("Kunden anzeigen");
		lblAlleKundenAnzeigen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblAlleKundenAnzeigen.setBounds(340, 75, 200, 16);
		panel.add(lblAlleKundenAnzeigen);

		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
				
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
				
		//Label positionieren
		lblKundennummer.setBounds(60, 130, 150, 16);
		lblVorname.setBounds(290, 130, 150, 16);
		lblNachname.setBounds(480, 130, 150, 16);
	
				
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		
		//Liste für die Ausgabe der Kunden
		JList list = new JList();
		list.setBounds(60, 150, 485, 200);
		panel.add(list);
				
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Kundenbearbeiten-Panel um neue Kunden anzulegen
	 * @author DMF
	 */
   public void kundenBearbeitenPanel(){
	   		
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKundenBearbeiten = new JLabel("Kunden bearbeiten");
		lblKundenBearbeiten.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenBearbeiten.setBounds(340, 75, 200, 16);
		panel.add(lblKundenBearbeiten);

		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtVorname = new JTextField();
	    JTextField txtNachname = new JTextField();
	    JTextField txtStraße = new JTextField();
	    JTextField txtPlz = new JTextField();
	    JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStraße.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		txtStraße.setBounds(320, 250, 150, 25);
		txtPlz.setBounds(320, 280, 150, 25);
		txtOrt.setBounds(320, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStraße);
		panel.add(txtPlz);
		panel.add(txtOrt);
		
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
		JLabel lblStrasse = new JLabel("Strasse");
		JLabel lblPLZ = new JLabel("PLZ");
		JLabel lblOrt = new JLabel("Ort");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label positionieren
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblVorname.setBounds(150, 175, 150, 16);
		lblNachname.setBounds(150, 205, 150, 16);
		lblStrasse.setBounds(150, 255, 150, 16);
		lblPLZ.setBounds(150, 285, 150, 16);
		lblOrt.setBounds(150, 315, 150, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblStrasse);
		panel.add(lblPLZ);
		panel.add(lblOrt);
		
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Kundenanlegen Button erstellen
		JButton btnKundenAnlegen = new JButton("löschen");
		btnKundenAnlegen.setBounds(230, 400, 135, 30);
		panel.add(btnKundenAnlegen);
		
		//Objekte neu malen
		panel.repaint();
   
   }
   
   /**
	 * Kundenlöschen-Panel um Kunden zu löschen
	 * @author DMF
	 */	
   public void kundenLoeschenPanel(){
	   
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKundenLoeschen = new JLabel("Kunden löschen");
		lblKundenLoeschen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenLoeschen.setBounds(340, 75, 200, 16);
		panel.add(lblKundenLoeschen);

		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtVorname = new JTextField();
	    JTextField txtNachname = new JTextField();
	    JTextField txtStraße = new JTextField();
	    JTextField txtPlz = new JTextField();
	    JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStraße.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(170, 140, 150, 25);
		txtVorname.setBounds(170, 170, 150, 25);
		txtNachname.setBounds(170, 200, 150, 25);
		txtStraße.setBounds(170, 250, 150, 25);
		txtPlz.setBounds(170, 280, 150, 25);
		txtOrt.setBounds(170, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStraße);
		panel.add(txtPlz);
		panel.add(txtOrt);
		
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
		JLabel lblStrasse = new JLabel("Strasse");
		JLabel lblPLZ = new JLabel("PLZ");
		JLabel lblOrt = new JLabel("Ort");
		JLabel lblZugehoerigeKonten = new JLabel("zugehörige Konten:");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblZugehoerigeKonten.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label positionieren
		lblKundennummer.setBounds(8, 145, 150, 16);
		lblVorname.setBounds(8, 175, 150, 16);
		lblNachname.setBounds(8, 205, 150, 16);
		lblStrasse.setBounds(8, 255, 150, 16);
		lblPLZ.setBounds(8, 285, 150, 16);
		lblOrt.setBounds(8, 315, 150, 16);
		lblZugehoerigeKonten.setBounds(350, 150, 150, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblStrasse);
		panel.add(lblPLZ);
		panel.add(lblOrt);
		panel.add(lblZugehoerigeKonten);
		
		//Liste für die Ausgabe der Konten
		JList list = new JList();
		list.setBounds(350, 170, 195, 165);
		panel.add(list);
				
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Kundenanlegen Button erstellen
		JButton btnKundeLoeschen = new JButton("löschen");
		btnKundeLoeschen.setBounds(230, 400, 135, 30);
		panel.add(btnKundeLoeschen);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Kontoanlegen-Panel um Konten anzulegen
	 * @author DMF
	 */
   public void kontoAnlegenPanel(){
	   	
	   
	    //Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();
	   
		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKontoLoeschen = new JLabel("Konto anlegen");
		lblKontoLoeschen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKontoLoeschen.setBounds(340, 75, 200, 16);
		panel.add(lblKontoLoeschen);

		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtKontonummer = new JTextField();
	    JTextField txtKontostand = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Text Felder Positionen setzen
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtKontonummer.setBounds(320, 170, 150, 25);
		txtKontostand.setBounds(320, 250, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtKontonummer);
		panel.add(txtKontostand);
	
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblKontonummer = new JLabel("Kontonummer");
		JLabel lblKontoart = new JLabel("Kontoart");
		JLabel lblKontostand = new JLabel("Kontostand");
		JLabel lblEur = new JLabel("EUR");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontoart.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblEur.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontonummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontoart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontostand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEur.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label Positionen setzen
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblKontonummer.setBounds(150, 175, 150, 16);
		lblKontoart.setBounds(150, 205, 150, 16);
		lblKontostand.setBounds(150, 255, 150, 16);
		lblEur.setBounds(470, 255, 30, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblKontonummer);
		panel.add(lblKontoart);
		panel.add(lblKontostand);
		panel.add(lblEur);
		
		//RadioButtons für die Auswahl erstellen, positionieren und hinzufügen
		JRadioButton rdbtnGirokonto = new JRadioButton("Girokonto");
		JRadioButton rdbtnSparkonto = new JRadioButton("Sparkonto");
		
		rdbtnGirokonto.setBounds(320, 200, 141, 23);
		rdbtnSparkonto.setBounds(320, 220, 141, 23);
		
		panel.add(rdbtnGirokonto);
		panel.add(rdbtnSparkonto);
		
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Kontoanlegen Button hinzufügen
		JButton btnKontoAnlegen = new JButton("anlegen");
		btnKontoAnlegen.setBounds(230, 400, 135, 30);
		panel.add(btnKontoAnlegen);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Kontenanzeigen-Panel um alle Konten anzuzeigen
	 * @author DMF
	 */	
   public void alleKontenAnzeigenPanel(){
	   	
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKontenAnzeigen = new JLabel("Konten anzeigen");
		lblKontenAnzeigen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKontenAnzeigen.setBounds(340, 75, 200, 16);
		panel.add(lblKontenAnzeigen);

		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtVorname = new JTextField();
	    JTextField txtNachname = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblVorname = new JLabel("Vorname");
		JLabel lblNachname = new JLabel("Nachname");
		JLabel lblKontonummer = new JLabel("Kontonummer");
		JLabel lblKontoart = new JLabel("Kontoart");
		JLabel lblKontostand = new JLabel("Kontostand");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontoart.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label positionieren
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblVorname.setBounds(150, 175, 150, 16);
		lblNachname.setBounds(150, 205, 150, 16);
		lblKontonummer.setBounds(60, 230, 150, 16);
		lblKontoart.setBounds(290, 230, 150, 16);
		lblKontostand.setBounds(470, 230, 150, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblKontonummer);
		panel.add(lblKontoart);
		panel.add(lblKontostand);
		
		//Liste für die Ausgabe der Konten
		JList list = new JList();
		list.setBounds(60, 250, 485, 100);
		panel.add(list);

		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Kontobearbeiten-Panel um Konten zu bearbeiten
	 * @author DMF
	 */
   public void kontoBearbeitenPanel(){
	    
	   
	    //Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();
	   
		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKontoBearbeiten = new JLabel("Konto bearbeiten");
		lblKontoBearbeiten.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKontoBearbeiten.setBounds(340, 75, 200, 16);
		panel.add(lblKontoBearbeiten);

		//Textfelder erstellen
		JTextField txtKundennummer = new JTextField();
	    JTextField txtKontonummer = new JTextField();
	    JTextField txtKontostand = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Text Felder Positionen setzen
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtKontonummer.setBounds(320, 170, 150, 25);
		txtKontostand.setBounds(320, 250, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtKontonummer);
		panel.add(txtKontostand);
	
		//Label erstellen und bennen
		JLabel lblKundennummer = new JLabel("Kundennummer");
		JLabel lblKontonummer = new JLabel("Kontonummer");
		JLabel lblKontoart = new JLabel("Kontoart");
		JLabel lblKontostand = new JLabel("Kontostand");
		JLabel lblEur = new JLabel("EUR");
		
		//Schriftart und Größe festlegen
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontonummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontoart.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblKontostand.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		lblEur.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Ausrichtung festlegen
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontonummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontoart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKontostand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEur.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label Positionen setzen
		lblKundennummer.setBounds(150, 145, 150, 16);
		lblKontonummer.setBounds(150, 175, 150, 16);
		lblKontoart.setBounds(150, 205, 150, 16);
		lblKontostand.setBounds(150, 255, 150, 16);
		lblEur.setBounds(470, 255, 30, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblKontonummer);
		panel.add(lblKontoart);
		panel.add(lblKontostand);
		panel.add(lblEur);
		
		//RadioButtons für die Auswahl erstellen, positionieren und hinzufügen
		JRadioButton rdbtnGirokonto = new JRadioButton("Girokonto");
		JRadioButton rdbtnSparkonto = new JRadioButton("Sparkonto");
		
		rdbtnGirokonto.setBounds(320, 200, 141, 23);
		rdbtnSparkonto.setBounds(320, 220, 141, 23);
		
		panel.add(rdbtnGirokonto);
		panel.add(rdbtnSparkonto);
		
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//Kontoanlegen Button hinzufügen
		JButton btnKontoBearbeiten = new JButton("speichern");
		btnKontoBearbeiten.setBounds(230, 400, 135, 30);
		panel.add(btnKontoBearbeiten);
		
		//Objekte neu malen
		panel.repaint();
   }
   
   /**
	 * Info Panel, zeigt Informationen zu Version und Authoren 
	 * @author DMF
	 */
   public void infoPanel(){
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();
	    
	    //Logo laden
	  	JLabel lblLogo = new JLabel();
	  	lblLogo.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
	  	lblLogo.setBounds(200, 15, 215, 75);
	  	panel.add(lblLogo);
	    
	    JLabel lblInfo = new JLabel("<html>test test test<p> test test </html>");
	    lblInfo.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
	    lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblInfo.setBounds(SwingConstants.CENTER, SwingConstants.CENTER, 600, 500);
	    panel.add(lblInfo);
	    
	    //Objekte neu malen
	  	panel.repaint();
   }
	
 }
