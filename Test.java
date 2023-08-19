import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
//        Runnable r1 = new Task("Task 1");
//        Runnable r2 = new Task("Task 2");
//        Runnable r3 = new Task("Task 3");
//        Runnable r4 = new Task("Task 4");
//        Runnable r5 = new Task("Task 5");
//        Runnable r6 = new Task("Task 6");
//
//        //create a thread pool with MAX_T fixed pool size
//        //1. fixedThreadPool
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        pool.execute(r1);
//        pool.execute(r2);
//        pool.execute(r3);
//        pool.execute(r4);
//        pool.execute(r5);
//        pool.shutdown();
//
//        //2. CachedThreadPool
//        ExecutorService cachedPool = Executors.newCachedThreadPool();
//        cachedPool.execute(r6);
//        cachedPool.shutdown();

        //3. scheduledThreadPool
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(10);
        //task to run after 10 seconds
        scheduleThreadPool.schedule(new Task("Task A"),10, TimeUnit.SECONDS);
        //task to run repeatedly every 10 seconds
        scheduleThreadPool.scheduleAtFixedRate(new Task("Task B"),15, 10,TimeUnit.SECONDS);
        //task to run repeatedly 10 seconds after previous task complete
        scheduleThreadPool.scheduleWithFixedDelay(new Task("Task C"), 15, 10,TimeUnit.SECONDS);

//        scheduleThreadPool.shutdown();


    }
}
