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
->Take two pointers slow and fast ,start traversing these pointers from head.
->slow pointer moves 1 step, fast pointer moves 2 steps, if cycle exists these two pointers will collide at some point of time.
->Then traverse a third pointer from head and move 1 step,and move only the slow pointer by 1 step. At one point these two pointers will make collision.Now return any of those pointers.(i.e., the tail i.e.,where  cycle begins)
TC: O(N)+O(N).
SC: O(1).
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
        {
            return null;
        }
        ListNode slow=head, fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;  
            fast=fast.next.next; 
            if(slow==fast)
            {
                ListNode third=head;
                while(third!=slow)
                {
                    third=third.next;
                    slow= slow.next;
                }
                return third;
            }
        }
        return null;
    }
}