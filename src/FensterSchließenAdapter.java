import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

 class FensterSchlie§enAdapter extends WindowAdapter
   {
	 @Override
     public void windowClosing( WindowEvent e ) { 
    	 DateiSpeichern.kontenListeSpeichern(KontoverwaltungsFenster.kontoListe, "kontoListe.txt");
    	 DateiSpeichern.kundenListeSpeichern(KontoverwaltungsFenster.kundenListe, "kundenListe.txt");
    	 System.exit(0);
     }
   }