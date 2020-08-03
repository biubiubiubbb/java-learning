package test.producer_consumer_model;

public class Producer implements Runnable {
    private final Production pen;  // 产品

    public Producer(Production pen) {
        this.pen = pen;
    }

    // 生产
    public void produce() {
        long code = 0;
        while (this.pen.isContinueProduce()) {
            synchronized (this.pen) {
                if (this.pen.isProduced()) {
                    try {
                        this.pen.wait(); // 等待消费者消费
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 开始生产
                this.pen.setType("铅笔");
                this.pen.setColor("蓝色");
                this.pen.setCode(code++);
                this.pen.setProduced(true);
                System.out.println(this.pen + " is produced");
                this.pen.notify();
            }
        }
        System.out.println("finish producing");
    }


    @Override
    public void run() {
        produce();
    }
}
