package zhiguang.daily.accumulator.design_patterns.iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiguang on 2018/7/1.
 */
public class ContainerA implements Iteratable<TheElement> {

    private List<TheElement> list = new ArrayList<>();
    private int position;

    public ContainerA() {
        this.list.add(new TheElement("egg"));
        this.list.add(new TheElement("meat"));
        this.list.add(new TheElement("cabage"));
        this.list.add(new TheElement("fish"));
        this.list.add(new TheElement("beer"));
        this.list.add(new TheElement("yogut"));
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.position > this.list.size()-1){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public TheElement next() {
        TheElement e = this.list.get(this.position);
        this.position++;
        return e;
    }
}
