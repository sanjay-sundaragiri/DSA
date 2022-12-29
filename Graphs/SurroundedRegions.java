//Do a DFS traversal four the boundaries of the matrix and mark 'O' as visited.
//Then fill 'X' where 'O' is not visited . i.e.,
//From Boundary,find O's and traverse and mark all 'O' connected to it.
//TC: O(N)+(N)+ O(N*M*4)+O(N*M*4) ~=O(N*M).
//SC:O(N*M)
class Solution {
    public void solve(char[][] grid) {
        
        int n=grid.length,m=grid[0].length;

        int[][] vis= new int[n][m];
        
        int[] delRow= {-1,0,+1,0};
        int[] delCol= {0,+1,0,-1};
        //Traverse first row and last row
        for(int j=0;j<m;j++)
        {
            //first row
            if(grid[0][j]=='O' && vis[0][j]==0)
            {
                dfs(0,j,vis,delRow,delCol,grid);
            }
            //last row
            if(grid[n-1][j]=='O' && vis[n-1][j]==0)
            {
                dfs(n-1,j,vis,delRow,delCol,grid);
            }
        }
       
       //traverse first column and last column
        for(int i=0;i<n;i++)
        {
            //first column
            if(grid[i][0]=='O' && vis[i][0]==0)
            {
                dfs(i,0,vis,delRow,delCol,grid);
            }
            //last column
            if(grid[i][m-1]=='O' && vis[i][m-1]==0)
            {
                dfs(i,m-1,vis,delRow,delCol,grid);

            }
        }
       

       for(int i=0;i<n;i++)
       {
           for(int j=0;j<m;j++)
           {
               if(vis[i][j]==0 && grid[i][j]=='O')
               {
                   grid[i][j]='X';
               }
           }
       }
        
    }


    private static void dfs(int row,int col,int[][]vis, int[] delRow,int[] delCol,char[][]grid)
    {
        vis[row][col]=1;
        int n=grid.length,m=grid[0].length;

        for(int i=0;i<4;i++)
        {
            int nrow= row+delRow[i];
            int ncol= col+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
             vis[nrow][ncol]==0 && grid[nrow][ncol]=='O')
             {
                 dfs(nrow,ncol,vis,delRow,delCol,grid);
             }
        }
        
    }
}