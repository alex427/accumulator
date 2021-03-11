package zhiguang.daily.accumulator.design_patterns.proxytest.staticproxy;

import org.apache.commons.lang3.RandomUtils;

/**
 * author  : zhiguang
 * date    : 2018/7/24
 */
public class ProviderProxy implements DataProvider {

    DataProvider dataProvider;

    public ProviderProxy(DataProvider dataProvider){
        this.dataProvider=dataProvider;
    }

    @Override
    public String providedata() {
        //为real提供访问控制，帮他做一些事情
        System.out.println("本代理先帮你检查调用者是否合法");
        checkAccess("shabi");
        System.out.println("本代理先帮你初始化几个类");
       String real = dataProvider.providedata();;
        System.out.println("本代理给你的数据数据做些加密，别怕。。");
        real = real+ RandomUtils.nextInt(10,100);
        return real;

    }

    public void checkAccess(String user){
        if("shabi".equals(user)){
            System.out.println("Valid access, accept.");
        } else {
            System.out.println("Too clever, rejected.");
        }
    }
}
