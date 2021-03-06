##https://www.geeksforgeeks.org/quick-sort/

def main():
    with open('input_100.txt') as inputfile:
        data = inputfile.read()
        inputfile.close()
    arr = [int (i) for i in data.split()]
    quicksort(arr,0,len(arr)-1)
    print(arr)
    

def quicksort(arr,low,high):
    if low < high:
        middle = partition(arr,low,high)
        quicksort(arr,low,middle-1)
        quicksort(arr,middle+1,high)


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
