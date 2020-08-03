package base.generic;

import java.util.ArrayList;

/*
<? extends T>,表示使用了受限泛型上限，只接受T及其T的子类。
<? super T>表示使用了受限泛型下限，只接受T及其T的父类。
 */

public class Demo {
    public static void main(String[] args) {
        Do<Integer> doInt = new Do<>();
        doInt.test(2);  // doSome.test("2") error
        doInt.genericInterfaceMethod(3);
        doInt.genericClassMethod(4);

        Do<String> doStr = new Do<>();
        doStr.test("2");  // doSome.test(2) error
        doStr.genericInterfaceMethod("3");
        doStr.genericClassMethod("4");
    }
}
