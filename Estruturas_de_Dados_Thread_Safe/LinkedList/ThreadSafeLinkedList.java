package Estruturas_de_Dados_Thread_Safe.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLinkedList {
    private Node head;
    private final ReentrantLock lock = new ReentrantLock();
    public void add(String data) {
        lock.lock();
        try {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } finally {
            lock.unlock();
        }
    }
    public String get() {
        lock.lock();
        try {
            if (head == null) {
                return null;
            }
            String data = head.data;
            head = head.next;
            return data;
        } finally {
            lock.unlock();
        }
    }
    private static class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
        }
    }

}