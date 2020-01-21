//https://www.geeksforgeeks.org/binary-search/
public class BinarySearch	{
	
int binarySearch(int arr[], int l, int r, int key) 
    { 
        if (r>=l) 
        { 
            int mid = l + (r - l)/2; 
  
            // If the element is present at the  
            // middle itself 
            if (arr[mid] == key) 
               return mid; 
  
            
            if (arr[mid] > key) 
               return binarySearch(arr, l, mid-1, key); 
  
           
            return binarySearch(arr, mid+1, r, key); 
        } 
  
        // We reach here when element is not present 
        //  in array 
        return -1; 
    }
}
