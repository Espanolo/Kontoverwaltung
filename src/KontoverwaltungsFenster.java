import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Robot;

@SuppressWarnings("serial")
public class KontoverwaltungsFenster extends JFrame
{
	JPanel panel;
	//Arraylisten für Kunden und Konten
	public static ArrayList<Kunde> kundenListe= new ArrayList<Kunde>();
	public static ArrayList<Konto> kontoListe= new ArrayList<Konto>();
				
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
       //addWindowListener( new FensterSchließenAdapter() );
       
       //Daten aus den Datein lesen
       kontoListe = DateiLaden.kontoListeLesen("kontoListe.txt");
       kundenListe = DateiLaden.kundenListeLesen("kundenListe.txt");
  
       //Logo laden
     	JLabel lblLogo = new JLabel();
     	lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
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
						FensterSchließenAdapter exit = new FensterSchließenAdapter();
						exit.windowClosing(null);
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
		JMenuItem allAccounts = new JMenuItem("Kundenkonto anzeigen/bearbeiten/loeschen");
		customerMenu.add(allAccounts);
		
		
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
		allAccounts.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						alleKontenAnzeigenPanel(0);
					}
				}
		);
		
		//Erstellt den MenüEintrag Konto mit allen nötigen Items
		JMenu accountMenu = new JMenu("Konto");
		menuBar.add(accountMenu);
		JMenuItem newAccount = new JMenuItem("Konto erstellen");
		accountMenu.add(newAccount);
		
		//ActionListner für die Konten Items hinzufügen
		newAccount.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						kontoAnlegenPanel();
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
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label anzeigen
		JLabel lblKundenAnlegen = new JLabel("Kunde anlegen");
		lblKundenAnlegen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenAnlegen.setBounds(340, 75, 200, 16);
		panel.add(lblKundenAnlegen);
		
		//Textfelder erstellen
		final JTextField txtKundennummer = new JTextField();
	    final JTextField txtVorname = new JTextField();
	    final JTextField txtNachname = new JTextField();
	    final JTextField txtStrasse = new JTextField();
	    final JTextField txtPlz = new JTextField();
	    final JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		txtStrasse.setBounds(320, 250, 150, 25);
		txtPlz.setBounds(320, 280, 150, 25);
		txtOrt.setBounds(320, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStrasse);
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
		
		txtKundennummer.setText(Integer.toString(GlobaleVariable.kundenNummer));
		txtKundennummer.setEditable(false);
		
		//Actionlistener für KundenAnlegen
		btnKundenAnlegen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						if (txtVorname.getText().equals("") || txtNachname.getText().equals("") || txtOrt.getText().equals("") || txtPlz.getText().equals("") || txtStrasse.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Bitte alle Daten angeben!");
						else {
							Kunde kunde = new Kunde();
							try	{	
								kunde.kundeAnlegen(GlobaleVariable.kundenNummer, txtVorname.getText(), txtNachname.getText(), txtStrasse.getText(), Integer.parseInt(txtPlz.getText()) , txtOrt.getText());
							} catch (NumberFormatException c) {
								
							}
							//Textfelder neu setzen 
							txtVorname.setText("");
							txtNachname.setText("");
							txtStrasse.setText("");
							txtPlz.setText("");
							txtOrt.setText("");
							txtKundennummer.setText(Integer.toString(GlobaleVariable.kundenNummer));
							
							kundenListe.add(kunde);					
							
							//Debug
							System.out.println(kunde.toString());
						}
					}
				}
		);
		
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
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
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
		JList list = new JList(kundenListe.toArray());
		list.setBounds(60, 150, 485, 200);
		list.setFont(new Font("Monaco",Font.PLAIN,12));
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
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKundenBearbeiten = new JLabel("Kunden bearbeiten");
		lblKundenBearbeiten.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenBearbeiten.setBounds(340, 75, 200, 16);
		panel.add(lblKundenBearbeiten);

		//Textfelder erstellen
		final JTextField txtKundennummer = new JTextField();
	    final JTextField txtVorname = new JTextField();
	    final JTextField txtNachname = new JTextField();
	    final JTextField txtStrasse = new JTextField();
	    final JTextField txtPlz = new JTextField();
	    final JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(320, 140, 150, 25);
		txtVorname.setBounds(320, 170, 150, 25);
		txtNachname.setBounds(320, 200, 150, 25);
		txtStrasse.setBounds(320, 250, 150, 25);
		txtPlz.setBounds(320, 280, 150, 25);
		txtOrt.setBounds(320, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStrasse);
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
		final JButton btnKundenBearbeiten = new JButton("bearbeiten");
		btnKundenBearbeiten.setBounds(230, 400, 135, 30);
		panel.add(btnKundenBearbeiten);
		btnKundenBearbeiten.setVisible(false);
		
		//Objekte neu malen
		panel.repaint();
	
		//Actionlistner für die Suche nach dem Kunden
		txtKundennummer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
							for (Kunde kd : kundenListe)	
								if (kd.getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
									txtVorname.setText(kd.getVorname());
									txtNachname.setText(kd.getNachname());
									txtStrasse.setText(kd.getStrasse());
									txtPlz.setText(Integer.toString(kd.getPostleitzahl()));
									txtOrt.setText(kd.getOrt());
									
									txtKundennummer.setEditable(false);
									btnKundenBearbeiten.setVisible(true);
								}
						}
				}
		);
		
		btnKundenBearbeiten.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						for (Kunde kd : kundenListe)	
							if (txtVorname.getText().equals("") || txtNachname.getText().equals("") || txtOrt.getText().equals("") || txtPlz.getText().equals("") || txtStrasse.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Bitte alle Daten angeben!");
							else {
								if (kd.getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
									//KundenBearbeiten Funtkion aufrufen
									kd.kundeBearbeiten(txtVorname.getText(), txtNachname.getText(), txtStrasse.getText(), Integer.parseInt(txtPlz.getText()) , txtOrt.getText());
									
									//Textfelder neu setzen 
									txtVorname.setText("");
									txtNachname.setText("");
									txtStrasse.setText("");
									txtPlz.setText("");
									txtOrt.setText("");
									
									txtKundennummer.setEditable(true);
									txtKundennummer.setText("");
									btnKundenBearbeiten.setVisible(false);
								}
							}
					}
				}
		);
   
   }
   
   /**
	 * Kundenlöschen-Panel um Kunden zu löschen
	 * @author DMF
	 * @TODO Kontos löschen
	 */	
   public void kundenLoeschenPanel(){
	   
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();

		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKundenLoeschen = new JLabel("Kunden löschen");
		lblKundenLoeschen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKundenLoeschen.setBounds(340, 75, 200, 16);
		panel.add(lblKundenLoeschen);

		//Textfelder erstellen
		final JTextField txtKundennummer = new JTextField();
	    final JTextField txtVorname = new JTextField();
	    final JTextField txtNachname = new JTextField();
	    final JTextField txtStrasse = new JTextField();
	    final JTextField txtPlz = new JTextField();
	    final JTextField txtOrt = new JTextField();
	    
	    //Schriftart und Größe festlegen
	    txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
		
		//Textfelder positionieren
		txtKundennummer.setBounds(170, 140, 150, 25);
		txtVorname.setBounds(170, 170, 150, 25);
		txtNachname.setBounds(170, 200, 150, 25);
		txtStrasse.setBounds(170, 250, 150, 25);
		txtPlz.setBounds(170, 280, 150, 25);
		txtOrt.setBounds(170, 310, 150, 25);
		
		//Textfelder dem Panel hinzufügen
		panel.add(txtKundennummer);
		panel.add(txtVorname);
		panel.add(txtNachname);
		panel.add(txtStrasse);
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
		final DefaultListModel data = new DefaultListModel();
		JList list = new JList(data);
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
		final JButton btnKundeLoeschen = new JButton("löschen");
		btnKundeLoeschen.setBounds(230, 400, 135, 30);
		panel.add(btnKundeLoeschen);
		btnKundeLoeschen.setVisible(false);
		
		//Objekte neu malen
		panel.repaint();
		
		//Actionlistner für die Suche nach dem Kunden
		txtKundennummer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
							for (Kunde kd : kundenListe)	
								if (kd.getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
									txtVorname.setText(kd.getVorname());
									txtNachname.setText(kd.getNachname());
									txtStrasse.setText(kd.getStrasse());
									txtPlz.setText(Integer.toString(kd.getPostleitzahl()));
									txtOrt.setText(kd.getOrt());
									
									//Nach seinen Konten suchen
									for (Konto kto : kontoListe) 
										if ( kto.getKundenNummer() == kd.getKundenNummer())
											data.addElement(kto.toStringShort());
											
									txtKundennummer.setEditable(false);
									btnKundeLoeschen.setVisible(true);
								}
						}
				}
		);
		
		btnKundeLoeschen.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						//Liste leeren
						data.removeAllElements();
						
						//Sicherheitsabfrage ob der Kunde, samt Konten wirklich gelöscht werden soll
						int ok = JOptionPane.showConfirmDialog(null, "Wollen Sie diesen Kunden samt seinen Konten wirklich löschen?", "ACHTUNG", JOptionPane.YES_NO_OPTION);
						
						if (ok == JOptionPane.YES_OPTION) {
							for (int i = 0; i < kundenListe.size(); i++) {	
								if (kundenListe.get(i).getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
								
									//Nach seinen Konten suchen und löschen
									for (int o = 0; o < kontoListe.size(); o++) 
										if ( kontoListe.get(o).getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
											kontoListe.remove(kontoListe.get(o));
											o--;
										}
									
									//Verweis auf den Kunden löschen und somit für GC freigeben
									kundenListe.remove(kundenListe.get(i));
									
									//Textfelder und Liste neu setzen
									txtKundennummer.setText("");
									txtVorname.setText("");
									txtNachname.setText("");
									txtStrasse.setText("");
									txtPlz.setText("");
									txtOrt.setText("");
									data.removeAllElements();
									
									txtKundennummer.setEditable(true);
									btnKundeLoeschen.setVisible(false);
									
									//Debug
									System.out.println(kundenListe.toString());
									System.out.println(kontoListe.toString());
								}
							}
						}
						else {
							//Textfelder und Liste neu setzen
							txtKundennummer.setText("");
							txtVorname.setText("");
							txtNachname.setText("");
							txtStrasse.setText("");
							txtPlz.setText("");
							txtOrt.setText("");
							data.removeAllElements();
							
							txtKundennummer.setEditable(true);
							btnKundeLoeschen.setVisible(false);
						}
							
					}
				}
		);
				
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
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Info Label erstellen
		JLabel lblKontoAnlegen = new JLabel("Konto anlegen");
		lblKontoAnlegen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKontoAnlegen.setBounds(340, 75, 200, 16);
		panel.add(lblKontoAnlegen);

		//Textfelder erstellen
		final JTextField txtKundennummer = new JTextField();
	    final JTextField txtKontonummer = new JTextField();
	    final JTextField txtKontostand = new JTextField();
	    	    
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
		final JRadioButton rdbtnGirokonto = new JRadioButton("Girokonto");
		JRadioButton rdbtnSparkonto = new JRadioButton("Sparkonto");
		
		//Radiobuttons gruppieren
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnGirokonto);
	    group.add(rdbtnSparkonto);
	    
	    //Initiale Auswahl treffen
	    rdbtnGirokonto.setSelected(true);
		
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
		
		txtKontonummer.setText(Integer.toString(GlobaleVariable.kontoNummer));
		txtKontonummer.setEditable(false);	
		txtKontostand.setText("0");
		
	
		
		btnKontoAnlegen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						
						//Leere Eingabe abfragen
						if (txtKundennummer.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Kundennummer eingeben!");
						else {
							//Eingegebene Kundennummer überprüfen ob vorhanden
							boolean kdnrGefunden=false;
							
							for (Kunde kd : kundenListe) {
								if (kd.getKundenNummer() == Integer.parseInt(txtKundennummer.getText()))
									kdnrGefunden=true;
							}
							
							if (kdnrGefunden == false) {
								JOptionPane.showMessageDialog(null, "Kundennummer existiert nicht!");
								txtKundennummer.setText("");
							}
							else {
								//Konto Objekt erstellen
								Konto konto = new Konto();
								
								//KontoArt bestimmen
								String kontoArt;
								if (true == rdbtnGirokonto.isSelected())
									kontoArt = "Girokonto";
								else
									kontoArt = "Sparkonto";
								
								try	{	
									konto.neuesKonto(GlobaleVariable.kontoNummer, Integer.parseInt(txtKundennummer.getText()), kontoArt, Double.parseDouble(txtKontostand.getText().replace(",", ".")) );
								} catch (NumberFormatException c) {
									System.out.println(c.getMessage());
								}
								//Textfelder neu setzen 
								txtKontostand.setText("0");
								txtKundennummer.setText("");
								txtKontonummer.setText(Integer.toString(GlobaleVariable.kontoNummer));
								
								kontoListe.add(konto);					
								
								//Debug
								System.out.println(konto.toString());
							}
						}
					}
				}
		);
   }
   
   /**
	 * Kontenanzeigen-Panel um alle Konten anzuzeigen/bearbeiten/loeschen
	 * @author DMF
	 */	
   public void alleKontenAnzeigenPanel(int kundenNummer){
	   
	   	//Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();
	    
	    //Zwichenergebnis KontoListe
	  	final ArrayList<Konto> hilfsKontoListe = new ArrayList<Konto>();
	  		
		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
		lblLogo.setBounds(55, 15, 215, 75);
		panel.add(lblLogo);
		
		//Icons mit Buttons laden 
		JButton btnBearbeiten = new JButton();
		JButton btnLoeschen = new JButton();
		
		btnBearbeiten.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/icon/stift.gif")));
		btnLoeschen.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/icon/delete.png")));
		
		btnBearbeiten.setBounds(490, 250, 50, 50);
		btnLoeschen.setBounds(490, 300, 50, 50);
		
		panel.add(btnBearbeiten);
		panel.add(btnLoeschen);
		
		
		//Info Label erstellen
		JLabel lblKontenAnzeigen = new JLabel("<html>Kundenkonto anzeigen/<p>bearbeiten/<p>loeschen<p></html>");
		lblKontenAnzeigen.setFont(new Font("KufiStandardGK", Font.BOLD, 20));
		lblKontenAnzeigen.setBounds(310, 15, 250, 86);
		panel.add(lblKontenAnzeigen);

		//Textfelder erstellen
		final JTextField txtKundennummer = new JTextField();
	    final JTextField txtVorname = new JTextField();
	    final JTextField txtNachname = new JTextField();
	    
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
		lblKontoart.setBounds(208, 230, 150, 16);
		lblKontostand.setBounds(334, 230, 150, 16);
		
		//Labels zum Panel hinzufügen
		panel.add(lblKundennummer);
		panel.add(lblVorname);
		panel.add(lblNachname);
		panel.add(lblKontonummer);
		panel.add(lblKontoart);
		panel.add(lblKontostand);
		
		//Liste für die Ausgabe der Konten
		final DefaultListModel data = new DefaultListModel();
		final JList list = new JList(data);
		list.setBounds(60, 250, 405, 100);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		
		if (kundenNummer != 0) 
	   		txtKundennummer.setText(Integer.toString(kundenNummer));
		txtKundennummer.requestFocus();
		
		
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

		} catch (AWTException e1) {
			
		}
		
		//Objekte neu malen
		panel.repaint();
		
		txtVorname.setEditable(false);
		txtNachname.setEditable(false);
		
		//Actionlistener für Kundensuche
		txtKundennummer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
							//Clear
							hilfsKontoListe.clear();
							data.removeAllElements();
							
							if (!txtKundennummer.getText().equals("")) {
								//Nach Kunde suchen
								for (Kunde kd : kundenListe)	
									if (kd.getKundenNummer() == Integer.parseInt(txtKundennummer.getText())) {
										txtVorname.setText(kd.getVorname());
										txtNachname.setText(kd.getNachname());
										
										//Nach seinen Konten suchen
										for (Konto kto : kontoListe) 
											if ( kto.getKundenNummer() == kd.getKundenNummer()) {
												data.addElement(kto.toString());
												hilfsKontoListe.add(kto);
											}
									}
							}	
					}
				}
		);
		
		//Actionlistener für btnBearbeiten
		btnBearbeiten.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (!list.isSelectionEmpty()) {
							int i = list.getSelectedIndex();
							
							kontoBearbeitenPanel(hilfsKontoListe.get(i));
						}
							
					}
				}
		);
		
		//Actionlistener für btnLoeschen
		btnLoeschen.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if (!list.isSelectionEmpty()) {
							int i = list.getSelectedIndex();
						    kontoListe.remove(hilfsKontoListe.get(i));
							//hilfsKontoListe.remove(i);
							alleKontenAnzeigenPanel(Integer.parseInt(txtKundennummer.getText()));

						}				
					}
				}
		);
   }
   
   /**
	 * Bearbeiten-Panel um Konten zu bearbeiten
	 * @author DMF
	 */
   public void kontoBearbeitenPanel(final Konto kto){
	    
	   
	    //Entfernt alle zuvor hinzugefügten Objekte vom Panel
	    panel.removeAll();
	   
		//Logo laden
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
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
	    final JTextField txtKontostand = new JTextField();
	    
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
		final JRadioButton rdbtnGirokonto = new JRadioButton("Girokonto");
		JRadioButton rdbtnSparkonto = new JRadioButton("Sparkonto");
		
		//Radiobuttons gruppieren
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnGirokonto);
		group.add(rdbtnSparkonto);
		
		rdbtnGirokonto.setBounds(320, 200, 141, 23);
		rdbtnSparkonto.setBounds(320, 220, 141, 23);
		
		
		
		//Separatoren für Oben und Unten 
		JSeparator sepOben = new JSeparator();
		JSeparator sepUnten = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepUnten.setBackground(Color.BLACK);
		
		sepOben.setBounds(55, 360, 490, 20);
		sepUnten.setBounds(55, 100, 490, 20);
		
		panel.add(sepOben);
		panel.add(sepUnten);
		
		//KontoBearbeiten Button hinzufügen
		JButton btnKontoBearbeiten = new JButton("speichern");
		btnKontoBearbeiten.setBounds(230, 400, 135, 30);
		panel.add(btnKontoBearbeiten);
		
		//Objekte neu malen
		panel.repaint();
		
		//Übergebens Konto darstellen
		txtKundennummer.setText(Integer.toString(kto.getKundenNummer()));
		txtKontonummer.setText(Integer.toString(kto.getkontoNummer()));
		if (kto.getKontoArt().equals("Girokonto"))
			rdbtnGirokonto.setSelected(true);
		else
			rdbtnSparkonto.setSelected(true);
		
		panel.add(rdbtnGirokonto);
		panel.add(rdbtnSparkonto);
		
		txtKontostand.setText(Double.toString(kto.getkontoStand()).replace(".", ","));
		
		//Nicht-änderbare TextFelder 
		txtKontonummer.setEditable(false);
		txtKundennummer.setEditable(false);
		
		
		btnKontoBearbeiten.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//KontoArt bestimmen
						String kontoArt;
						if (true == rdbtnGirokonto.isSelected())
							kontoArt = "Girokonto";
						else
							kontoArt = "Sparkonto";
						
						//KontoBearbeiten Funktion aufrufen und neue Werte abspeichern
						kto.kontoBearbeiten(kontoArt, Double.parseDouble(txtKontostand.getText().replace(",", ".")));
						
						//Altes Panel wieder starten
						alleKontenAnzeigenPanel(kto.getKundenNummer());
					}
				}
		);
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
	  	lblLogo.setIcon(new ImageIcon(KontoverwaltungsFenster.class.getResource("/pic/LOGO.jpg")));
	  	lblLogo.setBounds(200, 15, 215, 75);
	  	panel.add(lblLogo);
	    
	    JLabel lblInfo = new JLabel("<html><center>Autoren:<p><p> Dennis Morales Flores <p> Markus Mayer <p> Marco Rubin</center></html>");
	    lblInfo.setFont(new Font("KufiStandardGK", Font.PLAIN, 12));
	    lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblInfo.setBounds(SwingConstants.CENTER, SwingConstants.CENTER, 600, 500);
	    panel.add(lblInfo);
	    
	    //Objekte neu malen
	  	panel.repaint();
   }
 }
