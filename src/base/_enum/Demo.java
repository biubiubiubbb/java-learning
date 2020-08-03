package base._enum;

/*
那么什么时候应该使用枚举呢？每当需要一组固定的常量的时候，如一周的天数、一年四季等。
或者是在我们编译前就知道其包含的所有值的集合
 */

public class Demo {
    public static void main(String[] args) {
        MyEnum status = MyEnum.INIT;
        //int init = (int) MyEnum.INIT; 枚举不能转int
        int code = status.getCode();
        System.out.println("code:" + code + "\n" + "status:" + status); // INIT
    }
}
