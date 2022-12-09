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
     List<Integer> inorder= new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
       
        /*if(root==null) return inorder;
        
        inorderTraversal(root.left);
        inorder.add(root.val);              //recursive approach. TC: O(N)   ,SC:O(N)
        inorderTraversal(root.right);
        
        return inorder;*/
        
        Stack<TreeNode> s= new Stack<>();
        while(true)
        {
            if(root!=null)
            {
                s.push(root);
                root=root.left;
            }else{
                if(s.isEmpty())                 //Iterative approach. TC: O(N), SC:O(N)
                    break;
                root=s.peek();
                inorder.add(root.val);
                s.pop();
                root= root.right;
            }
        }
        
        return inorder;
    }
}