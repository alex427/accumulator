package zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.jiamengdian;


import zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.ingredient.BeijingIgFactory;
import zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.ingredient.IngredientFactory;
import zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.pizza.HotPizza;
import zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.pizza.Pizza;
import zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.pizza.SweetPizza;


//加盟店
//北京的加盟店，采用北京原料工厂提供的原料，生产多种pizza
public class BeijingStore {

    public static void main(String[] args){
        IngredientFactory beijingyuanliaochang  = new BeijingIgFactory();

        //顾客1， 买hotPizza
        Pizza hp = new HotPizza(beijingyuanliaochang);
        ((HotPizza) hp).prepareIngredient();
        hp.bake();
        hp.cut();
        hp.pack();
        System.out.println(hp);

        //顾客2， 买sweetPizza
        Pizza sp = new SweetPizza(beijingyuanliaochang);
        ((SweetPizza) sp).prepareIngredient();
        sp.bake();
        sp.cut();
        sp.pack();
        System.out.println(sp);
    }
}
