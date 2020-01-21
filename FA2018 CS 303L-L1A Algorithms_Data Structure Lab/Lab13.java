//import to read files
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; //reads files
import java.io.IOException;

public class Lab13 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WeightedGraph graph = new WeightedGraph(new BufferedReader(new FileReader("tinyDG.txt"))); //insert text file you want to test here and add .txt to the end
		long start = System.nanoTime(); //calculates time taken 
		graph.Djikstra(0); //calls Djikstras algorithim on the graph made.
        
		long end = System.nanoTime(); //calculates time taken
		
		System.out.println("The shortest path is:");
		System.out.println(graph.printPath(0,graph.getVertexCount()-1)); //prints the shortest path of the graph.
		System.out.println("Total time elapsed: " + (end-start) + " nanoSeconds");
	}
}