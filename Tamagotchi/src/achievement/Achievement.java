/**
 * Zum festhalten der Achievemntstatus.
 */
package achievement;

import java.io.Serializable;

public class Achievement implements Serializable{

	
	private static final long serialVersionUID = -3423947201210581401L;
	
	//erfolg 1 .. 2 .. 3 damit man nicht sofort gespoilert wird falls man iwo im code etwas sieht sondern nur erkennt das dort etwas gemacht wird. 
	private boolean erfolg1;//Erstes mal gestorben
	private boolean erfolg2;//"Oreo" keks (erst Keks(Bedingung) dann Milch(erreicht))
	private boolean erfolg2Bedingung;
	private boolean erfolg3;//bevor es starb hat es Salzwasser gesehen
	private boolean erfolg3Bedingung;
	
	//noch mehr möglich
	private boolean erfolg4;//10 sek überlebt
	private boolean erfolg5;//30 sek überlebt
	
	
	/**
	 * Konstruktor.
	 */
	public Achievement(){
		//Booleans sind in Java standartmaessig auf "false"
	}

	/**
	 * @return 	true, falls Erfolg1 erreicht.
	 */
	public boolean isErfolg1() {
		return erfolg1;
	}
	
	/**
	 * Setzt Erfolg1 auf true.
	 */
	public void setErfolg1() {
		this.erfolg1 = true;
	}
	
	/**
	 * @return 	true, falls Erfolg2 erreicht.
	 */
	public boolean isErfolg2(){
		return erfolg2;
	}
	
	/**
	 * Setzt Erfolg2Bedingung auf true.
	 */
	public void setErfolg2Bedingung(){
		this.erfolg2Bedingung = true;
	}
	
	/**
	 * Setzt Erfolg2Bedingung auf false.
	 */
	public void resteErfolg2Bedingung(){
		this.erfolg2Bedingung = false;
	}
	
	/**
	 * @return 	true, falls Erfolg2Bedinung erfüllt.
	 */
	public boolean getErfolg2Bedingung(){
		return this.erfolg2Bedingung;
	}
	
	
	/**
	 * Setzt Erfolg2 auf true.
	 */
	public void setErfolg2(){
		this.erfolg2 = true;
	}

	
	/**
	 * @return 	true, falls Erfolg3 erreicht.
	 */
	public boolean isErfolg3() {
		return erfolg3;
	}
	
	
	/**
	 * Setzt Erfolg3Bedinung auf true.
	 */
	public void setErfolg3Bedingung(){
		this.erfolg3Bedingung = true;
	}
	
	/**
	 * Setzt Erfolg3Bedinung auf false.
	 */
	public void resteErfolg3Bedingung(){
		this.erfolg3Bedingung = false;
	}
	
	/**
	 * @return	true, wenn Erfolg3Bedinung erfüllt.
	 */
	public boolean getErfolg3Bedingung(){
		return this.erfolg3Bedingung;
	}
	
	
	/**
	 * Setzt Erfolg3 auf true.
	 */
	public void setErfolg3() {
			this.erfolg3 = true;
	}
	
	/**
	 * @return true, falls Erfolg4 erreicht.
	 */
	public boolean isErfolg4() {
		return erfolg4;
	}
	
	/**
	 * Setzt Erfolg4 auf true.
	 */
	public void setErfolg4() {
		this.erfolg4 = true;
	}
	
	/**
	 * @return	true, falls Erfolg5 erreicht.
	 */
	public boolean isErfolg5() {
		return erfolg5;
	}
	
	/**
	 * Setzt Erfolg5 auf true.
	 */
	public void setErfolg5() {
		this.erfolg5 = true;
	}
	
	/**
	 * Wenn ein Erfolg nicht erreicht ist, wird dieser Text angezeigt.
	 * @return	String, der angezeigt wird, wenn der Erfolg noch nicht erreicht ist.
	 */
	public String getLueckenfuellerTXT(){
		return "???"
				+ "\n\n";
	}
	
	
	/**
	 * @return 	String, der angezeigt wird, wenn Erfolg1 erreicht ist.
	 */
	public String getErfolg1TXT(){
		return "Das Tamagotchi ist das erste mal gestorben. :c"
				+ "\n\n";
	}
	
	/**
	 * @return 	String, der angezeigt wird, wenn Erfolg2 erreicht ist.
	 */
	public String getErfolg2TXT(){
		return "Keks + Milch :D"
				+ "\n\n";
	}
	
	/**
	 * @return 	String, der angezeigt wird, wenn Erfolg3 erreicht ist.
	 */
	public String getErfolg3TXT(){
		return "Nooooiiiinnnn! Warum ? .w."
				+ "\n\n";
	}
	
	/**
	 * @return 	String, der angezeigt wird, wenn Erfolg4 erreicht ist.
	 */
	public String getErfolg4TXT(){
		return "Tamagotchi hat 10 Sekunden überlebt."
				+ "\n\n";
	}
	
	/**
	 * @return 	String, der angezeigt wird, wenn Erfolg5 erreicht ist.
	 */
	public String getErfolg5TXT(){
		return "Tamagotchi hat 30 Sekunden überlebt."
				+ "\n\n";
	}
}
