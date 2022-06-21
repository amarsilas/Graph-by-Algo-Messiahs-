package Dijkstra_Algorithm_for_Shotest_Path;


//Dijkstra's single source shortest path algorithm.
//for adjacency matrix representation of the graph.
class ShortestPath { 
    
    static final int V = 5; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
              min = dist[v]; 
                min_index = v; 
            }  
        return min_index; 
    } 
    //to print the constructed distance array 
    void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
  
    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V];  
        
        Boolean sptSet[] = new Boolean[V]; 
        
        for (int i = 0; i < V; i++) { 

            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        
        dist[src] = 0; 
        //To find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) { 
             
 int u = minDistance(dist, sptSet); 
           
            sptSet[u] = true; 
            
            for (int v = 0; v < V; v++) 
                
    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v]<dist[v]) 
          dist[v] = dist[u] + graph[u][v]; 
        } 
        // to print the constructed distance array 
        printSolution(dist); 
    } 
   
    public static void main(String[] args) 
    { 
        
        int graph[][] = new int[][] { { 0, 4, 0, 0, 1}, 
                                      { 4, 0, 8, 0, 0}, 
                                      { 0, 8, 0, 7, 0}, 
                                      { 0, 1, 7, 0, 9}, 
                                      { 5, 0, 0, 9, 0 } };
                                      

        ShortestPath t = new ShortestPath(); 
        t.dijkstra(graph, 0); 
    } 
}
