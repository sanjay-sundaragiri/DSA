//TC:O(m+n)+O(v+2E)   ,SC:O(2N)
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        List<List<Integer>>adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []e :edges)
        {
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);  //create an adjacency list for undirected graph.
            adj.get(v).add(u);
        }
        int[]dist= new int[n];
        Arrays.fill(dist,1000);   //fill the array with max number.
        
        Queue<Integer>q= new LinkedList<>();
        q.add(src);
        dist[src]=0;    //make the source node weight 0.
        while(!q.isEmpty())
        {
            int node= q.poll();
            
            for(int adjNode : adj.get(node))
            {
                if(dist[node]+ 1< dist[adjNode])   
                {
                    
                    dist[adjNode]= dist[node]+1;
                    q.add(adjNode);
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(dist[i]==1000)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
}