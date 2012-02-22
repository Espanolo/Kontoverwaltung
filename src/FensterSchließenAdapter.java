/**
	 * Java Projekt WS11
	 * Kontoverwaltungsprogramm
	 * 
	 * 
	 * @author Dennis Morales Flores, Markus Mayer, Marko Rubin
	 */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

	/**
	  * Um das Beenden �ber Men�->Datei->Schlie�en und den X-Button zu gew�hrleisten, bzw. das Laden und Speichern der Kunden/Kontenlisten
	  * @author DMF
	  */
 class FensterSchlie�enAdapter extends WindowAdapter
   {
	 @Override
     public void windowClosing( WindowEvent e ) { 
    	 DateiSpeichern.kontenListeSpeichern(KontoverwaltungsFenster.kontoListe, "kontoListe.txt");
    	 DateiSpeichern.kundenListeSpeichern(KontoverwaltungsFenster.kundenListe, "kundenListe.txt");
    	 System.exit(0);
     }
   }