public class VolatileFieldVisibility {
    int a=0;
    int b=0;
    int c=0;
    volatile int x=0;

    public void writeThread(){
        a=1;
        b=1;
        c=1;
        x=1; //write to x
    }

    public void readThread(){
        int r2 = x; // read x
        int d1 = a;
        int d2 = b;
        int d3 = c;

    }
}
