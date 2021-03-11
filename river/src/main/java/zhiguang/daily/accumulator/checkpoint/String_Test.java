package zhiguang.daily.accumulator.checkpoint;

public class String_Test {

    public static void main(String[] args){
        String path = "/user/s_xdata/data_platform/info_excel/ods_dataplatform_dp_data/dt=20201213/";
        String beforeFileName = path.substring(0, path.lastIndexOf("/"));
        System.out.println(beforeFileName);

        //前半部分
        String before = beforeFileName.substring(0, beforeFileName.lastIndexOf("/"));
        System.out.println(before);

        //分区目录
        String partition = beforeFileName.substring(beforeFileName.lastIndexOf("/") + 1);
        System.out.println(partition);
    }

}
