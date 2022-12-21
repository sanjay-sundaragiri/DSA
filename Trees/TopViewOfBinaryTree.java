class Pair
{
    int hd;
    Node node;
    Pair( Node node,int hd)
    {
        this.hd=hd;
        this.node = node;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ls = new ArrayList<>();
        if(root==null) return ls;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0) );
        while(!q.isEmpty())
        {
            Pair it = q.remove();
            int level=it.hd;
            Node temp= it.node;
            if(map.get(level)==null) map.put(level, temp.data);
            
            if(temp.left!=null)
            {
                q.add(new Pair(temp.left,level-1));
            }
            if(temp.right!=null)
            {
                q.add(new Pair(temp.right,level+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> m : map.entrySet())
        {
            ls.add(m.getValue());
        }
        
        
        return ls;
    }
}