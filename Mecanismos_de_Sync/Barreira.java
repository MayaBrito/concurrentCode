package Mecanismos_de_Sync;
import java.util.concurrent.Semaphore;

public class Barreira {

    private int count;
    private Semaphore semaphore;
    private Semaphore mutex;
    private int bar;

    public Barreira(int bar) {
        this.count = 0;
        this.semaphore = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.bar = bar;
    }

    public void waitt(){
        try {
            mutex.acquire();
            count++;
            int c = count;            
            mutex.release();

            if(c == bar){
                semaphore.release();
            }

            semaphore.acquire();   
            semaphore.release();

        } catch (Exception e) {
        }
   
    }

}