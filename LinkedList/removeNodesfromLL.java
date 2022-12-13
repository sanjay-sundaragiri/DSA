/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Set<Integer>set= new HashSet<>();
        List<Integer>ls= new ArrayList<>();
         ListNode cur=head;
        ListNode r=head;
         Map<Integer,List<Integer>>map= new HashMap<>();
        map.put(-1,new ArrayList<>());
        while(cur!=null)
        {
            ls.add(cur.val);
            set.add(cur.val);
            cur=cur.next;
           // map.put(-1,new ArrayList<>());
        }
        
        if(set.size()==1) return head; 
        int n=ls.size();
        int[] ar= new int[n];
      Stack<Integer> stack=new Stack<>();
      
        
        
       
        for(int i=n-1;i>=0;i--)
        {
            int number=ls.get(i);
                while(!stack.isEmpty() && stack.peek()<=ls.get(i))
                {
                    stack.pop();
                }
           
         
            if(stack.empty() )
            {
                map.get(-1).add(ls.get(i));
            }
//             }else{
                
//                // map.put(ls.get(i)).add(ls.get(i));
             
//             }
            stack.push(number);
        }
         List<Integer>res= map.get(-1);
       
        
       // System.out.println(res);
         ListNode newN=null;
       // ListNode t;
        for(int i=0;i<res.size();i++)
        {
           ListNode t= new ListNode(res.get(i));
            t.next=newN;
            newN=t;
        }
        return newN;
    }
}


/*
if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
*/

