#driver method made from previous lab
#https://www.geeksforgeeks.org/merge-sort/

def main():
    with open('input_100.txt') as inputfile:
        inputnumbers = inputfile.read()
        inputfile.close()
    numbers = inputnumbers.split()
    arr = list(map(int, numbers))
    n = len(numbers)
    temp = {1,4,5,6,44,55,66}
    for i in range(n): #prints array
        print (arr[i])
    mergesort(arr,temp,0,n-1)


def mergesort(arr, temp, p, r):
    if p < r:
        q = (p + r) / 2
        mergesort(A, temp, p , q)
        mergesort(A, temp, q + 1, r)
        merge(A, temp, p, q, r)




def merge(arr, temp, p, q, r):
    i = p
    j = q+1
    for i in range(p, r):
        if i > q:
            A[k] = temp[j]
            j = j+1
        elif j > r:
            A[k] = temp[i]
            i = i+1
        elif temp[j] < temp[i]:
            A[k] = temp[j]
            j = j+1
        else:
            A[k]=temp[i]
            i = i+1
    return i
    
main()
