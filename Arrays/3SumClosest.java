class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int Closest_sum=0;
        
       
            Closest_sum=nums[0]+nums[1]+nums[2];
        
        
        for(int i=0;i<nums.length-2;i++)
        {
            int start=i+1;
            int end=nums.length-1;
          while(start<end)
          {
            int sum = nums[i]+ nums[start] + nums[end];
            if( Math.abs(target-sum)<Math.abs(target-Closest_sum) )
            {
             Closest_sum=sum;
                //break;

            }
            else if(sum<target)
            {
                start++;
            }else{
                end--;
            }
          }
            
        }
        
        return Closest_sum;
    }
}