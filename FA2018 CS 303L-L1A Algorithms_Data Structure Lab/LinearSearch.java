import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
	   //https://www.geeksforgeeks.org/linear-search/
		
		public int linearsearch(int arr[], int key) { //Linear Search method
		for (int i = 0; i < arr.length; i++) {
		if (arr[i] == key)
			return i;
		}
		return -1;
		}
		
		public static void main(String [] args) throws IOException {
			BinarySearch bs = new BinarySearch();// making new objects for linear and binarysearch
			LinearSearch ls = new LinearSearch();
	        
			Scanner textfile = new Scanner(new File("input_1000.txt"));
			
			//https://stackoverflow.com/questions/26831340/generate-10-random-integers-storing-them-in-an-array-and-then-calling-a-method-t
			//Generate a set of random numbers.
			Scanner sc = new Scanner(System.in);
			System.out.println("How big do you want your array to be?"); //Scanner for user input for array size

			int arraysize = sc.nextInt();
		    int[] arr = new int[arraysize]; 
		    //Generates x numbers from 1 to x.
		    for(int i = 0; i < arr.length; i++) {
		    	arr[i] = (int)(Math.random() * (arraysize-1)+1);
		    }
		    Arrays.sort(arr);
		    System.out.println("Numbers Generated: " + Arrays.toString(arr));
			
		    //https://stackoverflow.com/questions/19341594/reading-numbers-from-a-text-file-into-an-arraylist-in-java
		    
		    ArrayList<Integer> keys = new ArrayList<Integer>(); //making an array for the keys from the text file.
		    while (textfile.hasNext()) {
		    String line = textfile.nextLine();
			Scanner scanner = new Scanner(line);
		    while (scanner.hasNextDouble()) {
		    keys.add((int) scanner.nextDouble());	
		    }
		    }
		    //System.out.println("Hopefully you see this message!!" + keys);
		    
		    //https://stackoverflow.com/questions/19346965/get-random-number-from-arraylist
		    Random r = new Random();
		    System.out.println("The key that has been chosen is " + keys.get(r.nextInt(keys.size())));
		    
		    
	       int n = arr.length;
	       //System.out.println("Enter the key number you are searching:");
	       //int key = sc.nextInt();
	       int key = keys.get(n);
	       
	       long startLinearSearch = System.currentTimeMillis();
	       int result = ls.linearsearch(arr, key);
	       if (result == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at index " +  
	                                                 result);
	       long endLinearSearch = System.currentTimeMillis();
	       
	       System.out.println("Elapsed time : " + (endLinearSearch - startLinearSearch )+ "milliseconds");
	       
	       int binary = bs.binarySearch(arr, 0, n-1, key);
	
	       long startBinarySearch = System.currentTimeMillis();
	       
	        if (binary == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at index " +  
	                                                 binary);
	        long endBinarySearch= System.currentTimeMillis();
	        
	        System.out.println("Elapsed time : " + (endBinarySearch - startBinarySearch )+ "milliseconds");
		
		
		}
}


