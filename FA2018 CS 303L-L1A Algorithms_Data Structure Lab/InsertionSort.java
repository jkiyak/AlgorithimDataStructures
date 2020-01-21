import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

	//Driver program
	public static void main(String[] args) throws IOException {
		 Integer[] temp = new Integer[100];
		  int i = 0;
		  // connect to the file
		  File file = new File("input_100.txt");
		  Scanner inputFile = null;
		  try {
		    inputFile = new Scanner(file);
		  }
		  // If file not found-error message
		  catch (FileNotFoundException Exception) {
		    System.out.println("File not found!");
		  }
		  // if connected, read file
		  if (inputFile != null) {
		    // loop through file for integers and store in array
		    try {
		      while (inputFile.hasNext()) {
		        try {
		          temp[i] = inputFile.nextInt();
		          i++;
		        } catch (InputMismatchException e) {
		          inputFile.next();
		        }
		      }
		    } finally {
		      inputFile.close();
		    }
		    Integer[] array = new Integer[i];
		    InsertionSort is = new InsertionSort();
			is.insertionsort(array);
		  }
	    }
	

	
	
	
	
public static void insertionsort(Integer[] array) {
for (int j = 2; j < array.length; j++) {
int key = array[j];
int i = (j-1);

while (i > 0 && array[i] > key) {
array[i+1] = array[i];
i = i-1;
}
array[i+1] = key;
}

}
}
