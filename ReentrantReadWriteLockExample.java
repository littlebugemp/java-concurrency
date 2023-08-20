import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
//    static Object obj = new ReentrantReadWriteLockExample();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock= lock.writeLock();

    public static void readResource(){
        readLock.lock();
        //view resource
        readLock.unlock();
    }

    public static void writeResource(){
        writeLock.lock();
        //write resource //change state
        writeLock.unlock();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> readResource()); thread1.start();
        Thread thread2 = new Thread(()-> writeResource()); thread2.start();
    }
}
