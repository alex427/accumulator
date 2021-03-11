package zhiguang.daily.accumulator.design_patterns.iterators;

/**
 * Created by zhiguang on 2018/7/1.
 */
public interface Iteratable<T> {

    boolean hasNext();

    T next();

}
