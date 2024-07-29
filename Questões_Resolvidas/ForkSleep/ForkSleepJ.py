import multiprocessing as mp
import random
import time

n = int(input())

def wait_for (timeout: int):
    time.sleep(timeout)


processes = []
for i in range(n):
    timeout = random.randint(0,5)
    print(timeout)
    p = mp.Process(target = lambda: wait_for(timeout))
    p.start()
    processes.append(p)

for p in processes:
    p.join()

print(f'Valor de n: {n}')