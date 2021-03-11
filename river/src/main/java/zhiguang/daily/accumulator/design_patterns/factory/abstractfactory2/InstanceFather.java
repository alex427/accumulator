package zhiguang.daily.accumulator.design_patterns.factory.abstractfactory2;

public abstract class InstanceFather {

    //抽象实例约定实例的规范，包括字段，实例后续通用处理方式，但是创建实例的方法是抽象的，让子类自己选择

    String rice;
    String oil;
    String salt;

    protected abstract void instantiate();


    //下面这些方法定义在父类里面，子类不要重写, 要实现统一化，标准化
     void taomi(){
        System.out.println(rice+" 淘米111");
    }

     void kaihuo(){
        System.out.println(oil+" is going to heat 5minutes");
    }

     void fangyan(){
        System.out.println(salt+" is needed ... ");
    }

    @Override
    public String toString() {
        return "InstanceFather{" +
                "rice='" + rice + '\'' +
                ", oil='" + oil + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}


class WebInstance extends InstanceFather {

    FieldFactoryInterface ff;

    public WebInstance(FieldFactoryInterface ff) {
        this.ff = ff;
    }

    //实例化的过程，定义在具体实现类中， 而且要把属性设置，委托给工厂
    @Override
    protected void instantiate() {
        this.rice = ff.produceRice();
        this.oil = ff.produceOil();
        this.salt = ff.produceSalt();
    }
}

class BigdataInstance extends InstanceFather {

    FieldFactoryInterface ff;

    public BigdataInstance(FieldFactoryInterface ff) {
        this.ff = ff;
    }

    @Override
    protected void instantiate() {
        this.rice = ff.produceRice();
        this.oil = ff.produceOil();
        this.salt = ff.produceSalt();
    }
}