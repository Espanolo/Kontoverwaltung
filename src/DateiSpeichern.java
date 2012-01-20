
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class DateiSpeichern {
/**
* Erstellt Datei und Speichert in pfad
* @param kundenListe
* @param pfad
* @author marko
*/
	public static void kundenListeSpeichern(ArrayList<Kunde>
kundenListe, String pfad){
		FileOutputStream schreibeStrom;
		try {
			schreibeStrom = new FileOutputStream(pfad);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		for (int i=0; i < kundenListe.size(); i++){
			
			String data = kundenListe.get(i).getData();
			for (int m=0; m < data.length(); m++){
				  try {

					  schreibeStrom.write((byte)data.charAt(m));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
		
			}}	
		try {
			schreibeStrom.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}	
	
	/**
	 * Erstellt Datei und Speichert in pfad
	 * @param kontenListe
	 * @param pfad
	 * @author marko
	 */
	public static void kontenListeSpeichern(ArrayList<Konto>
							kontenListe, String pfad){
		FileOutputStream schreibeStrom;
		try {
			schreibeStrom = new FileOutputStream(pfad);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		for (int i=0; i < kontenListe.size(); i++){
			
			String data = kontenListe.get(i).getData();
			for (int m=0; m < data.length(); m++){
				  try {
					  //Punkt durch Komma ersetzt, damit es spŠter beim Laden keine Probleme gibt
					  data = data.replace(".", ",");
					  schreibeStrom.write((byte)data.charAt(m));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
		
			}}	
		try {
			schreibeStrom.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}	
}
