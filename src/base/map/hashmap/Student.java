package base.map.hashmap;

import java.util.Objects;

public class Student {
    private final String name;
    private final int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
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


    @Override
    public String toString() {
        return "姓名：" + this.getName() + "\t" + "年龄：" + this.getAge();
    }
}
