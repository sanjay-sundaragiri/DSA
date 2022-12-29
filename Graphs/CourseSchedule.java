
class Solution
{
    static int[] findOrder(int V, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        List<List<Integer>>adj= new ArrayList<>();
        
         for(int i=0;i<V;i++)
        {
             adj.add(new ArrayList<>());
        }
        //form a graph
        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        
       // finding the inDegree of each node.
        int[] inDegree= new int[V];
        for(int i=0;i<V;i++)
        {
            for(int node : adj.get(i))
            {
                inDegree[node]++;
            }
        }
        
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
        
        int[] topo= new int[V];
        int k=0;
        while(!q.isEmpty())
        {
            int node= q.poll();
            
            topo[k++]=node;
            //node is in your topo sort , remove it from the inDegree
            for(int adjNode : adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }
        
        if(k==V)
        return topo;
        
        
        return new int[]{};
        
        
        
        
        
    }
}