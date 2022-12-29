// SC:O(N*N)
// TC: O(N*N).
class Pair
{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int count=0;
        int n=grid.length,m=grid[0].length;
        int[][] vis= new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        
        
        return count;
        
    }
    
    private void bfs(int ro,int co,int[][]vis,char[][]grid)
    {
        vis[ro][co]=1;
        Queue<Pair>q= new LinkedList<>();
        q.add(new Pair(ro,co));
        int n=grid.length,m=grid[0].length;
        
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col= q.peek().second;
            
            q.poll();
            //traverse in the neighbours and mark them, if it is a land.
             for(int delrow=-1;delrow<=1;delrow++)
             {
                 for(int delcol=-1;delcol<=1;delcol++)
                 {
                     int nrow= row+delrow;
                     int ncol= col+delcol;
                     
                     
                     if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                     && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0)
                     {
                         vis[nrow][ncol]=1;
                         q.add(new Pair(nrow,ncol));
                     }
                 }
             }
        }
    }
}