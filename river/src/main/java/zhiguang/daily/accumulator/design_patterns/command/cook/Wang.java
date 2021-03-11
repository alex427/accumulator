package zhiguang.daily.accumulator.design_patterns.command.cook;


import zhiguang.daily.accumulator.design_patterns.command.cookable.ChieseCook;
import zhiguang.daily.accumulator.design_patterns.command.utils.ThreadUtil;

public class Wang implements ChieseCook {

	@Override
	public void chaofan() {
		
		ThreadUtil.sleep(1000);
		System.out.println("中国炒饭");
	}
	
	
}
