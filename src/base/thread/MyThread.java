package base.thread;

public class MyThread extends Thread {
    private Runnable runnable = null;

    public MyThread(Runnable obj) {
        runnable = obj;
    }

    public MyThread() {
    }

    public void printThreadID() throws InterruptedException {
        sleep(100);
        System.out.println("Thread ID:" + currentThread().getId() + " is running");
    }

    @Override
    public void run() {
//        if (runnable != null) {
//            runnable.run();
//        }
//        try {
//            printThreadID();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
