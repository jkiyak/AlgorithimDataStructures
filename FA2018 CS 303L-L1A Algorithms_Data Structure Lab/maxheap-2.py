##https://www.geeksforgeeks.org/heap-sort/
import time

def main():
    with open('input_10000.txt') as inputfile:
        data = inputfile.read()
        inputfile.close()
    A = [int (i) for i in data.split()]
    heapsize = 0
    starttime = time.time()
    heapsort(A)
    endtime = time.time()
    elapsedtime = endtime - starttime
    print ("This test took", elapsedtime, "seconds")
    
    

def buildmaxheap(A):
    global heapsize
    heapsize = len(A)-1
    for i in range((len(A)-1) // 2, -1,-1):
        heapify(A,i)



def heapsort(A):
    buildmaxheap(A)
    for i in range((len(A)-1), 0,-1):
        A[0],A[i] = A[i],A[0]
        global heapsize
        heapsize = heapsize - 1
        heapify(A,0)






        
def heapify(A,i):
    global heapsize
    l = 2*i
    r = (2*i) + 1

    if l <= heapsize and  A[l] > A[i]:
        largest = l
    else:
        largest = i
    if r <= heapsize and  A[r] > A[largest]:
        largest = r
    if largest != i:
        A[i],A[largest] = A[largest],A[i]
        heapify(A,largest)
##test()
main()
