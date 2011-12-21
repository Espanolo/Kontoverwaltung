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
		/**
		 * Der Men�Bar ein Beenden hinzuf�gen und mit Funktionalit�t erweitern
		 * @author DMF
		 */
		Action exitAction = new AbstractAction("Beenden"){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		fileMenu.add(exitAction);
		
		
		JMenu helpMenu = new JMenu("Hilfe");
		menuBar.add(helpMenu);
		helpMenu.add(new JMenuItem("�ber das Programm"));
		
		
		mainWindow.setVisible(true);
		
	}

}
