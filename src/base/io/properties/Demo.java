package base.io.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/*
将集合与IO联系在一起的属性类
继承于Hashtable
store  写入磁盘
load   从磁盘读取
 */

public class Demo {
    public static void main(String[] args) throws IOException {
//        propertiesWrite();
        propertiesRead();
    }

    public static void propertiesWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\base\\properties\\test.txt", true);
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.store(fos, "this is a comments");
        fos.close();
    }

    public static void propertiesRead() throws IOException {
        FileInputStream fis = new FileInputStream("src\\base\\properties\\test.txt");
        Properties properties = new Properties();
        properties.load(fis);
        System.out.println(properties.getProperty("key1"));

        for (var kv : properties.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
        fis.close();
    }

}

