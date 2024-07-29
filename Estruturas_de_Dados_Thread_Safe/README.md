# Estruturas de Dados Thread-Safe

## Abordagens para Thread Safety:

1. **Sincronização**: Utilize mecanismos de sincronização como locks.
2. **Estruturas de Dados Concorrentes**: Utilize coleções thread-safe da biblioteca Java, como `ConcurrentHashMap`, `CopyOnWriteArrayList` ou `ConcurrentLinkedQueue`.

### Exemplos de Código:

1. **Dicionário Thread-Safe com ConcurrentHashMap:**

    ```java
    import java.util.concurrent.ConcurrentHashMap;
    public class ThreadSafeHashMap {
        private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        public void put(String key, String value) {
            map.put(key, value);
        }
        public String get(String key) {
            return map.get(key);
        }
    }
    ```

2. **Fila Thread-Safe com ConcurrentLinkedQueue:**

    ```java
    import java.util.concurrent.ConcurrentLinkedQueue;
    public class ThreadSafeQueue {
        private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        public void add(String item) {
            queue.offer(item);
        }
        public String poll() {
            return queue.poll();
        }
    }
    ```