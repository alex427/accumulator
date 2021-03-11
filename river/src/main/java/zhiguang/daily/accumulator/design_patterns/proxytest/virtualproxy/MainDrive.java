package zhiguang.daily.accumulator.design_patterns.proxytest.virtualproxy;

/**
 * author  : zhiguang
 * date    : 2018/7/24
 */
public class MainDrive {
    public static void main(String[] args){
        //虚拟代理的应用场景有哪些？
        //似乎没什么价值。

        //用户第一次调用服务时，真实数据类尚未创建，无法提供服务，由虚拟代理提供一些假数据
        //第二次调用时，真实数据已经创建，就可以由real类提供真实服务。
        //就是这样一个过程， 可是这有什么价值呢？ 毕竟真实数据的获得，要至少在第二次调用之后，而且用户不见得知道。

        //这种模式似乎应该满足以下需求：
        //用户调用服务，real去生产数据，可能是去执行hive或spark，或者socket访问某个数据源，总之要花很长时间
        //在这种情况下，系统先调用虚拟代理，向用户返回一个假数据，或者进度条之类的
        //用户继续做他的事情， 接着real类的任务执行完了，数据拿到了，这时它得把这个数据给用户发过去，进度条显示完成。
        //用户看到进度条显示完成，查看真实数据。

        //这个设计的关键
        //1. real类作为一个单独的线程，异步执行
        //2. 需要一个Subject, 进度程序是Observer,  Subject状态变化时会主动通知observer
        //过程如下：
        //1. real类执行完成，向Subject写入状态数据，向结果表写入结果集数据
        //2. Subject状态变化，通知进度程序update数据
        //3. 进度程序update方法被回调，更新进度数据

        //问题; 进度数据更新后，如何向前端反馈

    }
}
