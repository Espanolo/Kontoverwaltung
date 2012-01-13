import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DateiLaden {
	
	private static void zeileVerarbeiten(String zeile){
		
		Scanner scanner = new Scanner(zeile);
		scanner.useDelimiter(";;");
		
		if(scanner.hasNext()){
			int kundenNummer = scanner.nextInt();
			String vorname = scanner.next();
			String nachname = scanner.next();
			String strasse = scanner.next();
			int postleitzahl = scanner.nextInt();
			String ort = scanner.next();
					
		}
		else {
			 System.out.println("Leere oder ungültige Zeile. Konnte nicht verarbeitet werden.");
		}	
	}
	public static ArrayList<Kunde> kundenListeLesen(String pfad){

	BufferedReader neu;
	try {
		neu = new BufferedReader(new FileReader(pfad));
		
		String zeile;
		
		while((zeile = neu.readLine()) != null){
			zeileVerarbeiten(zeile);
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
}
