import time

#https://stackoverflow.com/questions/7370801/measure-time-elapsed-in-python (help on taking the time)

#https://en.wikibooks.org/wiki/Python_Programming/Input_and_Output (for help on output statements)


def driver():
    with open('NovelSortInput.txt') as inputfile:
        inputnumbers = inputfile.readlines()
        numbers = list(map(str,inputnumbers))
        starttime = time.time()
        insertionSort(numbers)
        for i in numbers:
            print(i)
        endtime = time.time()
        elapsedtime = endtime - starttime
        print(elapsedtime)
        inputfile.close()



def insertionSort(array):
    for j in range (1,len(array)):
        key = array[j]
        i = j-1
        while (i >= 0) and  (array[i] > key):
            array[i+1] = array[i]
            i = i-1
            array[i+1] = key
    

driver()


