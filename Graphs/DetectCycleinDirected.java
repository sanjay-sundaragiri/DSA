
/*Complete the function below*/

/*
->Find the Degree of Each node.
->store all the nodes having o as inDegree into the queue.
->loop through queue until it is empty,
   -remove the node and insert in topo[],then Traverse all the adjcent nodes of that  node.
   - decrement the inDegree of each adjacent node by 1 and check if it is 0.
   - if the current adjacent node inDegree is 0,then add the current node into queue.
   
->if the size of the topo[] is not equal to the no. of nodes int the graph,then there exists a cycle.
->if the size of topo[] is equal==V,then there is no cycle in the Directed graph.
-TC: O(3N) , SC:O(2N).
*/
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        //using TopoSort and Kahn's Algorithm
        
        int[] inDegree = new int[V];
        
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
        
        List<Integer>topo=new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int node= q.poll();
              topo.add(node);
            for(int adjNode: adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0)
                {
                    q.add(adjNode);
                }
            }
        }
        
        if(topo.size()!=V)
         return true;
         
        return false;
    }
}