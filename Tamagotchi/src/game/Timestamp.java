package game;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import runnable_klassen.OwnTimer;

public class Timestamp implements Serializable,Runnable {

	private static final long serialVersionUID = 726945156398220291L;

	private int time;
	
	public Timestamp(){
		this.setTime(0);
		startCounting();
	}
	
	public void startCounting(){
		OwnTimer.queueTask(this, 1, 1, TimeUnit.SECONDS);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void countTime(){
		this.time++; 
	}

	@Override
	public void run() {
		this.time++;
	}
	
	
}
