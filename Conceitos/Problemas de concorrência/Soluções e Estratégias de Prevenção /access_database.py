import threading
import time
import random

db_semaphore = threading.Semaphore(1)

def access_database(thread_id):
    print(f"Thread {thread_id} tentando acessar o banco de dados...")
    
    if db_semaphore.acquire():
        try:
            print(f"Thread {thread_id} acessando o banco de dados.")
            
            time.sleep(random.uniform(1, 3))
            print(f"Thread {thread_id} terminou a operação no banco de dados e está liberando o recurso.")
        finally:
            db_semaphore.release()

threads = []
for i in range(10):
    t = threading.Thread(target=access_database, args=(i,))
    threads.append(t)
    t.start()

for t in threads:
    t.join()

print("Todas as operações no banco de dados foram concluídas.")