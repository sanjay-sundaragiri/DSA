import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       if(nums.length<3)
           return new ArrayList();
        
        int n= nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> list= new HashSet();
        for(int i=0;i<n-2;i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum= nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    list.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                    
                }
                else if(sum>0){
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return new ArrayList(list); 
        //if()
     //List<List<Integer>> list = new ArrayList<List<Integer>>();
       //  Collections.addAll(list, nums);
        //TLE ERROR
       /* for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0 && (i!=j) && (i!=k) && (j!=k))
                    {
                       list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return new ArrayList(list);   */
    }
}