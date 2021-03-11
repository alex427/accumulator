package zhiguang.daily.accumulator.checkpoint;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


/**
 * 关于BitSet的测试
 * 这是一个陌生的技术点，常规项目几乎用不到
 *
 * */
public class BitSetTest {

    /**
     * The internal field corresponding to the serialField "bits".
     */
    private long[] words;

    /**
     * The number of words in the logical size of this BitSet.
     */
    private transient int wordsInUse = 0;


    public static void main(String[] args){
        BitSet bitSet=new BitSet();
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        bitSet.set(4);
        bitSet.set(5);
        bitSet.set(10);
        bitSet.set(11);
        bitSet.set(12);
        bitSet.set(100);
        bitSet.set(101);

        //System.out.println(bitSet.length());
        System.out.println(bitSet.toString());
        /*for(int i=0;i<bitSet.length();i=i+1) {
            System.out.println(bitSet.get(i));
        }

        System.out.println("----------");

        long[] arr = bitSet.toLongArray();
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i=i+1) {
            System.out.println(arr[i]);
        }*/

        System.out.println("----------");
        BitSetTest bitSetTest = new BitSetTest();
        List<Integer> list = bitSetTest.getValues(bitSet);
        System.out.println(list.size());
        System.out.println("----------");
        for(Integer i : list){
            System.out.println(i);
        }

    }


    private List<Integer> getValues(BitSet bitSet){
        //很low，但管用
        String str = bitSet.toString();
        String brace1 = "{";
        String brace2 = "}";
        String sep = ", ";
        String[] arr = str.replace(brace1,"").replace(brace2,"").split(sep);
        List<Integer> list = new ArrayList<>(4);
        for(int i=0;i<arr.length;i=i+1) {
            list.add(Integer.parseInt(arr[i]));
        }
        return list;
    }

    //下面这个方法有问题
    private List<Integer> getValues2(BitSet bitSet){
        checkInvariants();
        int i = bitSet.nextSetBit(0);
        List<Integer> list = new ArrayList<>(4);
        if (i != -1) {
            while (true) {
                if (++i < 0) break;
                if ((i = bitSet.nextSetBit(i)) < 0) break;
                int endOfRun = bitSet.nextClearBit(i);
                do { list.add(i); }
                while (++i != endOfRun);
            }
        }
        return list;
    }



    private void checkInvariants() {
        assert(wordsInUse == 0 || words[wordsInUse - 1] != 0);
        assert(wordsInUse >= 0 && wordsInUse <= words.length);
        assert(wordsInUse == words.length || words[wordsInUse] == 0);
    }

}
