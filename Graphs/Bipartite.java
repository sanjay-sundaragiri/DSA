
//TC:O(V+2E)
//SC: O(N)+O(N).
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int[] color= new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++)   //in case of connected components.
        {
            if(color[i]==-1)
            { 
                if(!dfs(i,0,color,adj))
                {
                    return false;
                }
            }
        }
        
        return true;
        
        
    }
    
    private static boolean dfs(int node,int col,int[] color,ArrayList<ArrayList<Integer>>adj)
    {
        color[node]=col;   //color the node.
        for(int adjNode : adj.get(node) )
        {
            if(color[adjNode]==-1) //if the adjacent node is not yet colored.
            {
                
                //do a dfs traversal for this node.
                if(!dfs(adjNode,1-col,color,adj)) //give the opposite color of the node.
                   return false;
            }
            else if(color[adjNode]==color[node])//if the same color exists for both  nodes,return false.
            {
                return false;
            }
        }
        
        return true;
    }
    
}