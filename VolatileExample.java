import java.util.logging.Logger;

public class VolatileExample {
    /* Changes made to sharedVar in one thread
     may not immediately reflect in other thread */
    static int sharedVar = 6;

    /* volatile keyword here makes sure that
     the changes made in one thread are
     immediately reflect in other thread */
    static volatile int sharedVar2 = 6;


}
