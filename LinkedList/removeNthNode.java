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
->count the number of nodes and subtract n from the count,this will give you how many nodes you must traverse through the list ans stop it there itself,then remove the connection of next node and connect currN to two steps away of current Node.
->return head;
TC:O(2n).
*/

/*Optimised approach:TC:O(N)
->create a dummy node and point it to head.next(in case of n==count)
->Take two pointers slow and fast, move fast pointer upto n moves.
->then again traverse through the List and move the slow pointer from head until fast pointer reaches null.
->Now we should remove the node i.e.,node present next to the slow pointer.
->return the dummy Node(which returns the list after removing the nth node).
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
         ListNode start = new ListNode();     //TC: O(N) ,SC: O(1)
        start.next=head;
       // ListNode dummy=head;
        ListNode slow=start, fast = start;
        
        for(int i=1;i<=n;i++)
        {
            fast= fast.next;
        }
        
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next= slow.next.next;
        
        return start.next;
        
        
        
       /* ListNode currN=head;                    //TC:O(2N), SC: O(1)
        int count=1;
        while(currN.next!=null)
        {
            currN= currN.next;
            count++;
        }
        currN=head;
       // System.out.println(count);
        if(count==1 )
            return null;
        if(count==n)
            return currN.next;
        int moves=count-n;
        count=0;
        
        while(currN!=null)
        {
            if(moves-1==count)   //break when it reaches n moves to delete.
                break;
            currN=currN.next;
            count++;
            
        }
        currN.next=currN.next.next;
        
        
        return head;*/
        
        
        
       
    }
}