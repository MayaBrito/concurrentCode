package Estruturas_de_Dados_Thread_Safe.LinkedList;
public class ThreadSafeLinkedListTest {

    public static void main(String[] args) {
        ThreadSafeLinkedList list = new ThreadSafeLinkedList();

        Runnable addTask = () -> {
            for (int i = 0; i < 5; i++) {
                list.add(Thread.currentThread().getName() + " Data " + i);
            }
        };

        Thread[] addThreads = new Thread[5];
        Thread[] getThreads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            addThreads[i] = new Thread(addTask, "Adder-" + i);
        }

        for (int i = 0; i < 5; i++) {
            addThreads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                addThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Runnable getTask = () -> {
            String data;
            while ((data = list.get()) != null) {
                System.out.println(data);
            }
        };

        for (int i = 0; i < 5; i++) {
            getThreads[i] = new Thread(getTask, "Getter-" + i);
        }

        for (int i = 0; i < 5; i++) {
            getThreads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                getThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Testing completed.");
    }
}
