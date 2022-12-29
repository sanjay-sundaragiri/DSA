
class Solution {
    static int [] delRow={-1,0,+1,0};
    static int[] delCol= {0,+1,0,-1};
    
    private static void dfs(int row,int col, int[][]vis,int[][]grid,ArrayList<String>ls,int r,int c)
    {
        vis[row][col]=1;
        int n=grid.length,m=grid[0].length;
        ls.add(toString(row-r,col-c));
        for(int i=0;i<4;i++)
        {
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vis,grid,ls,r,c);
               
            }
        }
    }
    private static String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        int n=grid.length;
        int m=grid[0].length;
        int[][]vis= new int[n][m];
        
        Set<ArrayList<String>>set= new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    ArrayList<String>ls = new ArrayList<>();
                    dfs(i,j,vis,grid,ls,i,j);
                    set.add(ls);
                }
            }
        }
        
        return set.size();
    }
    
    
    
}
