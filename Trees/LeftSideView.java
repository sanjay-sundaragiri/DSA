

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ls = new ArrayList<>();
      
      recursive(root,0,ls);
      return ls;
    }
    private static void recursive(Node root,int level,List<Integer> ls)
    {
        if(root==null) return ;
        
        if(level==ls.size())
        {
            ls.add(root.data);
        }
        recursive(root.left,level+1,ls);
        recursive(root.right,level+1,ls);
    }
}