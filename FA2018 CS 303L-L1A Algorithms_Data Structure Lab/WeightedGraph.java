
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


public class WeightedGraph {
	
	private class Edge {
		
      // initialize  variables 
		public int to;
		public double weight; //holds the weights
		
		private Edge(int v, double w) {
			to = v;
			weight = w;
		}
		
		public String toString() {
			return Integer.toString(to) + "(" + Double.toString(weight) + ")";
		}
		
	}
   
   
	
	private class CompareEdgeWeight implements Comparator<Edge> {

		@Override
		public int compare(Edge a, Edge b) {
			return Double.compare(a.weight, b.weight);
		}
		
	}
	
	private static int NIL = -1;
	
	private int vertex;
	private int edges;
	private LinkedList<Edge>[] adjacent;
	private int[] pie;
	private double[] d;
	
	@SuppressWarnings("unchecked")
   //WeightedGraph method is similar to one given from Lab10, so not much changes
	public WeightedGraph(BufferedReader reader)  throws IOException {
		String line;
        line = reader.readLine();
        vertex = Integer.parseInt(line); //holds the vertex for the graph
        line = reader.readLine();
        edges = Integer.parseInt(line); //holds the edges for the graph
        adjacent =  new LinkedList[vertex]; //puts the vertex into a linked list
        for (int v = 0; v < vertex; v++) {
            adjacent[v] = new LinkedList<Edge>();
        }
        while ((line = reader.readLine()) != null) {
            int tempV1, tempV2;
            double tempW; 
            StringTokenizer st = new StringTokenizer(line, " ");
            tempV1 = Integer.parseInt(st.nextToken());
            tempV2 = Integer.parseInt(st.nextToken());
            tempW = Double.parseDouble(st.nextToken());
            addEdge(tempV1, tempV2, tempW);
        }
        
        d = new double[vertex];
        pie = new int[vertex]; 
        
	}

	private void addEdge(int u, int v, double w) { //adds edge to weighted graph
		
		Edge e = new Edge(v,w);
		adjacent[u].add(e);
	
	}
	
	public String toString() {
		String s = new String();
        s = "There are "+vertex+" vertices and "+edges+" edges\n";
        for(int i=0;i<vertex;i++)
        {
            s = s+i+": ";
            for(int j = 0; j<adjacent[i].size();j++)
            {
                s = s+adjacent[i].get(j)+" ";
            }
            s = s+"\n";
            
        }
        return s;
	}
	
	

	public void Djikstra(int s) { //Djikstras algorithim
		boolean[] visited = new boolean[vertex];
		initializeSingleSource(s);
		LinkedList<Integer> set = new LinkedList<>();
		PriorityQueue<Edge> queue = new PriorityQueue<>(new CompareEdgeWeight()); //makes priority que with Edges.
		queue.add(new Edge(s, 0));
		while (!queue.isEmpty())
		{
			int u = queue.remove().to; 
			if (!visited[u])
			{
				visited[u] = true;
				set.add(u);
				for (Edge e : adjacent[u])
				{
					relax(u, e.to, e.weight);
					queue.add(e);
				}
			}
		}
	}
	
	private void initializeSingleSource(int s) {
		for (int v = 0; v < vertex; v++)
		{
			d[v] = Double.MAX_VALUE;
			pie[v] = NIL;
		}
		d[s] = 0;
	}
	
	private void relax(int u, int v, double w) {
		if (d[v] > (d[u] + w))
		{
			d[v] = d[u] + w;
			pie[v] = u;
		}
	}
	
	public LinkedList<Integer> printPath(int i, int j) { //prints the path of that the algorithim finds
		LinkedList<Integer> path = new LinkedList<>();
		path.add(j);
		while (j != -1 && j != i)
		{
			j = pie[j];
			path.add(j);
		}
		return path;
	}
	
	public int getVertexCount() { //method for getting vertex 
		return vertex; 	
	}
	
}