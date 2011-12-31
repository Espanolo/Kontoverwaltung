
/**
 * Kunden Klasse
 * @author DMF
 */

public class Kunde {
	private int kundenNummer, postleitzahl;
	private String vorname, nachname, strasse, ort;
	
	/**
	 * TODO: Kunde anlegen
	 * @author DMF
	 */
	public void kundeAnlegen(int kundenNummer, String vorname, String nachname, String strasse, int postleitzahl, String ort){
		this.kundenNummer = kundenNummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		
		//Kontonummer um 1 erhšhen
		GlobaleVariable.kundenNummer++;
		
	}
	//Getter
	public int getKundenNummer(){
		return kundenNummer;
	}
	public String getVorname(){
		return vorname;
	}
	public String getNachname(){
		return nachname;
	}
	public String getStrasse(){
		return strasse;
	}
	public int getPostleitzahl(){
		return postleitzahl;
	}
	public String getOrt(){
		return ort;
	}
	/**
	 * TODO: Kunde bearbeiten
	 * @author DMF
	 */
	public void kundeBearbeiten(String vorname, String nachname, String strasse, int postleitzahl, String ort){
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		
	}	
	/**
	 * ToString Ÿberschrieben, um bei der Ausgabe die richtige Breite zwischen den Variablen zu bekommen
	 * @author DMF
	 * @return kundennummer vorname nachname 
	 */
	public String toString(){
		return kundenNummer + "                             "
				+FuelleString.fuelleString(vorname, 26) + nachname;
	}
	/**
	 * ToString Long
	 * @author DMF
	 * @return kundennummer vorname nachname strasse postleitzahl ort 
	 */
	public String toStringLong(){
		return kundenNummer + "                                        "
				+ vorname + "                  "
				+ nachname + " " + strasse + " " + postleitzahl + " " + ort;
	}
}
