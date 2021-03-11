/**
 * 
 */
package zhiguang.daily.accumulator.design_patterns.strategy.behaviors;


import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.*;

/**
 * @author zhiguang
 *
 */
public class SpeakBadBehavior implements Speak {

	@Override
	public void speak() {
		System.out.println("i can speak bad");
		
	}

}
