package runnable_klassen;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OwnTimer{

	private static ScheduledThreadPoolExecutor s;

	public static void queueTask(Runnable command, long initialDelay, long period, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(0);
		}
		
		s.scheduleAtFixedRate(command, initialDelay, period, unit);
		
	}
	
	public static void queueTask(Runnable command, long initialDelay, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(0);
		}
		
		s.schedule(command, initialDelay, unit);
		
	}
	
	public static void stopTimer(){
		s = new ScheduledThreadPoolExecutor(0);
	}
	
	
}
