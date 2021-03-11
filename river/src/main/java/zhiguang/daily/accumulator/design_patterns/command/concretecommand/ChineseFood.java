package zhiguang.daily.accumulator.design_patterns.command.concretecommand;


import zhiguang.daily.accumulator.design_patterns.command.command.Command;
import zhiguang.daily.accumulator.design_patterns.command.cook.Wang;

public class ChineseFood implements Command {
	
	private Wang wang;
	
	public ChineseFood(Wang wang){
		this.wang = wang;
	}

	@Override
	public void cook() {
		
		wang.chaofan();
	}

	@Override
	public boolean canCook() {
		
		return false;
	}

}
