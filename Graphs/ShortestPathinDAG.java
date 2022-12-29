class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;this.second=second;
    }
}
//User function Template for Java
 
class Solution {
      private  void dfs(int node,List<List<Pair>>adj, int[]vis,Stack<Integer> st)
      {
           vis[node]=1;
           
           for(int i=0; i< adj.get(node).size();i++)
           {
               int v= adj.get(node).get(i).first;
               if(vis[v]==0)
               {
                   dfs(v,adj,vis,st);
               }
           }
           
           st.add(node);
      }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<Pair>> adj= new ArrayList<>();
		
		
		for(int i=0;i<N;i++)
		{
		    List<Pair>temp= new ArrayList<>();
		    adj.add(temp);
		    
		   // dist[i]=(int)(1e9);
		}
		
		for(int i=0;i<M;i++)
		{
		    int u= edges[i][0];
		    int v= edges[i][1];
		    int wt= edges[i][2];
		    
		    adj.get(u).add(new Pair(v,wt));
		}
		//step 1. Finding topo sort using DFS.
		
	Stack<Integer>st= new Stack<Integer>();
		int[] vis= new int[N];
		//TC:O(N+M).
		for(int i=0;i<N;i++)
		{
		   if(vis[i]==0)
		   {
		       dfs(i,adj,vis,st);
		   }
		}
		
		//step 2 take the nodes from stack and keep updating the dist[]
		int[] dist= new int[N];
		for(int i=1;i<N;i++)
		{
		    dist[i]= (int)(1e9);
		}
		//TC:O(N+M)
		dist[0]=0;
		while(!st.isEmpty())
		{
		    int node = st.peek();
		    st.pop();
		    for(int i=0;i<adj.get(node).size();i++)
		    {
		        int v= adj.get(node).get(i).first;
		        int wt= adj.get(node).get(i).second;
		        
		        if(dist[node]+wt <  dist[v])
		        {
		            dist[v] = wt+dist[node]; 
		        }
		    }
		}
		
		for(int i=0;i<N;i++){
		    if(dist[i]==(int)(1e9))
		    {
		        dist[i]=-1;
		    }
		}
		
		return dist;
	}
	
	
}