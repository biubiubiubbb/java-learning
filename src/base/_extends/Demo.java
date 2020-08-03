package base._extends;


/*
this使用本类
super使用父类
多态中，通过对象访问成员变量，等号左边是谁，优先找谁，没有则上查找（父类的父类）
通过对象访问成员函数，方法属于谁(new Son())，优先找谁，没有则向上找
fatherToSon.SonGetNum(); 错误写法 对象一旦向上转型为父类，则不能使用子类
特有的方法，这也是多态的一个缺点，可通过向下类型转换，将父类对象还原为子类对象，
即可使用子类特有方法
*/

public class Demo {
    public static void main(String[] args) {
        // 2 is son's num , 0 is father's num
        Son son = new Son();
        System.out.println(son.num);  // 2
        System.out.println(son.getNum()); // 2
        System.out.println(son.sonGetNum()); // 2
        System.out.println(son.sonGetNumBySuper()); // 0
        System.out.println(son.fatherGetNum()); // 0

        Father fatherToSon = new Son();  // 多态写法
        System.out.println(fatherToSon.num);  // 0 使用父类的属性
        System.out.println(fatherToSon.getNum()); // 2 使用子类的方法
        System.out.println(fatherToSon.fatherGetNum()); // 0 // 子类未重写fatherGetNum()该方法
    }

    //向下转型
    public static void GetChild(Father obj) {
        if (obj instanceof Son) {  // 判断是否可以安全转换
            Son child = (Son) obj;
        }
        if (obj instanceof Daughter) {  // 判断是否可以安全转换
            Daughter child = (Daughter) obj;
        }
    }

}
