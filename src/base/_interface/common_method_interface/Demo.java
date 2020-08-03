package base._interface.common_method_interface;

public class Demo extends DemoFather {
    public static void main(String[] args) {
        test("hello", System.out::println);
        test("hello", str -> System.out.println(str.toUpperCase()));
        test("hello", MethodRerClass::staticPrintUpperCase);  //通过类的静态方法引用

        MethodRerClass obj = new MethodRerClass();
        test("hello", obj::printUpperCase);  //通过对象的成员方法引用

        Demo demo = new Demo();
        demo.fatherTest();  //通过this和super引用

        Person person1 = buildPerson("java", Person::new);  //类的构造器的引用
        Person person2 = buildPerson("C++", Person::new);
        System.out.println(person1 + " " + person2);
    }


    public static void test(String str, MyInterface myInterface) {
        myInterface.print(str.toUpperCase());
    }

    public void fatherTest() {
        test("hello", this::printUpperCase); // 通过this引用本类 son say
        test("hello", super::printUpperCase); // 通过super引用父类father say
    }

    public static Person buildPerson(String name, PersonBuilderInterface builderInterface) {
        return builderInterface.buildPersonByName(name);
    }

    @Override
    public void printUpperCase(String str) {
        System.out.println("son say:" + str.toUpperCase());
    }
}

class MethodRerClass {
    public static void staticPrintUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }

    public void printUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }
}

class DemoFather {
    public void printUpperCase(String str) {
        System.out.println("father say:" + str.toUpperCase());
    }
}

class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

@FunctionalInterface
interface PersonBuilderInterface {
    public abstract Person buildPersonByName(String name);
}

@FunctionalInterface
interface MyInterface {
    public abstract void print(String s);
}