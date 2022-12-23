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
/*->Create a map add all the values and its indices of inorder array. call a method and pass both the arrays and its index from start ,end and a map.
->Build the left tree recursively by ,finding the root index in inorder array and left side from root is considered as new inorder ,same for preroder. Same build the right side tree by considering the values from right side of the root as new inorder and preorder.
->return the root.
-TC: O(N) , SC:O(N).
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
      //  System.out.println(map);
        TreeNode root= buildTree( preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        
        return root;
    }
    private static TreeNode buildTree(int[] preorder,int preStart ,int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map)
    {
        if(preStart>preEnd || inStart>inEnd) return null;
         
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot-inStart;
        
        root.left= buildTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        
        root.right= buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);
        
        
        return root;
    }
}