
class Pair
{
    int distance,node;
    Pair(int distance,int node)
    {
        this.distance=distance;
        this.node=node;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        int[] dist= new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        //using pq for always uodating the min distance at the peek.
        PriorityQueue<Pair>pq= new PriorityQueue<>((x,y)->x.distance-y.distance); 
      
      pq.add(new Pair(0,S));
      
        dist[S]=0;
        
        while(!pq.isEmpty())
        {
            int dis= pq.peek().distance;
            int node= pq.peek().node;
            
            pq.poll();
            for(ArrayList<Integer>ed : adj.get(node))
            {
                int adjNode= ed.get(0);
                int wt= ed.get(1);
                
                if( wt +dis < dist[adjNode])
                {
                    dist[adjNode] = dis + wt;
                     
                     pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        
        return dist;
        
        
        
    }
}

