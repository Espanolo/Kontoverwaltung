	/**
	 * f�llt String Variabe mit Leerzeichen auf
	 * @author DMF
	 * @return test
	 */
public class FuelleString{
	
	public static String fuelleString(String text, int breite) {
	//String rechts mit Spaces f�llen bis er 'breite' Zeichen breit ist
		while (text.length() < breite)
			text +=" ";
		return text;
	}
}
