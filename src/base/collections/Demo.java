package base.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/*
Collections:
    boolean addAll(Collection<? super T> c, T... elements) // 插入多个元素
    sort() // 默认升序排序
    shuffle()  // 乱序
    max()
    min()
 */

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 3, 2, 6, 5, 4);
        System.out.println(arrayList); // [1, 3, 2, 6, 5, 4]
        Collections.sort(arrayList);
        System.out.println(arrayList); // [1, 2, 3, 4, 5, 6]
        Collections.shuffle(arrayList);
        System.out.println(arrayList); // [5, 2, 6, 1, 3, 4] 随机排序

        System.out.println("max:" + Collections.max(arrayList));

        ArrayList<Student> stuList = new ArrayList<>();
        Student stu1 = new Student("J", 13);
        Student stu2 = new Student("K", 12);
        Student stu3 = new Student("H", 15);
        Collections.addAll(stuList, stu1, stu2, stu3);
        System.out.println(stuList); // [姓名：J	年龄：13, 姓名：K	年龄：12, 姓名：H	年龄：15]
        Collections.sort(stuList);   // Student类重写了CompareTo方法
        System.out.println(stuList); // 姓名：H	年龄：15, 姓名：J	年龄：13, 姓名：K	年龄：12]
        System.out.println("oldest:" + Collections.max(stuList));
    }
}
