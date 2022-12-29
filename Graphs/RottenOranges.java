
//TC:O(N*M)+O(N*M*4)~=O(N*M)
//Sc:O(N*M)+O(N*M)
class Pair
{
    int row,col,tm;
    public Pair(int row,int col,int tm)
    {
        this.row=row;this.col=col;this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
         int n=grid.length,m=grid[0].length;
         int[][] vis= new int[n][m];

         Queue<Pair>q= new LinkedList<>();

         int cntFresh=0;
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<m;j++)
             {
                 if(grid[i][j]==2)
                 {
                     q.offer(new Pair(i,j,0));    //pushing all the rotten orange cells into queue
                     vis[i][j]=2;        //updating the rotten cells.
                 }

                 if(grid[i][j]==1)
                 {
                     cntFresh++;   //counting the fresh oranges.
                 }
             }
         }
         int[] delRow= {-1,0,+1,0};
         int[] delCol= {0,+1,0,-1};
         int time=0,cnt=0;

         while(!q.isEmpty())
         {
             int row= q.peek().row;
             int col= q.peek().col;
             int t= q.peek().tm;
             q.remove();
             
             time= Math.max(time,t);    //updating max time.
             for(int i=0;i<4;i++) 
             {
                 int nrow= row+delRow[i];
                 int ncol= col+delCol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                grid[nrow][ncol]==1 && vis[nrow][ncol]!=2)
                {
                    q.offer(new Pair(nrow,ncol,t+1));   //adding rotten cells into queue

                    vis[nrow][ncol]=2;    //updating as rotten oranges.
                    cnt++;
                }
             }
         }

         if(cnt!=cntFresh) return -1;   //return -1 if no. of 1's and no. of times we rot each fresh orange are not equal.


         return time;
    }
}