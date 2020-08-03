package base._synchronized;

public class SynchronizeBlock implements Runnable {
    private int num = (int) (Math.pow(2, 10) - 1);  //2的10方-1
    @Override
    public void run() {
        while (num > 1) {
            synchronized (this) {
                //同步代码块，只有拿到锁，才有cpu执行权
                System.out.println("Thread ID:" + Thread.currentThread().getId() + "---num:" + num);
                num--;
            }
        }
        System.out.println("Thread ID:" + Thread.currentThread().getId() + " exit");
    }
}
