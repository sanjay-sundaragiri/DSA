//same as 130

/*
->Do DFS Traversal.
->from all the four boundaries,find 1's and mark as visited all the 1's that are connected to it.
->At the End, count the no. of 1's that are not visited int thr grid.
->return the count.
-TC:O(N)+O(N) +O(N*M)+O(N*M) ~=O(N*M)
-SC:O(N*M*4)~=O(N*M)
*/ 
class Solution {
    int [] delRow= {-1,0,+1,0};
    int[] delCol= {0,+1,0,-1};
    private void dfs(int row,int col,int[][]vis, int[][] grid)
    {
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<4;i++)
        {
            int nrow= row+delRow[i];
            int ncol = col+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vis,grid);
            }
        }
        
    }
    public int numEnclaves(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
         int[][] vis= new int[n][m];

         //traverse first row and last row
         for(int j=0;j<m;j++)
         {
             //first row
             if(grid[0][j]==1 && vis[0][j]==0)
             {
                 dfs(0,j,vis,grid);
             }
             //last row
             if(grid[n-1][j]== 1 && vis[n-1][j]==0)
             {
                 dfs(n-1,j,vis,grid);
             }

         }
         //traverse first column and last column
         for(int i=0;i<n;i++)
         {
             //first column
             if(grid[i][0]==1 && vis[i][0]==0)
             {
                 dfs(i,0,vis,grid);
             }
             //last column
             if(grid[i][m-1]==1 && vis[i][m-1]==0)
             {
                 dfs(i,m-1,vis,grid);
             }
         }

       //count the number of ones that are marked a 0 in vis[]
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