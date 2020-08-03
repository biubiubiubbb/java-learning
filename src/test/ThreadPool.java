package test;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPool {
    @Test
    public void demo() {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //单一线程池，线程核心数Core和最大线程数都为1
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);//定长线程池，线程核心数Core和最大线程数都为5
        ExecutorService executorService2 = Executors.newCachedThreadPool(); //可伸缩的缓存线程池，Core为0，Max为Integer.MAX_VALUE
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);//定时线程池

        //核心线程数(工作区)，空闲线程(备用区)，阻塞队列(候客区)
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,  //线程核心数，工作区(始终工作着的)
                5, //最大线程数，可工作区(工作区+备用区)
                40, //备用区关闭的超时时间，如果在规定时间内，备用区都没有被用到，就会关闭
                TimeUnit.SECONDS, //时间单位
                new LinkedBlockingDeque<>(4), //阻塞队列，候客区(当候客区满了时，开启备用区)
                Executors.defaultThreadFactory(), //线程工厂
                new ThreadPoolExecutor.DiscardPolicy() //拒绝策略 (当可工作区(5)+候客区(4)时，触发的机制)
                // AbortPolicy  抛异常
                // DiscardPolicy 丢弃新任务，不会抛异常
                // DiscardOldestPolicy  尝试丢弃旧任务，执行新任务
                // CallerRunsPolicy 在调用者的线程执行任务，这里为main线程
        );
        try {
            for (int i = 0; i < 9; i++) {
//                executorService.execute(()-> System.out.println(Thread.currentThread().getName()));
//                executorService1.execute(()-> System.out.println(Thread.currentThread().getName()));
//                executorService2.execute(()-> System.out.println(Thread.currentThread().getName()));
//                scheduledExecutorService.execute(() -> System.out.println(Thread.currentThread().getName()));

                threadPoolExecutor.execute(() -> {
                            System.out.println(Thread.currentThread().getName());
//                            try {
//                                TimeUnit.SECONDS.sleep(1);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            executorService1.shutdown();
            executorService2.shutdown();
            scheduledExecutorService.shutdown();
            threadPoolExecutor.shutdown();
        }
    }
}
