package zhiguang.daily.accumulator.design_patterns.strategy.foo;


import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Fly;
import zhiguang.daily.accumulator.design_patterns.strategy.interfaces.Speak;

/**
 * @author zhiguang
 *
 */
public abstract class Duck {
	public String color;
	public Fly fly;
    public Speak speak;


	public void dosome(){
		System.out.println("我来自抽象父类");
	}
	
	//关键
	public void fly(){
		fly.fly();
	}
	//关键
	public void speak(){
		speak.speak();
	}
	

	public Fly getFly() {
		return fly;
	}

	public void setFly(Fly fly) {
		this.fly = fly;
	}

	public Speak getSpeak() {
		return speak;
	}

	public void setSpeak(Speak speak) {
		this.speak = speak;
	}
	
	
	
}
