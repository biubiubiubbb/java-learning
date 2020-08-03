package base.io.buffered;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.nio.ByteBuffer;


/*
缓冲流：
字节输入/输出缓冲流
字符输入/输出缓冲流
提高文件读写效率，原理是以一个数组大小作为流的大小，而不是一个字节或者一个字符的读写
减少读写的次数
 */

public class Demo {
    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\base\\io\\text.txt"));
        bos.write("字节输入缓冲区".getBytes());
        bos.close();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\base\\io\\text.txt"));
        byte[] readBuf = new byte[1024];
//        bis.read(readBuf);
        int len = 0;
        while ((len = bis.read()) != -1) {
            System.out.println(len);
        }
        bis.close();
    }
}
