//TC:O(V+E) , SC:O(N)+O(N)
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)    
    {
        // add your code here
        int[] inDegree= new int[V];
        
        for(int i=0;i<V;i++)
        {
            for(int node : adj.get(i))
            {
                inDegree[node]++;     //finding the inDegree of each node.,just incrementing at node index.
            }
        }
        
        //initially store the nodes into queue which are having 0 indegree
        Queue<Integer>q= new LinkedList<>();
        
        for(int i=0;i<V;i++) 
        {
            if(inDegree[i]==0)
            {
                q.add(i);   
            }
        }
        
        int[] topo= new int[V];
        int a=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            
            topo[a++]=node;  //node is in the topo sort.
            
            
            //now removing the node from the indegree.
            for(int adjNode : adj.get(node))
            {
                inDegree[adjNode]--;   
                
                if(inDegree[adjNode]==0)   
                {
                    q.add(adjNode);  //if the indegree of the current node is 0,then push into queue.
                }
            }
        }
        
        return topo;
    }
}


