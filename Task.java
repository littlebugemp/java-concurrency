import java.text.SimpleDateFormat;
import java.util.Date;

//java programme to illustrate threadpool
public class Task implements Runnable{
    private String name;

    public Task(String s){
        this.name = s;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<5;i++){
                if(i==0){
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for "+ name + " = "+ simpleDateFormat.format(date));
                }else{
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Execution Time for "+ name + " = "+ simpleDateFormat.format(date));
                }
                Thread.sleep(1000);

            }
            System.out.println(name + " completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

