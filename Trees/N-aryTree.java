/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/*For clear objective refer#102.
->Traverse through every node and and check if there exists any children for the curr node ,if yes add the nodes into the queue.
->Each iteration add the values of each node into the list and add these list to the bfs.
->return bfs.
-TC:O(N) SC:O(N)
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> bfs= new ArrayList<>();
        Queue<Node> q= new LinkedList<>();
        if(root==null) return bfs;
        
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>sub= new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                Node curr= q.poll();
                sub.add(curr.val);
                for(Node c : curr.children)
                {
                    q.offer(c);
                }
            }
            bfs.add(sub);
        }
        
        return bfs;
    }
}