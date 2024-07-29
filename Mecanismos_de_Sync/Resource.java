package Mecanismos_de_Sync;
import java.util.concurrent.Semaphore;

public class Resource {
    private final Semaphore semaphore;

    public Resource(int maxConcurrentAccess) {
        semaphore = new Semaphore(maxConcurrentAccess);
    }

    public void useResource() {
        try {
            semaphore.acquire();
            try {
                System.out.println(Thread.currentThread().getName() + " está usando o recurso.");
                Thread.sleep(1000); 
            } finally {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " liberou o recurso.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrompida.");
        }
    }

    public static void main(String[] args) {
        final int maxConcurrentAccess = 1; 
        Resource resource = new Resource(maxConcurrentAccess);

        Runnable task = () -> {
            resource.useResource();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
