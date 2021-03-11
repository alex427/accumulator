package zhiguang.daily.accumulator.design_patterns.command.utils;

public class ThreadUtil {
	public static void sleep(long millis){
		try {			
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
