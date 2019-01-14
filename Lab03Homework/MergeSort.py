#driver method made from previous lab
#https://www.geeksforgeeks.org/merge-sort/

def main():
    with open('input_100.txt') as inputfile:
        inputnumbers = inputfile.read()
        inputfile.close()
    numbers = inputnumbers.split()
    arr = list(map(int, numbers))
    temp = []
    ##for i in range(len(numbers)):
        ##print (arr[i])
    for k in range(0, len(arr)):
        temp.append(numbers[k])


    mergeSort(arr, temp, 0, len(arr)-1)
    

def mergeSort(arr, temp, left, right):
        if left < right:
            middle = (left+right)/2
            mergeSort(arr, temp, left, middle)
            mergeSort(arr, temp, middle+1, right)
            merge(arr, temp, left, middle, right)
        return arr

def merge(arr, temp, left,middle,right):
    i = left
    j = middle + 1

    for k in range(left, right+1):
        temp[k] = A[k]

        for k in range(left, right+1):
            if i > middle:
                A[k] = temp[j]
                j = j+1
            elif j > right:
                A[k] = temp[i]
                i = i+1
            elif temp[j] < temp[i]:
                A[k] = temp[j]
                j = j+1
            else:
                A[k] = temp[i]
                i = i+1
            
            
main() 



