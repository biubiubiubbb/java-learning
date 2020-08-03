package base._extends;

public class Father {
    int num = 0;
//
//    public Father() {
//        System.out.println("Father 无参构造函数执行");
//    }
//
//    public Father(int i) {
//        System.out.println("Father 构造函数执行");
//    }

    public int getNum() {
        System.out.println("this a father's method and return this.num");
        return this.num;
    }

    public int fatherGetNum() {
        return this.num;
    }
}
