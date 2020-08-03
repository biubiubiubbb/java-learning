package base.io.serialization;

/*
序列化：将对象以字节流的方式写入至文件中
反序列化：以字节流的方式将文件中的对象加载到内存中

只有是实现java.io.Serializable接口以启用其序列化功能，才可以将此类的对象做序列化和反序列化处理
 */

import java.io.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "src\\base\\io\\serialization\\test.txt";
//        writeObject(fileName);
//        readObject(fileName);
        listObjectSerialize(fileName);
    }

    public static void writeObject(String fileName) throws IOException {
        ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(fileName));
        Student stu = new Student("小红", 19);
        oop.writeObject(stu);
        oop.close();
    }

    public static void readObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Object obj = ois.readObject();
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            System.out.println(stu);
        }
    }


    public static void listObjectSerialize(String fileName) throws IOException, ClassNotFoundException {
        // write
        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(new Student("小红", 12));
        stuList.add(new Student("小蓝", 12));
        ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(fileName));
        oop.writeObject(stuList);
        oop.close();

        // read
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Object obj = ois.readObject();
        if (obj instanceof ArrayList) {
            ArrayList<Student> _stuList = (ArrayList) obj;
            for (var stu : _stuList) {
                System.out.println(stu);
            }
        }
    }
}
