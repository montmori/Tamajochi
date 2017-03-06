package beduerfnis_klassen;

import runnable_klassen.BeduerfnissVerringerungsTask;

public class Langeweile extends Beduerfnis{

	private static final long serialVersionUID = -392813517868554401L;

	public Langeweile(int wert) {
		super(wert, BeduerfnisWerte.MAXLANGEWEILE, BeduerfnisWerte.MINLANGEWEILE);
		this.startTask();
	}


	public int getWert() {
		return super.wert;
	}
	
	public void startTask(){
		
		int periodTime = BeduerfnisWerte.LANGEWEILEPT;
		int initialDelay = periodTime;
		
		super.startTask(new BeduerfnissVerringerungsTask(this, VerringerungsWerte.LANGEWEILE), initialDelay, periodTime);
	}

}
