
//using topological sort(BFS) along with kahn's algorithm.
//The intuition is to reverse the adjacency list,and perfom topo sort.
// TC:O(N)+O(V+E)  SC: O(2N)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n=graph.length;
        int[] inDegree= new int[n];
        List<List<Integer>>adjRev= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adjRev.add(new ArrayList<>());
        }
         for(int i=0;i<n;i++)
         {
            for(int node :graph[i])
            {
                adjRev.get(node).add(i);   //reverse the edges.
                inDegree[i]++;    //finding the inDegree of reversed edges of each node.
            }
         }
       

        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
            {
                q.offer(i);    //nodes having indegree as 0,are considered to be terminal nodes.
            }
        }

        List<Integer>safeNodes= new ArrayList<>();
        while(!q.isEmpty())
        {
            int node= q.poll();
            safeNodes.add(node);

            for(int adjNode : adjRev.get(node))
            {
                inDegree[adjNode]--;    
                //if decrementing the indegree of any node results 0,add into the queue as a safeNode.
                if(inDegree[adjNode]==0)
                {
                    q.offer(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);   //sort before return.
        return safeNodes;
    }
}