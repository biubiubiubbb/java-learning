package base.threadpoor;

import java.util.concurrent.*;

/*
线程池的七个参数
public ThreadPoolExecutor(
        int corePoolSize,     即使这些线程处理空闲状态，他们也不会 被销毁，除非设置了allowCoreThreadTimeOut
        int maximumPoolSize,  创建的最大线程池数，一旦任务队列满了，有新的任务，则会先判断当前线程池数是否小于该值，若小于则创建新的线程去执行新的任务
        long keepAliveTime,   一个线程如果处于空闲状态，并且，当前的线程数量大于corePoolSize，那么在指定时间后，这个空闲线程会被销毁
        TimeUnit unit,  keepAliveTime的计量单位,一个枚举，TimeUnit.MILLISECONDS，比如为这个是，keepAliveTime的单位为ms
        BlockingQueue<Runnable> workQueue,   任务队列(四种)
        ThreadFactory threadFactory,  创建一个新线程时使用的工厂，可以用来设定线程名、是否为daemon线程等等
        RejectedExecutionHandler handler 拒绝策略(四种)  当工作队列中的任务已到达最大限制，并且线程池中的线程数量也达到最大限制，这时如果有新任务提交进来，该如何处理呢

newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

Cached
Fixed
Scheduled
Single

BlockingQueue<Runnable> workQueue,   任务队列(四种)
①ArrayBlockingQueue
基于数组的有界阻塞队列，按FIFO排序。新任务进来后，会放到该队列的队尾，有界的数组可以防止资源耗尽问题。
当线程池中线程数量达到corePoolSize后，再有新任务进来，则会将任务放入该队列的队尾，等待被调度。
如果队列已经是满的，则创建一个新线程，如果线程数量已经达到maxPoolSize，则会执行拒绝策略。

②LinkedBlockingQuene
基于链表的无界阻塞队列（其实最大容量为Interger.MAX），按照FIFO排序。由于该队列的近似无界性，
当线程池中线程数量达到corePoolSize后，再有新任务进来，会一直存入该队列，而不会去创建新线程直到maxPoolSize，
因此使用该工作队列时，参数maxPoolSize其实是不起作用的。

③SynchronousQuene
一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。
也就是说新任务进来时，不会缓存，而是直接被调度执行，如果没有该任务可用线程，
则创建新线程，如果线程数量达到maxPoolSize，则执行拒绝策略。

④PriorityBlockingQueue
具有优先级的无界阻塞队列，优先级通过参数Comparator实现
 */

public class Demo {
    public static void main(String[] args){
//        ExecutorService threadPoor = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoor = new ThreadPoolExecutor(4, 10, 1L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        var future = threadPoor.submit(() -> {
//            Thread.sleep(100 * 1000);
//            System.out.println("ddd");
//            return "Hello World";
//        }); // 有返回值，使用Callable<T> task, 无返回值使用Runnable task[
//        System.out.println(future.get());
//        threadPoor.setCorePoolSize(9);
        for (int i = 0; i < 9; i++) {
            threadPoor.submit(new RunTask());
        }
//        threadPoor.shutdown();
//        _threadPoor.awaitTermination(100,TimeUnit.SECONDS);
        System.out.println("finish main thread");
    }
}


class RunTask implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started");
        try {
//            Thread.sleep(3000);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " finish");
    }
}