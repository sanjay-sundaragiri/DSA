class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int[] ar = new int[nums.length+2];
        
        for(int num: nums)
        {
            if(num>=1 && num<ar.length)
            {
                ar[num]=1;            //missing element index will be allocated as 0
            }
        }
        
        for(int i=1;i<ar.length;i++)
        {
            if(ar[i]==0)
            {
                return i;       //so that if any value is 0 in array,then return the                                                                                index..i.e,missing integer
            }
        }
        
        
        return -1;
    }
}