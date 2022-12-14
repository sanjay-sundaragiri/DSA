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
    public boolean isPalindrome(ListNode head) {
      
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null)  //finding the middle of the linked list.
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        
        slow.next = reverseList(slow.next);  //reverse the right half.
        
        slow = slow.next; //moving slow pointer to right half starting position
        
        
        while(slow!=null)
        {
            if(head.val!=slow.val)
                return false;
            
            slow=slow.next;
            head=head.next;
        }
        
        return true;
    }
    
    ListNode reverseList(ListNode  head)
    {
        ListNode pre=null, next=null;
        while(head!=null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head=next;
        }
        return pre;
    }
}