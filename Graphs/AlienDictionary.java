
//User function Template for Java
//the intuition is to find the topological order of first K characters.
//-> Assume characters a=0,b=1,c=2...so on,and create an adjacency list to build a directed graph.
//TC-O(K+N), SC:O(K)
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        char a='a';
        int id=0;
       
        List<List<Integer>>adj= new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            
            adj.add(new ArrayList<>());
        }
     
        for(int i=0;i<N-1;i++)
        {
            int len= Math.min(dict[i].length(),dict[i+1].length()); //finding the min length string.
            int j=0;
            String s1=dict[i], s2= dict[i+1];
            for(;j<len;j++)    //traverse each character in both the string simultaneously.
            { 
                if(s1.charAt(j)!=s2.charAt(j))
                {
                    //whenever both char is not equal ,build a directed graph from s1[i]->s2[i]
                    adj.get((s1.charAt(j))-'a').add((s2.charAt(j))-'a');
                    break;
                }
            }
            
           
        }
       // System.out.println(adj);
       
        List<Integer>topo= TopoSort(adj,K);  //finding the topological sort 
       String res="";
       for(int c : topo)
       {
           res+=(char) (c+(int)'a');    //converting all the nodes into string.
       }
        
        return res;
        
    }
    
    private static List<Integer> TopoSort(List<List<Integer>>adj ,int K)
    {
       List<Integer>topo= new ArrayList<>();
        
        int[] inDegree= new int[K];
        for(int i=0;i<K;i++)
        {
            for(int node : adj.get(i))
            {
                inDegree[node]++;
            }
        }
        
        
        Queue<Integer>q= new LinkedList<>();
        for(int i=0;i<K;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
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
        
        return topo;
    }
}