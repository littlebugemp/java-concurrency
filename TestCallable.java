import java.util.Random;
import java.util.concurrent.*;

public class TestCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(new TestCallable()); //callable task
        try{
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        service.submit(new Task("Task1")); // runnable task
        service.execute(new Task("Task2")); // runnable Task
//        service.execute(new TestCallable()); // give exception as it is a callable task
        service.shutdown();
    }
}
