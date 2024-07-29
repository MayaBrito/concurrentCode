import multiprocessing
import time

def compute_squares(numbers):
    for n in numbers:
        print(f'Square of {n}: {n * n}')
        time.sleep(1)

def compute_cubes(numbers):
    for n in numbers:
        print(f'Cube of {n}: {n * n * n}')
        time.sleep(1)

numbers = [1, 2, 3, 4, 5]

process1 = multiprocessing.Process(target=compute_squares, args=(numbers,))
process2 = multiprocessing.Process(target=compute_cubes, args=(numbers,))

process1.start()
process2.start()

process1.join()
process2.join()

print("Multiprocessamento terminou.")