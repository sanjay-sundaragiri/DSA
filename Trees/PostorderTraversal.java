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
class Solution {
    List<Integer> postorder = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
       /* if(root==null) return postorder;
        
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        postorder.add(root.val);
        
        return postorder;*/
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root==null) return postorder;
        
        s1.push(root);
        while(!s1.isEmpty())
        {
            root = s1.pop();
            s2.add(root);
            if(root.left!=null)
                s1.push(root.left);         //using two stack spaces .TC:O(N) , SC:O(2N).
            if(root.right!=null)
                s1.push(root.right);
        }
        while(!s2.isEmpty())
        {
            postorder.add(s2.pop().val);
        }
        
        return postorder;
    }
}