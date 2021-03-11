package zhiguang.daily.accumulator.design_patterns.proxytest.virtualproxy;

/**
 * author  : zhiguang
 * date    : 2018/7/24
 */
public class VirtualProvider implements DataProvider {

    RealProvider realProvider;

    @Override
    public String providedata() {
        //当real类还没有被创建的时候，提供一些假数据，进度数据等等。。
        if(null != realProvider){
            return realProvider.providedata();
        } else {
            return generateVirtualData();
        }
    }

    public String generateVirtualData(){
        return "It is running on, please wait.";
    }
}
