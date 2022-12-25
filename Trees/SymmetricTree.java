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
/*->Traverse from left and right simultaneously. if there exists not equal values on both left, right return false.else return true.
->TC:O(N) , SC:O(N)
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        
       
        
        return isMirror(root.left,root.right);
        
    }
    private static boolean isMirror(TreeNode p, TreeNode q)
    {
        if(p==null && q==null) return true;
        
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right, q.left);
    }
}