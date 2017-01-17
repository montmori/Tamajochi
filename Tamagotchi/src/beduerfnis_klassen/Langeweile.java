package beduerfnis_klassen;

import timerTask_klassen.BeduerfnissVerringerungsTask;

public class Langeweile extends Beduerfnis{

	private static final long serialVersionUID = -392813517868554401L;

	public Langeweile(int wert) {
		super(wert, BeduerfnisWerte.MAXLANGEWEILE, BeduerfnisWerte.MINLANGEWEILE);
		this.startTask(this);
	}


	public int getWert() {
		return super.wert;
	}
	
	public void startTask(Beduerfnis b){
		
		int periodTime = LANGEWEILEPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(b, VerringerungsWerte.LANGEWEILE), initialDelay, periodTime);
	}

}
