package zhiguang.daily.accumulator.design_patterns.factory.factorymethod;

public abstract class Product {
    String name;

    public void printname(){
        System.out.println(this.name);
    }

    public void normalprocess(){
        System.out.println(this.name+" is under normal processing .. ");
    }

}

class SpringProduct extends Product {
    public SpringProduct(String name) {
        this.name=name;
    }
}


class HadoopProduct extends Product {
    public HadoopProduct(String name) {
        this.name=name;
    }
}
