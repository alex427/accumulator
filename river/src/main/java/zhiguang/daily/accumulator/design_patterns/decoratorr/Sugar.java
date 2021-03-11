package zhiguang.daily.accumulator.design_patterns.decoratorr;

/**
 * zhiguang
 */
public class Sugar extends Beverage{
    private Beverage beverage;

    public Sugar(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public int getprice() {
        return this.beverage.getprice()+2;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }
}
