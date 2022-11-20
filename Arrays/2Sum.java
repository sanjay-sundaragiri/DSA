class Solution {
    public int[] twoSum(int[] nums, int target) {
       // int n=nums.length;
        int[] ret=new int[2];
            int a=0;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
            if(nums[i]+nums[j]==target)
            {
                ret[a]=i;
                a++;
                ret[a]=j;
              
            }
            }
            
        }
        
      
      
        
    }
}