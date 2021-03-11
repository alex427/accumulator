package zhiguang.daily.accumulator.design_patterns.factory.abstractfactory2;

public interface FieldFactoryInterface {
    String produceRice();
    String produceOil();
    String produceSalt();
}

class SpringFiledFactory implements FieldFactoryInterface{

    @Override
    public String produceRice() {
        //各种复杂的处理
        return "Spring rice";
    }

    @Override
    public String produceOil() {
        //各种复杂的处理
        return "Spring oil";
    }

    @Override
    public String produceSalt() {
        //各种复杂的处理
        return "Spring salt";
    }
}

class HadoopFiledFactory implements FieldFactoryInterface{

    @Override
    public String produceRice() {
        //各种复杂的处理
        return "Hadoop rice";
    }

    @Override
    public String produceOil() {
        //各种复杂的处理
        return "Hadoop oil";
    }

    @Override
    public String produceSalt() {
        //各种复杂的处理
        return "Hadoop salt";
    }
}