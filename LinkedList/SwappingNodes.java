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
->take an ArrayList and add each value into it from the LinkedList.
->swap the kth element from both the sides in the array.
->traverse the array from the end and add each value to the LinkedList.
TC: O(N)+O(N)
SC: O(N)
*/

//Optimised approach.
/* 
-> Intially decrement k by 1.
->take a pointer first and traverse upto k positions from the head.
->take a second pointer(which is at head node) and traverse from where the first pointer has stopped until the first reaches null.
->Now we can swap the values  and return the list.
TC:O(N)
SC:O(1)
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        k=k-1;
        ListNode first=head;
        while(k>0)                   //TC: O(N)
        {
            first= first.next;
            k--;
        }
        ListNode f=first;
        ListNode second = head;
        
        while(f.next!=null)
        {
            second = second.next;
            f= f.next;
        }
        
        int temp=first.val;
        first.val=second.val;
        second.val= temp;
        
        return head;   
        
       /* List<Integer> ls= new ArrayList<>();
        ListNode currN=head;
                                     //TC: O(N)+O(N).
        while(currN!=null)
        {
            ls.add(currN.val);
            currN=currN.next;
            
        }
      
       // System.out.println(ls);
        int start=k, end= ls.size()-k;
        start= start-1;
       // end= end+1;
       // System.out.println((st-1)+" "+(ed+1));
        Collections.swap(ls, start,end);
       // ListNode dummy=head;
        //System.out.println(ls);
        ListNode newNode= null;
       
        for(int i=ls.size()-1;i>=0;i--)
        {
            
           ListNode newN= new ListNode(ls.get(i));
            if(newNode==null)
            {
                newNode= newN;
            }else{
                
                newN.next= newNode;
                newNode=newN;
            }
           
        }
        
        
        
        return newNode; */
    }
}