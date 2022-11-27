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
/*
->Create a LinkedList(ll)  using collections, Traverse through the Listand add the values that are less than x into ll
->Again traverse through the List,But now add values x>= into ll.
->Now,rebuild the LinkedList by adding evry element from the ll.
TC: O(N)+O(N)+O(N)
SC:O(N).
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        List<Integer> ll = new LinkedList<>();
        ListNode curr=head;
        ListNode curr1=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                ll.add(curr.val);
            }
            curr= curr.next;
        }
        
        while(curr1!=null)
        {
            if(curr1.val>=x)
            {
                ll.add(curr1.val);
            }
            curr1 = curr1.next;
        }
       // System.out.println(ll);
        ListNode newNode=null;
        for(int i=ll.size()-1;i>=0;i--)
        {
            ListNode node= new ListNode(ll.get(i));
            if(newNode==null)
            {
                newNode=node;
            }else{
                node.next = newNode;
                newNode= node;
            }
        }
        return newNode;
    }
}