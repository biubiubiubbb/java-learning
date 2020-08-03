package base.io.printer_stream;

import java.io.IOException;
import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream("src\\base\\io\\printer_stream\\test.txt");
        printStream.println(97); // 在文件中以97原样保存
        printStream.println("hello world " + 97);  // 自动换行

        System.out.println("输出到控制台");
        System.setOut(printStream);
        System.out.println("输出到文件中");

        printStream.close();
    }
}
