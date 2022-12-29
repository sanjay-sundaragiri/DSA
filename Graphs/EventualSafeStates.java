
// User function Template for Java
//refer detect cycle in directed graph 
//using DFS
//TC: O(V+E)  SC: O(3N)
class Solution {
    private  boolean dfs(int node,int[] vis,int[] pathVis,List<List<Integer>>adj,int[] check)
    {
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int adjNode : adj.get(node))
        {
            if(vis[adjNode]==0)//when the node is not visited.
            {
                if(dfs(adjNode,vis,pathVis,adj,check))
                {
                    
                    return true;
                }
              
            }
            //if the node has previously visited and it has to be on the same path.
            else if( pathVis[adjNode]==1)  
            {
                    
                return true;
            }
        }
        
         check[node]=1;
        pathVis[node]=0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<Integer>safeNodes= new ArrayList<>();
        // Your code here
        int[] vis= new int[V];
        int[] pathVis= new int[V];
        int[] check= new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,pathVis,adj,check);
               
                
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(check[i]==1)
            {
                safeNodes.add(i);
                
            }
        }
        
        return safeNodes;
    }
}
