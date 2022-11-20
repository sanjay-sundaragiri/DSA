class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int target2= target-nums[i]-nums[j];
                int start=j+1;
                int end=n-1;
                while(start<end)
                {
                    int sum= nums[start]+nums[end];
                    if(sum==target2)
                    {
                      List<Integer> quad= new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[start]);
                        quad.add(nums[end]);
                        list.add(quad);
                        
                        while(start<end && (nums[start]==quad.get(2)))
                            start++;
                        while(start<end && nums[end]==quad.get(3))
                            end--;
                    }
                    else if(sum>target2)
                    {
                        end--;
                    }else{
                        start++;
                    }
                }
                while(j+1<n && nums[j+1]==nums[j])
                    j++;
            }
            while(i+1<n && nums[i+1]==nums[i])
                i++;
        }
        
        return list;
    }
}