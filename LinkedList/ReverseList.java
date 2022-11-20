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
->store the head.next in another node, and point the head.next to newNode, make the newNode as head ,store the next node in head that we previously stored. Similarly traverse through the linked list.
-TC: O(N)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead= null;
        while(head!=null)
        {
            ListNode next= head.next;  //storing the next node to update the head.
            head.next = newhead;   //connecting reverse 
            newhead = head;         
            head = next;      //updating head i.e, to traverse the entire list.
        }
       
        
        return newhead;
        
       
    }
}