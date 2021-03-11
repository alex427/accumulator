package zhiguang.daily.accumulator.design_patterns.factory.factorymethod;

public class FactoryMehod {
    public static void main(String[] args){
        Factory sf = new SpringFactory();
        Factory hf = new HadoopFactory();

        Product sp = sf.getProduct();
        Product hp = hf.getProduct();

        sp.printname();
        hp.printname();

    }
}
