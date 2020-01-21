##https://www.geeksforgeeks.org/quick-sort/
import time

def main():
    with open('input_500000.txt') as inputfile:
        data = inputfile.read()
        inputfile.close()
    arr = [int (i) for i in data.split()]
    start = time.time()
    quicksort(arr,0,len(arr)-1)
    end = time.time()
    elapsedtime = end - start
    
    print("This sort took" , elapsedtime, "seconds")
    

def quicksort(arr,low,high):
    if low < high:
        N = (high - low) + 1
        m = median3(arr, low, low + (N//2), high)
        arr[m],arr[high] = arr[high], arr[m]
        middle = partition(arr,low,high)
        quicksort(arr,low,middle-1)
        quicksort(arr,middle+1,high)


def median3(arr, i,j,k):
    if arr[i] < arr[j]:
        return arr[j]
    elif arr[j] < arr[i]:
        return arr[i]
    else:
        return arr[k]


def partition(arr, low,high):
    pivot = arr[high]
    i = (low-1)
    for j in range(low,high):
        if arr[j] <= pivot:
            i = i+1
            arr[i],arr[j] = arr[j],arr[i]
    arr[i+1],arr[high] = arr[high],arr[i+1]
    return(i+1)
            








main()
