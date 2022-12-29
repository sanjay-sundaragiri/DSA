class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited= new boolean[n];

        dfs(0,rooms,visited);

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int idx,List<List<Integer>>rooms,boolean[] visited)
    {
        visited[idx]=true;
        for(int node  : rooms.get(idx))
        {
            if(!visited[node])
            {
                dfs(node,rooms,visited);
            }
        }
    }
}