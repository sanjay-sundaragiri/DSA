class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        
        List<Integer> row, prev=null;
        for(int i=0;i<numRows;i++)
        {
            row = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)    //first and last element pf each row must be 1.
                {
                   row.add(1); 
                }else{
                    row.add(prev.get(j-1) + prev.get(j));   //retrieve last row ele except 1st and last ele.
                }
            }
            prev= row;
            list.add(row);
        }
        
        return list;
    }
}