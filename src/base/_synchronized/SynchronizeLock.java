package base._synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizeLock implements Runnable {
    private Lock lock = null;
    private int num = (int) (Math.pow(2, 10) - 1);  //2的10方-1

    public SynchronizeLock(boolean fair) {
        lock = new ReentrantLock(fair); // 可重入锁
    }

    @Override
    public void run() {
        while (num > 1) {
            try {
                lock.lock();
                System.out.println("Thread ID:" + Thread.currentThread().getId() + "---num:" + num);
                num--;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        System.out.println("Thread ID:" + Thread.currentThread().getId() + " exit");
    }
}
