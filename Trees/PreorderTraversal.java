/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;;
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
    List<Integer> preorder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
       /* if(root==null) return preorder;
        
        preorder.add(root.val);
        preorderTraversal(root.left);    //recursive approach. TC: O(N) , SC: O(N)
        preorderTraversal(root.right);
        
        return preorder;*/
        
        if(root==null) return preorder;
        
        Stack<TreeNode> s= new Stack<>();
        s.push(root);
        
        while(!s.isEmpty())
        {
            TreeNode topNode = s.peek();             //Iterative approach. TC: O(N), SC: O(N);
            preorder.add(topNode.val);
            s.pop();
            
            if(topNode.right!=null)
                s.push(topNode.right);
            if(topNode.left!=null)
                s.push(topNode.left);
        }
            
      return preorder;  
    }
    
}