//using BFS
//TC:O(N) +O(N), SC: O(N)+O(N)
class Solution {
    public boolean isBipartite(int[][] graph) {

        
        int n=graph.length;
       
        int[] color= new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!bfs(i,graph,color))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int start,int[][] graph,int[] color)
    {
        Queue<Integer>q= new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(int adjNode : graph[node])
            {
                //if the adjacent is not yet colored,give the opposite color of the node.
                    if(color[adjNode]==-1)
                    {
                          color[adjNode]= 1-color[node];
                          q.offer(adjNode);
                    }
                    //if adjacent node is having the same color as node,then it can't be a bipartite
                    else if(color[adjNode]==color[node])
                    {
                        return false;
                    }
            }
        }
        return  true;
    }
}