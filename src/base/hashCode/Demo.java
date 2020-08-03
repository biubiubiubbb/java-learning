package base.hashCode;

public class Demo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        /*
        Object的toString源码
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
         */
        System.out.println(obj1.toString());

        // hashCode 不相同
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        String strObj1 = "String";
        String strObj2 = "String";
        // hashCode 相同 strObj1和strObj2都指向"String"所在的字符串常量区的某个地址
        System.out.println(strObj1.hashCode());
        System.out.println(strObj2.hashCode());
        System.out.println(strObj1 == strObj2);

        String strObj3 = "String1";
        String strObj4 = "String2";
        // hashCode 不相同
        System.out.println(strObj3.hashCode());
        System.out.println(strObj4.hashCode());

        // 特殊,如：
        String specialStr1 = "重地";
        String specialStr2 = "通话";
        System.out.println("重地hashCode:" + specialStr1.hashCode());  // 1179395
        System.out.println("通话hashCode:" + specialStr2.hashCode());  // 1179395
        System.out.println(specialStr1 == specialStr2); // false
        // 发现是一样的，且固定为1179395，说明不同对象的hashCode也有可能相等，这种情况称为哈希冲突

        Integer intNum1 = 8;
        Integer intNum2 = 8;
        System.out.println(intNum1.hashCode()); // 8
        System.out.println(intNum2.hashCode()); // 8

        Integer intNum3 = 7;
        Integer intNum4 = 8;
        System.out.println(intNum3.hashCode()); // 7
        System.out.println(intNum4.hashCode()); // 8
    }
}
