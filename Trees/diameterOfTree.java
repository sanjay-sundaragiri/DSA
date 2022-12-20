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
/*find the left and right height of the tree and at each recusrion keep track of the maxheight by comparing itself and adding left+right.
->return the diameter.
-TC: O(N),SC:O(N).
*/
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    
    private static int height(TreeNode root, int[] diameter)
    {
        if(root==null) return 0;
        
        int left = height(root.left,diameter);
        int right= height(root.right,diameter);
        
         diameter[0]= Math.max(diameter[0],left+right);
        return 1+Math.max(left,right);
    }
}