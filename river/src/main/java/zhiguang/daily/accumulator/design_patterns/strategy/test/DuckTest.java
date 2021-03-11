package zhiguang.daily.accumulator.design_patterns.strategy.test;


import zhiguang.daily.accumulator.design_patterns.strategy.behaviors.*;
import zhiguang.daily.accumulator.design_patterns.strategy.child.*;
import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.*;

/**
 * @author zhiguang
 */
public class DuckTest {

    public static void main(String[] args) {

        Fly fh = new FlyHighBehavior();
        Fly fl = new FlyLowBehavior();
        Speak sb = new SpeakBadBehavior();
        Speak sg = new SpeakGoodBehavior();

        GreenDuck greenDuck = new GreenDuck(fh, sb);
        RedDuck redDuck = new RedDuck(fl, sg);

        greenDuck.fly();
        greenDuck.speak();
        greenDuck.dosome();

        redDuck.fly();
        redDuck.speak();
        redDuck.dosome();

    }

}
