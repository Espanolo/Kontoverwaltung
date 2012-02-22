/**
	 * Java Projekt WS11
	 * Kontoverwaltungsprogramm
	 * 
	 * 
	 * @author Dennis Morales Flores, Markus Mayer, Marko Rubin
	 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DateiLaden {
	 private static ArrayList<Kunde> liste1;
	 private static ArrayList<Konto> liste2;
	 
	private static void kontoZeileVerarbeiten (String zeile){
	System.out.println(zeile);
		Scanner scanner = new Scanner(zeile);
		scanner.useDelimiter(";;");

		if(scanner.hasNext()){
			int kontoNummer = scanner.nextInt();
			int kundenNummer = scanner.nextInt();
			String kontoArt = scanner.next();
			double kontoStand = scanner.nextDouble();
			
			Konto marko = new Konto();
			marko.neuesKonto(kontoNummer, kundenNummer, kontoArt, kontoStand);
			
			
			liste2.add(marko);
	
		}
			else {
				 System.out.println("Leere oder ungueltige Zeile. Konnte nicht verarbeitet werden.");
			}	
		}

	public static ArrayList<Konto> kontoListeLesen(String pfad){

		liste2 = new ArrayList<Konto>();
		
	BufferedReader neu;
	try {
		neu = new BufferedReader(new FileReader(pfad));
		
		String zeile;
		
		while((zeile = neu.readLine()) != null){
			kontoZeileVerarbeiten(zeile);
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return liste2;
	}
	
	private static void kundenZeileVerarbeiten(String zeile){
		
		Scanner scanner = new Scanner(zeile);
		scanner.useDelimiter(";;");
		
		if(scanner.hasNext()){
			int kundenNummer = scanner.nextInt();
			String vorname = scanner.next();
			String nachname = scanner.next();
			String strasse = scanner.next();
			int postleitzahl = scanner.nextInt();
			String ort = scanner.next();
			
			Kunde marko = new Kunde();
			marko.kundeAnlegen(kundenNummer, vorname, nachname,
strasse, postleitzahl, ort);
			
			
			liste1.add(marko);
					
		}
		else {
			 System.out.println("Leere oder ungueltige Zeile. Konnte nicht verarbeitet werden.");
		}	
	}

	public static ArrayList<Kunde> kundenListeLesen(String pfad){

		liste1 = new ArrayList<Kunde>();
		
	BufferedReader neu;
	try {
		neu = new BufferedReader(new FileReader(pfad));
		
		String zeile;
		
		while((zeile = neu.readLine()) != null){
			kundenZeileVerarbeiten(zeile);
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return liste1;
	}
}