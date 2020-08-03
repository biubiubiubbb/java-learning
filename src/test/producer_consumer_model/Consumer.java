package test.producer_consumer_model;

public class Consumer implements Runnable {
    private final Production pen;

    public Consumer(Production pen) {
        this.pen = pen;
    }

    // 持续消费
    public void consumer() {
        while (this.pen.isContinueProduce()) {
            synchronized (this.pen) {
                if (!this.pen.isProduced()) {
                    try {
                        this.pen.wait(); // 等待生产者生产
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(this.pen + " is consumed"); // 使用
                this.pen.setProduced(false); // 使用完后更新状态
                this.pen.notify();
            }
        }
        // 确保停止生产后，能够使用最后生产的一支笔
        if (this.pen.isProduced()) {
            System.out.println(this.pen + " is consumed");
        }

        System.out.println("finish using");
    }

    @Override
    public void run() {
        consumer();
    }
}
