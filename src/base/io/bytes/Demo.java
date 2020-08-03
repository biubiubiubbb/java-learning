package base.io.bytes;

import java.io.*;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
//        reader("src\\base\\io\\text.txt");
        writer("src\\base\\io\\text.txt");
    }

    public static void reader(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        System.out.println("encoding: " + reader.getEncoding());
        int ret = 0;
        while ((ret = reader.read()) != -1) {
            System.out.println((char) ret);  // 中文，一共两个字符
        }
        reader.close();
    }

    public static void writer(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write("数字");
        writer.close();
    }
}
