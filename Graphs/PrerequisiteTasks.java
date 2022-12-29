
class Solution {
    public boolean isPossible(int V, int[][] prerequisites)
    {
        // Your Code goes here
        int N= prerequisites.length;
        List<List<Integer>>adj= new ArrayList<>();
        //creating an adjacent list.
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++)
        {
            
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] inDegree= new int[V];
        //finding Indegree of each node
        for(int i=0;i<V;i++)
        {
            for(int node : adj.get(i) )
            {
                inDegree[node]++;
            }
        }
        
        //store the nodes which are having inDegree as 0.
        Queue<Integer>q= new LinkedList<>();
        
        for(int i=0;i<V;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
            
        }
        List<Integer>topo= new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(int adjNode : adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }
        
        if(topo.size()==V) return true;
        
        return false;
    }
    
    
}