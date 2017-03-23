package runnable_klassen;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OwnTimer{

	private static ScheduledThreadPoolExecutor s;
	public static final int EXECUTOR_CORE_POOL_SIZE = 10;

	public static void queueTask(Runnable command, long initialDelay, long period, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
		}
		
		s.scheduleAtFixedRate(command, initialDelay, period, unit);
		
	}
	
	public static void queueTask(Runnable command, long initialDelay, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
		}
		
		s.schedule(command, initialDelay, unit);
		
	}
	
	public static void clearTimer(){
		s.shutdown();
		s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
	}
	
}
