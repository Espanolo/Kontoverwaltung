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
	 * 
	 * 
	 * @author DMF
	 */
	public static void main(String[] args) {
		
		/**
		 * Das Hauptfenster für das Programm wird initialisiert und ausgerichtet
		 * @author DMF
		 */
		JFrame mainWindow = new JFrame("Kontoverwaltung");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600, 500);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(true);
		
		/**
		 * Die MenüBar wird erstellt und die einzelnen Items werden hinzugefügt
		 * @author DMF
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);
		
		fileMenu.addSeparator();
		/**
		 * Der MenüBar ein Beenden hinzufügen und mit Funktionalität erweitern
		 * @author DMF
		 */
		Action exitAction = new AbstractAction("Beenden"){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		fileMenu.add(exitAction);
		
		JMenu customerMenu = new JMenu("Kunde");
		menuBar.add(customerMenu);
		customerMenu.add(new JMenuItem("Neuen Kunden erstellen"));
		customerMenu.add(new JMenuItem("Alle Kunden anzeigen"));
		customerMenu.add(new JMenuItem("Kunde bearbeiten"));
		customerMenu.add(new JMenuItem("Kunde löschen"));
		
		JMenu accoutMenu = new JMenu("Konto");
		menuBar.add(accoutMenu);
		accoutMenu.add(new JMenuItem("Neues Konto erstellen"));
		accoutMenu.add(new JMenuItem("Alle Konten anzeigen"));
		accoutMenu.add(new JMenuItem("Konto bearbeiten"));
		accoutMenu.add(new JMenuItem("Konto löschen"));
		
		JMenu helpMenu = new JMenu("Hilfe");
		menuBar.add(helpMenu);
		helpMenu.add(new JMenuItem("Über das Programm"));
		
		
		mainWindow.setVisible(true);
		
	}

}
