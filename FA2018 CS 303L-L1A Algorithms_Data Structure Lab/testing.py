import time

#https://stackoverflow.com/questions/7370801/measure-time-elapsed-in-python (help on taking the time)

#https://en.wikibooks.org/wiki/Python_Programming/Input_and_Output (for help on output statements)


def driver():
    with open('input_100000.txt') as inputfile:
        inputnumbers = inputfile.read()
        inputfile.close()
    numbers = inputnumbers.split()
    numbers = list(map(int, numbers))
    start = time.time()
    insertionSort(numbers)
    elapsedtime = (time.time() - start)
    print('This test took' , elapsedtime, 'seconds')


def insertionSort(array):
    for j in range (1,len(array)):
        key = array[j]
        i = j-1
        while (i >= 0) and  (array[i] > key):
            array[i+1] = array[i]
            i = i-1
            array[i+1] = key
    return array

driver()
