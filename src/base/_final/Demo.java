package base._final;

/*
final 关键字代表最后，不可改变的
1. 修饰类
public final class MyClass{
  ...
}
含义：final修饰的类不能有子类

2. 修饰方法
public final void method(){
  ...
}
含义：final修饰的方法不能覆盖重写

3. 修饰成员变量
成员变量都有默认值：0/null
含义：final修饰的成员变量，要么直接赋值，要么构造函数赋值，不能有默认值

4. 修饰局部变量
final int num = 0;
含义：num不可变


不可变：
1.对于基本类型，是指变量数据内容不可变
2.对于引用类型，是指变量的地址值不可变
 */
public class Demo {
    public static void main(String[] args) {
        final int num = 0;
        // num = 20;  error
    }

    final void finalFunc() {
        System.out.println("This function can't be override");
    }
}
