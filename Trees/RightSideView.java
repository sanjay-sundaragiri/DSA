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
/*Recursive approach is optimal:->Create a list and intially pass the root,0(i.e.,level) and list into a function.
->if the level equals the list size,then add the node value into it.
->recursivley traverse right side,and then left side.
-TC:O(N), SC:O(1).
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root==null) return ls;
      // Queue<Integer> q= new LinkedList<>();
        recursive(root,0,ls);
        
        return ls;
    }
    private static void recursive(TreeNode root, int level, List<Integer> ls)
    {
        if(root==null) return;
        
        if(level==ls.size())
        {
            ls.add(root.val);
        }
        recursive(root.right,level+1,ls);
        recursive(root.left,level+1,ls);
    }
}