package game;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import runnable_klassen.OwnTimer;

public class Timestamp implements Serializable,Runnable {

	private static final long serialVersionUID = 726945156398220291L;

	private int time;
	private boolean isStarted;
	
	public Timestamp(){
		this.setTime(0);
		this.isStarted = false;
		OwnTimer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
	}
	
	public void resumeAfterShutdown(){
		OwnTimer.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
		this.isStarted = true;
	}
	
	public void start(){
		this.isStarted = true;
	}

	public void stop(){
		this.isStarted = false;
	}
	
	public void reset(){
		this.setTime(0);
	}
	
	public int getTimeSeconds() {
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
		if(this.isStarted){
			this.time++;
		}
	}
}
