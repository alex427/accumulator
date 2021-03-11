package zhiguang.daily.accumulator.checkpoint;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ForLoppConfirmation {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(4);
        list.add("alex");
        list.add("amy");
        list.add("ada");
        list.add("archer");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("ivy");

        int count = 0;
        int t =0;
        for(String x : list){
            count = count + 1;
            if(count%3==0){
                System.out.println(x);
                System.out.println(count);
                t = count+t;
                count=0;
            }
        }
        System.out.println("---");
        System.out.println(t);
        System.out.println(list.size()-t);


        List<Map<String, String>> data = new ArrayList<>(8);
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        Map<String, String> map4 = new HashMap<>();
        Map<String, String> map5 = new HashMap<>();
        map1.put("alex","alex");
        map2.put("brent","brent");
        map3.put("camila","camila");
        map4.put("david","david");
        map5.put("eva","eva");
        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);

        data.add(map5);
        data.add(map5);
        data.add(map5);
        data.add(map5);
        data.add(map5);

        data.add(map5);
        data.add(map5);
        data.add(map5);
        data.add(map5);
        data.add(map5);

        data.add(map5);
        data.add(map5);
        data.add(map5);

        int idx = 0;
        int turn = 0;
        boolean completed = false;
        int commitBatch = 5;
        List<Map<String, String>> dataList = new ArrayList<>();

        //控制批量提交的规模（频率）
        log.info("本次准备同步数据{}条",data.size());
        for (Map<String, String> entry : data) {
            dataList.add(entry);
            idx++;
            if (idx % commitBatch == 0) {
                turn = turn+1;
                log.info("第{}个commit, batch size={}, total size={}",turn,dataList.size(),idx);
                dataList.clear();
                completed = true;
            }else {
                completed = false;
            }
        }
        //最后一批数据
        log.info("是否存在最后一批数据？{}", completed?"已完成，不存在":"没完成，存在");
        if (!completed) {
            turn = turn+1;
            log.info("第{}个commit, batch size={}, total size={}",turn,dataList.size(),idx);
        }


    }

}
