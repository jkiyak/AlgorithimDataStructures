##https://www.geeksforgeeks.org/heap-sort/

def main():
    with open('input_100.txt') as inputfile:
        data = inputfile.read()
        inputfile.close()
    A = [int (i) for i in data.split()]
    
    print(heapsort(A,len(A)))

def heapsort(A,heapsize):
    buildmaxheap(A)
    for i in range(len(A)-1, 0,-1):
        A[0],A[i] = A[i],A[0]
        heapsize = heapsize - 1
        heapify(A,0,heapsize)



def test():
    liz = [2,4,5,3,7,8,4]
    buildmaxheap(liz)
    print(liz)
def buildmaxheap(A):
    heapsize = len(A)-1
    for i in range(heapsize // 2, -1,-1):
        heapify(A,i,heapsize)
def heapify(A,i,heapsize):
    largest = i
    l = 2*i + 1
    r = 2*i + 2

    if l < heapsize and  A[l] > A[i]:
        largest = l
    if r <= heapsize and  A[r] > A[largest]:
        largest = r
    if largest != i:
        A[i],A[largest] = A[largest],A[i]
        heapify(A,largest, heapsize)
test()
#main()
