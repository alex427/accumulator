package zhiguang.daily.accumulator.checkpoint;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 关于字节数组的各种测试
 * */
public class ByteArrayTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b = new byte[12];
        System.out.println(Arrays.toString(b));
        System.out.println(b);

        //字节数组和字符串之间的转换
        String str = "orange";
        byte[] arr = str.getBytes();
        String str2 = new String(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr);
        System.out.println(str2);

        byte[] b1 = {(byte) 0xB8, (byte) 0xDF, (byte) 0xCB, (byte) 0xD9};
        String str3 = new String(b1, "UTF-8");
        System.out.println(str3);
        String str4 = new String(b1, "GBK");
        System.out.println(str4);


        String str5 = "飘雪";
        byte[] arr5 = str5.getBytes();
        String str6 = new String(arr5);
        System.out.println(str6);//因为当前ide设定的是UTF-8编码，在相同的环境下解码-编码自然是OK的
        String str7 = new String(arr5, "UTF-8");
        System.out.println(str7);
        System.out.println("-------------------------------------------");


        //long 和 字节数组之间的转换
        long a1 = 1229L;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(a1);
        byte[] longArr1 = buffer.array();
        System.out.println(longArr1);

        ByteBuffer buffer2 = ByteBuffer.allocate(8);
        buffer2.put(longArr1, 0, longArr1.length);
        buffer2.flip();
        long a2 = buffer2.getLong();
        System.out.println(a2);


        System.out.println("-------------------------------------------");
        long a3 = 1229L;
        ByteBuffer buffer3 = ByteBuffer.allocate(8);
        buffer3.putLong(a3);
        byte[] longArr3 = buffer3.array();
        long  value3 = 0;
        for (int i = 0; i < 8; i++) {
            value3 <<= 8; value3|= (longArr3[i] & 0xff);
        }
        System.out.println(value3);

        System.out.println("-------------------------------------------");
        long a5 = 1229L;
        byte[] longArr5 = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            longArr5[i] = (byte) ((a5 >> offset) & 0xff);
        }
        long  value5 = 0;
        for (int i = 0; i < 8; i++) {
            value5 <<= 8; value5|= (longArr5[i] & 0xff);
        }
        System.out.println(value5);

    }
}
