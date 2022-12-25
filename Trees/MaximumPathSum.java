/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*Find sum for everynode and update it to the maxSum.
->At each node traverse left and right and calculate the sum.
-TC: O(N), SC:O(N)
*/
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] maxValue= new int[1];
        maxValue[0]= Integer.MIN_VALUE;
        maxPath(root, maxValue);
        
        return maxValue[0];
       
    }
    private static int maxPath(TreeNode root, int[] maxValue)
    {
        if(root==null) return 0;
          int leftSum= Math.max(0, maxPath(root.left,maxValue) );
        int rightSum= Math.max(0, maxPath(root.right,maxValue) );
        
        maxValue[0] = Math.max(maxValue[0], leftSum+rightSum+root.val);
        
        return Math.max(leftSum, rightSum)+root.val;
        
    }
}