package base.reflection;

public class Student {
    private final String name;


    public int publicNum = 9;
    protected int protectedNum = 9;
    int defaultNum = 9;
    private int privateNum = 9;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    private void simpleMethod(String param) {
        System.out.println("get param:" + param + ",this is a public simple method of student:" + name);
    }
}
