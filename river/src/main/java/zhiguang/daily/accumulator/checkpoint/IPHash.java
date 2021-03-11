package zhiguang.daily.accumulator.checkpoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/// <summary>
/// IP Hash负载均衡算法
/// </summary>
public class IPHash {

    static Map<Integer,String> dic = new HashMap<>();

    public static void main(String[] args){
        dic.put(0,"192.168.1.12");
        dic.put(1,"192.168.1.13");
        dic.put(2,"192.168.1.14");
        dic.put(3,"192.168.1.15");
        dic.put(4,"192.168.1.16");
        dic.put(5,"192.168.1.17");
        dic.put(6,"192.168.1.18");
        dic.put(7,"192.168.1.19");
        System.out.println(ipHash("aaaaabbbcccdddd"));
    }


    public static String ipHash(String cookie) {
        Set<Integer> keys = dic.keySet();
        int hashCode = Math.abs(cookie.hashCode());
        int serverListSize = keys.size();
        int serverPos = hashCode % serverListSize;
        return dic.get(serverPos);
    }


}
