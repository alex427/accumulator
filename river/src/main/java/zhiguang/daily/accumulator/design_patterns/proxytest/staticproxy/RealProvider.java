package zhiguang.daily.accumulator.design_patterns.proxytest.staticproxy;

/**
 * author  : zhiguang
 * date    : 2018/7/24
 */
public class RealProvider implements DataProvider {
    @Override
    public String providedata() {
        //查询数据库
        return "10,20,30,40,50";
    }
}
