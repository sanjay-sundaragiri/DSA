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
/* Check Simultaneously both the trees, return true if the values are same at each node in both respective nodes.
-TC:O(N), SC:O(N)
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return (p==q);
        
       return( (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}


