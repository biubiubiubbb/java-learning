package base.collections;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return this.age;
    }

    String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
//        return o.getAge() - this.getAge(); // 年龄从大到小排序
        return this.getAge() - o.getAge(); // 年龄从小到大排序
    }

    @Override
    public String toString() {
        return "姓名：" + this.getName() + "\t" + "年龄：" + this.getAge();
    }
}
