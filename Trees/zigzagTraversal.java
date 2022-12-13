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
/*

->Initially,put a flag=0 and make it 1 when you go to next level and then make it 0.
->Repeat this process until you finishes reaching all the nodes in the tree.
-TC: O(N) , SC:O(N).
//for more refer to #102.
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> bfs= new ArrayList<>();
        if(root==null) return bfs;
        
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int flag=0;
        while(!q.isEmpty())
        {
            int size= q.size();
            List<Integer>sublist = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                
                sublist.add(q.poll().val);
            }
            if(flag==0)
            {
                bfs.add(sublist);
                flag=1;
            }else{
               Collections.reverse(sublist);
                bfs.add(sublist);
                flag=0;
            }
            
        }
        return bfs;
    }
}