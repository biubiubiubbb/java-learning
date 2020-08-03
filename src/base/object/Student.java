package base.object;

// 默认继承Object,所有类都默认继承它
public class Student /* extends Object*/ {
    private String name;
    private int age;
    private int salary = 0;

    @Override
    public String toString() {
        String stuInfo = "姓名：" + this.name + "\n" + "年龄：" + this.age;
        return stuInfo;
    }

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

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getSalary() {
        return this.salary;
    }

}
