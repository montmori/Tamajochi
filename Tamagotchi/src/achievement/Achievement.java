/****************************************
 * INFO:                                *
 *--------------------------------------*
 * Die Kommentare "Erfolg" sind nur     *
 * dazu da damit ich die Aenderungen    *
 * leichter wiederfinden kann die       *
 * ich in diesem Kontext gemacht        *
 * habe.                                *
 * ~ Yoshi                              *
 ****************************************/

package achievement;

import java.io.Serializable;

public class Achievement implements Serializable{

	
	private static final long serialVersionUID = -3423947201210581401L;
	
	//erfolg 1 .. 2 .. 3 damit man nicht sofort gespoilert wird falls man iwo im code etwas sieht sondern nur erkennt das dort etwas gemacht wird. 
	private boolean erfolg1;//1.malsterben
	private boolean erfolg2;//"oreo" keks (erst keks(bedingung) dann milch(erreicht))
	private boolean erfolg2Bedingung;
	private boolean erfolg3;//bevor es starb hat es salzwasser gesehen
	private boolean erfolg3Bedingung;
	
	//noch mehr möglich
	private boolean erfolg4;//10 sek überlebt
	private boolean erfolg5;//30 sek überlebt
	
	public Achievement(){
		//booleans sind in Java standartmaessig auf "false"
	}

	public boolean isErfolg1() {
		return erfolg1;
	}
	public void setErfolg1() {
		this.erfolg1 = true;
	}
	
	public boolean isErfolg2(){
		return erfolg2;
	}
	public void setErfolg2Bedingung(){
		this.erfolg2Bedingung = true;
	}
	public void resteErfolg2Bedingung(){
		this.erfolg2Bedingung = false;
	}
	public boolean getErfolg2Bedingung(){
		return this.erfolg2Bedingung;
	}
	public void setErfolg2(){
		this.erfolg2 = true;
	}

	public boolean isErfolg3() {
		return erfolg3;
	}
	public void setErfolg3Bedingung(){
		this.erfolg3Bedingung = true;
	}
	public void resteErfolg3Bedingung(){
		this.erfolg3Bedingung = false;
	}
	public boolean getErfolg3Bedingung(){
		return this.erfolg3Bedingung;
	}
	public void setErfolg3() {
			this.erfolg3 = true;
	}
	
	public boolean isErfolg4() {
		return erfolg4;
	}
	public void setErfolg4() {
		this.erfolg4 = true;
	}
	
	public boolean isErfolg5() {
		return erfolg5;
	}
	public void setErfolg5() {
		this.erfolg5 = true;
	}
	
	public String getLueckenfuellerTXT(){
		return "???"
				+ "\n\n";
	}
	public String getErfolg1TXT(){
		return "Das Tamagotchi ist das erste mal gestorben. :c"
				+ "\n\n";
	}
	public String getErfolg2TXT(){
		return "Keks + Milch :D"
				+ "\n\n";
	}
	public String getErfolg3TXT(){
		return "Nooooiiiinnnn! Warum ? .w."
				+ "\n\n";
	}
	public String getErfolg4TXT(){
		return "Tamagotchi hat 10 Sekunden überlebt."
				+ "\n\n";
	}
	public String getErfolg5TXT(){
		return "Tamagotchi hat 30 Sekunden überlebt."
				+ "\n\n";
	}
}
