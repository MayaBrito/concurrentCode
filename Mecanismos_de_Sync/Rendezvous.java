package Mecanismos_de_Sync;
import java.util.concurrent.Semaphore;

public class Rendezvous {
    private final Semaphore semaphore = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);
    private int count = 0;
    private final int N_THREADS = 5;

    public void enter() throws InterruptedException {
        mutex.acquire();
        count++;
        if (count == N_THREADS) {
            semaphore.release(N_THREADS); 
        }
        mutex.release();
        semaphore.acquire();
    }

    public void leave() throws InterruptedException {
        mutex.acquire();
        count--;
        if (count == 0) {
            semaphore.acquire(N_THREADS);
        }
        mutex.release();
    }

    public static void main(String[] args) {
        Rendezvous rendezvous = new Rendezvous();

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                rendezvous.enter();
                System.out.println(Thread.currentThread().getName() + " has crossed the rendezvous point.");
                rendezvous.leave();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < rendezvous.N_THREADS; i++) {
            new Thread(task).start();
        }
    }
}
