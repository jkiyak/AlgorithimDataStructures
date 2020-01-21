#driver method made from previous lab
#https://www.geeksforgeeks.org/merge-sort/
import math
import time
def main():
    with open('input_100.txt') as inputfile:
        data = inputfile.read()
        inputfile.close()
    A = [int (i) for i in data.split()]
    temp = []

    for k in range(0, len(A)): #made the empty array hyaaaaa
        temp.append(A[k])

    start = time.time()
    mergeSort(A, temp, 0, len(A)-1)
    end = time.time()
    elapsedtime = (end - start)
    print('This test took' , elapsedtime, 'seconds')

def mergeSort(A, temp, low, high):
    if(low < high):
        middle = math.floor((low + high) / 2)
        mergeSort(A, temp, low, middle) 
        mergeSort(A, temp, middle+1, high)
        merge(A, temp, low, middle, high)
    return A

def merge(A, temp, low, middle, high):
        j = middle + 1
        i = low

        for k in range(low,high+1):
            temp[k] = A[k]

        for k in range(low,high+1):
            if (i > middle):
                A[k] = temp[j]
                j = j+1
            elif (j > high):
                A[k] = temp[i]
                i = i+1
            elif (temp[j] < temp[i]):
                A[k] = temp[j]
                j = j+1
            else:
                A[k] = temp[i]
                i = i+1

main() 



