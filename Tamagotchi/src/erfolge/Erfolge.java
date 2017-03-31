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

package erfolge;

import java.io.Serializable;

public class Erfolge implements Serializable{

	private static final long serialVersionUID = -3423947201210581401L;
	
	//Testerfolge
	private boolean erfolg1;//nach 10 sek
	private boolean erfolg2;//nach 1. mal essen geben(Apfel)
	private boolean erfolg3;//game over
	
	public Erfolge(){
		this.erfolg1 = false;
		this.erfolg2 = false;
		this.erfolg3 = false;
	}

	//getter und setter
	public boolean isErfolg1() {
		return erfolg1;
	}

	public void setErfolg1(boolean erfolg1) {
		this.erfolg1 = erfolg1;
	}

	public boolean isErfolg2() {
		return erfolg2;
	}

	public void setErfolg2(boolean erflog2) {
		this.erfolg2 = erflog2;
	}

	public boolean isErfolg3() {
		return erfolg3;
	}

	public void setErfolg3(boolean erfolg3) {
		this.erfolg3 = erfolg3;
	}
	
	
	
}
