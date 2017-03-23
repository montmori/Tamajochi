package game;

import java.io.Serializable;

public class Timestamp implements Serializable {

	private static final long serialVersionUID = 726945156398220291L;

	private int time;
	
	public Timestamp(){
		this.setTime(0);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
