package base._synchronized;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.synchronizeBlockTest();
        demo.synchronizeLockTest();
        demo.synchronizeMethodTest();
        demo.synchronizeStaticMethodTest();
    }

    /**
     * 同步代码块
     */
    public void synchronizeBlockTest() {
        Runnable run = new SynchronizeBlock();
        for (int i = 0; i < 3; i++) {
            new Thread(run).start();
        }
    }

    /**
     * 同步非静态方法
     */
    public void synchronizeMethodTest() {
        Runnable run = new SynchronizeMethod(false);
        for (int i = 0; i < 3; i++) {
            new Thread(run).start();
        }

    }

    /**
     * 同步静态方法
     */
    public void synchronizeStaticMethodTest() {
        Runnable run = new SynchronizeMethod(true);
        for (int i = 0; i < 3; i++) {
            new Thread(run).start();
        }
    }

    /**
     * 可重入锁机制
     */
    public void synchronizeLockTest() {
        Runnable run = new SynchronizeLock(false);  // true：使用公平锁  false:使用非公平锁
        for (int i = 0; i < 3; i++) {
            new Thread(run).start();
        }
    }
}
