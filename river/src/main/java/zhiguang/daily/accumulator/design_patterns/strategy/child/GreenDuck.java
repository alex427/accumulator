/**
 * 
 */
package zhiguang.daily.accumulator.design_patterns.strategy.child;


import zhiguang.daily.accumulator.design_patterns.strategy.foo.Duck;
import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Fly;
import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Speak;

/**
 * @author zhiguang
 *
 */
public class GreenDuck extends Duck {

    public GreenDuck(Fly fly, Speak speak) {
        this.fly = fly;
        this.speak = speak;
    }

}
