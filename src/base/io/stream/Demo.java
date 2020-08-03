package base.io.stream;

import java.io.*;

import java.util.Arrays;

/*
Windows: \r\n
linux: /n
Mac: /r

类似还有：
        BufferedOutputStream / BufferedInputStream
        PipedInputStream / PipedOutputStream
        FilterInputStream / FilterOutputStream
 */


public class Demo {
    public static void main(String[] args) {
        outputStreamTest();
//        inputStreamTest();
    }

    public static void inputStreamTest() {
        try {
            FileInputStream fis = new FileInputStream("src\\base\\io\\text.txt");
//            byte[] readBytes = fis.readAllBytes();
//            System.out.println(Arrays.toString(readBytes));
            int ret = 0;
            while ((ret = (fis.read())) != -1) {
                System.out.println(ret);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void outputStreamTest() {
        try {
            FileOutputStream fos = new FileOutputStream("src\\base\\io\\text.txt", true);

            byte[] b = {'1', '2', '3'};
            String str = "中文";
            fos.write(str.getBytes());  // Demo.java文件格式为utf-8,所以默认以utf-8编码写入文件中
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
