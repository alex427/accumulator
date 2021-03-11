/**
 * 
 */
package zhiguang.daily.accumulator.design_patterns.strategy.behaviors;

import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Fly;

/**
 * @author zhiguang
 *
 */
public class FlyLowBehavior implements Fly {

	@Override
	public void fly() {
		System.out.println("I can fly low");
		
	}

}
