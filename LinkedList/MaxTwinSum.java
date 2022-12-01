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
-> Naive Approach:Traverse through the list and store each value in the ArrayList.
->Traverse through the array for half of the size.
->add the two values from start and end of the array
->keep updating the maxTwinSum for every sum.
->return the maxTwinSum. TC: O(N)+O(N/2)... SC: O(N)
*/

/*Optimised Approach- TC:O(N/2)+O(N/2)+O(N/2). SC:O(1).
->Take two pointers slow,fast and traverse through List and move slow(1 step),move fast(2 steps),until fast pointer reaches null.
->now reverse the second half(i.e., from slow).
->Now again make fast as head and move slow and fast pointer by 1 step ,for every iteration add two value and update it to the MaxTwinSum.
*/
class Solution {
    public int pairSum(ListNode head) {
      
        
        if(head==null) return 0;
        if(head.next==null) return head.val;    //optimised approach.
        
        ListNode slow=head, fast= head;
        while(fast!=null && fast.next!=null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        slow= reverse(slow);
       
       // System.out.print(slow);
        fast=head;
        int maxTwinSum=0;
        while(slow!=null)
        {
            int sum= slow.val+fast.val;
            maxTwinSum= Math.max(sum, maxTwinSum);
            slow=slow.next;
            fast=fast.next;
        }
        
        
        
        return maxTwinSum;
    }
    private static ListNode reverse(ListNode head)
    {
        ListNode newNode=null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=newNode;
            newNode = head;
            head= next;
        } 
        return newNode;  
    }
    
    
     /* if(head==null ) return 0;
        List<Integer>nodes= new ArrayList<>();
        while(head!=null)
        {
         nodes.add(head.val);
            head= head.next;                  //Naive approach
        }
        int maxTwinSum=0;
        for(int i=0;i<nodes.size()/2;i++)
        {
            int sum=nodes.get(i)+nodes.get(nodes.size()-i-1);
            
            maxTwinSum= Math.max(sum, maxTwinSum);
            
        }
        
        return maxTwinSum;*/
    
}