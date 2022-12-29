
/*
->create an adjacency List,store all the edges in it.
->Do a DFS Traversal.
->increment the counter whenever you call dfs.
//TC: O(N)+O(N*N)+O(N)+O(V+2E)
//SC:O(N)+O(N).
*/
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited= new boolean[n];
         
         List<List<Integer>>adj= new ArrayList<>();
         for(int i=0;i<n;i++)
         {
             adj.add(new ArrayList<>());
         }

         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 if(isConnected[i][j]==1 && i!=j)
                 {
                     adj.get(i).add(j);
                     adj.get(j).add(i);
                 }
             }
         }

        int count=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,adj);
                count++;
            }
        }
       
       return count;
    }
    private void dfs(int node ,boolean[] visited,List<List<Integer>>adj)
    {
        visited[node]=true;

        for(int n : adj.get(node))
        {
            if(!visited[n])
            {
                dfs(n,visited,adj);
            }
        }
    }
}