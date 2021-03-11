package zhiguang.daily.accumulator.design_patterns.iterators;

/**
 * Created by zhiguang on 2018/7/1.
 */
public class TheElement {

    private String name;

    public TheElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TheElement{" +
                "name='" + name + '\'' +
                '}';
    }
}
