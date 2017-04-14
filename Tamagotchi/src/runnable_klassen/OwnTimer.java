/**
 * Zentralisiert die Timer.
 * Ist wichtig, da man alle gleichzeitig aus- bzw. anschalten kann.
 */

package runnable_klassen;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OwnTimer{

	private static ScheduledThreadPoolExecutor s;
	public static final int EXECUTOR_CORE_POOL_SIZE = 20;

	/**
	 * Wenn kein ScheduledThreadPoolExecutor existiert, wird ein neuer erstellt.
	 * @see java.util.ScheduledThreadPoolExecutor#scheduleAtFixedRate(Runnable, long, long, TimeUnit)
	 */
	public static void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
		}
		
		s.scheduleAtFixedRate(command, initialDelay, period, unit);
		
	}
	
	
	/**
	 * Task wird nur einmal ausgeführt.
	 * Wenn kein ScheduledThreadPoolExecutor existiert, wird ein neuer erstellt.
	 * @see java.util.ScheduledThreadPoolExecutor#schedule(Runnable, long, TimeUnit)
	 */
	public static void queueTask(Runnable command, long initialDelay, TimeUnit unit){
		
		if(s == null){
			s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
		}
		
		s.schedule(command, initialDelay, unit);
		
	}
	
	
	/**
	 * Alle laufenden Threads die der Timer erstellt hat, werden beendet und eine neue Instanz eines ScheduledThreadPoolExecutor wird erstellt, die die alte Instanz überschreibt.
	 */
	public static void clearTimer(){
		s.shutdown(); //Threads die nicht beendet werden können, werden bei der Neuinstanzierung unbeendet verworfen.
		s = new ScheduledThreadPoolExecutor(OwnTimer.EXECUTOR_CORE_POOL_SIZE);
	}
	
}
