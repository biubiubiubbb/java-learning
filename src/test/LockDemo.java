package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        LockDemo demo = new LockDemo();
        demo.deadLockDemo();
    }

    private final Object locker1 = new Object();
    private final Object locker2 = new Object();

    /**
     * 死锁演示
     * Thread-0已得到locker1但未释放，然后尝试获取locker2
     * Thread-1已得到locker2但未释放，然后尝试获取locker1
     * 查看哪里出现了死锁
     * jps-l    定位进程号
     * jstack 进程号   查看栈信息，即可定位到哪里出现了死锁
     */
    @Test
    public void deadLockDemo() throws InterruptedException {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试得到locker1...");
            synchronized (locker1) {
                System.out.println(Thread.currentThread().getName() + "已得到locke1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "尝试得到locker2...");
                synchronized (locker2) {
                    System.out.println(Thread.currentThread().getName() + "已得到locke2");
                }
                System.out.println(Thread.currentThread().getName() + "已释放locker2");
            }
            System.out.println(Thread.currentThread().getName() + "已释放locker1");

        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试得到locker2...");
            synchronized (locker2) {
                System.out.println(Thread.currentThread().getName() + "已得到locke2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "尝试得到locker1...");
                synchronized (locker1) {
                    System.out.println(Thread.currentThread().getName() + "已得到locke1");
                }
                System.out.println(Thread.currentThread().getName() + "已释放locker1");
            }
            System.out.println(Thread.currentThread().getName() + "已释放locker2");
        }).start();
        Thread.sleep(3000);
    }

    /**
     * @param fair 公平/非公平锁测试
     * @throws InterruptedException 中断异常
     * <p>
     * 在非公平锁测试中，可能会出现以下的情况：
     * 线程3得到锁
     * 线程1得到锁
     * 线程2得到锁
     * 非公平锁与公平锁最大的区别就是
     * 公共锁机制会让先进到的线程得到锁，各个线程有序等待。
     * 非公共锁机制其实其实也会让先进到的线程得到锁，各个线程有序等待，但是如果锁释放的同时，刚好有一个线程尝试去拿到锁
     * 那么有可能这个线程不用进入线程队列中等待前面，而是直接拿到这个锁，相当于一个插队的操作。
     */
    public void fairOrNotFair(boolean fair) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock(fair); // 默认为false，非公平锁
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                locker.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                locker.unlock();
            }).start();


            new Thread(() -> {
                locker.lock();
                Thread.currentThread().setName("线程1");
                System.out.println(Thread.currentThread().getName() + "得到锁");
                locker.unlock();
            }).start();

            Thread.sleep(100);

            new Thread(() -> {
                locker.lock();
                Thread.currentThread().setName("线程2");
                System.out.println(Thread.currentThread().getName() + "得到锁");
                locker.unlock();
            }).start();

            Thread.sleep(900);
            new Thread(() -> {
                locker.lock();
                Thread.currentThread().setName("线程3");
                System.out.println(Thread.currentThread().getName() + "得到锁");
                locker.unlock();
            }).start();

            Thread.sleep(1000);
            System.out.println("end...");
        }
    }

    /**
     * 公平锁演示
     */
    @Test
    public void fairLockDemo() throws InterruptedException {
        fairOrNotFair(true);
    }

    /**
     * 非公平锁演示
     */
    @Test
    public void unFairLockDemo() throws InterruptedException {
        fairOrNotFair(false);
    }

    /**
     * 可重入锁演示
     */
    @Test
    public void reentrant() {
        synchronized (this) {
            synchronized (this) {
                //上层已经拿到本对象的锁并且未释放，按理说这里会拿不到锁而阻塞，
                //导致死锁，实际上synchronized为可重入锁，即同一个线程多次获
                //取同一个锁(即使未释放)，那么仍然可以拿到锁
                System.out.println("synchronized...");
            }
        }
        ReentrantLock locker = new ReentrantLock();
        locker.lock();
        locker.lock(); //ReentrantLock翻译为可重入锁，这里和上面的其实是一样的
        System.out.println("ReentrantLock");
        locker.unlock();
        locker.unlock();
        System.out.println("end...");
    }

    /**
     * 不可重入锁演示
     */
    @Test
    public void nonReentrantLock() throws InterruptedException {
        class NonReenTrantLock {
            private boolean isLocked = false;

            public synchronized void lock() throws InterruptedException {
                while (isLocked) {
                    wait();
                }
                isLocked = true;
            }

            public synchronized void unlock() {
                isLocked = false;
                notify();
            }
        }

        NonReenTrantLock nonLocker = new NonReenTrantLock();
        nonLocker.lock();
        nonLocker.lock(); //在这里就阻塞,死锁了
        System.out.println("nonLocker...");
        nonLocker.unlock();
        nonLocker.unlock();
        System.out.println("end...");
    }


    @Test
    public void test() throws InterruptedException {
        //CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        Demo demo = new Demo();
        new Thread(demo::set).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(demo::get).start();
        TimeUnit.SECONDS.sleep(4);
    }

    static class Demo {
        public synchronized void set() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("set...");
        }

        public synchronized void get() {
            System.out.println("get...");
        }
    }

    /**
     * WriteLock和ReentrantLock获取锁的区别
     * WriteLock是独占锁，那么他和ReentrantLock有什么区别呢？
     * 最大的区别就在获取锁时WriteLock不仅需要考虑是否有其他写锁占用，
     * 同时还要考虑是否有其他读锁，而ReentrantLock只需要考虑自身是否被占用就行了。来看下WriteLock获取锁的源代码：
     */
    @Test
    public void CacheDemo() throws InterruptedException {
        MyCache myCache = new MyCache();
        myCache.set("k1", "v1");
        TimeUnit.SECONDS.sleep(3);
        new Thread(() -> {
            System.out.println("k1:" + myCache.get("k1"));
        }).start();

        new Thread(() -> {
            myCache.set("k2", "v2");
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            System.out.println("k2:" + myCache.get("k2"));
        }).start();
        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * 读写锁实现缓存
     */
    private static class MyCache {
        private final Map<String, Object> map = new HashMap<>();
        ReentrantReadWriteLock locker = new ReentrantReadWriteLock();

        public void set(String key, Object o) {
            try {
                locker.writeLock().lock();
                System.out.println("start to write " + key);
                map.put(key, o); //其余线程的读写操作都不能进行
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                locker.writeLock().unlock();
                System.out.println("end to write " + key);
            }
        }

        public Object get(String key) {
            try {
                locker.readLock().lock();
                System.out.println("start to read " + key);
                if (key.equals("k1")) {
                    TimeUnit.SECONDS.sleep(2);
                }
                return map.get(key); //其余的线程读操作可以进行，写操作不可以进行
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                locker.readLock().unlock();
                System.out.println("end to read " + key);
            }
            return null;
        }
    }


}
