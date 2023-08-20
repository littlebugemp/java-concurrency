public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task1());
        thread.start();
        //do something
        thread.interrupt(); //not want to run this thread any more
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().isInterrupted()){ //check if thread is interrupted
            return;
        }
    }
}

