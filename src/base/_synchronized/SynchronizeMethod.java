package base._synchronized;

public class SynchronizeMethod implements Runnable {
    private int num = (int) (Math.pow(2, 10) - 1);  //2的10方-1
    private static int staticNum = (int) (Math.pow(2, 10) - 1);  //2的10方-1
    boolean useStaticMethod;

    public SynchronizeMethod(boolean useStaticMethodToTest) {
        this.useStaticMethod = useStaticMethodToTest;
    }

    // 对于非静态方法，同步锁对象即this
    public synchronized void method() {
        System.out.println("Thread ID:" + Thread.currentThread().getId() + "---num:" + num);
        num--;
    }

    // 对于静态方法，同步锁对象是当前方法所在类的字节码对象
    public synchronized static void staticMethod() {
        System.out.println("Static Method Thread ID:" + Thread.currentThread().getId() + "---num:" + staticNum);
        staticNum--;
    }

    @Override
    public void run() {
        if (useStaticMethod) {  // 测试静态同步方法
            while (staticNum > 1) {
                staticMethod();
            }
        } else {  // 测试非静态同步方法
            while (num > 1) {
                method();
            }
        }
        System.out.println("Thread ID:" + Thread.currentThread().getId() + " exit");
    }
}
