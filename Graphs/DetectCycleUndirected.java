
//TC: O(n+2E) +O(n)
//SC: O(N)+O(N)
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] vis= new boolean[V];
        
        for(int i=0;i<V;i++)    //in case of connected components
        {
            if(!vis[i])
            {
                if(dfs(i,-1,adj,vis))     //the parent will always be -1.
                {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    //using DFS 
    private static boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>>adj,boolean[] vis)
    {
        vis[node]=true;
        
        for(int adjNode : adj.get(node))
        {
            if(!vis[adjNode])
            {
                
                if(dfs(adjNode,node,adj,vis))
                    return true;
            }
            else if(adjNode!=parent)
            {
                return true;
            }
        }
        
        return false;
    }
}




