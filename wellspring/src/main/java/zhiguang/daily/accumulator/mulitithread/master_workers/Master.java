package zhiguang.daily.accumulator.mulitithread.master_workers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by zhiguang on 2017/10/19.
 */
public class Master {
    //需要一个盛放任务的容器   A
    //任务由客户端提交, 添加进来
    private ConcurrentLinkedQueue<Task> taskqueue = new ConcurrentLinkedQueue();
    //需要一个盛放worker的容器 B
    private HashMap<String, Thread> workermap = new HashMap<String, Thread>();
    //需要一个盛放结果集的容器 C
    private HashMap<String, Integer> resultset = new HashMap<String, Integer>();

    public Master() {
        //初始化时, 搞10个worker进去, 听候指令
        int p = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < p; i++) {
            Worker worker = new Worker(taskqueue, resultset);
            this.workermap.put("worker" + Integer.toString(i), new Thread(worker));
        }
    }

    //任务提交
    public void submit(Task task) {
        this.taskqueue.add(task);
    }

    //任务执行
    public void execute() {
        for (Map.Entry<String, Thread> en : workermap.entrySet()) {
            en.getValue().start();
        }
    }

    //任务执行完成, 退出, true表示完成
    public boolean isComplete() {
        for (Map.Entry<String, Thread> en : workermap.entrySet()) {
            if (en.getValue().getState() != Thread.State.TERMINATED) {
                //完成
                return false;
            }
        }
        return true;
    }

    //返回结果集
    public HashMap<String, Integer> getResult() {
        return this.resultset;
    }
}
