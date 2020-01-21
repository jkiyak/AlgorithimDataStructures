
import java.util.Scanner;

public class testing {
public static void main(String[] args)
{
	
int[] arr = {40, 52, 59, 65, 81, 114, 155, 239, 264, 281, 309, 320, 385, 394, 438, 466, 475, 486, 488, 489};	
binarysearch binarysearch = new binarysearch();	
linearsearch linearsearch = new linearsearch();
Scanner reader = new Scanner(System.in);
System.out.println("Enter a number from the array to search for:");
int searchkey = reader.nextInt();
reader.close();


linearsearch.linear_search(arr, searchkey);
binarysearch.binarySearch(arr, searchkey);
System.out.print(linearsearch.linear_search(arr, searchkey));
System.out.print(binarysearch.binarySearch(arr, searchkey));
}
}
