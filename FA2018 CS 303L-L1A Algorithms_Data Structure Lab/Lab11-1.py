import time
from collections import defaultdict 
  
#Class to represent a graph 
class Graph: 
    def __init__(self,vertices): 
        self.graph = defaultdict(list) #dictionary containing adjacency List 
        self.V = vertices #No. of vertices 
  
    # function to add an edge to graph 
    def addEdge(self,u,v): 
        self.graph[u].append(v) 
  
    # A recursive function used by topologicalSort 
    def topologicalSortUtil(self,v,visited,stack): 
  
        # Mark the current node as visited. 
        visited[v] = True
  
        # Recur for all the vertices adjacent to this vertex 
        for i in self.graph[v]: 
            if visited[i] == False: 
                self.topologicalSortUtil(i,visited,stack) 
  
        
        stack.insert(0,v) 
  
    def topologicalSort(self): 
        # Mark all the vertices as not visited 
        visited = [False]*self.V 
        stack =[] 
  
        # Call the recursive helper function to store Topological 
        # Sort starting from all vertices one by one 
        for i in range(self.V): 
            if visited[i] == False: 
                self.topologicalSortUtil(i,visited,stack) 
  
        # Print contents of the stack 
        print (stack)

starttime = time.time()        
g= Graph(8) 
g.addEdge(4, 5); 
g.addEdge(5, 4); 
g.addEdge(4, 7); 
g.addEdge(5, 7); 
g.addEdge(7, 5); 
g.addEdge(5, 1); 
g.addEdge(0, 4);
g.addEdge(0, 2);
g.addEdge(7, 3);
g.addEdge(1, 3);
g.addEdge(2, 7);
g.addEdge(6, 2);
g.addEdge(3, 6);
g.addEdge(6, 0);
g.addEdge(6, 4);
endtime = time.time()

elapsedtime = endtime - starttime


  
print ("Following is a Topological Sort of the given graph")
g.topologicalSort() ## Calls the topologicalSort function
print (elapsedtime)
