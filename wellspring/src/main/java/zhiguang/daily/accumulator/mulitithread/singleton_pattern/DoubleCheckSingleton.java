package zhiguang.daily.accumulator.mulitithread.singleton_pattern;

/**
 * Created by zhiguang on 2017/10/16.
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton dSingleton;

    public static DoubleCheckSingleton getdSingleton()  {
        if(dSingleton == null){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DoubleCheckSingleton.class){
                if(dSingleton == null){
                    dSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return dSingleton;
    }
}

