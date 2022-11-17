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
->find the length od the linkedlist.
->connect the last node to the head(i.e, head)
->the k%len will give the k times rotated list i.e,start from where you left and traverse until k times.
->make the currrent node next as head and currNode next as null..
->Now the LinkedList is k times rotatedRight.
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
        {
            return head;
        }
        ListNode currNode=head;
        int count=1;
            while(currNode.next!=null)
            {
                currNode=currNode.next;
                count++;
            }
          // System.out.println(count);
        
        currNode.next=head;
        k=k%count;
        k=count-k;
        
        while(k-->0)
        {
            currNode=currNode.next;
        }
        
        head=currNode.next;
        currNode.next=null;
        
        
        return head;
    }
}