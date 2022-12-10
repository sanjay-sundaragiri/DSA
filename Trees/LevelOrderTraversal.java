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
/*->Create a List of list to store each levels of the tree.
 * ->Create a Queue DS to store the nodes,Initially add root node into it,while queue is not empty then,
 * get the current size of the queue and traverse from 0-size, In each iteration check if there exists a 
 * any from left and right side of that node.
 * ->if there exits some node in either left or right,add the nodes into the queue.
 * ->create a sublist to add the level wise values into the LIST.
 * ->After each iteration add the values into this sublist and then after completion of traversal add the sublist int     the list.
 * ->Repeat this process until the queue is Empty.
 * ->Return the List. 
 -TC: O(N), SC: O(N).
 * */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelorder = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return levelorder;
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> sublist= new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                
                sublist.add(q.poll().val);
            }
            levelorder.add(sublist);
        }
        
        return levelorder;
    }
}