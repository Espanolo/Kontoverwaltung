/**
	 * Konto Klasse
	 * @author DMF
	 */
public class Konto{
	private int kontoNummer, kundenNummer;
	private String kontoArt;
	private double kontoStand;
	
	/**
	 * TODO: Neues Konto anlegen
	 * @author DMF
	 */
	public void neuesKonto(int kontoNummer, int kundenNummer, String kontoArt, double kontoStand){ 
		
		this.kontoNummer = kontoNummer;
		this.kundenNummer = kundenNummer;
		this.kontoArt = kontoArt;
		this.kontoStand = kontoStand;
		
		//Kontonummer um 1 erhöhen
		GlobaleVariable.kontoNummer++;
	}
	
	//Getter
	public int getkontoNummer(){
		return kontoNummer;
	}
	public int getKundenNummer(){
		return kundenNummer;
	}
	public double getkontoStand(){
		return kontoStand;
	}

	/**
	 * TODO: Konto bearbeiten
	 * @author DMF
	 */
	public void kontoBearbeiten(int kontoNummer){ 
		 
	}
	/**
	 * TODO: Kontolöschen 
	 * @author DMF
	 */
	public void kontoLoeschen(int kontoNummer){ 
		
	}
	
	public String getData(){
		String i = "" +kontoNummer
		+";;"+ kundenNummer
		+";;"+ kontoArt 
		+";;"+ kontoStand
		+"\r\n";
		return i;
	}
	/**
	 * ToString überschrieben, um bei der Ausgabe die richtige Breite zwischen den Variablen zu bekommen
	 * @author DMF
	 * @return kundennummer vorname nachname 
	 */
	public String toString(){
		return kontoNummer + "                             "
				+FuelleString.fuelleString(kontoArt, 26) + kontoStand;
	}
	public String toStringShort(){
		return kontoNummer + "                    " + kontoArt;
	}

}