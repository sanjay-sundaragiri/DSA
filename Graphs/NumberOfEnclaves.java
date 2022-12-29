class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;this.second=second;
        
    }
}
//using BFS
class Solution {
    
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length,m=grid[0].length;
        
        int[][] vis= new int[n][m];
        Queue<Pair>q= new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //first row ,first col, lasat row, last col
                if(i==0 || j==0 || i==n-1 || j==m-1){
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                    
                }
                }
            }
        }
        
        int[] delRow= {-1,0,+1,0};
        int[] delCol= {0,+1,0,-1};
        
        while(!q.isEmpty())
        {
            int row= q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            for(int i=0;i<4;i++)
            {
                int nrow= row+delRow[i];
                int ncol = col+delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    q.add( new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                    
                }
            }
        }
        
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}