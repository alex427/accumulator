package zhiguang.daily.accumulator.design_patterns.factory.simplefactory;

public class SimpleFactory {
    //简单工厂， 就是把实例化的过程抽取到一个工厂类中
    public Product getProduct(String type){
        if(null != type && "a".equalsIgnoreCase(type)){
            return new ProductA("A");
        } else if (null != type && "b".equalsIgnoreCase(type)){
            return new ProductB("B");
        } else{
            return null;
        }
    }
}

abstract class Product {
    String name;
    public void printname(){
        System.out.println(this.name);
    }
}

class ProductA extends Product {
    public ProductA(String name) {
        this.name=name;
    }
}


class ProductB extends Product {
    public ProductB(String name) {
        this.name=name;
    }
}

class mainDrive {
    public static void main(String[] args){
        SimpleFactory sf = new SimpleFactory();
        Product a = sf.getProduct("a");
        Product b = sf.getProduct("b");
        a.printname();
        b.printname();
    }
}