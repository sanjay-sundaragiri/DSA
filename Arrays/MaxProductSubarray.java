/*->if left==0 then make left=1,else multiply the ith value with left.
->if right==0 then make right=1, else multiply the last current ith number from the array.
->keep track of the maxprod ,by finding max(left,right) with maxProd.
->return max product.
-TC:O(N), SC:O(1)
*/
class Solution {
    public int maxProduct(int[] nums) {
        int prod=1;
        int maxProd=nums[0];
        int left=0;
        int right=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
             left =  (left == 0 ? 1 : left) * nums[i];
            right =  (right == 0 ? 1 : right) * nums[n - 1 - i];
            maxProd = Math.max(maxProd, Math.max(left,right));
           
        }
        return maxProd;
    }
}