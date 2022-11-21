class Solution {
    public void setZeroes(int[][] matrix) {
         int n=matrix.length;
        int m=matrix[0].length; 
        int[][] temp=new int[n][m];//creating a temp array with same size
       for(int i=0;i<n;i++)
           for(int j=0;j<m;j++)
               temp[i][j]=1;//assign 1 to the total matrix;
        //traversing row wise
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    for(int k=0;k<m;k++)
                    {
                        temp[i][k]=0;    // replacing 0 with in rows in temp array
                    }
                   
                }
            }
        }
        
        //traversing column wise
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(matrix[i][j]==0)
                {
                    for(int k=0;k<n;k++)
                    {
                        temp[k][j]=0;  // replacing 0 with in coloumns in temp arrray
                    }
                   
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(temp[i][j]==0)
                {
                    matrix[i][j]=0;   //copying the zero values into the original array
                }
            }
        }
        
        
        
        
        /* for(int i=0;i<n;i++)
           for(int j=0;j<m;j++)
               System.out.print(matrix[i][j]+" ");
            System.out.println();*/
    }
}