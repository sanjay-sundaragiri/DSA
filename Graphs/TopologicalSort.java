
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int [] vis= new int[V];
        Stack<Integer>st= new Stack<>();
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,st,adj);
            }
        }
        
        int[] res= new int[st.size()];
        int a=0;
        while(!st.isEmpty())
        {
            res[a++]=st.pop();
        }
        
        return res;
    }
    
    private static void dfs(int node,int[] vis,Stack<Integer>st,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        
        for(int adjNode : adj.get(node))
        {
            if(vis[adjNode]==0)
            {
                dfs(adjNode,vis,st,adj);
            }
        }
        
        st.push(node);
    }
}
