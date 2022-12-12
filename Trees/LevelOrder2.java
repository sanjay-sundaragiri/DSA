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
// Same approach used in #102.
//TC: O(N). SC:O(N)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> Bottomlevel=  new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return Bottomlevel;
        
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                if(q.peek().left!=null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                
                sublist.add(q.poll().val);
            }
            Bottomlevel.add(0,sublist);  //stores  values from the end.
            //Bottomlevel.add(sublist);
        }
     // Collections.reverse(Bottomlevel);
      
        return Bottomlevel;
    }
}