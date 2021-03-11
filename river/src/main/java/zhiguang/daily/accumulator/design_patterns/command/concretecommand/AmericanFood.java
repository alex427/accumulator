package zhiguang.daily.accumulator.design_patterns.command.concretecommand;


import zhiguang.daily.accumulator.design_patterns.command.command.Command;

public class AmericanFood implements Command {

	@Override
	public void cook() {
		
		
	}

	@Override
	public boolean canCook() {
		
		return false;
	}

}
