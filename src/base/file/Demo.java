package base.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 默认当前根目录为工程目录，即D:\\Code\\IDEA\\
//        readFile("src\\base\\file\\test.txt");
//        dirTest("src\\base\\");
        System.out.println("=================D:\\Code: dirs=================");
        getAllDirs("D:\\Code");
//        System.out.println("=================D:\\Code: files=================");
//        printFiles("D:\\Code");
    }


    // 遍历目录
    public static void getAllDirs(String dirPath) {
        System.out.println(dirPath);
        File file = new File(dirPath);
        if (file.isDirectory()) {
            for (File subFile : Objects.requireNonNull(file.listFiles())) {
                if (subFile.isDirectory()) {
                    getAllDirs(subFile.getAbsolutePath());
                }
            }
        }
    }

    // 遍历文件
    public static void getAllFiles(String dirPath) {
        File file = new File(dirPath);
        if (file.isDirectory()) {
            for (File subFile : Objects.requireNonNull(file.listFiles())) {
                if (subFile.isDirectory()) {
                    getAllFiles(subFile.getAbsolutePath());
                } else {
                    if (subFile.toString().contains(".java"))  // 可以设置些过滤规则
                        System.out.println(subFile.getName());
                }
            }
        }
    }

    public static void dirTest(String dirPath) {
        File file = new File(dirPath);
        System.out.println(Arrays.toString(file.listFiles())); // 子目录相对路径
        System.out.println(Arrays.toString(file.list()));  // 子目录名
    }

    public static void readFile(String filePath) throws IOException {
        File file = new File(filePath); // 默认当前目录为工程目录，即D:\\Code\\IDEA\\
        System.out.println("绝对路径:" + file.getAbsoluteFile());
        System.out.println("文件大小:" + file.length());
        var lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        for (var line : lines) {
            System.out.println(line);
        }
//        file.exists();
//        file.delete();
    }
}
