package zhiguang.daily.accumulator.design_patterns.factory.factorymethod;

public abstract class Factory {

    protected abstract Product getProduct();

    public void standarize(){

        Product p;
        p=getProduct();

        //有两种方式去对实例执行相同的逻辑
        p.normalprocess();
        interalprocess(p);
    }

    public void interalprocess(Product p){
        System.out.println(p.name+" is under internal normal processing .. ");
    }
}

class SpringFactory extends Factory {

    @Override
    protected Product getProduct() {
        System.out.println("植入IOC");
        return new SpringProduct("Spring");
    }
}

class HadoopFactory extends Factory {

    @Override
    protected Product getProduct() {
        System.out.println("配置集群信息");
        return new HadoopProduct("Hadoop");
    }
}

