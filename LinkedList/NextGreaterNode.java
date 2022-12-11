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
 /* */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer>ar= new ArrayList<>();
        while(head!=null)
        {
            ar.add(head.val);
            head=head.next;
        }
        int[]res= new int[ar.size()];

        Stack<Integer>st= new Stack<>();
        for(int i=ar.size()-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=ar.get(i))
            {
                st.pop();
            }
             
            if(!st.isEmpty())
            {
                res[i]=st.peek();
                
            }
            st.push(ar.get(i));
        }

        return res;
    }
}