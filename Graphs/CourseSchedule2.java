
//using topological sort (BFS).
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        
        int m= prerequisites.length;
        List<List<Integer>>adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree= new int[n];
        for(int i=0;i<n;i++)
        {
            for(int node : adj.get(i))
            {
                inDegree[node]++;
            }
        }

        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
            {
                q.offer(i);
            }
        }

        int[] topo= new int[n];
        int k=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo[k++]=node;
            for(int adjNode : adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0)
                {
                    q.offer(adjNode);
                }
            }
        }

        if(k==n) return topo;

        return new int[]{};
    }
}