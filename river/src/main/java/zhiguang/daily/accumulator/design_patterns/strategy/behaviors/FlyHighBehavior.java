/**
 * 
 */
package zhiguang.daily.accumulator.design_patterns.strategy.behaviors;


import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Fly;

/**
 * @author zhiguang
 *
 */
public class FlyHighBehavior implements Fly {

	@Override
	public void fly() {
		System.out.println("I can fly high");
		
	}

}
