package test.producer_consumer_model;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Production pen = new Production();
        Consumer consumer = new Consumer(pen);
        Producer producer = new Producer(pen);
        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(10000);
        pen.setContinueProduce(false);  // 10s后停止生产该类型的笔
    }
}
