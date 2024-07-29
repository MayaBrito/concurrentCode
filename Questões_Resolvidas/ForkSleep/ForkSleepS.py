import random
import time
from threading import Semaphore, Thread

n = int(input())

class Barrier: 
    def __init__(self, n) -> None:
        self.n = n
        self.count = 0
        self.s1 = Semaphore(0)
        self.mutex = Semaphore(1)

    def wait (self):
        self.mutex.acquire()
        self.count += 1
        count = self.count
        print(f'c: {self.count}')
        print(f'co: {count}')
        self.mutex.release()    

        if (count ==  self.n):
            print("Estou livre")
            self.s1.release()

        self.s1.acquire()
        self.s1.release()
    

def wait_for (timeout: int, barrier: Barrier):
    time.sleep(timeout)
    barrier.wait()

b = Barrier(n+1)

for i in range(n):
    timeout = random.randint(0,5)
    print(timeout)

    t = Thread(target = lambda: wait_for(timeout, b))
    t.start()

b.wait()

print(f'Valor de n: {n}')