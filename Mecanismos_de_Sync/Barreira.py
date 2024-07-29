from threading import Semaphore

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
    