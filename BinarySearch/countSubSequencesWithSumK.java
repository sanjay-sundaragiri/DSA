class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length;

        Arrays.sort(nums);
        int low=0,high=n-1;
        int mod=(int)1e9+7;

        int pows[]=new int[n];
        pows[0]=1;
        for(int i=1;i<n;i++)
        {
            pows[i]= pows[i-1]*2 % mod;
        }

        int count=0;
        while(low<=high)
        {
            int sum= nums[low]+nums[high];
            if(sum>target)
            {
                high--;
            }else{
                count= (count + pows[high-low]) % mod;
                low++;
            }
        }

        return count;
    }
}