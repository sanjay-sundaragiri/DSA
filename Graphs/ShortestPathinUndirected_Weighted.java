
// User function Template for Java
class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second= second;
    }
}
//O(E+logV)
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        // code here
        
        //adjacency list.
        ArrayList<ArrayList<Pair>>adj= new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
             adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        PriorityQueue<Pair>pq= new PriorityQueue<>( (x,y) -> x.first-y.first);
        pq.add(new Pair(0,1));
        
        
        int[] dist= new int[n+1];
        int[] parent = new int[n+1];
        
        for(int i=1;i<=n;i++)
        {
            dist[i]=(int)(1e9);
            parent[i]=i;
        }
        
        
        dist[1]=0;
        
        while(!pq.isEmpty())
        {
            int dis= pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            
            for(Pair it : adj.get(node))
            {
                int adjNode= it.first;
                int wt = it.second;
                
                if(dis +  wt < dist[adjNode])
                {
                    dist[adjNode] = dis + wt;
                    
                    pq.add(new Pair (dis+wt , adjNode));
                    parent[adjNode]= node;
                }
            }
            
            
        }
        
        List<Integer>path = new ArrayList<>();
        if(dist[n]==1e9)
        {
            path.add(-1);
            return path;
        }
        
        int node =n;
        //O(N)
        while(parent[node]!=node)
        {
            path.add(node);
            node = parent[node];
            
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}