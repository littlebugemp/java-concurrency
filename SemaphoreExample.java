import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {
    static Semaphore semaphore = new Semaphore(3);
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        IntStream.of(1000).forEach(i->executorService.execute(new Task2()));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    static class Task2 implements Runnable{
        @Override
        public void run() {
            try {
                semaphore.acquire(); //only 3 threads can acquire this method at a time
//                semaphore.acquireUninterruptibly();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            semaphore.release();
        }
    }
}

