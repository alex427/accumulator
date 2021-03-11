package zhiguang.daily.accumulator.design_patterns.iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiguang on 2018/7/1.
 */
public class User {

    private List<Iteratable> list = new ArrayList<>();


    public void addList(Iteratable it){
        this.list.add(it);
    }


    public void getAllElements(){
        for (Iteratable it : list) {
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

    public static void main(String[] args){

        User user = new User();
        Iteratable it = new ContainerA();
        Iteratable it2 = new ContainerB();
        user.addList(it);
        user.addList(it2);

        user.getAllElements();
    }



}
