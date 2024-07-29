package Mecanismos_de_Sync;
import java.util.concurrent.Semaphore;

public class Buffer {
    private final int[] items;
    private int head, tail;
    private static final int BUFFER_SIZE = 10;
    private final Semaphore emptySlots = new Semaphore(BUFFER_SIZE);
    private final Semaphore fullSlots = new Semaphore(0);

    public Buffer() {
        items = new int[BUFFER_SIZE];
        head = 0;
        tail = 0;
    }

    public void put(int item) throws InterruptedException {
        emptySlots.acquire();
        items[tail] = item;
        tail = (tail + 1) % BUFFER_SIZE;
        fullSlots.release();
    }

    public int get() throws InterruptedException {
        fullSlots.acquire();
        int item = items[head];
        head = (head + 1) % BUFFER_SIZE;
        emptySlots.release();
        return item;
    }
}
