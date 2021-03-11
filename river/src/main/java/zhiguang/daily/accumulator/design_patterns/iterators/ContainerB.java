package zhiguang.daily.accumulator.design_patterns.iterators;

/**
 * Created by zhiguang on 2018/7/1.
 */
public class ContainerB implements Iteratable<TheElement>{

    private TheElement[] arr = new TheElement[10];
    private int position;

    public ContainerB() {
        this.arr[0]=new TheElement("鸡蛋");
        this.arr[1]=new TheElement("猪肉");
        this.arr[2]=new TheElement("白菜");
        this.arr[3]=new TheElement("土豆");
        this.arr[4]=new TheElement("萝卜");
        this.position = 0;
    }


    @Override
    public boolean hasNext() {
        if(this.position > arr.length-1){
            return false;
        }
        return true;
    }

    @Override
    public TheElement next() {
        TheElement e = this.arr[this.position];
        this.position++;
        return e;
    }


}
