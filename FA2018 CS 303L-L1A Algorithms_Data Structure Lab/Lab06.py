
def main():
     arr = [6,4,7,8,10,12]
     novelSort(arr,0,len(arr)-1)
     print(arr)



def novelSort(arr,start,end):
    if start >= end:
        return arr

        
    min_index = arr[start:end+1].index(min(arr[start:end+1])) + start
    max_index = arr[start:end+1].index(max(arr[start:end+1])) + start
    
    
    arr[start], arr[min_index] = arr[min_index], arr[start]
    arr[end], arr[max_index] = arr[max_index], arr[end]
    
    novelSort(arr, start + 1, end - 1)



main() 
