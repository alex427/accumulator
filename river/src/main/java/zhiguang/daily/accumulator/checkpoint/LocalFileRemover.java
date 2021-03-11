package zhiguang.daily.accumulator.checkpoint;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalFileRemover {

    private static List<File> targetList = new ArrayList();

    public static void main(String[] args){
        remove(new File("C:\\home\\mi\\repository"),"_remote.repositories");
    }

    public static void remove(File file,String mark) {
        List<File> targetList = find(file,mark);
        System.out.println(targetList);
        for (File f : targetList){
            //f.delete();
        }
    }

    public static List<File> find(File f,String mark) {
        File[] list = f.listFiles();

        for (File file : list) {
            if (file.isDirectory()) {
                if (file.getParent().endsWith("\\")) {
                    //System.out.println("目录　" + file.getParent() + file.getName());
                }else {
                    //System.out.println("目录　" + file.getParent() + "\\" + file.getName());
                }
                find(file,mark);
            } else {
                if (file.getParent().endsWith("\\")) {
                    if(file.getName().equals(mark)){
                        System.out.println("文件　" + file.getParent() + "\\" +file.getName());
                        targetList.add(file);
                    }
                } else {
                    if(file.getName().equals(mark)){
                        System.out.println("文件　" + file.getParent() + "\\" +file.getName());
                        targetList.add(file);
                    }
                }
            }
        }
        System.out.println(targetList.size());
        return targetList;
    }


}
