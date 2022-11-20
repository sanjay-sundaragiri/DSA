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
->Two pointers ,odd at odd index and move two nodes every time,even pointer at even index and move two nodes..until the next node is null.
->But first store the evenNode in another dummy node.and finally connect it to the oddNode
->return head.(#FMU here we are just modifying the nodes in the lnked list, so head doesn't move to any place. )
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode oddNode=head, evenNode=head.next;
        ListNode even=evenNode;no
      
        while(evenNode!=null && evenNode.next!=null)
        {
            oddNode.next= oddNode.next.next;
            evenNode.next=evenNode.next.next;
            oddNode = oddNode.next;
            evenNode= evenNode.next;
        }
      oddNode.next = even;
        
        return head;
    }
}