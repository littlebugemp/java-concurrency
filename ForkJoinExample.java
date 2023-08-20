import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {
    private int n=1;

    ForkJoinExample(int n){
        this.n= n;
    }
    @Override
    protected Integer compute() {
        if(n<=1) return n;
        ForkJoinExample f1 = new ForkJoinExample(n-1);
        f1.fork();
        ForkJoinExample f2 = new ForkJoinExample(n-2);
        f2.fork();
        return f1.join() + f2.join();
    }
}
