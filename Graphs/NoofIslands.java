
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
      int n=grid.length,m=grid[0].length;
     

     for(int i=0;i<n;i++)
     {
         for(int j=0;j<m;j++)
         {
             if(grid[i][j]=='1')
             {
                 count++;
                 dfs(i,j,grid);
                 
             }
         }

     }
        return count;
    }

    private  void dfs(int row,int col,char[][] grid)
    {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length )
               return;
        
        if(grid[row][col]=='1')
        {
            grid[row][col]='2';
            
            dfs(row-1, col, grid);
            dfs(row, col+1, grid);
            dfs(row+1, col,grid);
            dfs(row, col-1,grid);
        }
    }

}