import java.awt.event.*;
import javax.swing.*;

	/**
	 * Java Projekt WS11
	 * Kontoverwaltungsprogramm
	 * 
	 * 
	 * @author Dennis Morales, Markus Mayer, Marco Rubin
	 */


public class KontoverwaltungMain {

	
	
	/**
	 * 
	 * Hauptprogramm
	 * 
	 * @author DMF
	 */
	public static void main(String[] args) {
		
		/**
		 * Das Hauptfenster f�r das Programm wird initialisiert und ausgerichtet
		 * @author DMF
		 */
		JFrame mainWindow = new JFrame("Kontoverwaltung");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600, 500);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(true);
		
		/**
		 * Die Men�Bar wird erstellt und die einzelnen Items werden hinzugef�gt
		 * @author DMF
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);
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
						//Funktionen fehlen
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
		mainWindow.setVisible(true);
		
	}

}
