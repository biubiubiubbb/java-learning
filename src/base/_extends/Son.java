package base._extends;

public class Son extends Father {
    int num = 2;

    public Son() {
        super();  // 默认隐含，会先调用父类无参构造方法
        System.out.println("Son 无参构造函数执行");
//        super();  // 默认隐含，会先调用父类无参构造方法，必须放在第一行执行
    }

//    public Son(int i) {
//        super(0);
//    }

    @Override
    public int getNum() {
        System.out.println("this a son's method and return this.num");
        return this.num;
    }

    public int sonGetNum() {
        return this.num;
    }

    public int sonGetNumBySuper() {
        return super.num;  // Father num
    }
}
