/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
->use two pointers as slow,fast and move the slow pointer one step ahead and fast pointer two steps ahead
->if there exits a cycle,then these slow and fast pointer will collide at some point of time throughout the List, so we can return true.
->if there  doesn't exists any such collision,then  return false;
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
       // boolean flag=false;
        ListNode slow= head, fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return true;
            }
            
        }
        
        
        return false;
        
    }
}