class Solution {
    public int maxArea(int[] height) {
        int maxWater=0;
        int start=0,end=height.length-1;
        
        while(start<end)
        {
            if(height[start]<height[end])
            {
                maxWater= Math.max(maxWater, height[start] * (end-start));
                start++;
            }
            else{
                maxWater= Math.max(maxWater, height[end]* (end-start));
                end--;
            }
        }
        
        return maxWater;
        
    }
}