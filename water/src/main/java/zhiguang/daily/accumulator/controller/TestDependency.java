package zhiguang.daily.accumulator.controller;


import zhiguang.daily.accumulator.service.Running;
import zhiguang.daily.accumulator.service.RunningTiger;

public class TestDependency {

    public static void main(String[] args){
        Running tiger = new RunningTiger();
        tiger.running();
    }
}
