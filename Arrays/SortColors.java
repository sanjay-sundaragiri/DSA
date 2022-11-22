class Solution {
    public void sortColors(int[] nums) {
       int zeros=0,ones=0,twos=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
              zeros++;
            else if(nums[i]==1)       
                ones++;
            else                 //count all 0's,1's,2's in nums.
                twos++;
        }
       // System.out.println(zeros+" "+ones+" "+twos);
        int i=0;
        while(zeros-->0)
        {
            nums[i++]=0;       //rearrange the all the 0's at first.
        }
        while(ones-->0)
        {
            nums[i++]=1;        //then 1's.
        }
        while(twos-->0)
        {
            nums[i++]=2;        //then 2's at the end.
        }
    }
}