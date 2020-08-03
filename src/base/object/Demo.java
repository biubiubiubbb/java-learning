package base.object;

import com.mysql.cj.x.protobuf.MysqlxExpr;

public class Demo {
    public static void main(String[] args) {
        Student stu = new Student("java", 22);
        stu.setSalary(10);
        System.out.println(stu);  // 也会调用已重写Object类的toString()方法


        // Object equals 比较两个对象是否相同
        // 如果没有重写equals方法，则比较两者地址值
        Student stu2 = new Student("java", 22);
        stu2.setSalary(10);
        boolean bret = stu2.equals(stu);  // false
        System.out.println(bret);

        Student stu3 = stu;
        bret = stu3.equals(stu);  // true
        System.out.println(bret);

        if (stu3 instanceof Student) {
            System.out.println(true);
        }
    }
}
