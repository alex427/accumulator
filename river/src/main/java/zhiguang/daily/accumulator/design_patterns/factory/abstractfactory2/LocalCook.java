package zhiguang.daily.accumulator.design_patterns.factory.abstractfactory2;

public class LocalCook {

    public static InstanceFather createInstance(String order){

        FieldFactoryInterface ff = new SpringFiledFactory();
        FieldFactoryInterface fh = new HadoopFiledFactory();


        InstanceFather f = null;
        if(null !=order && "spring".equalsIgnoreCase(order)){
            f = new WebInstance(ff);
        } else if(null !=order && "hadoop".equalsIgnoreCase(order)){
            f = new WebInstance(fh);
        }

        f.instantiate();

        f.taomi();
        f.kaihuo();
        f.fangyan();
        return f;
    }

    public static void main(String[] args){
        System.out.println(createInstance("spring"));
        System.out.println("---------------");
        System.out.println(createInstance("hadoop"));
    }

}
