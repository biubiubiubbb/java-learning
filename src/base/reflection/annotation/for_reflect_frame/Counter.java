package base.reflection.annotation.for_reflect_frame;

public class Counter {

    @Check
    public int add(int a, int b) {
        return a + b;
    }

    @Check
    public int sub(int a, int b) {
        return a - b;
    }

    @Check
    public int mul(int a, int b) {
        return a * b;
    }

    @Check
    public int div(int a, int b) {
        return a / b;
    }

    public void noCheck() {
    }
}
