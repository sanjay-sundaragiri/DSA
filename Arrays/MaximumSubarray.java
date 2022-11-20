/*->intitially store the first value in maxSum.
->Traverse through the array and add each value to sum and find out the maximum of (maxSum,sum).
->if sum<0,then make sum as 0.
->return maxSum.
-TC:O(N), SC:O(1).
*/
class Solution {
    public int maxSubArray(int[] nums) {
        
     int sum=0;
     int maxSum=nums[0];
     for(int i=0;i<nums.length;i++)
     {
         sum+=nums[i];
         maxSum = Math.max(maxSum,sum);
         
         if(sum<0)
         {
             sum=0;
         }
     }
        return maxSum;
        
    }
}